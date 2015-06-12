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
public class CalcUI {
    
     private Scanner scObj;
     float a;
     float b;
    //The UI should give the user a choice of operations - one of the choices should be to exit the program
    //user input method
     
    public void requestInput(){
        System.out.println("Which of the following would you like to do?");
        System.out.println("--------------------------------------------");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        
    }
    
    public float userCalcRequest(){
        //int[] input;  //input = new int[3];         
        Scanner keyInput = new Scanner(System.in);
        float op = scObj.nextFloat(); //operator
        //input[0] = op;
       
        return op;
    }
    
    // Once the user selects an operations, the UI should ask the user for 2 operands 
    public float operand1(){
        System.out.println("What's your first number?");
        a = scObj.nextFloat(); //first number;     
        return a;
    }
    public float operand2(){
        System.out.println("What's your second number?");              
        b = scObj.nextFloat(); //first number
        //input[1] = b;
        return b;
    }
    
        
//call the appropriate method in the calc class based on input and pass 3 integers (choice, a, b)
        
//and then display the result of the calculation
    //each calc method should return the result of the calc
  
    public void getCalcFunctions(float op, float a, float b){
        if(op==5){
        goodBye();
            
        }
        else if(op==1){
            add(a, b);
        }
        else if(op==2){
        }
        else if(op==3){
        }
        else if(op==4){
        }
        else{
            System.out.println("Not a valid choice.  Please reenter a value 1-5");
        }
    }
                             
    
// The UI should then display the menu of choices again
        //do while loop method
    
    public void goodBye(){
        // When the user chooses to exit the program, the UI should print a thank you message
        System.out.println("Thanks for using the calculator. Goodbye.");
    
    }


  
}
/*
Create another class that presents a simple console calculator UI to the user. This
second class should handle all user input and console output and must use the first
class to perform all of the math operations

Notes from doing the exercize:

fields from one class are not available to another in the same package if they are private
if fields are public, they are available, but generally we don't want to do this

the point of calling methods from other classes is to get values back to use

.*/