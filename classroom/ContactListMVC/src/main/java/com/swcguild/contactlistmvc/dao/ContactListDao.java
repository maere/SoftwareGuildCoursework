/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface ContactListDao {
    
    public Contact addContact(Contact contact);//needed to import our DTO package to 
                        //get access to the Contact class for our Type here
    
    public void removeContact(int contactId);
    
    public void updateContact(Contact contact);
    
    public List<Contact> getAllContacts();
    
    public Contact getContactById(int contactId);
    
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria); //Takes the enum we defined, as the key for our map
    
}
