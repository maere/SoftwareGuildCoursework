/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculator;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {
    public static void main(String[] args) {
        
        //declare vars
        int years;
        float startingPrinciple;
        float interestRate;
        
        int yearCounter;
        float interestAccrued = 0;
        float endPrinciple;
        
        float currentBalance;
        
        int compound = 4;
        
        //ask for input or assign directly
        years = 20;
        startingPrinciple = 500;
        interestRate = .10;
        
        //for loop to cover number of years the money is compounding and print each year's results
        for (yearCounter=0; i<years; yearCounter++){
            
        System.out.println("The year number is: " + yearCounter);
        System.out.println("The principal at the beginning of the year is: " + startingPrinciple);
        System.out.println("The total amount of interest earned for the year is: " + interestAccrued);
        System.out.println("The principal at the end of the year is: " + endPrinciple);
         
           //inner loop to do the compounding each quarter?
        
            /*      currentBalance * (1 + (quarterlyInterestRate / 100))
            every three months, the principal is multiplied by 2.5% (the 10%
            annual rate divided by 4 because it is compounded 4 times per year) 
            and the result is added to
            the principal.
            */
        }
        
     
    
    }
    
}
