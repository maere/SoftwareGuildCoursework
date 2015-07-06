/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbdsrecords;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Address           // apparently you can create a class inside of another file 
			  //without the same name as the file itself? This class is just an 
        		//object with fields, and a constructor will be generated by default
{
	String street;
	String city;
	String state;
	int zip;
}

/**
 *
 * @author apprentice
 */
public class WebAddresses163 {
    public static void main(String[] args) throws IOException 
            
	{
			//we store the URL to this file as a variable & create a URL object
            
            URL addys;
        //try {
            addys = new URL("http://cs.leanderisd.org/txt/fake-addresses.txt");
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(WebAddresses163.class.getName()).log(Level.SEVERE, null, ex);
//        }
			//we instantiate a scanner & assign to fin and then pass in a stream to 
			//pick up the info at the URL
                //addys = new URL("http://cs.leanderisd.org/txt/fake-addresses.txt");
		Scanner fin = new Scanner(addys.openStream());

		//create address objects by instantiating and passing in the info from the 	
		//file we are reading, line by line
		Address uno = new Address();
		uno.street = fin.nextLine();
		uno.city   = fin.nextLine();
		uno.state  = fin.next(); //note that we don't go to a line break, 
								//just the next token
		uno.zip    = fin.nextInt(); //reads int, not string
		fin.skip("\n");

		Address dos = new Address();
		dos.street = fin.nextLine();
		dos.city   = fin.nextLine();
		dos.state  = fin.next();
		dos.zip    = fin.nextInt();
		fin.skip("\n");

		Address tre = new Address();
		tre.street = fin.nextLine();
		tre.city   = fin.nextLine();
		tre.state  = fin.next();
		tre.zip    = fin.nextInt();
		fin.skip("\n");
                
                Address four = new Address();
		tre.street = fin.nextLine();
		tre.city   = fin.nextLine();
		tre.state  = fin.next();
		tre.zip    = fin.nextInt();
		fin.skip("\n");
                
                Address five = new Address();
		tre.street = fin.nextLine();
		tre.city   = fin.nextLine();
		tre.state  = fin.next();
		tre.zip    = fin.nextInt();
		fin.skip("\n");
                
                Address six = new Address();
		tre.street = fin.nextLine();
		tre.city   = fin.nextLine();
		tre.state  = fin.next();
		tre.zip    = fin.nextInt();
		fin.skip("\n");
		
		fin.close(); //we close the stream and/or file
		
		System.out.println(uno.street + ", " + uno.city + ", " + uno.state + "  " + uno.zip);
		System.out.println(dos.street + ", " + dos.city + ", " + dos.state + "  " + dos.zip);
		System.out.println(tre.street + ", " + tre.city + ", " + tre.state + "  " + tre.zip);
	} //end main

    //The code provided only creates three Address variables. 
    //Change the code to read and display two more addresses from the file. 
    
} //end  class
/*
Web Addresses

Records are an easy way to create a single variable that can hold several different values. 
For example, consider the problem of storing a mailing address. 
The address has many parts, but is conceptually one unit.

I have created a text file with some fake addresses. This file contains six addresses.

The code provided will create a record called "Address" that contains four fields:

    a field for the house number / street name (a String)
    a field for the city name (a String)
    a field for the state (a String)
    a field for the zip code (an int) 

Then, the code provided creates a variable of type Address and reads the values 
from the first address in the text file into the four fields of the record.

It does the same thing for a second and third address. Finally, it prints out the three addresses on the screen.
*/