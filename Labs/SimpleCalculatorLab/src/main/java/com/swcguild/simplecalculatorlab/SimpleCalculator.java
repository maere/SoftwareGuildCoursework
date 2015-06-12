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
    
//Design a class (no main method) 
    //that performs basic math operations (addition,subtraction, multiplication, division) on 2 operands.
    
    //fields
   
    private float a, b; //takes decimals
   
    //class constructor   
    public SimpleCalculator(){
        //this.a = a;
        //this.b = b;
        //Scanner keyInput = new Scanner(System.in);
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
