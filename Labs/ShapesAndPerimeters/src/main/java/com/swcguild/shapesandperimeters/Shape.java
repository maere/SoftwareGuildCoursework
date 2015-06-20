/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.shapesandperimeters;

/**
 *
 * @author apprentice
 */
public abstract class Shape {
    
    protected String color;
    protected String name;
    ConsoleIO io = new ConsoleIO();
       
    //constructor
    public Shape(){
   
    }
    
    
    public abstract float area();
    
    public abstract float perimeter();
    
}