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
              int n;

    Scanner sc = new Scanner(System.in);

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
    else{
        System.out.println(numPlays + " is not within the range requested. Game over");
    }
        
    }
}    
//--------------------- ends here -------------

//Here is the method call for main- I think this is step 4
//int nTimes = getInputInRange("Welcome to the Rock, Paper, Scissors game.\n "+
  //      "How many times do you want to play? \nPick a number between ", 1, 10);
    
  /* This method is for repeating prompting, not the actual assignment in step 2
    
    public static int getInputInRange(String prompt, int min, int max){
        int n =0;
        Scanner scInput = new Scanner(System.in);

            do{  
            System.out.println(prompt + min + " and " + max);
            n = scInput.nextInt();
            
            }while(n < min || n > max); // while the result is bad, keep prompting
            
            return n;
    }
*/
    

//Maximum number of rounds = 10, minimum number of round = 1. If the user asks
//for something outside this range the program prints and error message and quits.

//If the number of round is in range, the program plays that number of rounds.
//Each round is played according to the requirements in Step 1
          
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