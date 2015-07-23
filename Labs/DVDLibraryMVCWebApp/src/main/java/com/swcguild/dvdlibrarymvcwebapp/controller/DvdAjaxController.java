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
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/"})
public class DvdAjaxController {

    //delcare any daos
    private DvdLibraryDao dao;

    //constructor must inject the dao & create an instance
    @Inject
    public DvdAjaxController(DvdLibraryDao dao) {
        this.dao = dao;
    }

    //wire home mapping -- changed to index for the dynamic version

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String displayIndexPage() {
        return "index";
    }

    //CRUD REST route mapping
    //Retrieve one
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dvd getDvd(@PathVariable("id") int id) { //REST methods will require a path variable annotation, note object we are expecting is an int and has to be declared
        return dao.getById(id);                         //return type must match the object we want to return
    }//ResponseBody acknowledges that I am returning a model, otherwise, it tries to generate a view (resolves to .jsp, and can't find one bc doesn't exist)

    //Create one
    @RequestMapping(value = "/dvd", method = RequestMethod.POST) //add @Valid when ready to validate
    @ResponseStatus(HttpStatus.CREATED) //we will also send back the status of the request in our response
    @ResponseBody
    public Dvd createDvd(@Valid @RequestBody Dvd dvd) {  //Request Body is the paramater we are taking from the post, we are also validating the data in the Req as it comes in
        dao.add(dvd);
        return dvd; //we will also return the dvd in the response
    }

    //Delete one
    @RequestMapping(value = "dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteDvd(@PathVariable("id") int id) { //when do we need a path varaible vs. an object or request body?  what does it take for the DAO to work?
        dao.remove(id);

    }

    //Update one
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putDvdToCollection(@PathVariable("id") int id, @RequestBody Dvd dvd) {
        dvd.setId(id);
        dao.update(dvd);
    }

    //Retrieve all
    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<Dvd> listDvds() {
        List<Dvd> testReturnList = dao.listAll();
        return testReturnList;
    }

    //route to get to the search function
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearch() {
        return "search";
    }

    //post method for our search function
    @RequestMapping(value ="search/dvds", method = RequestMethod.POST)
    @ResponseBody public List<Dvd> searchDvd(@RequestBody Dvd dvd) //will pass a hypothetical DVD object, constructed from our search terms
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
        searchCriteria.put(SearchTerms.TITLE, titleSearch);
        searchCriteria.put(SearchTerms.RELEASE_DATE, releaseSearch);
        searchCriteria.put(SearchTerms.RATING, ratingSearch);
        searchCriteria.put(SearchTerms.DIRECTOR, directorSearch);
        searchCriteria.put(SearchTerms.STUDIO, studioSearch);
        
        List<Dvd> resultsList = dao.searchDvds(searchCriteria);
        
        return resultsList;
    }

}
//enums are often used to make dropdown list (e.g. all 50 states)