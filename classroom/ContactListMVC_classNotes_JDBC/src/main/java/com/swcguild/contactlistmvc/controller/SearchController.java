/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
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
 * @author ilyagotfryd
 */
@Controller
public class SearchController {
    //declar a contact list daao
    private ContactListDao dao;
    
    //inject Dao into the controller object
    @Inject
    public SearchController(ContactListDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String displaySearchPage()
    {
        return "search";
    }
    
    
    @RequestMapping(value="/search/contacts", method=RequestMethod.POST)   //bc we are going to send a list of contacts in our responseboody we annoatate this
    @ResponseBody public List<Contact> searchContacts(@RequestBody Map<String, String> searchMap )//maps to the key value pair in the JSON object
    {
        Map<SearchTerm, String> criteriaMap = new HashMap<>(); //this map allows us to map to our back end app with logic to look through the data
                                           //so we pick through the random map of strings to see if we got any matches to our enum
        
    //we are using a different method to get our data back, instead of reading into a Contact, we are reading into a map of string, strings, 
    //and are going to pick out the elements that will be present in our JSON objeect   
        
        String currentTerm = searchMap.get("firstName"); //assign the value of the current term to the value pulled from teh key firstName
        if (!currentTerm.isEmpty())                     // if that value is not empty (empty for a string is not the same as null)
        {
            criteriaMap.put(SearchTerm.FIRST_NAME, currentTerm); //put it to our new hashmap, where the key is the enum SearchTerm
        }                         //syntax for the enum term is enumName.ENUM_VALUE  and the value we are putting for that is our currentTerm we are handling for the particular field                  
        
        currentTerm = searchMap.get("lastName"); 
        if (!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.LAST_NAME, currentTerm);
        }
        
        currentTerm = searchMap.get("company"); 
        if (!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.COMPANY, currentTerm);
        }
        
        currentTerm = searchMap.get("email"); 
        if (!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.EMAIL, currentTerm);
        }
        
        currentTerm = searchMap.get("phone"); 
        if (!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.PHONE, currentTerm);
        }
        //need to make sure we made a constructor for the controller with a DAOf or calaling this method will not work
        return dao.searchContacts(criteriaMap);
    }     

    
}

//also enums are usually for things with FIXED values that will never change--like the 50 states
