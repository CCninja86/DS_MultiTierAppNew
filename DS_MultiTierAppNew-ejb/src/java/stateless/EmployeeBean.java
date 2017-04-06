/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import models.Employee;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Michael
 */
@Stateless
public class EmployeeBean implements EmployeeBeanRemote {

    private String url = "jdbc:mysql://dms-sydney-db.cjztu35wlump.ap-southeast-2.rds.amazonaws.com:3306/employees";
    private String username = "dms_server_user";
    private String pass = "dQ5A57UAWV8iwhEKTrid";

    private Connection connection;
    private Statement statement;

    @Override
    public List getEmployees(int limit) {
        List<Employee> employees = new ArrayList<Employee>();

        try {

            new Driver();
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees.employees LIMIT " + limit);

            Employee newEmployee;

            while (resultSet.next()) {
                newEmployee = new Employee();
                newEmployee.setId(resultSet.getInt(1));
                newEmployee.setBirthDate(resultSet.getDate(2));
                newEmployee.setFirstName(resultSet.getString(3));
                newEmployee.setLastName(resultSet.getString(4));
                newEmployee.setGender((char) resultSet.getString(5).charAt(0));
                newEmployee.setHireDate(resultSet.getDate(6));

                employees.add(newEmployee);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
       
        try {
             new Driver();
            connection = DriverManager.getConnection(url, username, pass);
        
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees.employees WHERE emp_no =" + id);

        Employee newEmployee;
        
        if(resultSet.next()){
                newEmployee = new Employee();
                newEmployee.setId(resultSet.getInt(1));
                newEmployee.setBirthDate(resultSet.getDate(2));
                newEmployee.setFirstName(resultSet.getString(3));
                newEmployee.setLastName(resultSet.getString(4));
                newEmployee.setGender((char) resultSet.getString(5).charAt(0));
                newEmployee.setHireDate(resultSet.getDate(6));
                
                return newEmployee;
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
