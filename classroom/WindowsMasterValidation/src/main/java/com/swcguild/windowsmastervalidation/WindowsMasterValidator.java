/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.windowsmastervalidation;


import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class WindowsMasterValidator {
    
    public static void main(String[]args){
     Scanner sc= new Scanner (System.in);  
       
        float height;
        float width;
        float enterCost;
       
    String height2;
    String width2;
   
    float area;
    double cost;
    float perimeter;
     
   
    System.out.println("Enter window height");
            height2 = sc.nextLine();
       
        System.out.println("Enter window width");
            width2 = sc.nextLine();
   
           
            height =Float.parseFloat(height2);
            width = Float.parseFloat(width2);
           
            area = height * width;
           
 
    
     boolean areaValid = ((height>= 1 && height<=15) && (width >= 1 && width <=15)&& (area <= 150));
   
      while(!areaValid)
     
      {  System.out.println("Please enter valid number between 1 & 15 with an area to not excceed 150");
       
        System.out.println("Enter window height");
            height2 = sc.nextLine();
       
        System.out.println("Enter window width");
            width2 = sc.nextLine();
              
 
    }
   
 
     
  
               
                perimeter = 2*( height + width);
            
            cost = ((3.50f * area)+ (2.25f * perimeter));
   
    System.out.println("Window height = "+ height2);
    System.out.println("Window width = " + width2);
    System.out.println("Window area = "+ area);
    System.out.println("Window perimeter = " + perimeter);
    System.out.printf("Total cost = %.2f\n", cost);
   
  
         //((height <= 15 && width <= 15)&&(area <= 150));
 
   //System.out.print("Please enter  cost you are willing to pay ");
        //enterCost = sc.nextFloat();
 
  }
   
    } 





