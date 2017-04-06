package stateless;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Employee;
import stateless.EmployeeBean;

/**
 *
 * @author james
 */
public class Database {
    
   private String url = "jdbc:mysql://dms-employee-db.cn8ktqpu4zgm.eu-central-1.rds.amazonaws.com:3306/employees";    
    private String username = "James";
    private String pass = "d8effaba4d";
    private Connection connection;
    private Statement statement;
    
   
    public List getEmployees(int limit) {
        List<Employee> employees = new ArrayList<Employee>();
        
        try {
            
            
            connection = DriverManager.getConnection(url, username, pass);
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees.employees LIMIT " + limit);
            
            Employee newEmployee;
            
            while(resultSet.next()){
                newEmployee = new Employee();
                newEmployee.setId(resultSet.getInt(1));
                newEmployee.setBirthDate(resultSet.getDate(2));
                newEmployee.setFirstName(resultSet.getString(3));
                newEmployee.setLastName(resultSet.getString(4));
                newEmployee.setGender((char) resultSet.getByte(5));
                newEmployee.setHireDate(resultSet.getDate(6));
                
                employees.add(newEmployee);
                
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

}
