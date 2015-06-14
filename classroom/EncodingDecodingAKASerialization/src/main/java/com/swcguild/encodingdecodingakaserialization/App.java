/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.encodingdecodingakaserialization;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class App {
    //will add an List/Map at the class level, not the run level
    
    private static HashMap<Integer, Student> students  = new HashMap<>();
    
    
    
    public static void main(String[] args) {
        
        //will do a decode first, calling the file name
        decode("Students.txt");
        
        
        Student student = new Student();
        student.setStudentId(3);
        student.setFirstName("Bob");
        student.setLastName("Sample");
        student.setCohort("Java");
        //now we need to add this info into our map
        students.put(student.getStudentId(), student);
        
        //then we'll call encode, but before we call it we need to make sure why have something
        //to add to it--so right above we will instantiate a student and set it's properties so we can encode this eventually
        encode("Students2.txt");
        
    }
    
    //methods
    private static void encode(String fileName)
    {
        //our try-catch block from 51 - 70 -- if we do not handle with either throw or try/catch
        //our code will not compile
        
      try{
        PrintWriter writer = new  PrintWriter(new FileWriter(fileName));
        for(Integer key:students.keySet())
        {
            Student student = students.get(key);
            writer.printf("%d::%s::%s::%s", //%d is integer in  string, %s is string
                    student.getStudentId(), //formats for our input, and manually separating for two colons
                    student.getFirstName(), 
                    student.getLastName(), 
                    student.getCohort());
            
            writer.println("");         
        }//we forgot to flush and close the file....so
        writer.flush();
        writer.close();
        
        
      }  
      catch(Exception e)
      {
          System.out.println(e.getMessage());//this is a catch all block and 
          //will catch anything and do a "throw new" and add it to the heap
          //this might be the last thing....
          //but it's good to specifyy because otherwise makes the code harder to debug
      }
        
      
       
        
    
    }
    
    
    //outside of run we are adding the decode method that we will use in our psvm run
    private static void decode(String fileName)
    {
    try{
         //when we type the above in, we willl get an arrow that we can resolve wtih an exception catcher
    Scanner sc = new Scanner(new BufferedReader(new FileReader("Students.txt")));
       
    
    while(sc.hasNext())
    {
        //scanner will go thru our file  line by line
        String fileLine = sc.nextLine();
        
        //will split each token and store into an array
        String[] fileProperties = fileLine.split("::"); //we pass in our delimiter for the .split method
        //
        if(fileProperties.length==4) //length of 4 bc we have 4 fields/props in our .txt file
        {
            Student student = new Student();
            //we will need to parse/cast our integer to String - we use the file writer method for doing this
            //so we didn't actually cast, we parsed, so Integer.parseInt is a property of java
            student.setStudentId(Integer.parseInt(fileProperties[0])); //the first item in the file is 0001 -- this is the student  ID
            student.setFirstName(fileProperties[1]); //second token
            student.setLastName(fileProperties[2]); //these are tokens, not students!
            student.setCohort(fileProperties[3]);
            students.put(student.getStudentId(), student); //this is in a loop, so will do it once each time it loops, 1-4 and push it into the hashmap with name and ID
            
            //now we will debug..
            //we are reading them, but we're not keeping them
            //so we need to go into our student HashMap and add the students to the map on line 60 
            
            
        }
        
    }
        
    } catch(Exception e) 
    {
        System.out.println(e.getMessage());
    }
        
      
    }
    
}
