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
public class ArrayListRemovalExample {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        
         
        System.out.println("List size before adding strings: " + stringList.size()); //will call our size method on the stringList we created
        stringList.add("My first string"); //note with ArrayList we can only put in one value
        System.out.println("List size after adding one string: " + stringList.size()); 
        
        stringList.add("My second string"); //note with ArrayList we can only put in one value
        System.out.println("List size after adding two string: " + stringList.size()); 
        
        stringList.add("My 3rd string");
        System.out.println("List after 3: " + stringList.size());
        
        //dumping contents out of array list
      //to remove an item, call remove and # index
        
        stringList.remove(1);
        System.out.println("We removed item #1. Let's see what's in index one now");
        System.out.println(stringList.get(1)); //we're removing the info in the 2nd's slot in the ArrayList
                                                //it moves all the info down (3 value becomes 2)
        
        ///reference that was pointing to 3 is now pointing to element 2 spot... so reference still exists, even though 
        System.out.println(stringList.remove(1));
        System.out.println(stringList.remove(0));
        System.out.println("Size after removing element 1 and element 0: " + stringList.size());
                                        //note: with and ArrayList you need to remove from back to front
        
        //if you try to remove an element you don't have...
        stringList.remove(0);
        //when we do this we get a index out of bounds exception
        
        /*
        System.out.println("Size after removal: " +stringList.size());
        for (int i; i<stringList.size(); i++){
            System.out.println(i);
                */
        
        
        }
        
    }
    

