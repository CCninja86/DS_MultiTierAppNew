/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Driver;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import models.Employee;
/**
 *
 * @author Michael
 */
public class ModifyUser extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            
           //new Driver();
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();
            ResultSet resultSet = null;
            
            int employeeID = Integer.parseInt((String) request.getParameter("id"));
            System.out.println(employeeID);
            String changedFirstName = request.getParameter("first_name");
            String changedLastName = request.getParameter("last_name");
            char changedGender = request.getParameter("gender").charAt(0);
            
            
            
            Employee updatedEmployee = new Employee();
            updatedEmployee.setFirstName(changedFirstName);
            updatedEmployee.setLastName(changedLastName);
            updatedEmployee.setGender(changedGender);
            
           
            //@TODO: Implement Database Update

            int success = statement.executeUpdate("UPDATE employees SET first_name = '" + updatedEmployee.getFirstName() + "'"
                   + ", last_name = '" + updatedEmployee.getLastName() + "', gender = '" + updatedEmployee.getGender() + "' WHERE emp_no = " + employeeID + "");
           
            
            HttpSession session = request.getSession(true);
            session.setAttribute("employee", updatedEmployee);
            // Check if update was successful
            if(success > 0){
                // Update was successful                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UpdateSuccessful.jsp");
                requestDispatcher.forward(request, response);
            } else {
                // Update wasn't successful
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UpdateUnsuccessful.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifyUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
