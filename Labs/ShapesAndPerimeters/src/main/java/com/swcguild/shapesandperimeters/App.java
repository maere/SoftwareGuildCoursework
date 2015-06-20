/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.shapesandperimeters;

/**
 *
 * @author: PAIR: This was an in-class pair with Dan.
 */
public class App {
   
    ConsoleIO io = new ConsoleIO();
    
    public static void main(String[] args) {

        Shape mySquare = new Square();
        mySquare.color = "Red";
        
        Shape myRectangle = new Rectangle();
        myRectangle.color = "Purple";
        
        Shape myTriangle = new Triangle();
        myTriangle.color = "Blue";
        
        Shape myCircle = new Circle();
        myCircle.color = "Green";

        Shape[] shapeArray;

        shapeArray = new Shape[4];

//        shapeArray[0] = mySquare.area();
//        shapeArray[1] = mySquare.perimeter();
        
        shapeArray[0] = mySquare;
        //shapeArray[1] = mySquare.perimeter();
        
        shapeArray[1] = myRectangle;
        //shapeArray[3] = myRectangle.perimeter();
        
        shapeArray[2] = myTriangle;
        //shapeArray[5] = myTriangle.perimeter();
        
        shapeArray[3] = myCircle;
        //shapeArray[7] = myCircle.perimeter();
        
        
        
        for (Shape s : shapeArray) {
            System.out.println("This is a "+s.color+" "+s.name+" with an area of "+s.area()+" and a perimeter of "+s.perimeter());
        
        }
        
        
        
        //coming back to enhanced for loop, later...much later.
//        float result1 = mySquare.area();
//        float result2 = mySquare.perimeter();
//        System.out.println(result1);
//        System.out.println(result2);
    }
}

/*
Requirements
Create a set of classes that represent a square, rectangle, triangle and circle. 

Have these classes inherit from a base class called Shape - each of them will implement at least two
methods. 
- One called area(), which will return the area of the shape, 
- and another called perimeter() which will return the perimeter of the shape.

Tips
The base class
Shape
will have a property called color 
and the two methods area() and perimeter() but they will be empty. 

They are designed to be overridden by inherited shapes. 

So make sure that any shape that you inherit from the base class implements their own versions of
area() and perimeter() based on the type of shape it is. 

It is suggested you start with a square since this should be the easiest to implement. 

Create a Shape base class, inherit a square from it and override the two methods. 

This should give you the idea for the others if you
have done things correctly.
*/
