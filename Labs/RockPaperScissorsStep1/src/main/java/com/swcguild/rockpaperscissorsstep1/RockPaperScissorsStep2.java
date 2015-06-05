/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rockpaperscissorsstep1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep2 {
    public static void main(String[] args) {
        
        //Each player (person/computer) chooses Rock, Paper or Scissors. 
//Declare some variables we will need
          
          //int computerPlay;
          
          int rock = 1;
          int paper = 2;
          int scissors = 3;
          float n;
          
Scanner scInput = new Scanner(System.in);
          
float nTimes = validRange("Welcome to the Rock, Paper, Scissors game.\n How many times do you want to play? \nPick a number between ", 1, 10);
             
//The computer asks the user for his/her choice (Rock, Paper, or Scissors)
System.out.println("This is how you play. Pick 1 if you want to play the Rock, 2 for Paper, and 3 for Scissors.");
          
//Maximum number of rounds = 10, minimum number of round = 1. If the user asks
//for something outside this range the program prints and error message and quits.

//If the number of round is in range, the program plays that number of rounds.
//Each round is played according to the requirements in Step 1
          
          
          
        
          int playerChoice = scInput.nextInt();
          
// After the computer asks for the user's input, the computer randomly chooses Rock, Paper, Sc
          Random rGen = new Random();
          int computerPlay = rGen.nextInt(3) + 1;
          System.out.println("Computer chose "+ computerPlay);
          
 // HINT   1 = Rock, 2 = Paper, 3 = Scissors
          
    /*test
          System.out.println("player" + playerChoice);
          System.out.println("computer" + computerPlay);
           //System.out.println("Paper beats rock.");
           //System.out.println("Rock beats scissors.");
           ///System.out.println("Scissors beats paper");
                //Scissors cuts paper to win
                //Rock breaks Scissors to win
                  //Paper wraps Rock to win
          
          
    */

          if ((playerChoice==2 && computerPlay==1)||(playerChoice==3 &&
                  computerPlay==2)||(playerChoice==1 && computerPlay==3)) 
          {
             
              System.out.println("Player wins.");
          }
          
        
          else if((playerChoice==1 && computerPlay==2)||(playerChoice==2 &&
                  computerPlay==3)||(playerChoice==3 && computerPlay==1)) {
                
              System.out.println("Computer wins.");
             
          }
      
//If both players choose the same thing, the round is a tie.

          else {
          
            System.out.println("The result is a tie.");
          }
        
    }
    
    public static float validRange(String prompt, float min, float max){
        float n =0;
        Scanner scInput = new Scanner(System.in);

            do{  
            System.out.println(prompt + min + " and " + max);
            n = scInput.nextFloat();
            
            }while(n < min || n > max); // while the result is bad, keep prompting
            
            return n; 

    }

    
}
