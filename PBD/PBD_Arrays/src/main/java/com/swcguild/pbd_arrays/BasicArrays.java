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
public class BasicArrays {
    public static void main(String[] args) {
        //declare
        int[] myArray;
        //instantiate and assign spaces -- spaces are NOT indexed
        myArray = new int[10];
        //assign value of -113  to each index
        myArray[0] = -113;
        myArray[1] = -113;
        myArray[2] = -113;
        myArray[3] = -113;
        myArray[4] = -113;
        myArray[5] = -113;
        myArray[6] = -113;
        myArray[7] = -113;
        myArray[8] = -113;
        myArray[9] = -113;
        
        System.out.println("Slot 0 contains a " + myArray[0]);
        
        System.out.println("Slot 1 contains a " + myArray[1]);
        System.out.println("Slot 2 contains a " + myArray[2]);
        System.out.println("Slot 3 contains a " + myArray[3]);
        System.out.println("Slot 4 contains a " + myArray[4]);
        System.out.println("Slot 5 contains a " + myArray[5]);
        System.out.println("Slot 6 contains a " + myArray[6]);
        System.out.println("Slot 7 contains a " + myArray[7]);
        System.out.println("Slot 8 contains a " + myArray[8]);
        System.out.println("Slot 9 contains a " + myArray[9]);
                                      
        
    }
    
    
}
//Create an array that can hold ten integers. Fill up each slot of the array with the number -113. 
//Then display the contents of the array on the screen.
//Do not use a loop. Also, do not use any variable for the index; 
//you must use literal numbers to refer to each slot.
//Slot 0 contains a -113
