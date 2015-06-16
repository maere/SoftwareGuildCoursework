/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classroster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class ClassRoster {
    //need constants
    public static final String ROSTER_FILE = "roster.txt"; // this constant must be in CAPS 
                                        // we set it equal to a persistant file
    public static final String  DELIMITER = "::";
    //*********Everything is based on this hashmap*********
    private HashMap <String, Student> students = new HashMap<>(); //this will hold keys and values of student objects
    
    public void loadRoster() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
                            //readers in the ROSTER_FILE (date)
        String currentLine; // creates a variable called currentLinie
        String[] currentTokens; //creates a string array for these
        
        while(sc.hasNextLine())
        {
            currentLine = sc.nextLine(); // our line has 4 items split by the :: delimtier
            currentTokens = currentLine.split(DELIMITER);  //this just splits everything into pieces & shoves into slots in the array
                                                            //how does it know the size?
            
            //we create a new student object with an id to push these values in the indexes into
            Student currentStudent = new Student(currentTokens[0]); //we don't have a constructor for this, but will take tokens and pass the first element in, and then define it
                                                //so we go back to Student class and create a constructor with at least a string input
            
            //now that we have a student object
            //we can use our setters to assign values to the properties of this data object
            currentStudent.setFirstName(currentTokens[1]);//this is the second item/token in the line
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);
            
            //students is our Hash--so we'll push what we just made into the hash, according to studentId (willl have to get the id of the currentObj
            students.put(currentStudent.getStudentId(), currentStudent); // current Student is a student object
                                        //we are asking for our getter to pull thei ID
        
        
        }
        sc.close();
        
    }
    
    public void writeRoster()throws IOException //every time you use the Exception class you have to import!
    {
        //we crate this to write to/from our data on the back end -- we call this from our Controller class in the run method
        PrintWriter out = new PrintWriter(new FileWriter(ROSTER_FILE));
        String[] keys = this.getAllStudentIds(); // it;s in hte same object -- our method is below...we just call it again on .this for this function
        
        for(int i=0; i<keys.length; i++){ //keys has all the ids so 
            Student currentStudent = this.getStudent(keys[i]);//getStudent is a method we wrote (below) to return a student object
                                                    //what we pass in as a value for get student will return the student object value
                                                    //which at this point is an object in memory--it doesn't actually have a name    
            out.print(currentStudent.getStudentId() + DELIMITER + currentStudent.getFirstName() +  DELIMITER + currentStudent.getLastName() +  DELIMITER + currentStudent.getCohort());
            currentStudent.getCohort();
            out.flush();
        }
    }
    
    public String[] getAllStudentIds(){
        Set<String> keySet = students.keySet(); //we have to make a key set of all the student in our students hash
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray); //turns the keyset into an array
        return  keyArray;
    }
    
    public Student getStudent(String studentId){ //why am I getting an errory
        return students.get(studentId); //this is what pulls the student object for line 70 above
    
    }
    
    public void addStudent(String studentId, Student student){
        students.put(studentId, student);
    }
    
    public Student removeStudent(String studentId){ //this physically removes from the roster--interacts with the data object, not the user
        return students.remove(studentId);    //the same named method in the controller interface
    }
    
}

//the Roster classes methods are always interacting with the data....