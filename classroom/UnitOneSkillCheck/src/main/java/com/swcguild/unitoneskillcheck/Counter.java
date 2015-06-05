/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class Counter {
    public static void main(String[] args) {
            
    //Implement test code in your main method that calls the toTen method.
        toTen();
        
    //Implement test code in your main method that calls the toN method with the following inputs:
    //3, 8, 200
        toN(3);
        toN(8);
        //toN(200);
        
    }
    
//Implement a static method called to10 that takes no parameters and returns nothing.  
//This method should simply print the numbers from 1 to 10 to the screen, one number per line.  
//Implement this method in the most efficient way you can.
    public static void toTen(){
    
        for (int i=1; i<11; i++){
            System.out.println(i);
        }
    }
    
    //Implement a non-static method called toN that takes one integer parameter and returns nothing.  
    //This method should simply print the number from 0  to the value of the parameters to the screen, 
    //one number per line.
    
    public static void toN(int a){
        for (int i=0; i<=a; i++){
            System.out.println(i);
        }
    }
    
}


