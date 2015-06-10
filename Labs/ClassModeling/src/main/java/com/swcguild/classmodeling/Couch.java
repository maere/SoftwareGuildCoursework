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
public class Couch {
    
//properties of this object: length, color, fold out sleeper, condition, material (e.g. leather, wool, cotton)

//fields
 private String color;
 private boolean sleeper;
 private String material;
    
//constructor
 public Couch(String couchColor, boolean isSleeper, String couchMaterial){
     this.color = couchColor;
     this.sleeper = isSleeper;
     this.material = couchMaterial;
 }
    
//getters and setters

    public String getColor() {
        return color;
    }

    public boolean isSleeper() {
        return sleeper;
    }

    public String getMaterial() {
        return material;
    }
    
    
}
