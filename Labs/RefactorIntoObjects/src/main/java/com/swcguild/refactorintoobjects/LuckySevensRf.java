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
public class LuckySevensRf {
    private Scanner sc;
    Random r = new Random();

    //declare fields  
    private int die1, die2;
    private int playerMoney = 0; 
    private int rollsCounter = 0;
    private int maxMoney = 0;
    private int peakRolls = 0;

    //constructor 
    public LuckySevensRf() {
        sc = new Scanner(System.in);
    }
//these LIVE with the object once created, so we don't need to pass them into the method
        //bc it *lives* with the object and will change as method acts on it, the value gets stored
        //as the state of the object currently

    //our run function
    public void LuckySevenRunner(){
        getPlayerMoney();
        playOn();
        outOfMoney();
        playerReport();
    
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

    //public int getPlayerMoney() {
    //   return playerMoney;
    // }
    //public void setPlayerMoney(int playerMoney) {
    //    this.playerMoney = playerMoney;
    //}
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

//3. The program then rolls the dice repeatedly until all the money is gone.
// loop construct to keep playing until the money is gone.
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
 // pulled this out of max Rolls and need to put back into main?
        /*
     else{
     System.out.println("You can't play--you're out of money.");
     } 
     */

    public void outOfMoney() {
        if (playerMoney <= 0) {
            System.out.println("You can't play--you're out of money.");
        }
    }

    /*tests
     System.out.println("die1 = " + die1);
     System.out.println("die2 = " + die2);
     System.out.println("roller's cash = " + playerMoney);
    
     You are broke after 543 rolls.
     You should have quit after 47 rolls when you had $113
     */
    public void playerReport() {
        System.out.println("You are broke after " + rollsCounter + " rolls.");
        System.out.println("You should have quit after " + peakRolls + " rolls when you had $" + maxMoney);
    }

    
}
