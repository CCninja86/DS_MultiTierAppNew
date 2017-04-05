/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.util.List;
import models.Department;

/**
 *
 * @author james
 */
public interface DepartmentBeanRemote {
    
    
    List<Department> getDepartments();
}
