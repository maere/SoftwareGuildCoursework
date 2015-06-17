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
public class Diff21 {
    
    //default constructor
    
 public int Diff21(int n) {
     int result;
     if (n>21) 
     {
         int x = Math.abs(21-n);
         result = 2*x;
     }
     else {
     result = Math.abs(21-n);
     }
   
     return result;
    }
    
}
/*
Given an int n, return the absolute value of the difference between n and 21, 
except return double the absolute value of the difference if n is over 21. 
Math.abs(intvalue)

Diff21(23) -> 4
Diff21(10) -> 11
Diff21(21) -> 0


*/