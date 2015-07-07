/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DvdLibraryController {

    private DvdLibraryDao dao;
    private ConsoleIO con;// = new ConsoleIO(); -- we're going to inject this as well

    //constructor--must pass in the interface we have coded our implementation to, as the parameter, and any other bean we want to construct when the controller class gets built
    public DvdLibraryController(DvdLibraryDao dao, ConsoleIO con) { // Spring can take an infinite number of params, but needs these to construct w. class
        //note when we pass in the class references, we have to assign a name to the parameter so the controller will have something to grab onto
        this.dao = dao;
        this.con = con;

    }

    //methods---------------------------------------
    public void run() throws FileNotFoundException, IOException {

        boolean keepGoing = true;
        int userChoice;

//load data   -------------- // dao.loadDVDdata();   -- not needed now bc we are not reading or writing to file
        con.print("This program allows you to create and maintain a DVD catalog. \n ");
        while (keepGoing) {
            this.mainMenu();

            userChoice = con.readInt("Select an option from the menu.");

            switch (userChoice) {
                case 1:
                    this.createDVD();
                    break;
                case 2:
                    this.deleteDVD();
                    break;
                case 3:
                    this.searchMenu(); //changed to searchMenu(); from search choice
                    break;
                case 4:
                    this.printAllDVDs();
                    break;
                case 5:
                    this.editDVD();
                    break;
                case 6:
                    //System.out.println("Exiting application now.");
                    keepGoing = false;
                    break;

                default:
                    throw new AssertionError();
            }
        //write to data source
            //myDVDcoll.writeToDVDdata(); -- not needed now bc we are not writing to file

        }
        con.print("Exiting...your data will not be saved if running in test/memory-only mode.");

    }

    private void mainMenu() {
        con.print("Select one of the following choices to start: \n"
                + "--------------------------------------------");
        con.print("1. Add a DVD title \n"
                + "2. Delete a DVD from the collection \n"
                + "3. Search DVDs \n"
                + "4. Print out a list of DVDs \n"
                + "5. Edit a DVD title \n"
                + "6. Exit from this program\n");        //e.g. return userChoice; I would like this method to return an int and store that as a field in this class
    }

    public void createDVD() throws FileNotFoundException {
        //skipping id -- but will ask for input and set our property values equal to the input
        String title = con.readString("Please enter your title: ");
        String strReleaseDate = con.readString("Please enter your release date (YYYYMMDD): "); //change date property

        LocalDate releaseDate = null; //
        try {
            releaseDate = LocalDate.parse(strReleaseDate, DateTimeFormatter.BASIC_ISO_DATE); //
        } catch (DateTimeParseException e) {
            System.out.println("Your date was incorrectly formatted or doesn't fit the date format.  "
                    + "Please check your entry and try again.");

        }

        String mpaaRating = con.readString("Enter the MPAA rating: ");
        String director = con.readString("Enter the director: ");
        String studio = con.readString("Enter the studio: ");
        String userReview = con.readString("Please enter your review for this film.");

        //need to instantiate a dVD object
        Dvd currentDVD = new Dvd();

        //setting the object's properties
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate); //change date property to formatted
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setNote(userReview);//currentDVD.setUserReview(userReview);

        //putting the object into the hash
        dao.add(currentDVD); //needs file not found exception...

        //
    }

    public void deleteDVD() {
        int id = con.readInt("Enter the ID of the DVD you would like to remove from the collection: ");
        dao.remove(id);
    }

    public void searchMenu() {
        int searchChoice = con.readInt("Choose a search option from the menu (1-10): \n"
                + "1. Search By Id \n"
                //                                          + "2. Search By Year of Release \n"
                + "2. Search By Title"
                + "3. List By MPAA Rating \n"
                //+ "4. Find By Director \n"
                + "4. Find By Studio \n"
                //need to have add a new note to DVD method -- which adds to the ArrayList
                //                + "6. Find Average Number of Ratings \n"
                //                + "7. Find Average Age of Release for DVDs in Collection \n"
                //                + "8. Find Oldest DVD \n"
                //                + "9. Find Newest DVD \n"
                + "5. Exit this menu.\n");
        /*
         //DVD liveDVD = myDVDcoll.getDVD(id);
         if (liveDVD != null) {
         should this be a while loop?
         */
        switch (searchChoice) {
            case 1:
                searchUsingId();
                break;
            case 2:
                searchByTitle();//searchByRelease();
                break;
            case 3:
                searchByRating();
                break;
//            case 4:
//                searchByDirector();
//                break;
            case 4:
                searchByStudio();
                break;
//            case 6:
//                //findAvgNumberNotes(); aka Ratings
//                break;
//            case 7:
//                findAvgAge();
//                break;
//            case 8:
//                searchOldest();
//                break;
//            case 9:
//                searchNewest();
//                break;

            case 5:
                System.out.println("Exiting...");
                break;
            default:
                con.print("Sorry, there has been some kind of error.  Exiting now.");
                throw new AssertionError();
        }

    }

    public void searchUsingId() {
        int idNum = con.readInt("Please enter the ID number of the video you would like to search for. \n"
                + "If you are unsure of the ID number you can go back to the Main Menu to List All DVDs.");
        Dvd reqDvd = dao.getById(idNum);
        dvdDisplaySingle(reqDvd);

    }

    public void searchByTitle() {

        List<Dvd> orderlyList = dao.listAll();

        String titleString = con.readString("Enter the first word or two of the title you would like to search for.\n"
                + "(Example: \"Spinal\" or \"Spinal Tap\" \n");

        Boolean found = false;
        //ArrayList<String>  foundTitleArray; //or array list?

        for (int i = 0; i < orderlyList.size(); i++) {

            //DVD currentDVD = orderlyList.get(i);
            String currentTitle = orderlyList.get(i).getTitle();

            if (currentTitle.contains(titleString)) {
                found = true;
                con.print("I found the title: " + currentTitle + " with ID #: " + orderlyList.get(i).getId());
                //foundTitleArray.add(currentTitle);//push to String array 
            }
        }

        if (found != true) {
            con.print("I did not find your title beginning with " + titleString);

        }

    }

    public void searchByRating() {

        String mpaaRating = con.readString("Enter the rating you would like to search by: ");

        List<Dvd> movieRatings = dao.getByRating(mpaaRating);

        System.out.println("Here are your films with the MPAA Rating of " + mpaaRating + ": \n------------------");

        printToScreen(movieRatings);

    }

    public void searchByStudio() {
        String studio = con.readString("Enter the name of the studio you would like to search by: ");

        List<Dvd> studioMovies = dao.getByStudio(studio);

        System.out.println(studio + " releases: \n------------------");

        printToScreen(studioMovies);

    }

    public void printToScreen(List<Dvd> dvds) {
        dvds.forEach(e -> System.out.println(e.getTitle()));

    }

    public void printAllDVDs() {

        List<Dvd> orderlyList = dao.listAll(); //indexed Array list containing 
        //all DVD objects
        dvdDisplayFormatter(orderlyList);

    }

    public void editDVD() throws IOException {
        int id = con.readInt("To edit a DVD record enter the ID of the record you would like to edit: \n\n"
                + "(If you are unsure of what you have in your collection you can exit this menu \nand choose 4 in the Main Menu to list all your DVDs.)");

        Dvd liveDVD = dao.getById(id);
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
                    String stringRelease = con.readString("Please enter your revised release date: ");
                    LocalDate newRelease = LocalDate.parse(stringRelease);
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
                    liveDVD.setNote(newUserReview);
                    break;
                case 7:
                    break;

                default:
                    con.print("Sorry, there has been some kind of error.  Exiting now.");
                    throw new AssertionError();
            }
//FIX: this needs to be replaced by writing to the database -- but it's already been written to the hash above          
            //dao.writeToDVDdata();
            con.print("Your DVD record has been successfully updated.");
        } else {
            con.print("We were not able to find that DVD in your collection.");

        }

    }//end edit method

    public void dvdDisplayFormatter(List<Dvd> allXinList) {

        for (Dvd d : allXinList) {
            System.out.println("\n" + Integer.toString(d.getId()) + " | " + d.getTitle() + "\n"
                    + "Directed by: " + d.getDirector() + "\n"
                    + "Rated: " + d.getMpaaRating() + "\n"
                    + "Studio: " + d.getStudio() + "\n"
                    + "Release Date: " + d.getReleaseDate() + "\n" + "User Review:" + d.getNote() +"\n");
        }
    }

    public void dvdDisplaySingle(Dvd d) {

        System.out.println("\n" + Integer.toString(d.getId()) + " | " + d.getTitle() + "\n"
                + "Directed by: " + d.getDirector() + "\n"
                + "Rated: " + d.getMpaaRating() + "\n"
                + "Studio: " + d.getStudio() + "\n"
                + "Release Date: " + d.getReleaseDate() + "\n" 
                + "User Review: " + d.getNote());

    }

}
