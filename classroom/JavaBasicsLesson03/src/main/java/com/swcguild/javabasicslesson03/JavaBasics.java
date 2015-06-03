/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.javabasicslesson03;

/**
 *
 * @author apprentice
 */
public class JavaBasics {
    public static void main(String[] args){
    
        int counter = 7;
    //or int counter; and then counter =7;
    System.out.println("Counter:"+counter);
   // boolean isDone = false;
    
    counter =counter+1;
    counter +=1;
    counter++;
    
       System.out.println("Counter:"+counter);
       
       int result;
       int operand1;
       int operand2;
       int operand3;
       
       result = 0;
       
       operand1 = 5;
       operand2 = 7;
       
       operand3 = operand2;
       
       result = operand1 + operand2 + operand3;
       
       System.out.println("Result:"+ result);
       
       
       
       
       
       
    }
}
