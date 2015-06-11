/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arrays;

/**
 *
 * @author apprentice
 */
public class BasicArrays2 {
    
    public static void main(String[] args) {
        //This time, you must use a loop, to put the values in the array /and also to display them. 
 //Also, in the condition of your loop,/you should not count up to a literal number -- use the length field of your array.

    //declare
        int[] myArray;
        //instantiate and assign spaces -- spaces are NOT as an indexed
        myArray = new int[10];
        
        //assign value of -113  to each index using a loop
    
        for(int i=0; i<myArray.length; i++){
        myArray[i] = -113;
            System.out.println("Slot " +i+ " contains " + myArray[i]);
    
        }
        
    }//end main

    
}
