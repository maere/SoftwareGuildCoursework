/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addresslab;

import java.io.IOException;
import java.util.ArrayList;
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
    //static int idNumber;

    //constructor
    //methods
    public void run() throws IOException, Exception {
        boolean keepGoing = true;
        int choice = 0;

        myAddressBook.loadAddresses();

        while (keepGoing) {
            mainMenu();

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
                case 5:
                    listAddresses();
                    break;

                case 6:
                    System.out.println("Exiting the system");
                    keepGoing = false;
                    break;
                default:
                    con.print("That is an invalid entry.");//this was a bad idea: assertion error or evgen throw new Exception();
            }
            myAddressBook.writeToAddresses();

        }
        con.print("Thanks for using this app!");

        //try catch loop
    }

    private void mainMenu() {
        con.print("Main Menu");
        con.print("---------");
        con.print("1. Add Address");
        con.print("2. Delete Address");
        con.print("3. Find Address");
        con.print("4. Count Addresses in Book");
        con.print("5. List All Addresses");
        con.print("6. Exit");

    }

    public void createAddress() throws IOException {

        String firstName = con.readString("Please type in the first name of the person you want to add.");
        String lastName = con.readString("Please type in the last name of the person you want to add.");
        String street = con.readString("Please type in their street address (e.g. 123 Elm St.)");
        String city = con.readString("Please type in the city.");
        String state = con.readString("Please enter the state.");
        int zipCode = con.readInt("Please enter the zip code.");


        //create an address object
        Address currentAddress = new Address(); //here's our abstraction of the instantiation on the fly
        
        //currentAddress.setIdNumber(); -- moved to DAO
        
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreet(street);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZipCode(zipCode);

        //enter info into hashmap
        myAddressBook.addAddressToBook(currentAddress); //in this method we ask the roster object/class
        //to do some data retrieval/removal...for us on behalf of the user
        //report back the user a confirmation.
        con.readString("Student successfully created. Please hit enter to continue.");
                                    //we communicate back ot the user

        //ask if they want to go to the main menu or exit
    }

    public void removeAddress() {
//NOTE: this method needs to catch exceptions -- because it throws a Null pointer exception if you enter an ID and it cannot find that item.
        int idNumber = con.readInt("Please enter the ID of the person you would like to remove.");
        
        //if you're using a reference via a method chain as below, just do it once, and store it as a variable, 
        //otherwise your'e querying the database multiple times needleyssly

        int response = con.readInt("Are you sure you want to remove " + myAddressBook.getAddress(idNumber).getFirstName() +" "+ myAddressBook.getAddress(idNumber).getLastName() +"? \n"
                + "Enter 1 for yes, 2 for No."); //later: use the method chaining above to pass these values in to allow user to remove an address by lastname or another getter/setteer parameter
        if (response == 1) {
            myAddressBook.removeAddress(idNumber);
            con.print("Address successfully removed.");
        } else {
            System.out.println("Okay, fine then.");
        }

    }

    //findAddress(String lastName);
    private void findAddress() {
      // String idNumber = con.readString("Please enter the idNumber of the person you would like to find");
        int idNumber = con.readInt("Please enter the idNumber of the person you would like to find.");
      Address currentAddress = myAddressBook.getAddress(idNumber);
        //we're changing to int
       
       if(currentAddress!=null)
       {
           con.print(currentAddress.getFirstName());
            con.print(currentAddress.getLastName());
             con.print(currentAddress.getStreet());
              con.print(currentAddress.getCity());
               con.print(currentAddress.getState());
               //int zippy = currentAddress.getZipCode();
               //String zip = zippy.toString();
                //con.print(currentAddress.getZipCode());
       }
       else
       {
           con.print("No such address found with that ID.");
       }
       con.print("Please hit enter to continue.");
    }

    //countAddresses();
    private void countAddresses() {
        
        //int total = 0;
        ArrayList<Address> a = myAddressBook.getAllAddresses();
        int totalAddresses = a.size();
        System.out.println("There are " + totalAddresses + " addresses in your address book.");
        
    }

    public void listAddresses() {
        ArrayList<Address> addressesAll = myAddressBook.getAllAddresses();
        for (int i = 0; i < addressesAll.size(); i++) {
            Address currentAddress = addressesAll.get(i);
            System.out.println(currentAddress.getIdNumber() + "|" + currentAddress.getFirstName() + " "  + currentAddress.getLastName() +"\n"
                    + currentAddress.getStreet()+"\n" 
                    + currentAddress.getCity()+ " " + currentAddress.getState()+ " " + currentAddress.getZipCode() + "\n");
        }

    }
    //private void listAddresses() {
    //String[] allAddresses = myAddressBook.getAllAddresses():
    //}
}
