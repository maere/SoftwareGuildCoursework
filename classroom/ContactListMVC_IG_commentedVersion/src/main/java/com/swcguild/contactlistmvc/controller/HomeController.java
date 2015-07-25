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
 * @author ilyagotfryd
 */
@Controller
public class HomeController {
    
    
    private ContactListDao dao;
    
    @Inject
    public HomeController(ContactListDao dao) {
        this.dao = dao;
    }
    
    
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHomePage()
    {
        return "home";
    }
    
    
    @RequestMapping(value="/contact/{contactId}", method=RequestMethod.GET)
    @ResponseBody public Contact getContact(@PathVariable("contactId") int contactId) {
        return dao.getContactById(contactId);
    }
    
    //put or post methods will all have an @RequestBody with the params passed - 
    //this is the way Spring knows to deserialize the data coming in and will pass those correctly into the method
    //in the correct format with lastName camelCase types of variables, 
    //we always have to pass a specific DTO 
    
    @RequestMapping(value="/contact", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody public Contact createContact(@Valid @RequestBody Contact contact) {
        dao.addContact(contact);
        return contact;
    }
    

    @RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {
        dao.removeContact(id);
    }
    
    
    
    @RequestMapping(value="/contact/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putContact(@PathVariable("id") int id, @RequestBody Contact contact) {
        contact.setContactId(id);
        dao.updateContact(contact);
    }
    
    
    @RequestMapping(value="/contacts", method=RequestMethod.GET)
    @ResponseBody public List<Contact> getAllContacts() {
        return dao.getAllContacts();
    }
    
    
    
}
