/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals2 {
    
   //set our fields--these will be the variables we will use throughout the methods in our class 
    private String stateName;
    private String cityName;
    private int population;
    private int squareMiles;
    
//    public Airplane (String modelOfAirplane, int yearOfManufacture){
//        this.modelOfAirplane = modelOfAirplane;
//        this.yearOfManufacture = yearOfManufacture;
//    }
//    
    //this is our Object constructor, we use it to create a capital objects
    public StateCapitals2 (String stateName, String cityName, int population, int squareMiles)
    {
        this.stateName = stateName;
        this.cityName = cityName;
        this.population = population;
        this.squareMiles = squareMiles;
    }
    
   
    //------------------
    //we need to create 4 objects (instantiate)
    StateCapitals2 montgomery = new StateCapitals2("Alabama", "Montgomery", 205000, 156);
     StateCapitals2 juneau = new StateCapitals2("Alaska", "Juneau", 31000, 3255);
      StateCapitals2 phoenix = new StateCapitals2("Arizona", "Phoenix", 1445000, 517);
       StateCapitals2 littlerock = new StateCapitals2("Alabama", "Montgomery", 193000, 116);
       
 //now we need a simple method that returns an object -- each one of the above is a capitals object 
       public Object accessObject(StateCapitals2 capitalName){ //object of type StateCapitals2
           return capitalName;
       }

//this is our print out method, it prints the requested data for each object in the specified format we can call in our loop
    public void printout(String cityName)
    {
        System.out.println(stateName+ " - " +cityName+ " - pop: " + population+ " - SqMiles: " +squareMiles);
    }
    
    
    
    
   // StateCapitals2 Montgomery = new StateCapitals2(Alabama, Montgomery, 205000, 156);
    
//    public void Montgomery(Albama, Montgomery, 205000, 156)
//    { 
//        System.out.println("");
//    }
    
    
}
