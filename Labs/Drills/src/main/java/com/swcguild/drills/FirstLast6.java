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
public class FirstLast6 {
    public boolean firstLast6(int[] numbers) {
        
        int x = numbers.length-1;
            
        if(numbers[0]==6 || numbers[x]==6){
        return true;
        }
        else{
        return false;
        }             
    }
    
}
