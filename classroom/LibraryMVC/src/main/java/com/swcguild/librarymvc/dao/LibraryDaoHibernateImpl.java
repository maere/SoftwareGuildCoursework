/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.dao;

import com.swcguild.librarymvc.model.*;
import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.HBook;
import com.swcguild.librarymvc.model.Publisher;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Repository
@Transactional
public class LibraryDaoHibernateImpl implements HLibraryDao {

    private SessionFactory sessionFactory; //every Hibernate needs this, it is a Hibernate DB session (not a login session)
    //each request is scoped as it's own hibernate session (i.e. each put, each update,post)

    @Inject
    public LibraryDaoHibernateImpl(SessionFactory session) { //even though we are passing in a session variable, when constructing, 
        this.sessionFactory = session;                      //we need ot make the sessionFactory = to the session (not session=session , or factory=factory)
    }

    //this will pull the session out of the session factory, this is a getter method, custom
    //we dont' have controller, dont have sprng mvc to manage sessions
    private Session currentSession() {
        Session session = null;

        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (Exception e) {

        }
        if (session == null) {
            session = this.sessionFactory.openSession();
        }
        return session;// getCurrentSession();
    }

    //our methods
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAuthor(Author author) { //this author object has all the magical annotations on it, so when it comes in, hibernate will be able to take everything and execute what it needs to
        //
        currentSession().save(author); //will build table, find parameters, 
    }

    @Override
    public void deleteAuthor(Author author) {
        //Session session = currentSession();
        currentSession().delete(author);
        //session.flush();
    }

    @Override
    public void updateAuthor(Author author) {
        currentSession().update(author);
    }

    @Override
    public Author getAuthorById(int authorId) {
        return (Author) currentSession().get(Author.class, authorId); //need to cast even tho we want this back--is this bc it retuurns a generic object?
    }

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) currentSession().createCriteria(Author.class).list();//you have to cast to a list of type author, even tho it is return an list of author objects (the list type needs to match too)
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBook(HBook book) {
        currentSession().save(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBook(HBook book) {
        //Session session = currentSession();
        currentSession().delete(book);//
       // session.flush();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateBook(HBook book) {
        currentSession().update(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public HBook getBookById(int bookId) {
        return (HBook) currentSession().get(HBook.class, bookId);// the HBook.class in the paramter argument is how we are passing the input -- as an HBook object
    }   //the casting of HBook on the return is how we are passing back the object--the getter method for hibernate is generic

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<HBook> getAllBooks() {
        return (List<HBook>) currentSession().createCriteria(HBook.class).list();//samme with casting the list--is a genric list it passes back
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPublisher(Publisher publisher) {
        currentSession().save(publisher);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePublisher(Publisher publisher) {
        
        currentSession().delete(publisher);
      
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePublisher(Publisher publisher) {
       //each time we have a choice between using the currentone, or opening a new one  
        currentSession().update(publisher);
       
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Publisher getPublisherById(int publisherId) {
        return (Publisher) currentSession().get(Publisher.class, publisherId);
    }

    //get methods in Hibernate will work with the @Id annotation to figure out what types things are 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) currentSession().createCriteria(Publisher.class).list();
    }

}
