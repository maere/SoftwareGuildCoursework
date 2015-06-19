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
public class Manager extends Employee {
    //Manager is going to extend Employee so just write "extends Employee above" (not when you create title)

    
    //default constructor for manager -- by default, if we run the constructor for manager, it will ALSO
                                    //run the constructor for the employee
                                    //so if we're not explicit abotu which  base constructor we use, ti will call the default
                    //so let's make the manager constructor take in the first name as a parameter...
                    //and now that we've made something that doesn't look exactly the same as .... our other constrctor will go away
   
    public Manager(){}
    
    public Manager(String firstName){
       //here we will get two constructors--one speciality for the employee (vs. the default)
       //and then the one we set up here for the manager
       
       super(0001); //whenever a manager obj gets instantiated, calls the one that takes an integer as a parameter
       //ususually if we want to call the super constructor, we have to call it explicitly like so:
       //super();  - must be in the constructor, *must be the very first statement*, and the signatures have to match
       this.firstName = "Bill";
       System.out.println("Manager constructor");
   }    
     //we can force manager to run constructor from the base class as well....
    
    
    //when you override a method it's CRUCIAL THAT IT HAS THE EXACT SAME METHOD SIGNATURE TO A T  (return type, parameters, name etc.)
    public void doWork(){
       this.firstName= "Josh"; //we can do this b/c we set this to protected in the parent nclass--otherwise we couldnt' do it
       //this.lastName = "Test"; //can't do this b/c it is private in Employee -- would need to change       t
       this.readPerformanceReview(); //same applies to methods--is a little key by proteced
       
       System.out.println("Manager doing work. Get out of the way!");
       
    }
    //second override method example--overrides Employee method
    
    //this is now an abstract method in our abstract base class...so unless we've defined a unique method here, 
    //it will not compile
    public void createObjectives(){
        System.out.println("Manager Objectives: make sure everyone shows up on time and pay all the bills.");
    }
    
    public void hire() {
    }

    public void fire() {
    }

    public void givePerformanceReviews() {
    }

}
