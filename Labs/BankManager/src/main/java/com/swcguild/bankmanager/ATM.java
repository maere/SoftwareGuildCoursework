/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bankmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class ATM {
    ConsoleIO con = new ConsoleIO();
    
    private Integer pinEntry;
    
    
    ///when an ATM is constructed 
    public ATM(){
        BankManager myBank = new BankManager();
    }
    
    public void run(){
        userMenu();
    
    }
    
    public void userVerification(){
        String userNum = con.readString("Please enter your account number to begin: ");
    
    }
    
    public void enterPIN(){
        pinEntry = con.readInt("Hi " +  "Welcome to X Bank. Please enter your PIN to begin: \n");
        
        if(pinEntry==){}
        else{}
    }
    
    public void userMenu(){
        con.print();
    
    }
    
    public void selectAction(){}
    
   
    }
    
    
    
