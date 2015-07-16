/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.services;

import com.swcguild.firstmultiappmvcproject.model.FiscalYear;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalcRf {
    //public static void main(String[] args) {

    //declare fields
   
    private FiscalYear currentYear;

    //if there is a variable that we don't need to hang around between functions we don't need a field for it
    //we can have local variables in methods within a class
    private int years;
    private float currentBalance;
    private float intRate;
    //private int yearCounter;
    private float interestAccrued = 0;
    private float endPrinciple = 0;
    private float compound;
    private float yearly;
    private int compoundInterval = 4;
    protected float yearInterest;

       
    //constructor
    public InterestCalcRf(float currentBalance, int years, float intRate) {
        this.currentBalance = currentBalance;
        this.years = years;
        this.intRate = intRate;
        //added DTO class for Fiscal year, will instantiate with a DTO               
        //FiscalYear year = new FiscalYear();

    }

    public void run() {

        EOY();
          
    }

       
    public List<FiscalYear> EOY() { 
       
        List<FiscalYear> resultsList = new ArrayList<>();

        for (int yearCounter = 0; yearCounter <= years - 1; yearCounter++) {
            
            currentYear = new FiscalYear();
             

            currentYear.setYear(yearCounter+1);
            currentYear.setCurrentBalance(currentBalance);
            float interest = accruedInterest(); 
            
            //yearly = currentBalance; 
            //endPrinciple = currentBalance + yearInterest;
            
            currentYear.setYearInterest(interest);
            
            //endPrinciple = yearly + interest;
            currentYear.setEndPrinciple(endPrinciple);

            resultsList.add(currentYear);

        }
                   
        return resultsList;

    }

    public float accruedInterest() {

        //inner loop to do the compounding for each quarter?
        compound = intRate / compoundInterval; //4 could be changed to respond to Q-4, M-12, D-30

        float quartInterest;
        yearInterest = 0;
       

        for (int i = 1; i <= compoundInterval; i++) { //Q, M, D

            //calculate amount of interest each quarter
            quartInterest = (currentBalance * (compound / 100));

            yearInterest = yearInterest + quartInterest; //this resets year's int each quarter by adding interest for the quarter

            //add quarterly interest to yearly interest sum
            currentBalance = currentBalance * (1 + (compound / 100));

        }
        endPrinciple = currentBalance + yearInterest;//interestAccrued = yearInterest;

        //returns intersestAccrued over a year
        return yearInterest;//return interestAccrued;
    }
  
}

