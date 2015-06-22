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
 * @author apprentice--DAO
 */
public class BankManager {
    ConsoleIO con = new ConsoleIO();
    //each account records are mapped here
    
    //username (or ID) and their accounts
    Map<String, ArrayList<Account>> bankAccounts = new HashMap<>();
    
    //so the account should store a pin as property, 
    //and an ArrayList of userAccounts, with the items in the ArrayList called by Object (either Savings or Checking)
    ArrayList<Account> userAccounts = new ArrayList<>();   
    
   
    
    
    
    //if the PIN matches more than one account, pulls up both
    
    //can instantiate either a checking or a savings account//each Savings or Checking object has a name, balance, account number, 
     public void openAccount(){
         //ask for stuff
          String userNum = con.readString("Enter the account number: ");
          String firstName = con.readString("Enter account holders' first name:");
          String lastName = con.readString("Enter account holder's last name:");
          int pin = con.readInt("Enter PIN you would like to use for the account: ");
          float balance = con.readFloat("Enter the initial deposit for opening the account:");
          int accountType = con.readInt("Enter 1 to open a savings account, or 2 to open a checking account:");
          
         //instantiate object
          if(accountType==1){
              Savings newAccount = new Savings(userNum, firstName, lastName, pin, balance);
          }
          else if(accountType==2){
              Checking newAccount = new Checking(userNum, firstName, lastName, pin, balance);
          }
          else{
              System.out.println("There has been an error.");
          }
         
         //set properties of object
          newAccount.
         
         //put object into hash
    
    
    }
    
    //reading and writing to account ledgers is done here
     
     
    
}
