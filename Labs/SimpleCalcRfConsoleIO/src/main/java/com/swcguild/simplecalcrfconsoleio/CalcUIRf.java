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
     private final SimpleCalculator myCalc;
     private int op;
     
    ConsoleIO2 con = new ConsoleIO2();
        
    public void run(){
       
      
       
    
    }
       
    
     
     //constructor for calcUI 
     public CalcUIRf(){
      this.myCalc = new SimpleCalculator(); 
       }
     
   
    public void requestInput(){
        System.out.println("Which of the following would you like to do?");
        System.out.println("--------------------------------------------");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        
    }
    
    
    
    //tried to swap this for something from Console IO but it didn't go well
    public int userCalcRequest(){         
        Scanner sc = new Scanner(System.in);
        op = sc.nextInt(); //operator
        return op;
    }
    
    
    
    // Once the user selects an operations, the UI should ask the user for 2 operands 
    public float operand1(){
        scObj = new Scanner(System.in);
        System.out.println("What's your first number?");
        float a = scObj.nextFloat(); //first number;     
        return a;
    }
    public float operand2(){
        scObj = new Scanner(System.in);
        System.out.println("What's your second number?");              
        float b = scObj.nextFloat(); //first number
        //input[1] = b;
        return b;
    }
    public void getCalcFunctions(float op){
        
        if(op==5){
        goodBye();
            
        }
        else if(op==1){
            float a = operand1();
            float b = operand2();
            float result = myCalc.add(a, b); //need to call our method on the object we instantiated
            System.out.println("Your result is: " + result);//we can now print
        }
        else if(op==2){
            float a = operand1();
            float b = operand2();
            float result = myCalc.subtract(a, b); 
            System.out.println("Your result is: "  + result);
        }
        else if(op==3){
           float a = operand1();
            float b = operand2();
            float result = myCalc.multiply(a, b);
            System.out.println("Your result is: " + result);
        }
        else if(op==4){
            float a = operand1();
            float b = operand2();
            float result = myCalc.divide(a, b); 
            System.out.println("Your result is: " + result);
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
