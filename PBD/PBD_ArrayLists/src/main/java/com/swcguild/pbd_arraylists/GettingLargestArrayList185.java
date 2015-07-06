/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arraylists;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class GettingLargestArrayList185 {
    
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        Random r = new Random();
        int putInt;
        
        for (int i = 0; i <= 9; i++) {
            putInt = 1 + r.nextInt(100);
            myList.add(i, putInt);
        }
        
        System.out.println("ArrayList: " + myList);
        int first = 0;
        int n = 0;
        while (n < myList.size()) {
            int current = myList.get(n);
            
            if (current > first) {
                first = myList.get(n); 
            }
            
            n++;
        }
        
        System.out.println("The largest value in the ArrayList is: "  + first);
        
    }
}
/*
 Write a program that creates an ArrayList which can hold Integers. 
 Fill the ArrayList with random numbers from 1 to 100. 
 Display the values in the ArrayList on the screen. 
 Then use a linear search to find the largest value in the ArrayList, 
 and display that value.
 */
