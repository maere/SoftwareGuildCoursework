/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessmynumberwarmup;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class GuessMyNumber {
    public static void main(String[] args) {
        //generate number between one and 10
Random r = new Random();
    int number = 1 + r.nextInt(10);

//prompt user to guess an input
Scanner sc = new Scanner(System.in);
        System.out.println("Guess an input between 1 and 10.");    
    int playerGuess = sc.nextInt();

//verify that the number is in the right range, request re-entry if not
    //redo the do while below as a method & method call
 int guessToTest = validGuess(playerGuess);   
    /*
    do {
        System.out.println("That is not in the required range. Please re-enter a  number between 1 & 10");
          playerGuess = sc.nextInt();
    }
    while(playerGuess>10 || playerGuess<1);
    */
 
//count the number of times it took them to guess the number    
   int count =0;
// if not correct, ask them to guess again
    while (guessToTest!=number){
       
        System.out.println("That is incorrect. Guess again.");
          guessToTest = sc.nextInt();
          count++;
        
    }

//if is correct tell them they won
        System.out.println("You got it! The number was " + number);
        System.out.println("It took you " + count + " guesses.");
    
    
    }
    
    public static int validGuess(int test){
        
        do {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("That is not in the required range. Please re-enter a  number between 1 & 10");
            test = sc.nextInt();
        }
    while(test>10 || test<1);
    
    return test; 
    }
}
/*
//refactor the validation as a method


*/
