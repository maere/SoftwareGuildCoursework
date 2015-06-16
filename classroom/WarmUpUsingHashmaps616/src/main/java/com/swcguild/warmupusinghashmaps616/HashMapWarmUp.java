/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.warmupusinghashmaps616;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class HashMapWarmUp {
     
        //create hashmap  to store player points
       HashMap<String, Integer> teamScores = new HashMap<>();
       
       //put keys into a keyset so we can iterate through them
        //this is setting a variable, NOT instantiating
       //Set<String> keys;       //only need a class level variable if you need it between methods
                        //in this instance, we don't really need class level and it will cause us to get out of synch
                        //instead of creating a variable we called the keySet method directly to get the set
        public void run(){
       
        //put players in HashMap
        teamScores.put("Smith", 23);
        teamScores.put("Jones", 12);
        teamScores.put("Jordan", 45);
        teamScores.put("Pippen", 32);
        teamScores.put("Kerr", 15);
        
            int total = 0;
            int count = 0;
        
        for(String s: teamScores.keySet())
        { //return type of KeySet currently is a set of STrinngs
            System.out.println(s + " " +  teamScores.get(s));
            
                total = total + teamScores.get(s); 
                count++;
        }
            System.out.println("------------------------------------");
            System.out.println("The average points for this game are: " + total/count);
        }
    

}//end classs
    
    

