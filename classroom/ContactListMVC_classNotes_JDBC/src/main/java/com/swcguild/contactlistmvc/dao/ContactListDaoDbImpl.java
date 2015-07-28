/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class ContactListDaoDbImpl implements ContactListDao {
                                                                            //bc we are matching columns to values in two chunks, will need to set off the chunks in ()
    private static final String SQL_INSERT_CONTACT = "INSERT INTO contacts (first_name, last_name, company, "
                                                                            + "phone, email) VALUES (?,?,?,?,?)";
                                                                             //parameterized to prevent SQL injection attacke  
    private static final String SQL_DELETE_CONTACT = "DELETE FROM contacts WHERE contact_id=?";
    
    private static final String SQL_UPDATE_CONTACT = "UPDATE contacts " // with SET, don't need () b/c I'm just telling it to set each one, whereas above, I'm matching params tot values in two chunks
                                                   + "SET first_name=?, last_name = ?, company=?, phone=?, email=? "
                                                   + "WHERE contact_id=?";
    
    private static final String SQL_SELECT_ALL_CONTACTS = "SELECT * FROM contacts";
    
    private static final String SQL_SELECT_CONTACT = "SELECT * FROM contacts where contact_id=?";
    
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) //only pay attn to the things I just told you, so we don't get someone else's ID
    public Contact addContact(Contact contact) {                // locks the table fore the duration of the exercize
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail());//
        //we also need to get the id that SQL auto_incremented
        contact.setContactId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class)); //if we have a busy system, this could potentially give us the wrong info, 
                        //so we need to be specific in this method this needs to happen within the scope of a single transaction
                        //set an annotation for this above the method
        return contact;
    }

    @Override
    public void removeContact(int contactId) {
         jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);//
    }

    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT, 
                contact.getFirstName(), 
                contact.getLastName(), 
                contact.getCompany(), 
                contact.getPhone(), 
                contact.getEmail(),
                contact.getContactId()
                        );//
    }

    @Override
    public List<Contact> getAllContacts() {
        //need a way to take the result set that comes back from teh Query and turn it into a list -- we do this with a "mapper"
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, new ContactMapper()); //this method looks for a row mapper
        //we need to construct ContactMapper as a private class within this Imple -- se below

    }

    @Override
    public Contact getContactById(int contactId) {
            //reuse contactMapper method we created at the bottom of the class
        
        //will throw an exception, so need to addd a try catch as well:
        try{
             return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT, new ContactMapper(), contactId); //not that this is now queryForObject which will only return ONE object, not a set like .query
        }
        catch (EmptyResultDataAccessException ex){
            return null;
        }
       
    }

    @Override                           //k is SearchTerm, and v is the String in our Lambda below
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        //dynamic search querty that will change as our criteria change
        if (criteria==null || criteria.size()==0) return getAllContacts(); //can either return everything or nothing in this instance
        
        //new string builder object -- way to build strings in a way that is memory efficient
        StringBuilder query = new StringBuilder("SELECT * FROM contacts WHERE "); //this is the beginging of our criteria, and depending will add clauses to this
        
        int numParams = criteria.size(); //will keep track of how many we have
        
        int paramPosition = 0;//variable to keep track of where we are in our array
        
        String [] paramVals = new String [numParams]; //for each string passed in we will create a position
        
        
        Set<SearchTerm> keyset = criteria.keySet(); //make a set from our criteria and iterate over them (brute force, bc lambda didn't work)
        Iterator<SearchTerm> iter = keyset.iterator();
        while (iter.hasNext()){
            SearchTerm currentKey = iter.next();
            String currentValue = criteria.get(currentKey);
            
             if (paramPosition >0){ //ie if it's not the first time we've been in this loop...
                //we will append an and
                query.append(" and ");
            }
                                                                                            //Table name is case sensitive, column name is not
            query.append(currentKey); //we are appending the name of the column -- our enums match our colums (SQL is not very sensitive, except for aliases)
            
            query.append(" =?"); //we are appending the params
            
            //array to keep track of the params, and the param order
            paramVals[paramPosition] = currentValue; //so e.g. for 1, push in this value
            
            paramPosition++; //bc we are doing this multiple times we need to increment 
        }
        
           return jdbcTemplate.query(query.toString(), new ContactMapper(), paramVals);
        
    }        
        //with lambdas, if you access a value inside a lambda needs to be declared final outside, cannot change the value of a variable inside of a lambda --so no looping?
//        criteria.forEach((k, v) -> { //key will be search term, and v will be criteria we are searching for
//            if (paramPosition >0){ //ie if it's not the first time we've been in this loop...
//                //we will append an and
//                query.append(" and ");
//            }
//                                                                                            //Table name is case sensitive, column name is not
//            query.append(k); //we are appending the name of the column -- our enums match our colums (SQL is not very sensitive, except for aliases)
//            
//            query.append(" =?"); //we are appending the params
//            
//            //array to keep track of the params, and the param order
//            paramVals[paramPosition] = v; //so e.g. for 1, push in this value
//            
//            paramPosition++; //bc we are doing this multiple times we need to increment
//            
//            
//        });
        
        


    private static final class ContactMapper implements ParameterizedRowMapper<Contact>{

        @Override //for now, we'll do this, but as system gets more complex defining these contact mappers could get tedious--so Hibernate does this for us (ORM - object relational mapper)
        public Contact mapRow(ResultSet rs, int i) throws SQLException { //takes a result set and a row number
                //this method is going to run a for each loop, and we need to create a contact out of each row
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contact_id")); //takes the column label, ours is contact_id 
                                                        //we can get any data type with this....
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setCompany(rs.getString("company"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));
            
            return contact;
        }
    } //paramRowmapper is an abstract class that defines methods
    
}
