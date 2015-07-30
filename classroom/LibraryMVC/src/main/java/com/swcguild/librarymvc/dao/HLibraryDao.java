/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.dao;

import com.swcguild.librarymvc.model.*;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface HLibraryDao {

    public void addAuthor(Author author);
    public void deleteAuthor(Author author);
    public void updateAuthor(Author author);
    public Author getAuthorById(int authorId);  
    public List<Author> getAllAuthors();
    
    public void addBook(HBook book);
    public void deleteBook(HBook book);
    public void updateBook (HBook book);
    public HBook getBookById(int bookId);
    public List<HBook> getAllBooks();
    
    public void addPublisher(Publisher publisher);
    public void deletePublisher(Publisher publisher);
    public void updatePublisher(Publisher publisher);
    public Publisher getPublisherById(int publisherId);
    public List<Publisher> getAllPublishers();

    
    
}
