/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interfaceexample;

/**
 *
 * @author apprentice
 */
public interface Colorable {
    
    //we've defined the interface as such: if you want to use this you need to define a color
    //a member field....
    public String onADare = "test"; //can do this!
    //public String test; //can't do this in an interface!
    
    public void setColor(String color);
    //we never provide implementation with an interface!
    public String getColor();
    
    //we are not allowed to define fields within an interface, but
    //we are allowed to define constants
    
}

//Iterator is an interface
