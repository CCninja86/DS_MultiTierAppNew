/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Michael
 */
public class Department {
    private String id;
    private String name;
    private Employee manager;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the manager
     */
    public Employee getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(Employee manager) {
        this.manager = manager;
    }
    
}
