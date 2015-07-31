/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcwebapp.dao;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import com.swcguild.dvdlibrary.dto.SearchTerms;
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
public class DvdLibraryDaoDbImpl implements DvdLibraryDao {

    //need the jdbc template (is a Type, needs a cap)
    private JdbcTemplate jdbcTemplate;

    //need a custom setter for the template
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //need SQL statements as variables - private static final String (and make them "strings!") only the ones that are set--not the ID
    private static final String SQL_INSERT_DVD = "INSERT INTO Dvds (title, release_date, rating, director, studio, note) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_DVD = "UPDATE Dvds SET title=?, release_date=?, rating=?, director=?, studio=?, note=? WHERE id=?";
    private static final String SQL_DELETE_DVD = "DELETE FROM Dvds WHERE id=?";
    private static final String SQL_SELECT_DVD = "SELECT * FROM Dvds WHERE id=?";
    private static final String SQL_SELECT_ALL_DVDS = "SELECT * FROM Dvds";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void add(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(), //we use getters bc we are getting object that were passed to us from the web and need to pull the values before we can pass these to DB
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote());

        dvd.setId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        //our interface does not require a return, just tht we insert, and set the id
        //NOTE: this differs from the contact model
    }

    @Override //jdbc template kind of replaces the dao
    public void remove(int id) {
        jdbcTemplate.update(SQL_DELETE_DVD, id);
    }

    @Override
    public List<Dvd> listAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());

    }

    @Override
    public Dvd getById(int id) {

        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public void update(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getId());

    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerms, String> criteria) {

        //if the whole thing is empty, just return everything
        if (criteria == null || criteria.isEmpty()) {
            return listAll();   //once we return, we're out - simple if
        }
        //else build up a String query with String builder
        StringBuilder sQuery = new StringBuilder("SELECT * FROM Dvds WHERE ");

        //make an array to hold the search terms -- before that need to initialze a variable to hold the size of the array
        String[] paramValues = new String[criteria.size()]; //this will be the second part of the search query with the paramaterize values (????)

        //make a param counter and initalize to 0
        int paramNum = criteria.size();
        int paramPos = 0;

        //make a key set and a way to iterate from the Keyset
        Set<SearchTerms> keyTerms = criteria.keySet();
        Iterator<SearchTerms> iter = keyTerms.iterator(); //iterator on the SearchTerms

        //use the iter .whileNext() method 
        while (iter.hasNext()) {
            //get the next key and next value
            SearchTerms currentTerm = iter.next();
            String currentValue = criteria.get(currentTerm);

            //if it's the first array item, will NOT need to append AND, but for all the other ones you will
            if(paramPos>0){
                sQuery.append(" AND ");
            }
            //push the term to the paramString 
            sQuery.append(currentTerm);
            sQuery.append("=?");
            //and don't forget to add to the Param array, we will need to pass that separately -- don't think we need to pass comma, bc is array and the jdbc query method will take care of that
            paramValues[paramPos] = currentValue;
            //increment the paramcounter
            paramPos++;
        }
        //call the query you've created on the jdbcTemplate
        //we choose the querty that takes a SQLQuery(we will build w. STring Builder), a rowMapper, and an Object with args (indicates List<> but [] will prob also work)
        return jdbcTemplate.query(sQuery.toString(), new DvdMapper(), paramValues);
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        return null;

    }

    @Override
    public List<Dvd> getByRating(String rating) {
        return null;

    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return null;

    }

////ROW mapper implementation and method
    //everything in the DB version is private static final, including the class...
    private static final class DvdMapper implements ParameterizedRowMapper<Dvd> { //parameterized row mapper is the Class we need to implement secruity

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {
            //constructor for object
            Dvd dvd = new Dvd();
            //set properties of object based on resultSet getters -- all of the values will be the columnName strings
            dvd.setId(rs.getInt("id"));
            dvd.setTitle(rs.getString("title"));
//            String strRelease = rs.getString("release_date");
//            dvd.setReleaseDate(strRelease);
            dvd.setReleaseDate(rs.getString("release_date")); //this needs to be converted to a date object

            dvd.setMpaaRating(rs.getString("rating"));
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setNote(rs.getString("note"));

            return dvd;
        }

    }

}

//    @Override
//    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
//        
//        if (criteria == null || criteria.size() == 0) return getAllContacts();
//        
//        
//        StringBuilder query = new StringBuilder("SELECT * FROM contacts WHERE ");
//        
//        int numParams = criteria.size();
//        int paramPosition = 0;
//        
//        String[] paramVals = new String[numParams];
//        
//        
//        
//        Set<SearchTerm> keyset = criteria.keySet();
//        Iterator<SearchTerm> iter = keyset.iterator();
//        
//        
//        while (iter.hasNext()) {
//            
//            SearchTerm currentKey = iter.next();
//            String currentValue = criteria.get(currentKey);
//            
//            
//            if (paramPosition > 0) {
//                query.append (" and "); // this is actually the AND in a SQL query so query string will "SELECT * DVDs WHERE X=? AND Y=? AND Z=? (how does the ; get put in? or does it not matter)
//            }
//            
//            query.append(currentKey);
//            query.append(" = ?");
//            
//            paramVals[paramPosition] = currentValue;
//            paramPosition++;
//            
//        }
//        
//        return jdbcTemplate.query(query.toString(), new ContactMapper(), paramVals);
//        
//    }
//    
