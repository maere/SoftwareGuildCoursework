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
        
        int playerScore;
        int dealerScore;
        int card;
        int playerTotal;
        int dealerTotal;
        int[] playerDraw;
        int[] dealerDraw;
        //ArrayList<Integers> playerDraw;
        //ArrayList<Integers> dealerDraw;
        String response;
        boolean hitMe;
        
        Scanner sc = new Scanner(System.in);
        
    public BlackjackRf(){
            this.playerScore = 0;
            this.dealerScore = 0;
            
        }
        
         //method to generate initial draw data
    public int[] cardDraw(String playerName){
        Random r = new Random();
        
        int[] draw;  // change to ArrayList
        draw  = new int[3]; //change to ArrayList
        
        int card1 = (2 + r.nextInt(10));
        int card2 = (2 + r.nextInt(10));
        
        int sum = card1 +card2;
        
        draw [0] = card1; //.add to ArrayList
        draw [1] = card2; //.add to ArrayList
        draw [2] = sum; // .add to ArrayList
        
        return draw;  //return ArrayList
     }
           
    //Initial Draw Print out
    public void initialDrawsResults(){
        
        card=0;
        playerTotal = playerDraw[2]; //convert for ArrayList
        dealerTotal = dealerDraw[2]; //convert for ArrayList
         
        System.out.println("You drew " + playerDraw[0] + " and " + playerDraw[1] );
        System.out.println("Your current total is " + playerDraw[2] );
        
        System.out.println("The dealer drew " + dealerDraw[0] + " and an unrevealed card.");
        
     
        }
    
    public String playOn(){
        System.out.println("Would you like another card? (y for yes, n for no)");
        response = sc.nextLine();
        return response;
    }
   
    //adds player cards while yes, returns playerTotal     
    public int playerHit(){ 
            
        if(response.equals("y")){
            hitMe=true;
        }
            while (playerTotal<22 && hitMe == true)
                {    
                    Random r = new Random();
                    card = 2 + r.nextInt(10);
                    playerTotal = playerTotal+card;

                    System.out.println("Your total now equals " + playerTotal);
                    playerDraw[2] = playerTotal;
                    
                    System.out.println("Would you like another card? (y for yes, n for no)");
                    response = sc.nextLine();
                    
                    if (response.equals("y")){
                        hitMe = true;
                    
                    }
                    else{
                        hitMe = false;
                    }
            
                }   
            return playerTotal;
        } 

    public void checkPlayer(){
           if(playerTotal>21)
            {
            System.out.println("You are over 21! Dealer wins");
            }
           else{
            System.out.println("Your total for this hand is " + playerDraw[2]);  
            dealerTotal = dealerDraw();
           }
    }  
    
    //dealer's turn
    public int dealerDraw(){
        Random r = new Random();
            card = 0;
            dealerTotal = dealerDraw[2];

            while (dealerTotal<16){
                card = 2 + r.nextInt(10);
                dealerTotal = dealerTotal+card;
                dealerDraw[2] = dealerTotal;
            }
            System.out.println("Dealer result is " + dealerDraw[2]);
            return dealerTotal;
    }
    
    public void checkGameTotals(){
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
    
 }  //end primary class 


