/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ContactListDaoMemImpl implements ContactListDao {
    
    private Map<Integer, Contact> contactMap = new HashMap<>();
    private static int contactIdCounter = 0; //bc is only in memm we can do this
    
    
    @Override
    public Contact addContact(Contact contact) {
         //To change body of generated methods, choose Tools | Templates.
        contact.setContactId(contactIdCounter);
        contactIdCounter++;
        contactMap.put(contact.getContactId(), contact);
        return contact;
    }

    @Override
    public void removeContact(int contactId) {
        contactMap.remove(contactId);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateContact(Contact contact) {
         contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {
         Collection<Contact> c = contactMap.values();//To change body of generated methods, choose Tools | Templates.
         return new ArrayList(c); //does this just "magically" get created?
         
        //we are passing the collection in (c is the collection of values that results from calling values on the collection)
        //we are allowed, when we construct an array list, to pass in a collection and it will convert those object into an array list of objects of that type (it's smart enough to do this)
    
         //------------------JSON test -------------------
//        Contact contact1 = new Contact();
//        
//        contact1.setFirstName("Bill");
//        contact1.setLastName("Gates");
//        contact1.setCompany("Microsoft");
//        contact1.setPhone("555-1212");
//        contact1.setEmail("my@email.com");
//        
//       
//        Contact contact2 = new Contact();
//        
//        contact2.setFirstName("Justin");
//        contact2.setLastName("");
//        contact2.setCompany("oracle");
//        contact2.setPhone("555-1212");
//        contact2.setEmail("my@email.com");
//        
//        List<Contact> list = new ArrayList<>();
//        list.add(contact2);
//        list.add(contact1);
//        
//        return list;
        
    }

    @Override
    public Contact getContactById(int contactId) {
      
        
        //temporarioly overloading to test our REST methods
        return contactMap.get(contactId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
                                    //criteria is the name of our map we passed in of predicates/strings
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME); //this is pulled from our enum "SearchTerm" which we created
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String companyCriteria = criteria.get(SearchTerm.COMPANY);
        String phoneCriteria = criteria.get(SearchTerm.PHONE);
        String emailCriteria = criteria.get(SearchTerm.EMAIL);
        
        //will concatenate our predicates, which will allow us to filter
        //declare var of type Predicate<Contact>
        Predicate<Contact> firstNameMatches;
        Predicate<Contact> lastNameMatches;
        Predicate<Contact> companyMatches;
        Predicate<Contact> phoneMatches;
        Predicate<Contact> emailMatches;
 
        //true predicate--if we don't hear back, it's true
        Predicate<Contact> truePredicate = (c)->{return true;}; //expectatino of filter w. lambda is that it will pass in a paramater
                            //our filter takes in a parameter of type "Predicate"
        //we just defined a predicate that is a pass-through predicate for a pass=through filter
                                        //if we run a get, we get nothing....
        firstNameMatches = (firstNameCriteria ==null || firstNameCriteria.isEmpty())?//this is ternaary operator and continues on next line
                truePredicate //if either of the first is true, assign truePredicate (i.e. let everything through)
                : (c) -> c.getFirstName().equalsIgnoreCase(firstNameCriteria); //else, assign these criteria to the matches
          
        
        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())?
                truePredicate
                    : (c) -> c.getLastName().equalsIgnoreCase(lastNameCriteria);
        
        companyMatches = (companyCriteria == null || companyCriteria.isEmpty())?
                truePredicate
                    : (c) -> c.getCompany().equalsIgnoreCase(companyCriteria);      
        
        phoneMatches = (phoneCriteria == null || phoneCriteria.isEmpty())?
                truePredicate
                : (c) -> c.getPhone().equalsIgnoreCase(phoneCriteria);
        
          
        emailMatches = (emailCriteria == null || emailCriteria.isEmpty())?
                truePredicate
                : (c) -> c.getEmail().equalsIgnoreCase(emailCriteria);
                
                                                                  //here is where we chaing the predicates
        return contactMap.values().stream().filter(firstNameMatches
                .and(lastNameMatches)
                .and(companyMatches)
                .and(phoneMatches)
                .and(emailMatches)
                )
                .collect(Collectors.toList());
                                                //we are now putting the first name matches into our filter
        
        //we will now do the same thing with all of our predicates and then we can chain them
        //this will allow us to search on several search terms at the same time
        
        
    }//end method
    
}//end  class
