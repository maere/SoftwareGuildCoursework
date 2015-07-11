/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecontacts.dao;

import com.swcguild.simplecontacts.dto.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author apprentice
 */
public class ContactsDAOMockImpl implements ContactsDAO{

    @Override
    public List<Contact> getContacts() {
      List<Contact> list = new ArrayList<>();
        //we are mocking out some data here to build JSTL, but once this comes together we will not plant data here!
        Contact c1 = new Contact();
        c1.setName("John Does");
        c1.setPhone("555-1212");
        c1.setEmail("jdoe@doe.com");

        list.add(c1);

        Contact c2 = new Contact();
        c2.setName("Sally Smith");
        c2.setPhone("555-4455");
        c2.setEmail("sally@smith.com");

        list.add(c2);

        Contact c3 = new Contact();
        c3.setName("Bert Johnson");
        c3.setPhone("555-3456");
        c3.setEmail("bjohnson@mail.com");

        list.add(c3);
        
        return list;
//To change body of generated methods, choose Tools | Templates.
    }
    
}
