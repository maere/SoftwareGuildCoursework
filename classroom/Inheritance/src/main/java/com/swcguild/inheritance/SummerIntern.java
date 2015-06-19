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
public class SummerIntern extends Employee {
    
    //overriding the base class's createObjectives with the interns unique onne's
    public void createObjectives(){
//when you want to do BOTH things--run what's in the method for the employee, and run the intern specific one...    
//when create obj is called for intern,will call the base method first, and then will calll the child methods
        
        
        System.out.println("Try not to get fired.");
        //super must must be the very first thing you call when using an overridden method--but is specific toi instructor
        
    //super.createObjectives(); //if we abstract the super class, we will get an error when we try to do this
    }

    public void requestPerformanceReview() {
    }
    
  
}
