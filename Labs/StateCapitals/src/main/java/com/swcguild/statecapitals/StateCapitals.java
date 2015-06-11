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
        
        //our method creaes a hash map
        HashMap<String, String> mapData = new HashMap<>();
        
         //HashMap<String, Integer> populations = new HashMap<>();
        //populations.put("USA", 200000000);
        
        //we use the built HashMap method .put to add key, value pairs (state/cap)
        mapData.put("Alabama", "Montgomery");
        mapData.put("Alaska", "Juneau");
        mapData.put("Arizona", "Phoenix");
        mapData.put("Arkansas", "Little Rock");

        //we create a Set called keys, and and call the .ketSet() method to just pull just the keys
        Set<String> keys = mapData.keySet(); //don't think we actually need this in the code
                                            // we could do it all just with the HashMap
        
        //the for each key in the set we do the following:
            //for each, print the key in our set (keys)
        for (String s : keys)
        {
            System.out.println(s);
        }
        
        //for each, print the value (via the get method) of each item in our HashMap
            //by using the key in the set and associating it back with the value in our HashMap
                //(so we go back to it)
        for (String s : keys)
        {   
            System.out.println(mapData.get(s));
        }
            //use key key to do both--print the set and get the value -- 
        for (String s : keys)
        {
            System.out.println("The capital of " +s+ " is " +mapData.get(s));
        }
        
    ///////
        for (String s : keys){
            StateCapitals2 tempObjHolder = accessObject(mapData.get(s));

        }
        
        }
    ///////
    
    
}
