/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
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
public class HomeController {
    
    //using AJAX now....so will need a contactListDao and to inject
    
    private ContactListDao dao;
    
    @Inject //we need our controller to make a dao when it gets constructed and to inject the dao
    public HomeController(ContactListDao dao){
        this.dao=dao;
    }
    
   //----------------------------------------------------------------------------
    //method dsiplay homepage -- these two "home" values are not directly related
                        //the first is the endpoint it is resolving from the UROL...
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)   //we need values for our potential endpoints--there are two values going in
                                        //this means that more than one URL can resolve to this endpoint
                                         //will hit web.xml first, if it doesn't find this file within our root folder
                                         //will go to router and look to resolve the route--this is our alternate default page
    // the 2nd param above comes from Spring framework - .web.bind.annoation -- method=RequestMethod.GET is an enum
    public String displayHomePage(){
        return "home"; //this will return home.jsp as the responese
                        //..this home will be passsed back and will have a .jsp added, but we haven't bulilt that page yet
    }
    
    //dispatcher will go look at all the request mapping annoations
    //-----------------------------------------------------------------------------
    ////////NEW AJAX stuff
    
    //NOTE; @Response Body MUST be right before the method on the same line!!
    
                        //eg /contact/42
    @RequestMapping(value="/contact/{contactId}", method=RequestMethod.GET) //this is a parammeter gets substituted at runtime, by spring, whenever it makes the rquest
 //responseBody is a new annotation, tells spring to return a JSON object instaed of HTML
       @ResponseBody public Contact getContact(@PathVariable ("contactId") int contactId){ //tell it which parameter in the url is going to be set to contact id
        return dao.getContactById(contactId);
    }
    
    @RequestMapping(value="/contact", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    //serializes into JSON
    @ResponseBody public Contact createContact(@Valid @RequestBody Contact contact){ //annoatating the contact varaiuble
        dao.addContact(contact); //request body takes JSON and will turn into this contact object (so deserializing)
        return contact;
    }
    
    //our delete doens't need to return anything so has no return value
    
    @RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT) //message that says "my delete was good" - a sresponse status like 200 okay
    //(only need @ResponseBody with return type and if you want to turn into JSON)
    public void deleteContact(@PathVariable("id") int id){  //need to make sure our id gets mapped to the path so we put thyis in the params
        dao.removeContact(id); //doesn't matter what parameter is called
        
    }

    @RequestMapping(value="/contact/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT) //this is because it's a void return, no content in tieh response - I didn't give you anything, that's normal
    public void putContact(@PathVariable("id") int id, @RequestBody Contact contact){ //map parameters - id to id, and @RquestBody will deserialize the contact
        
        contact.setContactId(id);
        dao.updateContact(contact);
    
    }
    
    @RequestMapping(value="/contacts", method=RequestMethod.GET)
    @ResponseBody public List<Contact> getAllContacts(){
        return dao.getAllContacts();
    }
    
    
    
    
}//end class
