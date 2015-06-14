/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizgrades;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class Class {
    Map<String, Student> students;

    public Class() {
        students = new HashMap<>();
    }
    
    public void addStudent(String studentName, Student student)
    {
         students.put(studentName, student);
    }
    
    public void removeStudent(String studentName, Student student)
    {
        students.remove(studentName, student);
    }
    
    public void viewAllStudents()
    {
        Set<String> names = students.keySet();
        for(String n: names)
        {
            System.out.println(n);
        }
    }
}
