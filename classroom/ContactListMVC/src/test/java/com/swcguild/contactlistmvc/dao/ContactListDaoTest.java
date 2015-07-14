/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class ContactListDaoTest {

    private ContactListDao dao;

    public ContactListDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("contactListDao", ContactListDao.class);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void addGetDeleteContact() {
        Contact nc = new Contact(); ///set up a contact object & import DTO then set all of the elements
        nc.setFirstName("John");
        nc.setLastName("Doe");
        nc.setCompany("Oracle");
        nc.setEmail("john@doe.com");
        nc.setPhone("123445678");

        dao.addContact(nc);

        Contact fromDb = dao.getContactById(nc.getContactId());

        assertEquals(fromDb, nc);
        dao.removeContact(nc.getContactId());
        assertNull(dao.getContactById(nc.getContactId()));

    }

    @Test
    public void addUpdateContactTest() {
        Contact nc = new Contact(); ///set up a contact object & import DTO then set all of the elements
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setCompany("Sun");
        nc.setEmail("jim@smith.com");
        nc.setPhone("4405551212");

        dao.addContact(nc);
        nc.setPhone("5103335566"); //update phone number, then run dao update

        dao.updateContact(nc);

        //puull ID from teh database and make sure it matches what we did
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
    }

    @Test //will jsut take  alook at the size, not what's in it--but this is a cheesy test
    public void getAllContacts() {
        Contact nc = new Contact(); ///set up a contact object & import DTO then set all of the elements
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setCompany("Sun");
        nc.setEmail("jim@smith.com");
        nc.setPhone("4405551212");

        dao.addContact(nc);

        Contact nc2 = new Contact();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setCompany("Apple");
        nc2.setEmail("john@jones.com");
        nc2.setPhone("6503335500");

        dao.addContact(nc2);

        List<Contact> seeList = dao.getAllContacts();
        assertEquals(2, seeList.size());

    }

    @Test
    public void testSearchContacts() {

        Contact nc = new Contact(); ///set up a contact object & import DTO then set all of the elements
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setCompany("Sun");
        nc.setEmail("jim@smith.com");
        nc.setPhone("4405551212");

        dao.addContact(nc);

        Contact nc2 = new Contact();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setCompany("Apple");
        nc2.setEmail("john@jones.com");
        nc2.setPhone("6503335500");

        dao.addContact(nc2);

        Contact nc3 = new Contact();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setCompany("Microsoft");
        nc3.setEmail("steve@msft.com");
        nc3.setPhone("5552221234");

        dao.addContact(nc3);

        //next we are goign to feed our criteria hashmap and feeding that in 
        Map<SearchTerm, String> criteria = new HashMap<>(); //create an instance and will feed it in 
        
        criteria.put(SearchTerm.LAST_NAME, "Jones");
        
        //now will pull a list out of our contacts
        List<Contact> cList = dao.searchContacts(criteria);

        //now will run assert equals tests- expected/actual
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0)); //object instance /object inList
        //now will run the test to make sure the first assertion plays out

        criteria.put(SearchTerm.LAST_NAME, "Smith");
        cList = dao.searchContacts(criteria);
        assertEquals(2, cList.size());

        criteria.put(SearchTerm.COMPANY, "Sun");//we never put him in...
        cList = dao.searchContacts(criteria);
        assertEquals(nc, cList.get(0));

        
        criteria.put(SearchTerm.COMPANY, "Microsoft");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc3, cList.get(0));

        criteria.put(SearchTerm.COMPANY, "Apple");
        cList = dao.searchContacts(criteria);
        assertEquals(0, cList.size());

    }

}//end  test class
