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
public class IntCalcTests {
    public static void main(String[] args) {
        
    //ask for input or assign directly
    int years = 20;
    float currentBalance = 100;
    float intRate = 10; 
    //int yearCounter;
    
    double interestAccrued = 0;
    double endPrinciple; //initialization error in the compiler origiinally
    //was referring to the fact that didn't have a value in line 41--this is particular to floats

    float compound;
    compound = intRate/4; //4 could be changed to respond to Q, M, D
    
    for (int i = 0; i<4; i++){ //Q, M, D
                
                //add quarterly interest to yearly interest sum
                currentBalance = currentBalance * (1 + (compound/100));
                
                //calculate amount of interest each quarter
                interestAccrued = interestAccrued + (currentBalance * (compound/100));
               
            }
            //end principle is added interest to the startPrinciple at the end of each outer loop
            endPrinciple = currentBalance;
            

        System.out.println("The total amount of interest earned for the year is: " + interestAccrued);
        System.out.println("The principal at the end of the year is: " + endPrinciple);
        
    }
}
