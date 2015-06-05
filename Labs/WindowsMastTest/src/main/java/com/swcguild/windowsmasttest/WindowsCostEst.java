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
              
              /*System.out.println("Enter the height of the window:");
                strHeight = custInput.nextLine();*/
        
                //we will also do with width...
              //System.out.println("Enter the width of the window:");
                //strWidth = custInput.nextLine();
               
                //we replaced 3 lines of code of Ilya's window master with the function at end
              height = readUserInputFloat("Please enter window height.")
              width = readUserInputFloat("Please enter window width.")
                
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
        
        // class notes on creating methods -- start outside of the main
        //we are creating a method to take user input for window height 
        //will include a request for input scanner, scan the token, and then parse the string
        public static float readUserInputFloat(String prompt) //indciate type and parameter name
        {
            Scanner sc = new Scanner(System.in);
            System.out.println(prompt);
            String stringInput  = sc.nextLine(); //we can't reuse our height var, so we have to declare an agnostic one
            //float result = Float.parseFloat(StringInput);
            //return result;
            return Float.parseFloat(stringInput); //condensed the two lines above
        }
}//it doesn't matter if the method is above or below the method call, as long is it's the same class it can find
//we can also call in methods from other classes (import them)
