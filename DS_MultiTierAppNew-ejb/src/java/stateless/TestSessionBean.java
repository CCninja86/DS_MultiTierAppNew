/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Michael
 */
@Stateless

public class TestSessionBean implements TestSessionBeanRemote{

    @Override
    public String getMsg() {
        return "Hello EJB TEST";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
