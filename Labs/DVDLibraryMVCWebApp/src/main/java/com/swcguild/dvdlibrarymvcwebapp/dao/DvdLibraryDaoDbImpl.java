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
import java.util.List;
import java.util.Map;
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
        
        try{
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), id);
        }
        catch (EmptyResultDataAccessException ex){
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
        return null;

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
    private static final class DvdMapper implements ParameterizedRowMapper<Dvd>{ //parameterized row mapper is the Class we need to implement secruity

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
