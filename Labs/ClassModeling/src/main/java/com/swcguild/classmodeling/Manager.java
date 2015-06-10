/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classmodeling;

/**
 *
 * @author apprentice
 */
public class Manager {
    
//properties of this object: department, number of reports, quarterly budget, responsibililtes, director, 
//request 
    
//fields
    private String department;
    private int directReports;
    private float budget;
  
    
//constructor
    
    public Manager(String mgrDept, int mgrDirReports, float qBudget){
        this.department = mgrDept;
        this.directReports = mgrDirReports;
        this.budget = qBudget;
    }
    
//getters and setters
    
    public String getDepartment() {
        return department;
    }

    public int getDirectReports() {
        return directReports;
    }

    public void setDirectReports(int directReports) {
        this.directReports = directReports;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
    
    
//other methods and behaviors
public int addEmployeeReport(int increase){
    directReports = directReports + increase; // wants the class field, not the param
    return directReports;

}


    
    
}
