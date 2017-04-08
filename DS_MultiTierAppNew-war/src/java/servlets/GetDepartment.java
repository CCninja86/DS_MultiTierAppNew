/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Department;

/**
 *
 * @author james
 */
@WebServlet(name = "GetDepartment", urlPatterns = {"/GetDepartment"})
public class GetDepartment extends HttpServlet {
    
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
        
        try {
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int employeeID = Integer.parseInt(request.getParameter("id"));
        
        ResultSet resultSet = null;
        boolean employeeFound = false;
        
        try {
            // Lookup Employee ID in Database
            resultSet = statement.executeQuery("SELECT * FROM employees WHERE emp_no = " + employeeID);
            
            if(resultSet != null && resultSet.next()){
                employeeFound = true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String departmentNumber = "";
        
        // If employee is found, get the department number of the department they are in
        if(employeeFound){
            try {
                resultSet = statement.executeQuery("SELECT dept_no FROM dept_emp WHERE dept_emp.emp_no = " + employeeID);
                
                if(resultSet.next()){
                    departmentNumber = resultSet.getString("dept_no");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        Department department = null;
        // If the department number is not null/empty, get department name and number from departments table     
        if(!departmentNumber.isEmpty()){
            try {
                resultSet = statement.executeQuery("SELECT * FROM departments WHERE departments.dept_no = '" + departmentNumber + "'");
                
                // If found, create the Department Bean
                if(resultSet.next()){
                    department = new Department();
                    department.setId(resultSet.getString("dept_no"));
                    department.setName(resultSet.getString("dept_name"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(GetDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("department", department);
        
        if(department != null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ViewDepartment.jsp");
            requestDispatcher.forward(request, response);
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
