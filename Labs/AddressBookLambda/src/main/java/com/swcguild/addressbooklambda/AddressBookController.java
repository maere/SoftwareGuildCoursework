/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    private ConsoleIO con = new ConsoleIO();
    private AddressBookImpl myAddressBook = new AddressBookImpl();

    //constructor -- default
    //methods
    public void run() throws IOException, Exception {
        boolean keepGoing = true;
        int choice = 0;
        
        try{
            myAddressBook.loadAddresses(); //single source of truth, so we need to find out where it's at when we begin
        }catch (FileNotFoundException e){
            System.out.println("This book has not yet been created. Would you like to create a book?");
            //change to ConsoleIO y/n and create addresses.txt file...
        }

        

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

        con.readString("Student successfully created. Please hit enter to continue.");

    }

    public void removeAddress() {
//NOTE: this method needs to catch exceptions -- because it throws a Null pointer exception if you enter an ID (et al) and it cannot find that item.

        try {
            int idNumber = con.readInt("Please enter the ID of the person you would like to remove.");

            //if you're using a reference via a method chain as below, just do it once, and store it as a variable, otherwise you're querying the database multiple times needlessly
            Address requestedId = myAddressBook.getAddress(idNumber);
            
            int response = con.readInt("Are you sure you want to remove " + requestedId.getLastName() + " " + requestedId.getLastName() + "? \n"
                    + "Enter 1 for yes, 2 for No.");                        //later: use the method chaining above to pass these values in to allow user to remove an address by lastname or another getter/setteer parameter
            if (response == 1) {
                myAddressBook.removeAddress(idNumber);
                con.print("Address successfully removed.");
            } else {
                System.out.println("Okay, fine then.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Your requested address was not found.");

        }

    }

    private void findAddress() {
        String name = con.readString("Please enter the last name of the person you would like to find");

        ArrayList<Address> currentBook = myAddressBook.getAllAddresses();

        boolean foundAddress = false;

        for (Address currentAddress : currentBook) {
            if (currentAddress.getLastName().equals(name)) {
                foundAddress = true;

                System.out.println("\n" + Integer.toString(currentAddress.getIdNumber()) + "|" + currentAddress.getFirstName() + " " + currentAddress.getLastName() + "\n"
                        + currentAddress.getStreet() + "\n"
                        + currentAddress.getCity() + " " + currentAddress.getState() + " " + Integer.toString(currentAddress.getZipCode()) + "\n");

            }//end if

        }//end for loop

        if (foundAddress == false) {
            con.print("No such address found with that ID.");
        }
        con.print("Please hit enter to continue.");
    } //end method

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
            System.out.println(currentAddress.getIdNumber() + "|" + currentAddress.getFirstName() + " " + currentAddress.getLastName() + "\n"
                    + currentAddress.getStreet() + "\n"
                    + currentAddress.getCity() + " " + currentAddress.getState() + " " + currentAddress.getZipCode() + "\n");
        }

    }

}
