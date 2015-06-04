/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.primefinder;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class PrimeFinder {
    public static void main(String[] args) {
        
        //Display explanation of pgram to user
        System.out.println("This program asks you for a prime number and returns the number /n"
                + "of primes between 0 and your number.  Your number must be larger than 0.");
        
        int sessionCounter = 0;
        int primeCounter = 0;
        int willPlay;
        Scanner sc = new Scanner(System.in);
        
        //asks the user if he/she wants to find primes (again)
        System.out.println("Do you want to search a number? 1 for yes, 0 for no.");
        willPlay = sc.nextInt();
        
            while (willPlay == 1){     
        
        //Ask user for number
        System.out.println("What number would you like to test?");
        int userNum = sc.nextInt();
        
        //ensure # is larger than 0, and keeps asking until number is valid
        while (userNum<=0){
          System.out.println("Please input a valid number.");
          userNum = sc.nextInt();
          
        }
        
        //finds and displays all of the prime numbers between 0 and the given # -- one per line
        //displays number of primes found
        int counter = 0;
        int tempNum;
        
        for (int i=userNum; i>0; i--){
            
            for (int j=i; j>0; j--){
                
                if (i%j==0){ ///userNum!=i &&
                counter++;
                }
            }
              
                if (counter==2){
                    System.out.println(i + "is a prime.");
                    primeCounter++;
                }
                
            counter = 0;    
        }
        
//count primes during player session
        sessionCounter = sessionCounter + primeCounter;
        primeCounter = 0;

            
            
                System.out.println("Do you want to play again?? 1 for yes, 0 for no.");
                willPlay = sc.nextInt();
                
        }
      
       
        //if no, the pgrm prints a message saying thanks, and prints the total # of primes users/found during the session   
        System.out.println("Thanks for playing. We found " + sessionCounter + " primes  durring this session. ");
        
    }
}
