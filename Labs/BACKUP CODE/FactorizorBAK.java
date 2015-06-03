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
public class Factorizer {
    public static void main(String[] args) {
        
// This program must ask the user the number for which he/she wants to factor.
    Scanner sc = new Scanner(System.in);

    System.out.println("What number would you like to factor?");
    int number = sc.nextInt();
    
    // The program must print out the original number.
        System.out.println("Your original number is " + number + " and your factors are:");   
        
    
    int numFact = 0;
    int sum = 0;
    //int tempNumb = 0;
        
//The program must print out the total number of factors for the number.
for (int i=number; i>=1; i--){
    //tempNumb = number;// 6, 3,2,1
    if (number%i ==0){
        // The program must print out each factor of the number (not including the number itself).
        System.out.println(i);
        sum = sum + i;
        numFact++;
    }
}
        System.out.println("There are " + numFact + " factors for your number " + number);  
     
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
}

