/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ilyasdatamodwarmup;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class Class {
    
    //field -- cannot instantiate Map bc it's not a public class but an interface--need to import
    Map<String, Student> student;
    
    //consturctor
    public Class{
        students = new HashMap<>();
    }
    
    //getters and setters
    
    public void addStudent(Student student){
        //call add class on a given student
    }
    
    public void removeStudent(String studentName){
    // call remove class on givenn stuent
    }
    
    
    
    
    
}
