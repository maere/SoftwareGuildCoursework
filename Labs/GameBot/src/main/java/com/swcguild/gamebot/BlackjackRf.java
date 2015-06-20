/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.gamebot;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
//Still need to refactor, moved on because I refectored the other 4

public class BlackjackRf implements Game {
        
        int playerScore;
        int dealerScore;
        int card;
        int playerTotal;
        int dealerTotal;
        //int[] playerDraw;
        //int[] dealerDraw;
        ArrayList<Integer> playerDraw;
        ArrayList<Integer> dealerDraw;
        String response;
        boolean hitMe;
        
        Scanner sc = new Scanner(System.in);
        
    @Override
    public void runGame() {
       
        
        //inital draws
        playerDraw = cardDraw("player");//playerDraw[2]; //convert for ArrayList
        dealerDraw = cardDraw("dealer");
        
        //cardDraw("player");
        //cardDraw("dealer");
        initialDrawsResults();
        playOn();
        playerHit();
        checkPlayer();
        checkGameTotals();
    }

    @Override
    public String getGameTitle() {
        return "Blackjack";
    }
        
    public BlackjackRf(){
            this.playerScore = 0;
            this.dealerScore = 0;
            
        }
        
         //method to generate initial draw data //refactored to an ArrayList return
    public ArrayList cardDraw(String playerName){
        Random r = new Random();
        
        int[] draw;  // change to ArrayList
        draw  = new int[3]; //change to ArrayList
        
        int card1 = (2 + r.nextInt(10));
        int card2 = (2 + r.nextInt(10));
        
        int sum = card1 +card2;
        
        draw [0] = card1; //.add to ArrayList
        draw [1] = card2; //.add to ArrayList
        draw [2] = sum; // .add to ArrayList
            //converstion of Int array to arrayList
        ArrayList<Integer> drawArray = new ArrayList<>();
        
        for (Integer i: draw)
        {
            drawArray.add(i);
        }
        
        return drawArray;  //return ArrayList
     }
           
    //Initial Draw Print out
    public void initialDrawsResults(){
        
        //card=0;
        //playerTotal = //playerDraw[2]; //convert for ArrayList
        //dealerTotal = //dealerDraw[2]; //convert for ArrayList
        playerTotal = playerDraw.get(2);
        dealerTotal = dealerDraw.get(2);
         
        System.out.println("You drew " + playerDraw.get(0) + " and " + playerDraw.get(1));
        System.out.println("Your current total is " + playerTotal);
        //System.out.println("Your current total is " + playerDraw[2] );
        
        //System.out.println("The dealer drew " + dealerDraw[0] + " and an unrevealed card.");
        System.out.println("The dealer drew " + dealerTotal + "and an unrevealed card.");
     
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
                    //playerDraw.add(card) = playerTotal;
                    
                    System.out.println("Would you like another card? (y for yes, n for no)");
                    response = sc.nextLine();
                    
                    if(response.equals("y")){
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
            System.out.println("Your total for this hand is " + playerTotal);  
            dealerTotal = dealerDraw();
           }
    }  
    
    //dealer's turn
    public int dealerDraw(){
        Random r = new Random();
            card = 0;
            dealerTotal = dealerTotal+card;

            while (dealerTotal<16){
                card = 2 + r.nextInt(10);
                dealerTotal = dealerTotal+card;
                //dealerDraw[2] = dealerTotal;
            }
            System.out.println("Dealer result is " + dealerTotal);
            return dealerTotal;
    }
    
    public void checkGameTotals(){
         if (dealerTotal >21){
                    System.out.println("Dealer goes bust. You win.");
                }

                else if (playerTotal == dealerTotal){
                    System.out.println("It's a tie and the dealer wins.");
                }

                else if ((playerTotal>dealerTotal) && playerTotal <=21){
                    System.out.println("You beat the dealer with " + playerTotal + "!");
                }
                else{
                System.out.println("Dealer beats you.");
                }
        }


    
 }  //end primary class 


