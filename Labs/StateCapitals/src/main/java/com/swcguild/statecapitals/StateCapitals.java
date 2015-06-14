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
public class StateCapitals {
    

//our class has a method that runs things 
    public void run (){
        
        //our method creates a hash map -- if refactoring, might be better to create this when the State object is created
        HashMap<String, String> mapData = new HashMap<>();
        
         //HashMap<String, Integer> populations = new HashMap<>();
        //populations.put("USA", 200000000);
        
        //we use the build HashMap method .put to add our key, value pairs (state/cap)
        mapData.put("Alabama", "Montgomery");
        mapData.put("Alaska", "Juneau");
        mapData.put("Arizona", "Phoenix");
        mapData.put("Arkansas", "Little Rock");

        //we create a Set called keys, and and call the .ketSet() method to just pull just the keys
        Set<String> keys = mapData.keySet(); 
        
        //the for each key in the set we do the following:
            //a for/each, to print each key in the set we pulled (called keys)
        for (String s : keys)
        {
            System.out.println(s);
       
        }
             System.out.println("---------");
        //for each, print the value (via the get method) of each item in our HashMap
            //by using the key in the set and associating it back with the key/value in our HashMap
                //(so we go back to it)
        for (String s : keys)
        {   
            System.out.println(mapData.get(s)); //this method pulls the values from the HashMap using the key s
            
        }
            System.out.println("---------");
            //use key key to do both--print the set and get the value -- 
        for (String s : keys)
        {
            System.out.println("The capital of " +s+ " is " +mapData.get(s));
        }
        
    ///////
        //    print state names to screen
//            print capital names to screen
//                    print state and cap together
        
        }
    ///////
    
    
}
