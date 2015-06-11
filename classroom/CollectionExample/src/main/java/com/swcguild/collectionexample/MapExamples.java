/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionexample;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class MapExamples {
    public static void main(String[] args) {
        //HashMap is the primary type of map we'll use
//we add Types for the key, value    
        HashMap<String, Integer> populations = new HashMap<>();  //made a specific object to do stuff to
        
        // to put items into our HashMap
        populations.put("USA", 313000000); 
        populations.put("Canada", 340000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        //test
        System.out.println("Map size is: " +  populations.size());
        
        //explore value/mapping

        
        
        
    }
    
}

//can also use .indexOf method to get index numbers (not get(i)) in an enhanced for loop
