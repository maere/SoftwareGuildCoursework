/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.mapexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class ListAllValues {
    public static void main(String[] args) {
                
        HashMap<String, Integer> populations = new HashMap<>();  //made a specific object to do stuff to

        populations.put("USA", 200000000); 
        populations.put("Canada", 340000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        //pulling a collection of values--I guess this is like a set
        //collections allow repeat values, set does not
        //have to import Collection package/library
        Collection<Integer> popValues = populations.values();
        
        for(Integer p: popValues){
            System.out.println(p); //will just give us a collection of values with repeats
                //lexigraphically? how does it order the output--seems random
        
        }
        
    }
    
}
