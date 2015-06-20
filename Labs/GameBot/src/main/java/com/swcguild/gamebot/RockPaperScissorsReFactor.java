/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.gamebot;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsReFactor implements Game {
    //private static Object response;
    
    
    @Override
    public void runGame() {
        runRPS();
    }

    @Override
    public String getGameTitle() {
       return "Rock, Paper, Scissors";
    }
    
    public void runRPS() {
        
        Scanner sc = new Scanner(System.in);
        String response;
        
        do {
            
            
            //Each player (person/computer) chooses Rock, Paper or Scissors. 
    //Declare some variables we will need

              //int computerPlay;

              int rock = 1;
              int paper = 2;
              int scissors = 3;
              int n;
              
              // variables for tracking rounds
        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;



    //Maximum number of rounds = 10, minimum number of round = 1. If the user asks
       //for something outside this range the program **prints and error message and quits.**
    System.out.println("How many times to do you want to play?  You must choose a number between 1 & 10.");
    int numPlays = sc.nextInt();
            
        

    //If the number of round is in range, the program plays that number of rounds.  
    //Each round is played according to the requirements in Step 1
    if (numPlays >=1 && numPlays<=10){
        
        
        
        
        //play as before, but in a for loop according to the number of plays
        for (int i=1; i<=numPlays; i++){

            //The computer asks the user for his/her choice (Rock, Paper, or Scissors)
    System.out.println("Okay. Round " + i + " Pick 1 if you want to play the Rock, 2 for Paper, and 3 for Scissors.");

              int playerChoice = sc.nextInt();

    // After the computer asks for the user's input, the computer randomly chooses Rock, Paper, Sc
              Random rGen = new Random();
              int computerPlay = rGen.nextInt(3) + 1;
              System.out.println("Computer chose "+ computerPlay);

              if ((playerChoice==2 && computerPlay==1)||(playerChoice==3 &&
                      computerPlay==2)||(playerChoice==1 && computerPlay==3)) 
              {

                  System.out.println("Player wins.");
                  playerWins++;
              }


              else if((playerChoice==1 && computerPlay==2)||(playerChoice==2 &&
                      computerPlay==3)||(playerChoice==3 && computerPlay==1)) {

                  System.out.println("Computer wins.");
                  computerWins++;

              }

    //If both players choose the same thing, the round is a tie.

              else {

                System.out.println("The result is a tie.");
                ties++;
              }


        }

    }
    else{
        System.out.println(numPlays + " is not within the range requested. Game over");
    }
        System.out.println("------------------");
    // print out and evaluation of wins, losses, ties and winner declaration
        System.out.println("Player wins " + playerWins + " games.");
        System.out.println("Computer wins " + computerWins + " games.");
        System.out.println("There are " + ties +" ties." );
        System.out.println("------------------");
        if (playerWins == computerWins)
        {
            System.out.println("Tied games.");
        }
        else if(playerWins > computerWins)
        {
            System.out.println("Player wins the round.");
        }
        else{
            System.out.println("Computer wins the round.");
        }
        
        
        
            response = sc.nextLine();
            System.out.println("Do you want to play again? (y for yes)");
            
           
        }
        while (response.equals("y"));
        
        System.out.println("Thanks for playing! Goodbye.");
        
        //
        
        
    }

    
}
