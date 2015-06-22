/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bankmanager;

/**
 *
 * @author apprentice
 */
public class Savings extends Account {

    public Savings(String userNum, String firstName, String lastName, int pinNumber, float balance) {
        super(userNum, firstName, lastName, pinNumber, balance);
    }
 
    
    public void deposit(){}
    
    
    public void withdrawl(){
    //include withdrawl checks--
        //check account balance test
        //check amount to withdrawl test
    }
    
    //withdrawl penalty
    public void withdrawlPenaltyCheck(){}
    
    public void interestCalculator(){}

    @Override
    public void openAccount() {
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
