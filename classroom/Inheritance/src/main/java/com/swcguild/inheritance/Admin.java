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
public class Admin extends Manager{
        // our admins superclass is now manager, whose superclass is employee--so it inhertis from both down the chain
    
    /*Abstract class: when you abstract the class, if we deal with the createObjective methods definition in the superclass...
    //..in this case "Manager", we don't need to define in the subsclasses (doesn't go all the way down the chain, just to the next child class)
    public void createObjectives(){
        System.out.println("Collect Ferraris.");
    }
    */
    
    
    
}
