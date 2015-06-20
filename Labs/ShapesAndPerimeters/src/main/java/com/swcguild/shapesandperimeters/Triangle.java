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
public class Triangle extends Shape {
    
   
    protected float base = io.readFloat("For the TRIANGLE shape\nPlease enter the base (if perimeter this would still be the bottom of your triangle) ");
    protected float height = io.readFloat("Please enter the height ");
    protected float sideA = io.readFloat("To calculate the Perimeter we will also need left and right side input\nPlease enter the length of the left side ");
    protected float sideB = io.readFloat("Please enter the length of the right side \n");
    
    
    
    public Triangle () {
        this.name = "Triangle";
    }
    
    public float area() {
    
        float area = (1/2)*(height*base);
        return area;
    }
    
    public float perimeter() {
    
        float perimeter = base+sideA+sideB;
        
        return perimeter;
        
    }
    
}
 