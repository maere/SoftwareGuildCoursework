/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcwebapp.dao;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import com.swcguild.dvdlibrary.dto.SearchTerms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoImpl implements DvdLibraryDao { //couuld call this one DvdLibraryDaoMemImpl--because it's the memory implementation

    static int counter = 0;
    private HashMap<Integer, Dvd> dvdCollection = new HashMap<>(); //if this is private, you need to make a getter and setter for it to be available
    //outside of class--even in an instance

    public HashMap<Integer, Dvd> getDvdCollection() {
        return dvdCollection;
    }

    public void setDvdCollection(HashMap<Integer, Dvd> dvdCollection) {
        this.dvdCollection = dvdCollection;
    }

    @Override
    public void add(Dvd dvd) {
        
    dvd.setId(counter);
        counter++;
         //will recognize this because is part of the DTO--we are setting on the object
        // }
        dvdCollection.put(dvd.getId(), dvd); // here we are getting the id we just set when we add to the collection so that the HashMap is keeping track
    }

    @Override
    public void remove(int id) {
        dvdCollection.remove(id);
    }

    @Override
    public List<Dvd> listAll() {
        //dan included this check for a null pointer to see if there was no list
        if (dvdCollection.keySet().size() == 0) {
            return null;
        }

        List<Dvd> dvdList = new ArrayList<Dvd>(dvdCollection.values());
        return dvdList;
    }

    @Override
    public Dvd getById(int id) {
        return dvdCollection.get(id);
    }

    @Override
    public void update(Dvd dvd) {
        dvdCollection.put(dvd.getId(), dvd);

    }

    @Override // can't need to override bc it's not in my Dao //need to reconfigure dao interface to add put and search or just revert to an earlier commit or pull an earlier commit
    public List<Dvd> searchDvds(Map<SearchTerms, String> criteria) { //the paramater is a map made up an enum as the key, and (series of)strings as the value

        String titleSearchCriteria = criteria.get(SearchTerms.TITLE);
        String ratingSearchCriteria = criteria.get(SearchTerms.RATING);
        //String strReleaseSearchCriteria = criteria.get(SearchTerms.RELEASE_DATE);
        String directorSearchCriteria = criteria.get(SearchTerms.DIRECTOR);
        String studioSearchCriteria = criteria.get(SearchTerms.STUDIO);

//        LocalDate releaseDate = null; //
//        try {
//            releaseDate = LocalDate.parse(strReleaseDate, DateTimeFormatter.BASIC_ISO_DATE); //
//        } catch (DateTimeParseException e) {
//            System.out.println("Your date was incorrectly formatted or doesn't fit the date format.  "
//                    + "Please check your entry and try again.");
//
//        }
        //declare -- assign as second step
        Predicate<Dvd> titleMatches;
        Predicate<Dvd> ratingMatches;
        Predicate<Dvd> releaseMatches;
        Predicate<Dvd> directorMatches;
        Predicate<Dvd> studioMatches;

        //placeholder predicate for empty matches -- is "c" for criterion?
        Predicate<Dvd> truePredicate = (c) -> {
            return true;
        };

        //assign values to the predicates via iterative lambda getters
        titleMatches = (titleSearchCriteria == null || titleSearchCriteria.isEmpty()) ? truePredicate
                : (c) -> c.getTitle().equalsIgnoreCase(titleSearchCriteria);

        ratingMatches = (ratingSearchCriteria == null || ratingSearchCriteria.isEmpty()) ? truePredicate
                : (c) -> c.getMpaaRating().equalsIgnoreCase(ratingSearchCriteria);

//        releaseMatches = (releaseSearchCriteria == null || releaseSearchCriteria.isEmpty())?truePredicate
//                :(c) -> c.getReleaseDate() == releaseSearchCriteria;
        directorMatches = (directorSearchCriteria == null || directorSearchCriteria.isEmpty()) ? truePredicate
                : (c) -> c.getDirector().equalsIgnoreCase(directorSearchCriteria);

        studioMatches = (studioSearchCriteria == null || studioSearchCriteria.isEmpty()) ? truePredicate
                : (c) -> c.getStudio().equalsIgnoreCase(studioSearchCriteria);

        //filter to return matches that meet all the input criteria
        return dvdCollection.values().stream()
                .filter(titleMatches.and(ratingMatches).and(directorMatches).and(studioMatches))
                .collect(Collectors.toList());

    }
/// these are our old search methods, without the enum, ony one field at a time
    //these methods are deprected ;)

    @Override
    public List<Dvd> getByTitle(String title) {
        List<Dvd> titleMatchList = dvdCollection.values().stream()
                .filter(d -> d.getTitle().contains(title)).collect(Collectors.toList());
        return titleMatchList;
    }

    @Override
    public List<Dvd> getByRating(String rating) {
        List<Dvd> titlesByRating = dvdCollection.values()
                .stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(rating)).collect(Collectors.toList());
        return titlesByRating;
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        List<Dvd> titlesByStudio = dvdCollection.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio)).collect(Collectors.toList());
        return titlesByStudio;

    }//end studio method

//    @Override
//    public List<Dvd> getByTitle(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Dvd> getByRating(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Dvd> getByStudio(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}//end class
