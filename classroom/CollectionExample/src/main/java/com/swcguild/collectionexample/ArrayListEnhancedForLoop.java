/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionexample;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class ArrayListEnhancedForLoop {
    public static void main(String[] args) {
        // Enhance for loop == For/each
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("My first string.");
    stringList.add("My second string.");
    stringList.add("My third string.");
    stringList.add("My fourth string.");
    
        System.out.println("List size: " + stringList.size());  
        
        //enhanced for loop - for each
                            //for an ArrayList we can use both a for/each and the Iterator class
        for(String s: stringList)
        {
            System.out.println(s);
        }
        //to get the index, would run a for loop and use:
        // stringList.get(i) --- loop limit would be stringList.size()
        //can also use .indexOf method to get index numbers (not get(i)) in an enhanced for loop

        
    }
    
    
    
    
}
