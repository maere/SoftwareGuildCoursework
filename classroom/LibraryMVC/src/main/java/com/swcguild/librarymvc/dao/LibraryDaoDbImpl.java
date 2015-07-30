/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.dao;

import static com.sun.jmx.snmp.SnmpStatusException.readOnly;
import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.Book;
import com.swcguild.librarymvc.model.Publisher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class LibraryDaoDbImpl implements LibraryDao {

    private JdbcTemplate jdbcTemplate;

    //our custom setter method for jdbc //SETTERS and GETTERs MUST BE PUBLIC OR THEY CAN'T BE ACCESSED!!
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //authors
    private static final String SQL_INSERT_AUTHOR = " INSERT INTO authors (first_name, last_name, street, city, state, zip) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_AUTHOR = " DELETE FROM authors WHERE author_id = ?";
    private static final String SQL_UPDATE_AUTHOR = " UPDATE authors SET first_name=?, last_name=?, street=?, city=?, state=?, zip=?, phone=? WHERE author_id=?";
    private static final String SQL_SELECT_AUTHOR = " SELECT * FROM authors WHERE author_id=?";
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID = "SELECT au.author_id, au.first_name, au.last_name, au.street, au.city, au.state, au.zip, au.phone FROM authors au "
            + "JOIN books_authors ba on au.author_id=ba.author_id "
            + "WHERE ba.book_id=?";
    private static final String SQL_SELECT_ALL_AUTHORS = "SELECT * FROM authors";

    //books and authors - note is not a one-to-one relationship between DTO, but follows the business logic
    private static final String SQL_INSERT_BOOK = " INSERT INTO books (isbn, title, publisher_id, price, publish_date) VALUES (?,?,?,?,?)";
    private static final String SQL_INSERT_BOOKS_AUTHORS = "INSERT INTO books_authors(book_id, author_id) VALUES (?, ?)";
    private static final String SQL_DELETE_BOOK = "DELETE FROM books WHERE book_id=?";
    private static final String SQL_DELETE_BOOKS_AUTHORS = "DELETE FROM books_authors WHERE book_id=?"; //we won't have a query to remove a book/author releationship, tho we could do it directly in SQL
    private static final String SQL_UPDATE_BOOK = "UPDATE books SET isbn=?, title=?, publisher_id=?, price=?, publish_date=?"
            + "WHERE book_id=?";
    private static final String SQL_SELECT_BOOK = "SELECT * FROM books WHERE book_id =?";
    private static final String SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID = "SELECT author_id FROM books_authors WHERE book_id=?";
    private static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String SQL_SELECT_BOOKS_BY_AUTHOR_ID = "SELECT b.book_id, b.isbn, b.title, b.publisher_id, b.price,  b.publish_date FROM books b " //need a space between statements in SQL--make sure you don't slip on line breaks!
            + " JOIN books_authors ba ON ba.book_id = b.book_id=?";  //do a join and then run a where clause to find crossovers
    private static final String SQL_SELECT_BOOKS_BY_PUBLISHER_ID = "SELECT * FROM books WHERE publisher_id=?";

    //publishers
    private static final String SQL_INSERT_PUBLISHER = "INSERT INTO publishers (name, street, city, state, zip, phone) VALUES (?,?,?,?,?,?)";
    private static final String SQL_DELETE_PUBLISHER = "DELETE FROM publishers WHERE publisher_id=?";
    private static final String SQL_UPDATE_PUBLISHER = "UPDATE publishers SET name=?, street-?, city=?, state=?, zip=?, phone=? WHERE publisher_id=?";
    private static final String SQL_SELECT_PUBLISHER = "SELECT * FROM publishers WHERE publisher_id=?";                                                           //can also use publishers pub (SQL knows you mean AS)
    private static final String SQL_SELECT_PUBLISHER_BY_BOOK_ID = "SELECT pub.publisher_id, pub.name, pub.street, pub.city, pub.state, pub.zip, pub.phone FROM publishers AS pub "
            + "JOIN books ON pub.publisher_id = books.publisher_id WHERE books.book_id=?";
    private static final String SQL_SELECT_ALL_PUBLISHERS = "SELECT * FROM publishers";

////
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Author addAuthor(Author author) {
        jdbcTemplate.update(SQL_INSERT_AUTHOR,
                author.getFirstName(), author.getLastName(),
                author.getStreet(), author.getCity(), author.getState(),
                author.getZip(), author.getPhone());

        //pull id        //we will pass the author id... if we need it, it would return it
        author.setAuthorId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class)); //casting to an integer here,  this method returns an integer, we are passing the id we got from the DB to the setter via this method that returns it
        return author;
    }

    @Override
    public void deleteAuthor(int authorId) {
        jdbcTemplate.update(SQL_DELETE_AUTHOR, authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHOR, author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getPhone(),
                author.getAuthorId());
    }

    @Override   //individual get is the one that gets the try catch...
    public Author getAuthorById(int authorId) {
        try {                                                        //go make mapper
            return jdbcTemplate.queryForObject(SQL_SELECT_AUTHOR, new AuthorMapper(), authorId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Author> getAuthorsByBookId(int bookId) {
        return jdbcTemplate.query(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(), bookId);
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORS, new AuthorMapper());  //we always will need our rowMappers to do the iterating
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Book addBook(Book book) {
        jdbcTemplate.update(SQL_INSERT_BOOK, book.getIsbn(), book.getTitle(), book.getPublisherId(), book.getPrice(),
                book.getPublishDate().toString()); //date object in DTO, need to convert to string for DB
        book.setBookId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class)); //this is a cast of the result from a stored PROC

        return book;
    }

    //delete book will need to be transactional as well, because we are linking books and authorss
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBook(int bookId) {
        //need to delete authors FIRST, bc Foreign Key will prevent deletion 
        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, bookId);
        jdbcTemplate.update(SQL_DELETE_BOOK, bookId);

    }

    //update book will be transactional as well--is this because there is a linking table?  if two tables are linked we need propagation? Is that the general rule?
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateBook(Book book) {
        //we have book we are updating, and all the relationshipsn  we are updating, 
        //so we are dumpting relationships and reinserting, including the new list of autohrs
        jdbcTemplate.update(SQL_UPDATE_BOOK,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate().toString(),
                book.getBookId());

        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, book.getBookId());
        insertBooksAuthors(book); //need to write this as a special method in our DAO imple
        //this helper methods dumps all the relationshiops of books to authors and rewrites it
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)//this is a candidate because it executes more than one query -- that's the general rule for transactional propagation
    public Book getBookById(int bookId) {
//bc we are pulling a singular object, will throw an error if it finds nothing, so need to wrap in a try/catch block
        try {
            Book b = jdbcTemplate.queryForObject(SQL_SELECT_BOOK, new BookMapper(), bookId); //will need to write book mapper
            //array of authors
            int[] idArray = getAuthorIdsForBook(b); //had to write this as a private helper method, see below, this pulls info from the bridge table

            b.setAuthorIds(idArray);

            return b;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> bList = jdbcTemplate.query(SQL_SELECT_BOOKS_BY_AUTHOR_ID, new BookMapper(), authorId);

        for (Book b : bList) {
            b.setAuthorIds(getAuthorIdsForBook(b));
        }
        return bList;
    }

    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {
        List<Book> bList = jdbcTemplate.query(SQL_SELECT_BOOKS_BY_PUBLISHER_ID, new BookMapper(), publisherId);
        for (Book b : bList) {
            b.setAuthorIds(getAuthorIdsForBook(b));
        }
        return bList;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bList = jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, new BookMapper()); // we can't just pass in a query, bc we need the author ids, 
        //this is the reason we need a row mapper

        for (Book b : bList) {
            b.setAuthorIds(getAuthorIdsForBook(b)); //we committed to getting the author ids as well
        }
        return bList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(SQL_INSERT_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone());
        publisher.setPublisherId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class)); //indcates we want to get Integer type returned

        return publisher;
    }

    @Override
    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(SQL_DELETE_PUBLISHER, publisherId);
    }

    @Override
    public void updatePublishers(Publisher publisher) {
        jdbcTemplate.update(SQL_UPDATE_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone(),
                publisher.getPublisherId()
        );
    }

    @Override
    public Publisher getPublisherById(int publisherId) {

        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PUBLISHER, new PublisherMapper(), publisherId);
        } catch (EmptyResultDataAccessException ex) {
            
            return null;
        }
    }

    @Override
    public Publisher getPublisherByBookId(int bookId) {
        
        try {
           return jdbcTemplate.queryForObject(SQL_SELECT_PUBLISHER_BY_BOOK_ID, new PublisherMapper(), bookId);
        } catch (EmptyResultDataAccessException ex) {
            
            return null;
        }
        
       
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHERS, new PublisherMapper());
    }

    //HELPER methods
//private class method we are writing as a helper method for stuff like updateBooks
    private void insertBooksAuthors(Book book) {
        final int bookId = book.getBookId();
        final int[] authorIds = book.getAuthorIds();   //getter method from teh DTO

        //Type we need to import
        jdbcTemplate.batchUpdate(SQL_INSERT_BOOKS_AUTHORS, new BatchPreparedStatementSetter() { //this is an anonymous class we will write

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, bookId);
                ps.setInt(2, authorIds[i]);
            }

            @Override
            public int getBatchSize() {
                return authorIds.length; //To change body of generated methods, choose Tools | Templates.
            }

        });

    }

    //add another helper method, private bc is only used within our DAO class
    private int[] getAuthorIdsForBook(Book book) { //single value in, but our query will return a list
        List<Integer> authorIds = jdbcTemplate.queryForList(SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID, //our bridge table
                new Integer[]{book.getBookId()}, Integer.class); //this specifies the return type we want, 
//second param is array of values, which is what the query is expecting, but we only have one value to pass in //bc we pass a generic in, so now our results in the list (from the query) will come back as integers
        int[] idArray = new int[authorIds.size()]; //make an array
        for (int i = 0; i < authorIds.size(); i++) {
            idArray[i] = authorIds.get(i);  //copy list of elements to arry
        }
        return idArray;
    }

//MAPPER classes                                      //need to implemetn all abstract methods for the ParmRowMapper
    private static final class AuthorMapper implements ParameterizedRowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {

            Author au = new Author();

            au.setFirstName(rs.getString("first_name"));
            au.setLastName(rs.getString("last_name"));
            au.setStreet(rs.getString("street"));
            au.setCity(rs.getString("city"));
            au.setState(rs.getString("state"));
            au.setZip(rs.getString("zip"));
            au.setPhone(rs.getString("phone"));
//is this supposed to be get or set?            
            au.setAuthorId(rs.getInt("author_id")); //is this supposed to be get or set?

            return au;
        }
    }//end private class

    private static final class BookMapper implements ParameterizedRowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException { //does it matter what order the fields are in?

            Book b = new Book();

            b.setBookId(rs.getInt("book_id"));
            b.setIsbn(rs.getString("isbn"));
            b.setTitle(rs.getString("title"));
            b.setPublisherId(rs.getInt("publisher_id"));
            b.setPrice(rs.getBigDecimal("price"));
            b.setPublishDate(rs.getTimestamp("publish_date").toLocalDateTime().toLocalDate()); //why do we need to do it this way?

            return b;

        }

    }//end private class
    
    private static final class PublisherMapper implements ParameterizedRowMapper<Publisher>{

        @Override
        public Publisher mapRow(ResultSet rs, int i) throws SQLException {
            Publisher pb = new Publisher();
            
            pb.setPublisherId(rs.getInt("publisher_id"));
            pb.setName(rs.getString("name"));
            pb.setStreet(rs.getString("street"));
            pb.setCity(rs.getString("city"));
            pb.setState(rs.getString("state"));
            pb.setZip(rs.getString("zip"));
            pb.setPhone(rs.getString("phone"));

            return pb;
        }
    
    }
    
    

}//end main class
