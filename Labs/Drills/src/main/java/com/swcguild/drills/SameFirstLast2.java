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
public class SameFirstLast2 {
    
     public boolean sameFirstLast(int[] numbers) {
        int x = numbers.length -1;
        if (numbers.length>=1 && (numbers[0]==numbers[x])){
            return true;
        }
        else {
        return false;
        }
    
}
}
