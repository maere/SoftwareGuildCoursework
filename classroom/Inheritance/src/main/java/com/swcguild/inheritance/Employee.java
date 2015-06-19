/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.inheritance;

/**
 *
 * @author apprentice
 */
       //we can make this an absstract base class by writing the word abstract before the class

public abstract class Employee {
    
    //things all employees will have
    //private String firstName; //if this is private, Manager will not be able to access first name inside a method
    protected String firstName; //protected means this will be available to it's child classes--like manager
    private String lastName;
    
    //default constructor for employee
    //the default constructor will always get called from the children 
   
    public Employee(){
        System.out.println("Employee Constructor");
    }
    
    //if there is a  default constructor for the base class, it will automatically get created for any subclasses
    //but if we are explicit about paramters we need, in the super, we'll need to explicity call it, for example
    //so here is a second constructor:
    public Employee(Integer employeeNum){
        System.out.println("Employee number" + employeeNum + " constructor");
    }
    
    //will also do one for strings
    public Employee(String employeeName){
        System.out.println("Welcome " + employeeName);
    }
    
    
    
    public void doWork(){
       
        System.out.println("Employee did work");
    
    }
    
    //Abstract method--just a signal to our subclasses that we will need to providte the implementations
    
    public abstract void createObjectives();
    /*
    {
        System.out.println("Employee Objectives: Come in on time, get my stuff done.");
    }
    */
    
    //private -- if  we do private, our child/subclasses wouldn't be able to use these methods 
        protected void readPerformanceReview(){
            System.out.println("Oh my.");
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
