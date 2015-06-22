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
public class Checking extends Account {

    public Checking(String userNum, String firstName, String lastName, int pinNumber, float balance) {
        super(userNum, firstName, lastName, pinNumber, balance);
    }

        
    //constructor
     
     
    public void deposit(){
    
    }
    
    
    
    public void withdrawl(){
    //include withdrawl checks--
        //check account balance test
        //check amount to withdrawl test
    }
    
    public void negativeBalanceCheck(){}
    
    public void overdraftFee(){}

    @Override
    public void openAccount() {
        
    }
    
}

/*
    public void openAccount(){
         //ask for stuff
          String userNum = con.readString("Enter the account number: ");
          String firstName = con.readString("Enter account holders' first name:");
          String lastName = con.readString("Enter account holder's last name:");
          int pin = con.readInt("Enter PIN you would like to use for the account: ");
          float balance = con.readFloat("Enter the initial deposit for opening the account:");
          
         //instantiate object
          
         
         //set properties of object
         
         //put object into hash
    
    
    }
    
*/