/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlamdbas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    private ConsoleIO con = new ConsoleIO();
    int userChoice;

    //this is so we have access to our DAO....
    DVDLibraryFileImpl myDVDcoll = new DVDLibraryFileImpl();

    //constructor?
    public DVDLibraryController() {
    }

    //methods---------------------------------------
    public void run() throws FileNotFoundException, IOException {

        boolean keepGoing = true;
        int userChoice;

        try {
            myDVDcoll.loadDVDdata();//load data   -------------- 
        } catch (FileNotFoundException e) {
            System.out.println("File does not yet exist. Making an empty collection for you...");
            myDVDcoll.writeToDVDdata();

        }

        while (keepGoing) {
            //present menu  
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
                    System.out.println("Exiting application now.");
                    keepGoing = false;
                    break;

                default:
                    throw new AssertionError();

            }

        }

        myDVDcoll.writeToDVDdata();

    }

    private void mainMenu() {
        con.print("This program allows you to create and maintain a DVD catalog. \n "
                + "Select one of the following choices to start: \n"
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
        DVD currentDVD = new DVD();

        //setting the object's properties
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate); //change date property to formatted
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

        List<DVD> orderlyList = myDVDcoll.listAllDVDs();

        String titleString = con.readString("Enter the first word or two of the title you would like to search for.\n"
                + "(Example: \"Spinal\" or \"Spinal Tap\" \n");

        Boolean found = false;
        //ArrayList<String>  foundTitleArray; //or array list?

        for (int i = 0; i < orderlyList.size(); i++) {

            //DVD currentDVD = orderlyList.get(i);
            String currentTitle = orderlyList.get(i).title;

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

    public void searchMenu() {
        int searchChoice = con.readInt("Choose a search option from the menu (1-10): \n"
                + "1. Search By Title \n"
                + "2. Search By Year of Release \n"
                + "3. List By MPAA Rating \n"
                + "4. Find By Director \n"
                + "5. Find By Studio \n"
                //need to have add a new note to DVD method -- which adds to the ArrayList
                + "6. Find Average Number of Ratings \n"
                + "7. Find Average Age of Release for DVDs in Collection \n"
                + "8. Find Oldest DVD \n"
                + "9. Find Newest DVD \n"
                + "10. Exit this menu.\n");
        /*
         //DVD liveDVD = myDVDcoll.getDVD(id);
         if (liveDVD != null) {
         should this be a while loop?
         */
        switch (searchChoice) {
            case 1:
                searchDVDs();
                break;
            case 2:
                searchByRelease();
                break;
            case 3:
                searchByRating();
                break;
            case 4:
                searchByDirector();
                break;
            case 5:
                searchByStudio();
                break;
            case 6:
                //findAvgNumberNotes(); aka Ratings
                break;
            case 7:
                findAvgAge();
                break;
            case 8:
                searchOldest();
                break;
            case 9:
                searchNewest();
                break;

            case 10:
                System.out.println("Exiting...");
                break;
            default:
                con.print("Sorry, there has been some kind of error.  Exiting now.");
                throw new AssertionError();
        }

    }

    public void searchByRelease() {
        //1. Find all movies released in the last N years -- search by release year
        long nYears = con.readLong("This function will return only movies from the past \"n\" years. \n"
                + "Enter a number to get movies from  \"n\"  years ago until now:");

        List<DVD> selectedYears = myDVDcoll.ageSearch(nYears); //calls the method from the DAO which returns a list from an Age search

        System.out.println("Here are the titles for the releases from the past " + nYears + " years: \n------------------");

        printToScreen(selectedYears);

    }

    public void findAvgAge() {
        double average = myDVDcoll.averageAge();
        System.out.println("The average age of DVD releases in your collection is: " + average);
    }

    public void searchNewest() {
        DVD newest = myDVDcoll.newestDVD();
        System.out.println("The newest DVD in your collection is: " + newest.getTitle() + " released on " + newest.getReleaseDate());
    }

    public void searchOldest() {
        DVD oldest = myDVDcoll.oldestDVD();

        System.out.println("The oldest DVD in your collection is: " + oldest.getTitle() + " released on " + oldest.getReleaseDate());
    }

    public void searchByRating() {

        String mpaaRating = con.readString("Enter the rating you would like to search by: ");

        List<DVD> movieRatings = myDVDcoll.ratingSearch(mpaaRating);

        System.out.println("Here are your films with the MPAA Rating of " + mpaaRating + ": \n------------------");

        printToScreen(movieRatings);

    }
//3. Find all the movies by a given director

    public void searchByDirector() {
        // a. When searching by director, the movies should be sorted into separate data structures by MPAA rating
        String director = con.readString("Enter the name of the director you would like to search by: ");

        //changed to a list....Map<String, List<DVD>> directorMap = myDVDcoll.directorSearch(director);
        List<DVD> directorsList = myDVDcoll.directorSearch(director);

        //get ratings by grouping (call)
        Map<String, List<DVD>> ratingsMap = myDVDcoll.ratingGrouping(directorsList);
        Set<String> ratings = ratingsMap.keySet();

        for (String rating : ratings) {
            System.out.println("-----------------------");
            List<DVD> ratingGroup = ratingsMap.get(rating);
            System.out.println("Under " + rating + " ratings:");

            for (DVD dvd : ratingGroup) {
                if (dvd.getDirector().equals(director)) {
                    System.out.println(dvd.getMpaaRating() + " | " + dvd.getTitle() + "| "
                            + dvd.getReleaseDate() + "\n");
                }

            }

        }
//        for (DVD title : directorsList) {
//        }
        //get the mpaa lists for the director wtih the passed name,
        //one by one, and print out the titles from the director found in that set

    }

    //4. [list all] find all the movies released by a particular studio
    public void searchByStudio() {
        String studio = con.readString("Enter the name of the studio you would like to search by: ");

        List<DVD> studioMovies = myDVDcoll.studioSearch(studio);

        System.out.println(studio + " releases: \n------------------");

        printToScreen(studioMovies);

    }

    public void findAvgNumNotes() {
    }

    public void printToScreen(List<DVD> dvds) {
        dvds.forEach(e -> System.out.println(e.getTitle()));

    }

    public void printAllDVDs() {

        List<DVD> orderlyList = myDVDcoll.listAllDVDs(); //indexed Array list containing 
        //all DVD objects
        dvdDisplayFormatter(orderlyList);
//        for (int i = 0; i < orderlyList.size(); i++) {
//            System.out.println("Title #:" + orderlyList.get(i).getId() + "  " + orderlyList.get(i).getTitle());
//        }

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
        } else {
            con.print("We were not able to find that DVD in your collection.");

        }

    }//end edit method

    public void dvdDisplayFormatter(List<DVD> allXinList) {
        for (DVD d : allXinList) {
            System.out.println("\n" + Integer.toString(d.getId()) + "|" + d.getTitle() + "\n"
                    + "Directed by: " + d.getDirector() + "\n"
                    + "Rated: " + d.getMpaaRating()
                    + " Studio: " + d.getStudio()
                    + " Release Date:  " + d.getReleaseDate() + "\n" + "User Review:" + d.getUserReview());
        }

    }

}///end class


/*
 String word = "cat";
 String text = "The cat is on the table";
 Boolean found;
 found = text.contains(word);
 */
