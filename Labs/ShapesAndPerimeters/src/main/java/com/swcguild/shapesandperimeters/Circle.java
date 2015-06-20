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
public class Circle extends Shape{

    protected float diameter = io.readFloat("For the CIRCLE shape\nPlease enter the diameter \n");
    
    
    
    public Circle() {
        this.name = "Circle";
    }
    
    public float area() {
    
        float area = (float) (Math.PI*(Math.pow((diameter/2), 2)));
        
        return area;
    }
    
    public float perimeter() {
    
        float perimeter = (float) (Math.PI*(diameter));
        
        return perimeter;
    }
}



