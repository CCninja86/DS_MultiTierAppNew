/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author james
 */
public class User {
    
    private String userID;
    private String decimalType;

    
    public User(){
        
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the decimalType
     */
    public String getDecimalType() {
        return decimalType;
    }

    /**
     * @param decimalType the decimalType to set
     */
    public void setDecimalType(String decimalType) {
        this.decimalType = decimalType;
    }




    
    
    
}
