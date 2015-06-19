/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    //fields
    private ConsoleIO con = new ConsoleIO();
    int userChoice;

    //this is so we have access to our DAO....
    DVDLibrary myDVDcoll = new DVDLibrary();
    //constructor?

    public DVDLibraryController() {
    }

    //methods---------------------------------------
    public void run() throws FileNotFoundException, IOException {

        //load data 
        myDVDcoll.loadDVDdata();
        //present menu  
        this.mainMenu();

        userChoice = con.readInt("Please choose an option from the menu.");

        switch (userChoice) {
            case 1:
                this.createDVD();
                break;
            case 2:
                this.deleteDVD();
                break;
            case 3:
                this.searchDVDs();
                break;
            case 4:
                this.printAllDVDs();
                break;
            case 5:
                this.editDVD();
                break;
            case 6:
                System.out.println("Exiting application now.");
                break;

            default:
                throw new AssertionError();
        }

        myDVDcoll.writeToDVDdata();

    }

    private void mainMenu() {
        con.print("This program allows you to create and maintain a DVD catalog. \n "
                + "Select one of the following choices to start: \n"
                + "--------------------------------------------");
        con.print("1. Add a DVD title \n"
                + "2. Delete a DVD from the collection \n"
                + "3. Search for a DVD \n"
                + "4. Print out a list of DVDs \n"
                + "5. Edit a DVD title \n"
                + "6. Exit from this program\n");        //e.g. return userChoice; I would like this method to return an int and store that as a field in this class
    }

    public void createDVD() throws FileNotFoundException {
        //skipping id -- but will ask for input and set our property values equal to the input
        String title = con.readString("Please enter your title: ");
        String releaseDate = con.readString("Please enter your release date: ");
        String mpaaRating = con.readString("Enter the MPAA rating: ");
        String director = con.readString("Enter the director: ");
        String studio = con.readString("Enter the studio: ");
        String userReview = con.readString("Please enter your review for this film.");

        //need to instantiate a dVD object
        DVD currentDVD = new DVD();

        //setting the object's properties
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserReview(userReview);

        //putting the object into the hash
        myDVDcoll.addToLibrary(currentDVD); //needs file not found exception...

        //
    }

    public void deleteDVD() {
        int id = con.readInt("Enter the ID of the DVD you would like to remove from the collection: ");
        myDVDcoll.removeDVD(id);
    }

    public void searchDVDs() {

        ArrayList<DVD> orderlyList = myDVDcoll.listAllDVDs();

        String titleString = con.readString("Enter the first word or two of the title you would like to search for.\n"
                + "(Example: \"Spinal\" or \"Spinal Tap\" \n");
        
        Boolean found = false;
        //ArrayList<String>  foundTitleArray; //or array list?
        
        for (int i = 0; i < orderlyList.size(); i++) {

            DVD currentDVD = orderlyList.get(i);
            String currentTitle = orderlyList.get(i).title;
            
                if (currentTitle.contains(titleString)) {
                    found = true;
                    con.print("I found the title: " + currentTitle + " with ID #: " + orderlyList.get(i).id); 
                    //foundTitleArray.add(currentTitle);//push to String array 
                } 
        }
        
         if(found!=true){
                 con.print("I did not find your title beginning with " + titleString);
                  
         }
               
    }
             
           
        /*
         String word = "cat";
         String text = "The cat is on the table";
         Boolean found;
         found = text.contains(word);
         */
    

    public void printAllDVDs() {

        ArrayList<DVD> orderlyList = myDVDcoll.listAllDVDs(); //indexed Array list containing 
        //all DVD objects
        for (int i = 0; i < orderlyList.size(); i++) {
            System.out.println("Title #:" + orderlyList.get(i).id
                    + "  " + orderlyList.get(i).title);
        }

    }

    public void editDVD() throws IOException {
        int id = con.readInt("To edit a DVD record enter the ID of the record you would like to edit: \n\n"
                + "(If you are unsure of what you have in your collection you can exit this menu \nand choose 4 in the Main Menu to list all your DVDs.)");

        DVD liveDVD = myDVDcoll.getDVD(id);
        if (liveDVD != null) {
            int editChoice = con.readInt("Your title" + liveDVD.getTitle() + " was located. \n"
                    + "Enter the number for the information you would you like to edit. \n"
                    + "1. Title \n"
                    + "2. Release Date \n"
                    + "3. MPAA Rating \n"
                    + "4. Director \n"
                    + "5. Studio \n"
                    + "6. User Rating \n"
                    + "7. Exit this menu.");

            //should be a while loop, eventually
                    switch (editChoice) {
                        case 1:
                            String newTitle = con.readString("Please enter your revised title: ");
                            liveDVD.setTitle(newTitle);
                            break;
                        case 2:
                            String newRelease = con.readString("Please enter your revised release date: ");
                            liveDVD.setReleaseDate(newRelease);
                            break;
                        case 3:
                            String newRating = con.readString("Please enter your revised MPAA rating: ");
                            liveDVD.setMpaaRating(newRating);
                            break;
                        case 4:
                            String newDirector = con.readString("Please enter your revision for the director: ");
                            liveDVD.setDirector(newDirector);
                            break;
                        case 5:
                            String newStudio = con.readString("Please enter your revision for the studio: ");
                            liveDVD.setStudio(newStudio);
                            break;
                        case 6:
                            String newUserReview = con.readString("Please enter your revised review or notes: ");
                            liveDVD.setUserReview(newUserReview);
                            break;
                        case 7:
                            break;

                        default:
                            con.print("Sorry, there has been some kind of error.  Exiting now.");
                            throw new AssertionError();
                    }
                    myDVDcoll.writeToDVDdata();
                    con.print("Your DVD record has been successfully updated.");
        } 
        else 
        {
            con.print("We were not able to find that DVD in your collection.");
            
        }

    }//end edit method

}///end class
