/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datamodelingwarmup;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Course {
    //properties: studentname, student email, course Object, list of courses at the school
    //methods: .add, .contains, .size, 
    
    //fields
    private String studentName;
    private String studentEmail;
    private String courseName;
    
    private int enrollment;
    private String teacher;
    private int roomNumber;
    
    //constructor
     public Course(String courseName, String studentName, String studentEmail, int enrollment, String teacher, int roomNumber){
        //this.model = carModel;
         this.courseName = courseName;
         this.studentName = studentName;
         this.studentEmail = studentEmail;
         this.teacher = teacher;
         this.enrollment = enrollment;
      
    }
    
    
    
    //getters and setters
    
    //methods
     //create an HashMap of students in the course with 
     HashMap<String, String> semesterCourse = new HashMap<>();
     semesterCourse.put("studentName", "email"); 
    
    
    
}
