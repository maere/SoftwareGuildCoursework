/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlamdbas;

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
FIXES: fix counter so it reads from file...

The objective of this lab is change the implementation of the first version of AddressBook to
take advantage of the new Lambda, Stream, and Aggregate features of Java 8.

Requirements:
In this lab you will add the following features to your program:


//1. Find all movies released in the last N years -- search by release

//5. Find the average age of the movies in the collection

//6. Find the newest movie in your collection

//7. Find the oldest movie in your collection



//3. Find all the movies by a given director

   // a. When searching by director, the movies should be sorted into separate data structures by MPAA rating




//8. Find the average number of notes associated with movies in your collection

- . You must create an Interface for the DVDLibrary API (i.e. your DAO) that contains all the
methods specified here and in Version 1 of this lab

-. You must create an DVDLibraryImpl class that implements the DVDLibrary interface -
you must use Lambdas, Streams, and Aggregates in your implementation.

-. Find all the movies released by a particular studio

-. Find all the movies with a given MPAA rating

*/
