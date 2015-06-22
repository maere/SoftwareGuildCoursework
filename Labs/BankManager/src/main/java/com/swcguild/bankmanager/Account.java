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
public abstract class Account {
    
    protected String userNum;
    protected int pinNumber;
    
    public String firstName;
    public String lastName;
    
    protected float balance;
    
    //each account stores PIN, name, first and last and has ability to read and write to balance
    public Account(String userNum, String firstName, String lastName, int pinNumber, float balance){
        this.userNum=userNum; 
        this.pinNumber = pinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    
  
    public abstract void openAccount();
    public abstract void deposit();    
    public abstract void withdrawl();
    //include withdrawl checks--
        //check account balance test
        //check amount to withdrawl test
    
    
}
