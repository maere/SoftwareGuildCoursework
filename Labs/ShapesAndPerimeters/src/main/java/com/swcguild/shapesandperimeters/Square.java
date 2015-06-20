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
public class Square extends Shape {
    
 float side = io.readFloat("For the SQUARE shape\nPlease enter the length of your side\n");
    
    
    public Square( ) {
    this.name = "Square";
        
    }
    
    public float area() {
        
       
        float area = side*side;
        return area;
    }
    
    public float perimeter() {
        
    
        
        float perimeter = side*4;
        
        return perimeter;
    
    }
    
}