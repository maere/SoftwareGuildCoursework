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
 */         //an ArrayList is a flexible array--so is indexed, but expands and contracts and does garbage collection and reindexing
public class ArrayListExample {
    public static void main(String[] args) {
        //array list of strings
        ArrayList<String> stringList = new ArrayList<>(); 
        //we have to import the package             //we don't have to specify type again in second half <String>, but we can in <>
                //naming convention, arrays are plural or the name array
                //for lists, we give it plural or List, and map need to say Map
        
        System.out.println("List size before adding strings: " + stringList.size()); //will call our size method on the stringList we created
        stringList.add("My first string"); //note with ArrayList we can only put in one value
        System.out.println("List size after adding one string: " + stringList.size()); 
        
        stringList.add("My second string"); //note with ArrayList we can only put in one value
        System.out.println("List size after adding two string: " + stringList.size()); 
        
        //dumping contents out of array list
        //we'll open a new class
        
        
        
    } //end main
    
}//end class
