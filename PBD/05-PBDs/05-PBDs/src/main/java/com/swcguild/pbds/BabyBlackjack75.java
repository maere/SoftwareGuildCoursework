/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BabyBlackjack75 {
    public static void main(String[] args) {
        //variables for the players
        int player1;
        int computer;
        
        System.out.println("You will play the computer in Baby Blackjack. We will pick 2 cards for each player.");
        
        
        Random r = new Random();
        
        //evaluate player results -- sum and compare
        //int sum1;
        //int sum2;
            //cards picks--probably good to do this in a for loop
            for (int i=1; i<3; i++)
            {
                int card1 = 1 + r.nextInt(10);
                int card2 = 1 + r.nextInt(10); 
                
                if (i==1){         
                player1 = card1 + card2;
                System.out.println("You drew " + card1 + " and " + card2); 
                System.out.println("Your total is " + player1);
                } 
                else if (i==2){
                computer = card1 + card2;
                System.out.println("The dealer has " + card1 + " and " + card2); 
                System.out.println("Dealer's total is " + computer);
                }
               // else{
               //System.out.println("Something went wrong.");
                //}
                
            }
            
            //declare winner
            /* this doesn't work because the program didn't retain the value of the variable
            outside of the for loop, even though it was declared globallyy
            if (player1 > computer)
            {
                System.out.println("You won!");
            }
            else
            {
                System.out.println("Dealer wins.");
            }
            */
        
            
        
    }
    
}

/*
Write a program that allows a human user to play a single hand
of "blackjack" against a dealer.

    Pick two values from 1-10 for the player. 
    These are the player's "cards".
    Pick two more values from 1-10 for the dealer.
    Whoever has the highest total is the winner.

    Baby Blackjack!

You drew 6 and 5.
Your total is 11.

The dealer has 7 and 3.
Dealer's total is 10.

YOU WIN!

*/

