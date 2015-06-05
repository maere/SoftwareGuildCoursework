/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class Adder {
    public static void main(String[] args) {
    // Implement test code in your main method that calls the add method.  
        add(1,1);
         add(2,3);
          add(5,8);
           add(95,42);
        
        /*
    Test with the following input parameters (the code in main must print out the results 
    of each set of parameters to the console):
        1 and 1
        2 and 3
        5 and 8
        95 and 42
    */
        
    }
    
    //Implement a static method called add that takes two integers as parameters 
    //and returns an integer that is the sum of the two parameters.

    public static int add(int a, int b){
       
       int c = a + b;  // cannot return from here
        System.out.println("adding 1 and 1 yeilds " + c);
        return c; //  // must return the value on the last line, even if you use it first
       
    }
    /*
    Test with the following input parameters (the code in main must print out the results 
    of each set of parameters to the console):
        1 and 1
        2 and 3
        5 and 8
        95 and 42
    */
    
    
}
