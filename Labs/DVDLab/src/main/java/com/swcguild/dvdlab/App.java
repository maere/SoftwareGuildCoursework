/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlab;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DVDLibraryController mainObjectController = new DVDLibraryController();
       mainObjectController.run();
        
    }

}
/*
Requirements: about Collections and Maps

//classes: App, UIController, DVDCollection, DVD Data Object, ConsoleIO

In this lab you will create a program that stores a DVD collection. T

//Allow the user to add a DVD to the collection.
    -both UI and App

//Allow the user to remove a DVD from the collection.
    both UI and App

//Allow the user to list the DVD's in the collection.
    -print out HashMap of titles

//Allow the user to display the information for a particular DVD.
    - print out objects fields of data in formated way

//Allow the user to search for a DVD by title.
    - UI, pass in title, 
    - domain class - use Hash to find object by key - 
    --not sure how title gets associated with key <String, Object>
    --still has unique ID

//Load the DVD library from a file.
    -- Data reading 

//Save the DVD library back to the file when the program completes.
    -- Data writing or overwriting

//Allows the user to add/edit/delete many DVD's in one session.
    -- while loop that allows them to go back to MMenu
*/
