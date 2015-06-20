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
public class LuckySevensRf implements Game {
    private Scanner sc;
    Random r = new Random();

    //declare fields  
    private int die1, die2;
    private int playerMoney = 0; 
    private int rollsCounter = 0;
    private int maxMoney = 0;
    private int peakRolls = 0;
    
    
    //our run function - was refactored from:  public void LuckySevenRunner(){}   and code block was pasted below
                                        //LuckySevensRf newLuckyGame = new LuckySevensRf();
                                         //newLuckyGame.LuckySevenRunner();
    @Override
    public void runGame() {
                                            
        getPlayerMoney();
        playOn();
        outOfMoney();
        playerReport();
    }

    @Override
    public String getGameTitle() {
       return "Lucky Sevens";
    }


    //constructor 
    public LuckySevensRf() {
        sc = new Scanner(System.in);
    }



    public int getDie1() {
        return die1;
    }

    public void setDie1(int die1) {
        this.die1 = die1;
    }

    public int getDie2() {
        return die2;
    }

    public void setDie2(int die2) {
        this.die2 = die2;
    }

    public int getRollsCounter() {
        return rollsCounter;
    }

    public void setRollsCounter(int rollsCounter) {
        this.rollsCounter = rollsCounter;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    public int getPeakRolls() {
        return peakRolls;
    }

    public void setPeakRolls(int peakRolls) {
        this.peakRolls = peakRolls;
    }

    //2. The program first asks the user how many dollars they have to bet.
    public int getPlayerMoney() {
        System.out.println("How much money do you want to bet?");
        playerMoney = sc.nextInt(); //or float nextFloat()
        maxMoney = playerMoney;
        return playerMoney;
    }

    public int rollDice() {
        Random rGen = new Random();
        die1 = rGen.nextInt(6) + 1;
        die2 = rGen.nextInt(6) + 1;
        int currRoll = die1 + die2;
        rollsCounter++;
        return currRoll;
    }


    public boolean playOn() {

        while (playerMoney > 0) {

                //our dice roll was here.... so:  int variable = randomDiceRoll(int myRoll);   
            this.rollDice();
                //4. The program keeps track of how many rolls were taken before the money ran out
                //rollsCounter++;
            
            this.moneyTracker();
                 //- If the sum of the 2 dice is equal to 7, the play wins $4; else the play loses $1
            
        }   //look to adjust maxDollars and maxRolls at the end of each loop
            this.maxDollars();
            this.maxRolls();
        
        return true;
            
    }

    //Refactored: If the sum of the 2 dice is equal to 7, the play wins $4; else the play loses $1
    public int moneyTracker() {
        if (die1 + die2 == 7) {
            playerMoney = playerMoney + 4;
        } else {
            playerMoney = playerMoney - 1;
        }
        return playerMoney;
    }

          //5. The program keeps track of the maximum amount of money held by the player.
    //6. Prgm keeps track of # rolls taken at the point when the user held most money.
    public int maxDollars() {
        if (playerMoney > maxMoney) {
            maxMoney = playerMoney;
        }
        return maxMoney;
    }

    public int maxRolls() {
        if (playerMoney > maxMoney) {
            maxMoney = playerMoney;
            peakRolls = rollsCounter;
        }
        return rollsCounter;
    }


    public void outOfMoney() {
        if (playerMoney <= 0) {
            System.out.println("You can't play--you're out of money.");
        }
    }

    public void playerReport() {
        System.out.println("You are broke after " + rollsCounter + " rolls.");
        System.out.println("You should have quit after " + peakRolls + " rolls when you had $" + maxMoney);
    }

 
    
}
