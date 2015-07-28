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
 * @author ilyagotfryd
 */
public class ContactListDaoInMemImpl implements ContactListDao {

    private Map<Integer, Contact> contactMap = new HashMap<>();
    private static int contactIdCounter = 0;
    
    @Override
    public Contact addContact(Contact contact) {
        contact.setContactId(contactIdCounter);
        contactIdCounter++;
        contactMap.put(contact.getContactId(),contact);
        return contact;
    }

    @Override
    public void removeContact(int contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {      
        Collection<Contact> c = contactMap.values();
        return new ArrayList(c);
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String companyCriteria = criteria.get(SearchTerm.COMPANY);
        String phoneCriteria = criteria.get(SearchTerm.PHONE);
        String emailCriteria = criteria.get(SearchTerm.EMAIL);
        
        Predicate<Contact> firstNameMatches;
        Predicate<Contact> lastNameMatches;
        Predicate<Contact> companyMatches;
        Predicate<Contact> phoneMatches;
        Predicate<Contact> emailMatches;
        
        Predicate<Contact> truePredicate = (c) -> {return true;};
        
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getFirstName().equalsIgnoreCase(firstNameCriteria);
        
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
        
        return contactMap.values().stream()
                    .filter(firstNameMatches
                                .and(lastNameMatches)
                                .and(companyMatches)
                                .and(phoneMatches)
                                .and(emailMatches)
                    )
                    .collect(Collectors.toList());
        
    }
    
}
