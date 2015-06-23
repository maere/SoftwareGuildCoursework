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
public class StringX {
    
    public String StringX(String str) {
        char[] stringOfChar = str.toCharArray();
        String sansX = "";
        
        
        for(int i=1; i<stringOfChar.length-1; i++){
            char result = str.charAt(i);
            if(result=='x'){//chars have single quotes! //char holder = stringOfChar[i];  //if (charValue(i)){}
               continue;
            } 
            else{
                 sansX = sansX+result;
            }
    
        }
        System.out.println(sansX);
        return sansX;
    }
    
}
/*
Given a string, r
eturn a version where all the "x" have been removed. 
Except an "x" at the very start or end should not be removed. 




*/