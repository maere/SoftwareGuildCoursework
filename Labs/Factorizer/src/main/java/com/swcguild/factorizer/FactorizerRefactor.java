/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizer;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FactorizerRefactor {
//start refactor
    
    // fields
    private int numFact = 0;
    private int sum = 0;
    private int number = 0;
    private int[] factorArray; //equivalent to delcaring an object value
    //int tempNumb = 0;
    
    //constructor
    public FactorizerRefactor(int number, int sum, int numFact) {
        //only need params in constructor if I want to change them when I "new" it up/instantiate 
        this.number = number;
        this.sum = sum;
        this.numFact = numFact;

}
    
    // This program must ask the user the number for which he/she wants to factor.
    Scanner sc = new Scanner(System.in);

    public int queryNum(){
        System.out.println("What number would you like to factor?");
        number = sc.nextInt();
    
    // The program must print out the original number.
        //run gatherResultArray here //call this method inside the class instead of in our App
        
        System.out.println("Your original number is " + number + " and your factors are:");   
        
        return number;
    }
        
//The program must print out the total number of factors for the number.
    // better to split into two methods -- one prints, one gather values
    public int[] gatherResultsArray(){
        factorArray = new int[number +1];
         for (int i=number; i>=1; i--){
            
    //tempNumb = number;// 6, 3,2,1
            if (number%i ==0){
                // The program must print out each factor of the number (not including the number itself).
                //w. refactor, if the num is a factor, I need to push into the array, so..
                factorArray[i] = number;
                sum = sum + i;
                numFact++;
            }
        }
        
        return factorArray;
    }
    
    public void printResult(){
       // this was pulled from my loop, need to do a for/each on the array
        //to do the printing>>
        for (int value:factorArray)
        {
            System.out.println(value);
        }
        
        System.out.println("There are " + numFact + " factors for your number " + number);  
        //return sum;
    }
    

     public void perfectNums(){
         // The program must print out whether or not the number is perfect.
        int sumCorrection = sum - number;
        //System.out.println("sumCorris now: " + sumCorrection);
   
if (number == sumCorrection){
    System.out.println("Congrats! You picked a perfect number.");
}

// The program must print out whether or not the number is prime.
if (numFact == 2){
    System.out.println("Your number is also a prime!!");
}
    
     }

//when you finish refactoring, he wants us to create  a "run" method 
     //in the class that does the callling of the methods in the class for the object
     //ultimately we only want to call run(); in our app.class.

    
}//end class
