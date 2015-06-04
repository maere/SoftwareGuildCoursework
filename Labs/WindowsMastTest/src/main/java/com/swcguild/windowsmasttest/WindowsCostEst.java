/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.windowsmasttest;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowsCostEst {
        public static void main(String[] args){
            Scanner custInput = new Scanner(System.in);
            
              String strHeight = ""; //String variable for height (read from Console)
              String strWidth = ""; //String variable for width (read from Console)
              
              String strGlassCost = "";//add materials cost
              String strTrimCost = "";
              
              System.out.println("Enter the height of the window:");
                strHeight = custInput.nextLine();
        
              System.out.println("Enter the width of the window:");
                strWidth = custInput.nextLine();
                
              System.out.println("Enter the cost of the glass you want:");
                strGlassCost = custInput.nextLine();
                
              System.out.println("Enter the cost of the trim you want:");
                strTrimCost = custInput.nextLine();  
                
        float height = Float.parseFloat(strHeight);//float variable for height (converted from String - use float because we don’t want to be
        //limited to whole feet)
        float width =  Float.parseFloat(strWidth);//float variable for width (converted from String - use float because we don’t want to be
        //limited to whole feet)
        
        float glassCost = Float.parseFloat(strGlassCost);
        float trimCost = Float.parseFloat(strTrimCost);
    
        float area = height * width;//float variable for area of window (calculated from height and width)
        float perimeter = (height*2)+(width*2);//float variable for perimeter of window (calculated from height and width)
        
        //need to change materials to variables and ask for them   
        float cost = (glassCost*area) + (trimCost*perimeter);//float variable for cost (calculated from area, perimeter, and costs)

        System.out.println("Your total area is:" + area); //print area
         System.out.println("Your total perimeter is:" + perimeter); //print perimeter
          System.out.println("Your total glass cost is:" + (glassCost*area)); //print glass cost
           System.out.println("Your total frame cost is:" + (trimCost*perimeter)); //print area
        
        System.out.println("Your total cost is:" + cost); //println prints our cost
        }
    
}
