/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drills_conditionals;

/**
 *
 * @author apprentice
 */
public class MissingChar {

    
    public static void main(String[] args) {
        MissingChar testObj = new MissingChar();
        testObj.missingChar("kitten", 5);

    }
    
   public String missingChar(String str, int n) {
       
      char[] wordAsArray = str.toCharArray();
      
      char[] dropped;
      dropped = new char[wordAsArray.length];
      
      for (int i=0; i<wordAsArray.length; i++){
          
          if (i==n){
              continue;
          }
          else{
              dropped[i] = wordAsArray[i];
          }
          
      }
       
       String result = dropped.toString();
       System.out.println(result);
       return result;
}
    
    
}
/*
Given a non-empty string and an int n, 
return a new string where the char at index n has been removed. 

The value of n will be a valid index of a char in the original string 
(Don't check for bad index). 

MissingChar("kitten", 1) -> "ktten"
MissingChar("kitten", 0) -> "itten"
MissingChar("kitten", 4) -> "kittn"
*/