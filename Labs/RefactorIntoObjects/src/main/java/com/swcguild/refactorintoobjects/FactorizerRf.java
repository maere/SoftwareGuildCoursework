/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.refactorintoobjects;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FactorizerRf {
    //start refactor
    
    // fields
    private Scanner sc;
    private int numFact = 0;
    private int sum = 0;
    private int number = 0;
    private int[] factorArray; //equivalent to delcaring an object value
    //int tempNumb = 0;
    
    //constructor - we can create it with just a number
    public FactorizerRf() {
         // This program must ask the user the number for which he/she wants to factor.
        sc = new Scanner(System.in);
        //only need params in constructor if I want to change them when I "new" it up/instantiate 
        //this.number = number;
        //this.sum = sum;  -- these last two are not needed
        //this.numFact = numFact;
}
    
  //create a function to run my methods in the class --- will call from app
    public void FactorizerRun(){
        queryNum(); //returns number and changes the value in our object
    //prints results based on the factors stored in the array 
        confirmNumResults();
        gatherResultsArray();
        printResult(); //array is the result of testing numbers as factors of the given number
        
        //test for perfect numbers
        perfectNums();
    }

    public void queryNum(){
        System.out.println("What number would you like to factor?");
        number = sc.nextInt();
    
    }
        
    public void confirmNumResults(){
    // The program must print out the original number.
    //run gatherResultArray here //call this method inside the class instead of in our App
        System.out.println("Your original number is " + number + " and your factors are:");   
    }
//The program must print out the total number of factors for the number.
    // better to split into two methods -- one prints, one gather values
    public void gatherResultsArray(){
        factorArray = new int[3];
        
         for (int i=number; i>=1; i--){
            //tempNumb = number;// 6, 3,2,1
            if (number%i ==0){
                // The program must print out each factor of the number (not including the number itself).
                //w. refactor, if the num is a factor, I need to push into the array, so..
                System.out.println(i);
                sum = sum + i;
                numFact++;
                 
            }
        }
         factorArray[0] = number;
         factorArray[1] = sum;
         factorArray[2] = numFact;
        
        //return factorArray;
    }
    
    public void printResult(){
       // this was pulled from my loop, need to do a for/each on the array
        //to do the printing>>
        /*
        for (int value:factorArray)
        {
            System.out.println(value);
        }
         */
        
        //System.out.println("There are " + numFact + " factors for your number " + number);  
        System.out.println("There were " + factorArray[2] + " factors for your number " + number);  
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


}//end of class