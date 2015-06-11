/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arrays;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrays3aka2 {
    public static void main(String[] args) {
        int[] myArray;
        //instantiate and assign spaces -- spaces are NOT as an indexed
        myArray = new int[10];
        
        //assign value of -113  to each index using a loop
        Random r = new Random();
        
        for(int i=0; i<myArray.length; i++){
            
            int x = 1 + r.nextInt(100);
            myArray[i] = x;
            System.out.println("Slot " +i+ " contains " + myArray[i]);
    
        }

    }
    
}
/*
Create an array that can hold ten integers. 
Fill up each slot of the array with a random number from 1 to 100. 
Then display the contents of the array on the screen. 
You must use a loop.
*/