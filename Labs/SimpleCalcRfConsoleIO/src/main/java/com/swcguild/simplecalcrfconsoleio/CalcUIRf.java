/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalcrfconsoleio;

import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class CalcUIRf {
    
    
     private Scanner scObj;
     private SimpleCalculator myCalc;
     private int op;
     float result;
     
    ConsoleIO2 con = new ConsoleIO2();
        
    public void run(){
       
    }
      
     //constructor for calcUI 
     public CalcUIRf(){
      this.myCalc = new SimpleCalculator(); //this can now call add, subtract, mult  or divide
       }
     
   
    public void runGetInput(){
        op = con.readInt("\"Which of the following would you like to do? \n"
                + "--------------------------------------------\n"
                + "1. Add\n"
                + "2. Subtract\n"
                + "3. Multiply\n"
        + "4. Divide\n"
        + "5. Exit\n");
        //System.out.println("Which of the following would you like to do?");
        //System.out.println("--------------------------------------------");
        //System.out.println("1. Add"); 
       float a = con.readFloat("Please enter your first number: ");
       float  b = con.readFloat("Please enter your second number: "); 
        
        getCalcFunctions(op, a, b);
        
        System.out.println("Your result is: " + result);
       
        
    }
    
    
    private float getCalcFunctions(int op, float a, float b){
        
        if(op==5){
        goodBye();
            
        }
        else if(op==1){
            result = myCalc.add(a, b); //need to call our method on the object we instantiated 
        }
        else if(op==2){
            result = myCalc.subtract(a, b);   
        }
        else if(op==3){
           result = myCalc.multiply(a, b);
        }
        else if(op==4){ 
            result = myCalc.divide(a, b); 
        }
        else{
            System.out.println("Not a valid choice.  Please reenter a value 1-5");
        }
    
    return result;
    }
                             
    
// The UI should then display the menu of choices again
//do while loop method
    
    private void goodBye(){
        // When the user chooses to exit the program, the UI should print a thank you message
        System.out.println("Thanks for using the calculator. Goodbye.");
    
    }


  
    
}
