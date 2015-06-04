/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {
    public static void main(String[] args) {
        
        Scanner scObj = new Scanner(System.in);
//declare vars and ask for input
        System.out.println("How many years will you invest?");
        int years = scObj.nextInt();
        System.out.println("How much money will you be investing?");
        float currentBalance = scObj.nextFloat();
        System.out.println("What is your annual interest rate?");
        float intRate = scObj.nextFloat();
        
        int yearCounter;
        float interestAccrued = 0;
        float endPrinciple = 0; //initialization error in the compiler origiinally
        //was referring to the fact that didn't have a value in line 41--this is particular to floats
        
        float compound;
        compound = intRate/4; //4 could be changed to respond to Q, M, D
        
        //ask for input or assign directly //years = 20; //startPrinciple = 500;
        //intRate = .10f; //need to explicitly tell the compiler that it's a float with this f
        // .10 is normally a double, so if i'm changing the game need  to declare
        
        //for loop to cover number of years the money is compounding and print each year's results
        for (yearCounter=1; yearCounter<=years; yearCounter++){
            
        System.out.println("The year number is: " + yearCounter);
        System.out.println("The principal at the beginning of the year is: " + currentBalance);
        
        float yearly = currentBalance;
         
           //inner loop to do the compounding for each quarter?
            for (int i = 1; i<=4; i++){ //Q, M, D
                  
                //calculate amount of interest each quarter
                interestAccrued = interestAccrued + (currentBalance * (compound/100));
//this part is off....                
                //add quarterly interest to yearly interest sum
                currentBalance = currentBalance * (1 + (compound/100));
               
            }
            //end principle is added interest to the startPrinciple at the end of each outer loop
            endPrinciple = yearly + interestAccrued;
            

        System.out.println("The total amount of interest earned for the year is: " + interestAccrued);
        System.out.println("The principal at the end of the year is: " + endPrinciple);
        }
        
     
    
    }
    
}
