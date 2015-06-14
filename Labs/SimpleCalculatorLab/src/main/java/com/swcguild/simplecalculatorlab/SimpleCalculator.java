/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalculatorlab;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator {
    
//Design a class (no main method) that performs basic math operations (addition,subtraction, multiplication, division) on 2 operands.
    
    //fields
        //it's okay to not have fields if we won't be reusing the value outside of a method 
   
    //class constructor   
    public SimpleCalculator(){
       //is okay to not have anything in here
    }
//calculations
    
    //add method
    public float add(float a, float b){
    return a+b;
    }
    
    //subtract method
      public float subtract(float a, float b){
      return a-b;
      }
    
    //multiply method
        public float multilply(float a, float b){
        return a*b;
        }
    
    //divide method
          public float divide(float a,float b){
          return a/b;
          }

		

    
}
