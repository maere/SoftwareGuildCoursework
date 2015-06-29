/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addresslab;

/**
 *
 * @author apprentice--DTO
 */
public class Address {
    //fields -- these should all be privately scoped
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private int idNumber;
    
    //static int instanceCounter = 0; //so this willl get reset to 0 every time this application runs
    //the only way to make it persist is to put it in the data file
    //when we add to data store, we look at the last id number and add 1, and then set variable to +1

    
    //contstructor
    
    public Address(){
        //this.idNumber = idNumber;
        //this.idNumber = instanceCounter++;
        
        
        //this.firstName = firstName;
        //this.lastName = lastName; //this is our handle to call up the address object - lastName parameter 
        //this.street = street;
       // this.city = city;
       // this.state = state;
        //this.zipCode = zipCode;
    
    
    }
    
    //counter added here using above fields
    //public void myCounter(){
    //    instanceCounter++;
    //    counter=instanceCounter;
    //}
    
    
    //later functionality:
    //we could add getters and setters to access individual fields -- like changing just the street address
    
    

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    
}//end class
