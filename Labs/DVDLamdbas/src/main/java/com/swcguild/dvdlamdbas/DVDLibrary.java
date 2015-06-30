/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlamdbas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibrary {

    public void addToLibrary(DVD dvd) throws FileNotFoundException;

    public void loadDVDdata() throws FileNotFoundException;

    public void writeToDVDdata() throws IOException;

    public List<DVD> listAllDVDs();

    public DVD getDVD(Integer id);
    
    public void removeDVD(Integer id);

    public int getDVDCount();
      
    public List<DVD> ageSearch(long age); 
    
    public double averageAge();
    public DVD newestDVD();
    public DVD oldestDVD();
    
    public List<DVD> ratingSearch(String mpaaRating);
    public void directorSearch(String director);
    public List<DVD> studioSearch(String studio);
   
    public void AvgNumNotes();

    //public HashMap<Integer, DVD> getDvdCollection();

    //public void setDvdCollection(HashMap<Integer, DVD> dvdCollection);
    
    
}
