/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateful;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author james
 */
@Stateful
@LocalBean
public class UserBean implements UserBeanRemote {

    private String userID;
    private String decimalType;
    
    @Override
    public String getUserID(){
        return this.userID;
    }
    
    @Override
    public String getDecimalType(){
        return this.decimalType;
    }
}
