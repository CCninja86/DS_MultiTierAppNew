/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;
import javax.ejb.Remote;
/**
 *
 * @author Michael
 */
@Remote
public interface TestSessionBeanRemote {
    public String getMsg();
    
}
