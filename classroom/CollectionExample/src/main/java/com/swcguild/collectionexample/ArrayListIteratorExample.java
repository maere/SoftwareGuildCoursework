/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionexample;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayListIteratorExample {
    public static void main(String[] args) {
        //
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("My first string.");
    stringList.add("My second string.");
    stringList.add("My third string.");
    stringList.add("My fourth string.");
    
        System.out.println("List size: " + stringList.size());
        
        ///create an iterator -- we don't need new because we are using our stringList object to get the iterator
     //so here we are just setting it equal to a varialbe
        Iterator<String> iter = stringList.iterator(); // it's resting at "0"
        
        while (iter.hasNext()) //does the current have an item after?
        {
            String current = iter.next(); //when you call next in an iterator it steps over current...will give us the NEXT element
                                          //after our initial one we called up
            System.out.println(current); //will be where we are on the first loop - if we put iter.out in the arg, we wouldn't have a handle
        }                              //so we pull it out of the sequence and use it for our variable
        
    }//main
    
}//class
