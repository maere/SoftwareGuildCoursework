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
    
    float side;
    
    public Square(){
   
    }
    
    //@Override
    public float area(){
        float area = side*side;
        return area;
    }
    
    public float perimeter(){
        float perimeter = side*4;
        return perimeter;
    
    }
    
}
