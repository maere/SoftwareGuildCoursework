/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.mapexample;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class RetrievKeyValueExample {
    public static void main(String[] args) {
         HashMap<String, Integer> populations = new HashMap<>();  //made a specific object to do stuff to
        
        // to put items into our HashMap
        populations.put("USA", 200000000); 
        populations.put("Canada", 340000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        
        //if we want to pull the value out of the hashmap and store as a variable....
        
        Integer japanPop = populations.get("Japan"); //declare a Type for the var, call the method .get passing in key to get corresponding value
        System.out.println("The population of japan is: " + japanPop);
        
        //keys come back to you as a set  - a set collection - each key has to be a unique value (one and only on)
   
       
        
    }
    
}
