-- these our a settings....
SET SQL_MODE= "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00"; -- greenich mean time

CREATE TABLE IF NOT EXISTS 'authors' (
	'author_id' int(11) NOT NULL AUTO_INCREMENT, 
	'first_name' varchar(20) NOT NULL,
	'last_name' varchar(20) NOT NULL, 
	'street' varchar(20) NOT NULL,
	'city'	varchar(20) NOT NULL,
	'state' varchar(20) NOT NULL, 
	'zip'	varchar(20) NOT NULL,
	'phone' varchar(20) NOT NULL,
	PRIMARY KEY ('author_id')

) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1; -- this is the seed value,  
-- need to run the INNOengine in order for our tables to support FOREIGN KEYS
-- are several engines in SQL, one is super quick, but doesn't support Foregin keys, Inno is most popular, 
-- but is not actually the default (samIAm is)

CREATE TABLE IF NOT EXISTS 'books'(
	'book_id' int(11) NOT NULL AUTO_INCREMENT,
	'isbn' varchar(20) NOT NULL, 
	'title' varchar(50) NOT NULL, 
	'publisher_id' int(11) NOT NULL, -- many books, one publisher
	'price' decimal(5,2) NOT NULL, -- this is a minumu, will make sure at least 5 digits to the record, 010.00, but can grow
	-- if you insert +0003.1 into decimaial, 5, 1 column, it was stored as +0003.1
	'publish_date' datetime NOT NULL,
	PRIMARY KEY ('book_id'),
	-- going off script here, which altered table later
	KEY 'publisher_id'('publisher_id') -- just the set up/placeholder, since the table that it references hasn't been created yet, we have to add the CONSTRAINT later
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

-- our linking table -- books-authors is many to many
CREATE TABLE IF NOT EXISTS 'books_authors'(
	'book_id' int(11) NOT NULL, -- many books
	'author_id' int(11) NOT NULL, -- many authors
	KEY 'book_id' ('book_id'),
	KEY 'author_id' ('author_id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1; -- no need to auto-increment bc. we are pulling these from elsewhere

CREATE TABLE IF NOT EXISTS 'publishers'(
	'publisher_id' int(11) NOT NULL AUTO_INCREMENT,
	'name' varchar(20) NOT NULL, 
	'street' varchar(20) NOT NULL,
	'city'	varchar(20) NOT NULL,
	'state' varchar(20) NOT NULL, 
	'zip'	varchar(20) NOT NULL,
	'phone' varchar(20) NOT NULL,
	PRIMARY KEY('publisher_id')

)ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

-- set constraints the key we created in the books table  -- one to many, one constraint
ALTER TABLE 'books'      -- constraint is its own beast, we give it a name, so that if we ever need to alter or delte the constraint we have a way to do that
	ADD CONSTRAINT 'books_idfk_1' FOREIGN KEY ('publisher_id') REFERENCES 'publishers' ('publisher_id')
	 ON DELETE NO ACTION; -- when we delete a publsiher, no actio, other option is to cascade and delete all books
	-- can't put in book for a publsiher that doesn't exist,        will not delete publisher, --DB will not warn us

-- set constraints for the linking table (is this always many to many) -- are two constraints 

ALTER TABLE 'books_authors'
	ADD CONSTRAINT 'books_authors_idfk_1' FOREIGN KEY ('book_id') REFERENCES 'books' ('book_id') 
		ON DELETE NO ACTION,

	ADD CONSTRAINT 'books_authors_idfk_2' FOREIGN KEY ('author_id') REFERENCES 'authors' ('author_id') 
		ON DELETE NO ACTION;

		--- constraints protect the users from themselves and from destroying the integrity of the tables