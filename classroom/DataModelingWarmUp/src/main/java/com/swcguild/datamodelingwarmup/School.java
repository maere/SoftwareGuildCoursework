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
public class School {
    //fields this class will use
    private String school;
    private String studentName;
    private String studentEmail;
    private List aCourse;
    private List courses;
    private String courseName;
    private int enrollment;
    private String teacher;
    
    //constructor
public School(String school, String courseName, String studentName, String studentEmail, 
int enrollment, String teacher, int roomNumber){
        //this.model = carModel;
         this.courseName = courseName;
         this.studentName = studentName;
         this.studentEmail = studentEmail;
         this.teacher = teacher;
         this.enrollment = enrollment;
      
    }

//getters and setters

//methods

//create an ArrayList of courses with each course
public HashMap schoolCourses(){
    //create an HashMap of students in the course with name of course and teacher
     HashMap<String, String> 2015courses = new HashMap<>();
     2015courses.put("courseName", "teacher"); 
     return HashMap;

}
   
}




