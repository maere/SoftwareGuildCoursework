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
public class Rectangle {
    
    // we need to put the things we need to calculat this into the class as a part of the contrstuctor
    //we're not going to pass as paramters
    float length;
    float width;
    
    //
    public Rectangle(){
    
   
    //return area();
    
    }
    
    public float area(){
        
         float area = length*width;
         return area;
    }
    
    public float perimeter(){
        float perimeter = (length*2)+(width*2);
        return perimeter;
    
    }
    
    
   
    
    
}
