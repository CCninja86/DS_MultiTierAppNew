/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import models.Department;

/**
 *
 * @author james
 */
@Stateless
@LocalBean
public class DepartmentBean implements DepartmentBeanRemote {
    
    private String url = "jdbc:mysql://dms-employee-db.cn8ktqpu4zgm.eu-central-1.rds.amazonaws.com:3306/employees";    
    private String username = "James";
    private String pass = "d8effaba4d";
    private Connection connection;
    private Statement statement;

    @Override
    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<Department>();
        
        try {
            
            
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("Select * from employees.employees limit 100");
            
            Department newDepartment;
            
            while(resultSet.next()){
                newDepartment = new Department();
                newDepartment.setId(String.valueOf(resultSet.getInt(1)));
                newDepartment.setName(resultSet.getString(2));

                departments.add(newDepartment);
                
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
        
        
    }
}
