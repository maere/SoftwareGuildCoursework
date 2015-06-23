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
public class StringTimes {
    
    public String stringTimes(String str, int n) {
        int i=0;
        String nStr="";
        while(i<n){
            nStr=nStr+str;
            
            i++;
        }
        
        return nStr;
    }
    
}
/*
Given a string and a non-negative int n, 
return a larger string that is n copies of the original string. 




*/