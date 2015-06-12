/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.refactorintoobjects;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
//Still need to refactor, moved on because I refectored the other 4

public class BlackjackRf {
    public static void main(String[] args) {
        
        int playerScore = 0;
        int dealerScore = 0;
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        
        //inital draws
        //player1 = (2 + r.nextInt(12)) + (2 + r.nextInt(12));
        //dealer = (2 + r.nextInt(12)) + (2 + r.nextInt(12));    
        
        //test so far
        //System.out.println(player1);
        //System.out.println(dealer);
        int[] playerDraw = cardDraw("player");
        int[] dealerDraw = cardDraw("Dealer");
        
        System.out.println("You drew " + playerDraw[0] + " and " + playerDraw[1] );
        System.out.println("Your current total is " + playerDraw[2] );
        
        System.out.println("The dealer drew " + dealerDraw[0] + " and an unrevealed card.");
        
        int card;
        int total;
        total = playerDraw[2];
        
        String response;
        System.out.println("Would you like another card? (y for yes)");
        response = sc.nextLine();
      
        
        while (response.equals("y"))
            
            
            {
                if (total<22)
                {    
                    card = 2 + r.nextInt(10);
                    total = total+card;

                    System.out.println("Your total now equals " + total);

                    System.out.println("Would you like another card? (y for yes)");
                    response = sc.nextLine();
                    
                    playerDraw[2] = total;
                    //test - System.out.println(playerDraw[2]);
                }
                else 
                {
                    System.out.println("You are over 21! Dealer wins");
                }
            }
        System.out.println("Your total for this hand is " + playerDraw[2]);
        
//dealer's turn
        card = 0;
        total = dealerDraw[2];
        while (total<16){
            card = 2 + r.nextInt(10);
            total = total+card;
            dealerDraw[2] = total;
            
        }
        System.out.println("Dealer result is " + dealerDraw[2]);
        
        if (dealerDraw[2] >21){
            System.out.println("Dealer goes bust. You win.");
        }
        
        else if (playerDraw[2] == dealerDraw[2]){
            System.out.println("It's a tie and the dealer wins.");
        }
               
        else if ((playerDraw[2]>dealerDraw[2]) && playerDraw[2] <=21){
            System.out.println("You beat the dealer with " + playerDraw[2] + "!");
        }
        else{
        System.out.println("Dealer beats you.");
        }
    }
    
   
    
        
    //method to generate draw data
    
     public static int[] cardDraw(String playerName){
        Random r = new Random();
        int[] draw;
        draw  = new int[3];
        int card1 = (2 + r.nextInt(10));
        int card2 = (2 + r.nextInt(10));
        int sum = card1 +card2;
        draw [0] = card1;
        draw [1] = card2;
        draw [2] = sum;
        return draw;
     }
    
}
