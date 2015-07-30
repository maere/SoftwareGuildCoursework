/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.dao;

import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.Book;
import com.swcguild.librarymvc.model.Publisher;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface LibraryDao {
    
    public Author addAuthor(Author author);
    public void deleteAuthor(int authorId);
    public void updateAuthor(Author author);
    public Author getAuthorById(int authorId);
    public List<Author> getAuthorsByBookId(int bookId); //will return one or many
    public List<Author> getAllAuthors();
    
    public Book addBook(Book book);
    public void deleteBook(int bookId);
    public void updateBook(Book book);
    public Book getBookById(int bookId);
    public List<Book> getBooksByAuthorId(int authorId);//will return one or many
    public List<Book> getBooksByPublisherId(int publisherId);
    public List<Book> getAllBooks();
    
    public Publisher addPublisher(Publisher publisher);
    public void deletePublisher(int publisherId);
    public void updatePublishers(Publisher publisher);
    public Publisher getPublisherById(int publisherId);
    public Publisher getPublisherByBookId(int bookId); //one to one
    public List<Publisher> getAllPublishers();
         
    
    
}
