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
          // HINT   1 = Rock, 2 = Paper, 3 = Scissors
          Random rGen = new Random();
          int computerPlay = rGen.nextInt(3) + 1;
          
    /*test
          System.out.println("player" + playerChoice);
          System.out.println("computer" + computerPlay);
    */
          
        //If both players choose the same thing, the round is a tie.
            System.out.println("The result is a tie.");
        
        //Paper wraps Rock to win
        //Scissors cuts paper to win
        //Rock breaks Scissors to win
        //then displays the result of the round
        
    }
}
