package com.swcguild.classmodeling;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class House {
    /* properties: address, bedrooms, color, entrance, number doors
       let's do setters and getters for 3 and just getters for 2
    */
    //declare
    private String houseAddress;
    private String city;
    private String houseColor;
    private int bedrooms;
    private int numberOfWindows;
    
    //constructor
    public House(String address, String location, String color, int rooms, int windows){
        this.houseAddress = address;
        this.city = location;
        this.houseColor = color;
        this.bedrooms = rooms;
        this.numberOfWindows = windows;
         
    }
    
    //getters and setters (aka - accessors and mutators
    public String getHouseAddress() {
        return houseAddress;
    }

    public String getCity() {
        return city;
    }

    public String getHouseColor() {
        return houseColor;
    }

    public void setHouseColor(String houseColor) {
        this.houseColor = houseColor;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }
    
    //other methods
    public void sold(){
        System.out.println("This house was just sold.");
    }
    
    public void saleDate(){
        System.out.println(LocalDate.now());
    
    }
    
}
