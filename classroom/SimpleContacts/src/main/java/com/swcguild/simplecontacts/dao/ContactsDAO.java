/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecontacts.dao;

import com.swcguild.simplecontacts.dto.Contact;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ContactsDAO {
    List<Contact> getContacts();
    
    
}
