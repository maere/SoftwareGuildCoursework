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
public class Chair {
//properties of this object: type, material, color, fold or unfold, location

//fields
private String type;
private String material;
private String location;
       
//constructor
public Chair(String chairType, String chMaterial, String chLocation){
    this.type = chairType;
    this.material = chMaterial;
    this.location = chLocation;
}
    
//getters and setters

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
//other methods and behaviors
    public void magicChair(String phrase){
        System.out.println("This chair talks.  It says things like: " + phrase);
    
    }
    
}
