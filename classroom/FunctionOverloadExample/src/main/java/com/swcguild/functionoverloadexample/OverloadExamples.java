/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.functionoverloadexample;

/**
 *
 * @author apprentice
 */
public class OverloadExamples {
    public static void main(String[] args) {
        
        //let's call the methods we overloaded
        int result = add(5,7); //gives us an int out
        
        double resultDbl = add(8,9); //gives us an int out AS WELL bc we passed in int arguments
        
        resultDbl = add(5.0, 13.0);
        System.out.println(resultDbl);
        
        resultDbl = add(5.0, 1);
        System.out.println(resultDbl);
        
        
    }//end  main
    
    
    //methods
    public static int add(int a, int b){
        return a+b;
    }
    public static double add(double a, double b){
        return a+b;
    }
    
}//end class
