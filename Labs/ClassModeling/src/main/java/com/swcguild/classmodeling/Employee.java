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
public class Employee {
    
//properties of this object: position, salary, age, years at company, manager, 
//methods:     

//fields
    private String position;
    private int salary;
    private String manager;
    private int years;
    
    
//constructor
    public Employee(String empTitle, int empSalary, int empYears, String empManager) 
    {
        this.position = empTitle;
        this.salary = empSalary;
        this.years = empYears;
        this.manager = empManager;
    }

    public int getYears() {
        return years;
    }
    
 //getters and setters

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    
//other methods and behaviors 
    //methods
    public void loggedIn(){
        System.out.println("Our" + position + " is in the house");
    }
    
    public void addYears(){
        
        //if (dateDayMonth == startDateDayMonth)
        years++;
    }
    
}

    

    

