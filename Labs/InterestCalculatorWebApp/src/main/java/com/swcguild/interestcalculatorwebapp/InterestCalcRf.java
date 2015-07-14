/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculatorwebapp;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalcRfDao {
    //public static void main(String[] args) {
         
//declare fields
       //create scanner at the class level
        private Scanner scObj;
        
         //if there is a variable that we don't need to hang around between functions we don't need a field for it
        //we can have local variables in methods within a class
        private int years;
        private float currentBalance;
        private float intRate;
        private int yearCounter;
        private float interestAccrued = 0;
        private float endPrinciple = 0; 
        private float compound;
        private float yearly;
        private int compoundInterval = 4;
        protected float yearInterest;
       
        //private String message;

       
     
        //constructor
        public InterestCalcRfDao(float currentBalance, int years, float intRate){
            this.currentBalance = currentBalance;
            this.years = years;
            this.intRate = intRate;
            //OLDway:scObj = new Scanner(System.in);  
        }
        
        public void run(){
//            
//            years = userYears();
//            currentBalance = userBalance();
//            intRate = userRate();
            
            EOY();
            //call to print out yearly result
            eoyResultPrintOut();
        
        }
        
           //and ask for input>>>>> this will go in the form
        //refactor into two--asking for a prompt and a number
//        public int userYears(){
//            System.out.println("How many years will you invest?");
//            years = scObj.nextInt();
//            return years;
//        }
//        public float userBalance(){
//            System.out.println("How much money will you be investing?");
//            currentBalance = scObj.nextFloat();
//            return currentBalance;
//        }
//        public float userRate(){
//            System.out.println("What is your annual interest rate?");
//            intRate = scObj.nextFloat();
//            return intRate;
//            
//        }
        

        //outer for loop to cover number of years the money is compounding and print each year's results--could move this whole thing to view (?)
        public void EOY(){ //changed to void for web
                    //need to push all of these into an object with setters, and add the object at the end of the loop
                    //then return the list from the method
            
                for (yearCounter=1; yearCounter<=years; yearCounter++){
                    
                    System.out.println("The year number is: " + yearCounter);                              //yearCounter == entered years
                    System.out.println("The principal at the beginning of the year is: " + currentBalance);//currentBalance
                    yearly = currentBalance;                                                               //yearly

                //call inner loop as function call here
                    accruedInterest(); //acrruedInt method to calculate interest for the year --calculated interest, but isn't returned from the method
                                        //might need to return it
                    endPrinciple = yearly + yearInterest;                                                  //principle at end of year here
                                    //could still return end principle
                    
                    System.out.println("The total amount of interest earned for the year is: " + yearInterest); //yearInterest is available here after running the accrued int
                }
                    //this is the return value of the outer loop    
                    //end principle is the interest added to the startPrinciple at the end of each outer loop
            //return endPrinciple;
            
        }           
      
        public float accruedInterest(){
            
            //inner loop to do the compounding for each quarter?
            compound = intRate/compoundInterval; //4 could be changed to respond to Q-4, M-12, D-30
            
            float quartInterest;
            yearInterest=0;
            
            for (int i = 1; i<=compoundInterval; i++){ //Q, M, D
                  
                //calculate amount of interest each quarter
                quartInterest = (currentBalance * (compound/100));
                
                yearInterest = yearInterest + quartInterest; //this resets year's int each quarter by adding interest for the quarter
                
                //add quarterly interest to yearly interest sum
                currentBalance = currentBalance * (1 + (compound/100));
        
            }
            endPrinciple = yearly + yearInterest;//interestAccrued = yearInterest;
            
            //returns intersestAccrued over a year
            return yearInterest;//return interestAccrued;
        }
        
        //print out results
        
        public void eoyResultPrintOut(){
        //System.out.println("The total amount of interest earned for the year is: " + yearInterest);
        System.out.println(  "The principal at the end of the year is: " + endPrinciple);
        }
            
}
   
        

/*
public class ConsoleIO {
  private Scanner scan;

        public ConsoleIO() {
        scan = new Scanner(System.in);
        } 
*/