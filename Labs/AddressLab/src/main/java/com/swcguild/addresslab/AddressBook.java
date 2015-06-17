/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addresslab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice -- DAO
 */
public class AddressBook {
    
    //fields (class level variables)
    //to store our addresses
    public static final String ADDRESSES_FILE = "addresses.txt";
    public static final String DELIMITER = "::";
    
    int idNumber;
    Address addressObject;
    
      //constructor
    HashMap<Integer, Address> addressMap = new HashMap<>();
    
    //this is only use to create a unique ID, NOT to keep track of records
    //static int counter; //is all one of these fields for all address books we may want to make
    //ArrayList<String> stringList = new ArrayList<>(); 
    
    //we need to use the HashMap to count records, to figure out where to inserrt the 
    //next record or where to pull the from
   
   
    //read and write data methods
    public void loadAddresses()throws FileNotFoundException {
       Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESSES_FILE)));
       
       String currentLine;
       String[]currentTokens;
       
       while(sc.hasNextLine()){
           currentLine = sc.nextLine();
           currentTokens = currentLine.split(DELIMITER); //why not "::"?
           
           Address currentAddress  = new Address(Integer.parseInt(currentTokens[0])); //we have to parseInt bc evertying out of a file reader is a string
           currentAddress.setFirstName(currentTokens[1]);
           currentAddress.setLastName(currentTokens[2]);
           currentAddress.setStreet(currentTokens[3]);
           currentAddress.setCity(currentTokens[4]);
           currentAddress.setState(currentTokens[5]);
           currentAddress.setZipCode(Integer.parseInt(currentTokens[6]));
           
           addressMap.put(currentAddress.getIdNumber(), currentAddress);
       }
       //close
       sc.close();
    }
    
    
     public void writeToAddresses() throws IOException {
     PrintWriter out = new PrintWriter(new FileWriter(ADDRESSES_FILE));
     
     //this is the ArrayList we get from all the objects we just pulled from our hash
     ArrayList<Address> addressKeys = this.getAllAddresses();
     //do we need to use the keyArray instead?  
                
        for(Address currentAddress: addressKeys)//this is a bunch of objects (the values)
        {
            
            
            //String strI = Integer.toString(i);
            String strId = Integer.toString(currentAddress.getIdNumber());
           
            out.println(strId + DELIMITER + 
                    currentAddress.getFirstName()+ DELIMITER +
                    currentAddress.getLastName()+ DELIMITER + 
                    currentAddress.getStreet()+ DELIMITER + 
                    currentAddress.getCity() + DELIMITER +
                    currentAddress.getState() + DELIMITER +
                    currentAddress.getZipCode());
            //flush before you leave the loop
            out.flush();
        }
    //and close
        out.close();
        
     }
     
    //getters and setters
    public Address getAddress(int idNumber){
         return addressMap.get(idNumber);
    }
    //methods
    
    public void addAddressToBook(Address addressObject) throws IOException{
      idNumber = addressMap.size()+1;
      //idNumber++;
      //idNumber= counter;
      addressMap.put(idNumber, addressObject);
    //now id/Object is in the HashMap, but has not yet been written to the file
      //addressObject.setIdNumber(idNumber);
      
    }
    
    public void removeAddress(int idNumber) {
        addressMap.remove(idNumber); ///.remove(idNumber, addressObject);
        //return addressObject;
  
    }
    
    
    //get address from the hash
    
    //get all addresses from hash
    ArrayList<Address> getAllAddresses() {
        
        Set<Integer> keys = addressMap.keySet();
                 
        ArrayList addressArray = new ArrayList<>();
        
        for(Integer k: keys){
            //k.toString();  -- this just converts the uniqueID to a string
            addressArray.add(addressMap.get(k));
        }
        
        return addressArray;  //this is a object array of all the addresses   
    }

    
    
}
