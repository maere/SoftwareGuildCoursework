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
public class ReplaceKeyValueExample {
    
    public static void main(String[] args) {
        HashMap<String, Integer> populations = new HashMap<>();  //made a specific object to do stuff to
        
        // to put items into our HashMap
        populations.put("USA", 313000000); 
        populations.put("Canada", 340000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        //test
        System.out.println("Map size is: " +  populations.size());
        
        //replace
          populations.put("USA", 200000000);  //new value --overwrites value
          //this just replaces the value
          
          System.out.println(populations.get("USA"));  // will print value
          System.out.println("Map size is: " +  populations.size()); //same size
    }
    
    
}
