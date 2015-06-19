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
public class App {
    public static void main(String[] args) {
        //we'll create an employee (generice) in our main
        /*
        Employee employee = new Employee();
        employee.setFirstName("Fred");
        employee.setLastName("Flintstone");
        */
        //using the default constructor that takes now parameter
        //Manager manager = new Manager("Bob");
        //this is where the neat stuff starts happening--after the .dot we'll see all of his available properties and methods
            //which include the firstname lastName we created for Employee, as well as the methods, and a Manager's unique methods
                //which are bolded in NetBeans
        //manager.fire();
        /*
        SummerIntern summerIntern = new SummerIntern();
        summerIntern.createObjectives();
        */
        
        //-------------------------------------------------
        //POLYMORPHISM
        //Employee employee = new Manager(""); //we are creating an object reference
                                        //constructs a manager object and sets it equal to an employee
                                        // now we will treat it like any other employee
                                        //use case: Bob has to go through onboarding, or maybe is an undercover boss
                                        //treat them normally, but when you need them to step into the boss role, 
                                        //...you will need to explicitly cast them as such
        //employee.createObjectives();   //for this one, it's clear which version of createObjectives method will get called
                                        //since he is an employee, since it is Typed from the Employee class
        
        //Manager manager = new Manager(); - ??
        //manager.createObjectives();
        
        //Employee employee = new Manager();
        //employee.createObjectives();
        
        //Manager manager = new Manager(); 
        //manager.createObjectives();
        
        /*
        Employee employee = new Manager();// we have an employee reference--does what is availablke to employyee
                                //but is POINTING  to a Manager object
                                //so if we call our createObj on the manager object, what is it going to do?
        employee.createObjectives();    
                                 //once a method has overwritten the employye method, it's going to call THAT version
                                 //if it's pointing to the employee
        System.out.println("---------------------------------------------");
        
        Employee employee2 = new SummerIntern(); //secret intern
        employee2.createObjectives();             //but can only behave likee an intern
        System.out.println("--");
        
        Employee summerIntern = new SummerIntern();
        summerIntern.createObjectives();
                */
       
        
        //ABSTRACT BASE CLASS
            //now that we've made the class abstract we can't instantiate it!
       Employee employee = new Employee();
    }
    
}
