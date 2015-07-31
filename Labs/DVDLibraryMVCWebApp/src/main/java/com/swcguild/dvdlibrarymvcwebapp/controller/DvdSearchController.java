/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcwebapp.controller;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import com.swcguild.dvdlibrary.dto.SearchTerms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class DvdSearchController {
    
 //delcare any daos
    private DvdLibraryDao dao;

    //constructor must inject the dao & create an instance
    @Inject
    public DvdSearchController(DvdLibraryDao dao) {
        this.dao = dao;
    }
    
     //route to get to the search function
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearch() {
        return "search";
    }

    //post method for our search function
    @RequestMapping(value ="/search/dvds", method = RequestMethod.POST)  //NOTE: changed this method to return the HashMap that the Controller serach method needs, vs the old return: List<Dvd>
    @ResponseBody public List<Dvd> searchDvd(@RequestBody Dvd dvd) //will pass a hypothetical DVD object, constructed from our search terms //
    {
        //build up a map, so we can pass this a parameter to our search function in the Dao
        Map<SearchTerms, String> searchCriteria = new HashMap<>();
        
        //call every field, if not null(DAO method handles this logic), put an entry in my map with the search term and the string that it is 
        String titleSearch = dvd.getTitle();
        String releaseSearch = dvd.getReleaseDate(); //release date is in the enum as a string
        String ratingSearch = dvd.getMpaaRating(); 
        String directorSearch = dvd.getDirector();
        String studioSearch = dvd.getStudio();
        //String noteSearch = dvd.getNote(); //this item is not in the enum, could add later and refactor
        
        //the enum is the key in my map//SearchTerms.DIRECTOR //this is how we refer to an enum value, always two parts
        if(titleSearch!=null&&!titleSearch.isEmpty()){
             searchCriteria.put(SearchTerms.TITLE, titleSearch); //check to see if it's not != empty and if so pass it in...
        }
        
        if(releaseSearch!=null&&!releaseSearch.isEmpty()){
             searchCriteria.put(SearchTerms.RELEASE_DATE, releaseSearch);
        }
        
        if(ratingSearch!=null&&!releaseSearch.isEmpty()){
             searchCriteria.put(SearchTerms.RATING, ratingSearch);
        }
        
       if(directorSearch!=null&&!directorSearch.isEmpty()){
             searchCriteria.put(SearchTerms.DIRECTOR, directorSearch);
       }
       
       if(studioSearch!=null&&!studioSearch.isEmpty()){
             searchCriteria.put(SearchTerms.STUDIO, studioSearch);
       }
       
       //return searchCriteria; //old return is below and was for returning a list
        List<Dvd> resultsList = dao.searchDvds(searchCriteria);
        return resultsList;
    }
    //enums are often used to make dropdown list (e.g. all 50 states)
}
