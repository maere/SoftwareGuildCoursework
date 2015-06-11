/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.mapexample;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class ListingAllTheKeys {
    public static void main(String[] args) {
        
    HashMap<String, Integer> populations = new HashMap<>();  //made a specific object to do stuff to
    
    //now this is set in stone...if we want to store more values for a country, we would set this data structure up
    // with a key (country) and our class (object) -- then we would define our class with all fo the fields that we need for data
    //the data will persist in this object
        
        // to put items into our HashMap
        populations.put("USA", 200000000); 
        populations.put("Canada", 340000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        System.out.println("Map size is: " + populations.size());
        //keys come back to you as a set  - a set collection - each key has to be a unique value (one and only on)
        
//we have to import "Set" if we use, and have to declare a type
        Set<String> keys = populations.keySet();
        
        
        for (String k: keys){
            System.out.println(k);
        
        }
        
        
        
    }
    
}
