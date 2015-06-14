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
     // deleted a and b as fields bc we don't need them globally--returned from a function
    //The UI should give the user a choice of operations - one of the choices should be to exit the program
  
     //fields
     //can make the instantiation of our calculator object a field!!!
     private final SimpleCalculator myCalc;  //b/c we'll need the calc throughout, so we declare it here
                                        //if declaring here we must also assign a name for field 
                                        //so that we can grab it as an object and perform methods on it
     
     //constructor for calcUI (we need this for our App to grab this and run these methods)
     public CalcUI(){
      this.myCalc = new SimpleCalculator(); // even though we declared, we still have to instantiate
                                            //now we can grab it
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
    
    public int userCalcRequest(){         
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt(); //operator
        return op;
    }
    
    // Once the user selects an operations, the UI should ask the user for 2 operands 
    public float operand1(){
        Scanner scObj = new Scanner(System.in);
        System.out.println("What's your first number?");
        float a = scObj.nextFloat(); //first number;     
        return a;
    }
    public float operand2(){
        Scanner scObj = new Scanner(System.in);
        System.out.println("What's your second number?");              
        float b = scObj.nextFloat(); //first number
        //input[1] = b;
        return b;
    }
    
        
//call the appropriate method in the calc class based on input and pass 3 integers (choice, a, b)
        
//and then display the result of the calculation
    //each calc method should return the result of the calc
  
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
            float result = myCalc.multilply(a, b);
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
/*
Create another class that presents a simple console calculator UI to the user. This
second class should handle all user input and console output and must use the first
class to perform all of the math operations

Notes from doing the exercize:

fields from one class are not available to another in the same package if they are private
if fields are public, they are available, but generally we don't want to do this

the point of calling methods from other classes is to get values back to use

.*/