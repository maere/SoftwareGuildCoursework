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
public class RockPaperScissorsStep1 {
      public static void main(String[] args) {
        
//Each player (person/computer) chooses Rock, Paper or Scissors. 
//Declare some variables we will need
          
          //int computerPlay;
          
          int rock = 1;
          int paper = 2;
          int scissors = 3;
          
//The computer asks the user for his/her choice (Rock, Paper, or Scissors)
          System.out.println("Welcome to the game Rock, Paper, Scissors.\n Pick 1 if you want to play the Rock, 2 for Paper, and 3 for Scissors.");
          
          Scanner scInput = new Scanner(System.in);
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
}
