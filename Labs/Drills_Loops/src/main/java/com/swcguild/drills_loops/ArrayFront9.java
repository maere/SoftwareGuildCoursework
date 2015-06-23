/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drills_loops;

/**
 *
 * @author apprentice
 */
public class ArrayFront9 {

    public boolean ArrayFront9(int[] numbers) {
        
        boolean result=false;  
        
        for(int i=0; i<4; i++){
            
            if(numbers[i]==9){
               result = true;
            }
            //else{result = false;}
        
        }
        return result;
    }

}
/*
Given an array of ints, return true if one of the first 4 elements in the array is a 9.
The array length may be less than 4. 




*/
