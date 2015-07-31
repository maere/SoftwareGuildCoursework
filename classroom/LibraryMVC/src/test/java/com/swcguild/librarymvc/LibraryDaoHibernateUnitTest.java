/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc;

import com.swcguild.librarymvc.dao.HLibraryDao;
import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.HBook;
import com.swcguild.librarymvc.model.Publisher;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class LibraryDaoHibernateUnitTest {
    
    private HLibraryDao dao;
    private HBook b1;
    private HBook b2;
    private HBook b3;
    private Author a1;
    private Publisher p1;
    
    public LibraryDaoHibernateUnitTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("hibernateLibraryDao", HLibraryDao.class);
        
        p1 = new Publisher();
        p1.setCity("Cleveland");
        p1.setName("Local");
        p1.setPhone("2161234567");
        p1.setState("OH");
        p1.setStreet("123 Euclid ave.");
        p1.setZip("44103");
        
        b1 = new HBook();
        b1.setIsbn("ISBN-12345");
        b1.setPrice(new BigDecimal(123.45));
        b1.setPublisher(p1);
        b1.setPublishDate(new Date()); 
        b1.setTitle("Some BOOK");
        
        
    }
    
    @After
    public void tearDown() {
        List<Publisher> publishers = dao.getAllPublishers();
        for(Publisher p: publishers){
            dao.deletePublisher(p);
        }
        List<Author> authors = dao.getAllAuthors();
        for(Author a: authors){
            dao.deleteAuthor(a);
        }
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void addGetRemoveBook()
     {
         dao.addBook(b1);
         HBook result = dao.getBookById(b1.getBookId());
         dao.addPublisher(p1);
         assertEquals(b1,result);
     }
     
     @Test
     public void addGetRemovePublisher()
     {
         dao.addPublisher(p1);
         int resultId = p1.getPublisherId();
         Publisher result = dao.getPublisherById(resultId);
         assertEquals(p1,result);
         
         dao.deletePublisher(result);
         result = dao.getPublisherById(resultId);
         Assert.assertNull(result);
                 
     }
   
     @Test
     public void updatePublisher(){
         dao.addPublisher(p1);
         int resultId = p1.getPublisherId();
         p1.setName("New Publisher"); //change name here from Cleveland to New Publisher
         
         dao.updatePublisher(p1);
         
         Publisher result = dao.getPublisherById(resultId);
         //in mem impl, the object is same obj, but when we pull object out of the dB we are getting a brand new model
         Assert.assertEquals(p1, result); //this is now a different reference but a different object
         
     
     }
     
     
}
