/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drills;

/**
 *
 * @author apprentice
 */
public class Reverse {

    public int[] reverse(int[] numbers) {
        int[] revArray;
        revArray = new int [numbers.length];
        
        for(int i=numbers.length-1; i>=0; i--){
            int j = 0;
            revArray[i] = numbers[j];
            j++;
        
        }
        
        return revArray;
    }

}
/*Given an array of ints length 3, return a new array with the elements in reverse order, 
 so for example {1, 2, 3} becomes {3, 2, 1}. 


 */
