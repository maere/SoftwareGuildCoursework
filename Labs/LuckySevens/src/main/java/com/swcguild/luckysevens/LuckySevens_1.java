/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LuckySevens_1 {
    private static Object cs;
    public static void main(String[] args){
        
        //declare two dice vars    
        int die1;
        int die2;
        
        //moved var:  better's Money--declared below with scanner as float
        int rollsCounter = 0;//rollsCounter
        
        //moved var: maxMoney--moved below $input to set start point
        int peakRolls = 0;//highPoint
        
    //2. The program first asks the user how many dollars they have to bet.
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How much money do you want to bet?");
        int playerMoney = sc.nextInt(); //or float nextFloat()
        
        int maxMoney = playerMoney;   
        
//3. The program then rolls the dice repeatedly until all the money is gone.
// loop construct to keep playing until the money is gone.
        
       if (playerMoney>0){
            
           while (playerMoney >0){
                //Each round the program rolls a virtual pair (2) of dice for the user    
                Random rGen = new Random();
                die1 = rGen.nextInt(6) + 1;
                die2 = rGen.nextInt(6) + 1;
                
                //- If the sum of the 2 dice is equal to 7, the play wins $4; else the play loses $1
                if (die1 +die2 == 7){
                    playerMoney = playerMoney + 4;
                }    
                else{
                    playerMoney = playerMoney - 1;
                }     
          //4. The program keeps track of how many rolls were taken before the money ran out
                rollsCounter++;
          
          //5. The program keeps track of the maximum amount of money held by the player.
          //6. Prgm keeps track of # rolls taken at the point when the user held most money.
                if (playerMoney > maxMoney){
                    maxMoney = playerMoney;
                    peakRolls = rollsCounter;
                }
           
           }
        
       } 
       else {
        System.out.println("You can't play--you're out of money.");
        }   
          
    /*tests
        System.out.println("die1 = " + die1);
        System.out.println("die2 = " + die2);
        System.out.println("roller's cash = " + playerMoney);
    
    You are broke after 543 rolls.
    You should have quit after 47 rolls when you had $113
    */   
        System.out.println("You are broke after " + rollsCounter + " rolls.");
        System.out.println("You should have quit after " + peakRolls + " rolls when you had $" + maxMoney);
     
    }
//3. The program then rolls the dice repeatedly until all the money is gone.
//a. HINT: use a loop construct to keep playing until the money is gone.
//a. HINT for 4, 5, and 6: declare some variables
}
