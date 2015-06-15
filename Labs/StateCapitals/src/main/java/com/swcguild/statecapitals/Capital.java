/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals;



/**
 *
 * @author apprentice
 */
public class Capital {
   //properties
        String stateN; //finally just added the state name to the object bc wasn't able to print by separating Hash from Collection
	String capName;
	int pop;
	int sqMiles;
       
        
        //constructor
        public Capital(String stateN, String capName, int pop, int sqMiles)  
    {
        this.stateN = stateN;
        this.capName = capName;
        this.pop = pop;
        this.sqMiles = sqMiles;
        
    }
             
    
}
     