/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classmodeling;

/**
 *
 * @author apprentice
 */
public class School {
    
//properties of this object: location, level, number of students, mascot, demographics, 
    //context: is it a game, or a realty, or 
    //if the purpose of the field is to keep the state internally, you don't need to expose that
    //e.g. grades--these don't need getters and setters
//fields
private String location;
private String level;
private int students;
private String mascot;
private boolean power;
private Object sRecords; // is this correct? //this is just the path to our student records object
//which will have all the properties and method of a specific object -- this allows access to that object collection of records
    
//constructor
public School(String schoolLocation, String gradeLevel, int schoolStudents, boolean powerOn, Object studentRecords){
    this.location = schoolLocation;
    this.level = gradeLevel;
    this.students = schoolStudents;
    this.power = powerOn;
    this.sRecords = studentRecords;
}
    
//getters and setters

    public String getMascot() {
        return mascot;
    }

    public int getStudents() {
        return students;
    }

    public String getLocation() {
        return location;
    }

    public String getLevel() {
        return level;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public Object getsRecords() {
        return sRecords;
    }

    public void setsRecords(Object sRecords) {
        this.sRecords = sRecords;
    }

   

//other methods and behaviors-- lights on and lights off, fire drill, 
    
    public static boolean electricitySwitch(boolean currentVal){
        if (currentVal==true){
            currentVal=false;
        }
        else if(currentVal==false){
            currentVal=true;
        }
        return currentVal;
    
    }
    /* this should go in the sRecords Class/Object -- the ability to pull a record
    public Object studentGrade(String studentName){
        
        return record;}
    */
    


   
}
