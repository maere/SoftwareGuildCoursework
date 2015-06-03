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
        float intRate;
        
        int yearCounter;
        float interestAccrued = 0;
        float endPrinciple = 0; //initialization in the compiler error in this case
        //referred to the fact that didn't have a value in 41--this is particular to floats
        
        float currentBalance;
        
        int compound = 4;
        
        //ask for input or assign directly
        years = 20;
        startingPrinciple = 500;
        intRate = .10f; //need to explicitly tell the compiler that it's a float with this f
        // .10 is normally a double, so if i'm changing the game need  to declare
        
        //for loop to cover number of years the money is compounding and print each year's results
        for (yearCounter=0; yearCounter<years; yearCounter++){
            
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
