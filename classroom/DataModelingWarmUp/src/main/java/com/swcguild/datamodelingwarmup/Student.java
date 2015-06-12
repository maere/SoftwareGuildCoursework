/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datamodelingwarmup;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Student {
    private String studentName;
    private String studentEmail;
    private String courseName;
    private List studentCourses;
    
    private String studentLevel;
    private int courseGPA;
    private int overallGPA;
    
    //student constructor
    public Student(String studentName, String studentEmail, List studentCourses, int overallGPA){
        //this.model = carModel;
         this.studentName = studentName;
         this.studentEmail = studentEmail;
          this.studentCourses = studentCourses;
          this.overallGPA = overallGPA;
        
    }
    
    //getters and setters
    
    //methods
        //add a course
        //calculate GPA
        //delete a course
    
}
