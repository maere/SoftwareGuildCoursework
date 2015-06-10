/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild._pbd;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AreaCalculator104Method {
    
    public static void main(String[] args) {
        int response;
        System.out.println("This program calculates areas: ");
        System.out.println("");
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("1. Triangle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.println("4. Circle");
        System.out.println("5. Quit");
        System.out.println("----------------");
        System.out.println("Which shape's area would you like to calculate?");
        
        response = sc.nextInt();
        System.out.println("You picked: " + response);
       
        
        switch (response) {
            case 1:  
                System.out.println("Please enter a base.");
                int base = sc.nextInt();
                System.out.println("Please enter a height.");
                int height = sc.nextInt();
                double output = area_triangle(base, height);
                System.out.println("Your area is:" + output);
                break;
            case 2:  
                System.out.println("Please enter the length.");
                int length = sc.nextInt();
                System.out.println("Please enter a width.");
                int width = sc.nextInt();
                int intOutput = area_rectangle(length, width);
                System.out.println("Your area is:" + intOutput);    
                break;
            case 3: 
                System.out.println("Please enter the side length.");
                int side = sc.nextInt();
                intOutput = area_square(side);
                System.out.println("Your area is:" + intOutput);    
                break;      
            case 4: 
                System.out.println("Please enter the radius.");
                int radius = sc.nextInt();
                double doubleOutput = area_circle(radius);
                System.out.println("Your area is:" + doubleOutput);    
                break;
            case 5:  
                System.out.println("Goodbye.");
                break;
            default: 
                break;
    }
        
        
    }
           
    
    //methods
    public static double area_circle( int radius ){
        return (Math.PI)*(Math.pow(radius, 2));
    }// returns the area of a circle
    //There is no operator, but there is a method. //Math.pow(2, 3) // 8.0   //Math.pow(3, 2) // 9.0

            
    public static int area_rectangle( int length, int width ){
        return length*width;
    }   // returns the area of a rectangle
            
            
    public static int area_square( int side ){
        return side*side;
    }                   // returns the area of a square
            
            
    public static double area_triangle( int base, int height ){
        return .5*base*height;
    }  // returns the area of a triangle
    
    
}
// to cast  - double dTime = 6.555; --- int hours = (int) dTime; -- int minutes = (int) ((dTi


/**
 * Write a program to calculate the area of four different geometric shapes: 
 * triangles, squares, rectangles, and circles. 
 * You must use functions. Here are the functions you should create:



* our program should present a menu for the human to choose which shape to calculate, 
* then ask them for the appropriate values (length, width, radius, etc.). 
* Then it should pass those values to the appropriate function and display the resulting area.

Notice that you must not input the values inside the functions, 
* and you must not display the values inside the functions. 
* All input and output must be in the main(), 
* and values must be passed to the functions and returned from them.
* 
* You'll need the value of π for area_circle(); 
* feel free to use the built-in double variable called Math.PI.

The menu should keep looping until the human chooses to quit.
* 
 */