/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addresslab;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class AddressBookController {
    
    //add a console object to take input from user
    private ConsoleIO con = new ConsoleIO();
    private AddressBook myAddressBook = new AddressBook();
    //String name;
      int idNumber;
     
    
    //constructor
    
    
   //methods
    public void run(){
       mainMenu();
       int choice = 0;
       choice = con.readInt("Which would you like to do?");
       
        switch (choice) {
            case 1:
                createAddress();
                break;
            case 2:
                removeAddress();
                break;
            case 3:
                findAddress();
                break;
            case 4:
                countAddresses();
                break;
                /*
            case 5:
                listAddresses();
                break;
                        */
            case 6:
                System.out.println("Exiting the system");
                break;
            default:
                throw new AssertionError();
        }

    }
    
    private void mainMenu(){
        con.print("Main Menu");
        con.print("---------");
        con.print("1. Add Address");
        con.print("2. Delete Address");
        con.print("3. Find Address");
        con.print("4. Return Total Number of Addresses Storeed");  
        con.print("5. List All Addresses");  
        con.print("6. Exit");  
 
    }
    
    public void createAddress(){
    
        String firstName = con.readString("Please type in the first name of the person you want to add.");
        String lastName = con.readString("Please type in the last name of the person you want to add.");
        String street = con.readString("Please type in their street address (e.g. 123 Elm St.)");
        String city = con.readString("Please type in the city.");
        String state = con.readString("Please enter the state.");
        int zipCode = con.readInt("Please enter the zip code.");
        
        //create an address object
      Address currentAddress = new Address(0); //here's our abstraction of the instantiation on the fly
     
      currentAddress.setFirstName(firstName);
      currentAddress.setLastName(lastName);
      currentAddress.setStreet(street);
      currentAddress.setCity(city);
      currentAddress.setZipCode(zipCode);
      
      
       //enter info into hashmap
      myAddressBook.addAddressToBook(currentAddress); //in this method we ask the roster object/class
                                    //to do some data retrieval/removal...for us on behalf of the user
      //report back the user a confirmation.
      con.readString("Student successfully created. Please hit enter to continue.");
                                    //we communicate back ot the user
      
      
        //ask if they want to go to the main menu or exit
   
    }
    
    public void removeAddress(){
        String name;
        name = con.readString("Please enter the first and last name of the person you would like to remove \n"
                + "in this format:  \"First Last\" (i.e. Zola Budd).");
        myAddressBook.removeAddress(name);
    
    }
    
    //findAddress(String lastName);
     private void findAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //countAddresses();
    
        private void countAddresses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    //listAddresses();

    //private void listAddresses() {
        //String[] allAddresses = myAddressBook.getAllAddresses():
        
    //}
    
}
