/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_14_sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MovieTitleGen {
    public static void main(String[] args) throws Exception
	{

//		String[] adjectives = arrayFromUrl("http://cs.leanderisd.org/txt/adjectives.txt");
//		String[] nouns      = arrayFromUrl("http://cs.leanderisd.org/txt/nouns.txt");
                
            
                String[] adjectives = arrayFromFile("adjectives.txt");
                String[] nouns = arrayFromFile("nouns.txt");

		System.out.println("Mitchell's Random Movie Title Generator\n");

		System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
		System.out.println("and " + nouns.length + " nouns (" + (adjectives.length*nouns.length) + " combinations).");

//               String adjective = "Cool";
//		String noun = "Mitchell";
                
//Make it so that the adjective and noun are chosen randomly out of their respective arrays. 
                //first we need a random integer value to pass in to the slot
                int adjInt = (int) (0 + Math.random()*adjectives.length);
                int nounInt = (int) (0 + Math.random()*nouns.length);
                
                //then we need to assign a variable to the string equal to the value of that slot
                String adjective = adjectives[adjInt];
                String noun = nouns[nounInt];  
                
                //then pass that into the sout statement
         
		System.out.println( "Your movie title is: " + adjective + " " + noun );
	}

	/**
	*	@param url - the URL to read words from
	*	@return An array of words, initialized from the given URL
	*/	
//    public static String[] arrayFromUrl( String url ) throws Exception
//	{
//		Scanner fin = new Scanner((new URL(url)).openStream());
//                
//		int count = fin.nextInt(); //a number is stored at the top of the .txt file as the first item -- this is what nextInt pulls
//                                           
//
//		String[] words = new String[count]; //string array size is pulled from the txt file as a single int
//
//		for ( int i=0; i<words.length; i++ )
//		{
//			words[i] = fin.next(); //affter it pulls the int, just goes through the list, token by token (also line by line)
//		}
//		fin.close(); //close the scanner
//
//		return words;
//	}
	
    
    public static String[] arrayFromFile(String myFile) throws FileNotFoundException{
        //String[] myArray;
        Scanner sc = new Scanner(new BufferedReader(new FileReader(myFile)));
        
        int count = sc.nextInt(); //a number is stored at the top of the .txt file as the first item -- this is what nextInt pulls
                                           

		String[] words = new String[count]; //string array size is pulled from the txt file as a single int

		for ( int i=0; i<words.length; i++ )
		{
			words[i] = sc.next(); //affter it pulls the int, just goes through the list, token by token (also line by line)
		}
		sc.close(); //close the scanner

		return words;
    }
    

}
    

