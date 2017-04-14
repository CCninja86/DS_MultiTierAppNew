/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michael Daschner
 */
public class GetSalariesStats extends HttpServlet {

    private String url = "jdbc:mysql://dms-sydney-db.cjztu35wlump.ap-southeast-2.rds.amazonaws.com:3306/employees";
    private String username = "dms_server_user";
    private String pass = "dQ5A57UAWV8iwhEKTrid";

    private Connection connection;
    private Statement statement;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int currentSalary = 0, startSalary;
        int yearsEmployed = 0;
        double salaryIncrease = 0;
        String decimalPreference = request.getParameter("userDecimalPref");

       
         
        try {
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        int employeeID = Integer.parseInt(request.getParameter("id"));

        ResultSet resultSet = null;
        boolean employeeFound = false;

        try {
            // Get current salery
            resultSet = statement.executeQuery("SELECT emp_no, salary, from_date, to_date FROM employees.salaries WHERE to_date > CURRENT_DATE AND emp_no =" + employeeID);
            
            
            if (resultSet != null && resultSet.next()) {
                employeeFound = true;
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        // If employee is found, get the department number of the department they are in
        if (employeeFound) {
           
            try {
                currentSalary = resultSet.getInt(2);

                ResultSet resultStartingWage = statement.executeQuery("SELECT MIN(from_date), salary FROM employees.salaries WHERE emp_no =" + employeeID);
                
                
                
                
                if (resultStartingWage.next()) {
                    Date startDate = resultStartingWage.getDate(1);
                    
                    SimpleDateFormat df = new SimpleDateFormat("yyyy");
                    String startYear = df.format(startDate);

                    int currentYear = Integer.parseInt(df.format(new Date()));
                    
                    yearsEmployed = currentYear - Integer.parseInt(df.format(startDate));
                    //@TODO: Fix salalary increase calculation
                    
                    salaryIncrease = ((double)(currentSalary - Integer.parseInt(resultStartingWage.getString(2))))/currentSalary*100;
                   
                    
                    
                    System.out.println("Salary" + salaryIncrease);
                }
            } catch (SQLException ex) {
                System.out.println("ResultSet:" + ex);
                Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("current_salary", currentSalary);
        session.setAttribute("yearsEmployed", yearsEmployed);
        
        if(decimalPreference.equals("comma")){
            session.setAttribute("salaryIncrease", new java.text.DecimalFormat("0,00").format( salaryIncrease ));
        } else {
            session.setAttribute("salaryIncrease", new java.text.DecimalFormat("0.00").format( salaryIncrease ));
        }
        
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ViewSalaryStats.jsp");
        requestDispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
