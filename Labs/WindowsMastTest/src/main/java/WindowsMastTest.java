import java.util.Scanner; //import the Scanner package so we can get user input
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.swcguild.windowsmasttest;

/**
 *
 * @author apprentice
 */
public class WindowsMastTest {
    public static void main(String[] args) {
        String strHeight = ""; //String variable for height (read from Console)
        String strWidth = ""; //String variable for width (read from Console)
    /*
    String s = "123";
    int i = Integer.parseInt( s );
    */
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Enter the height of the window:");
        strHeight = sc.nextLine();
        
        System.out.println("Enter the width of the window:");
        strWidth = sc.nextLine();
        
        float height = Float.parseFloat(strHeight);//float variable for height (converted from String - use float because we don’t want to be
        //limited to whole feet)
        float width =  Float.parseFloat(strWidth);//float variable for width (converted from String - use float because we don’t want to be
        //limited to whole feet)
    
        float area = height * width;//float variable for area of window (calculated from height and width)
        float perimeter = (height*2)+(width*2);//float variable for perimeter of window (calculated from height and width)
        
        float cost = (3.50f*area) + (2.25f*perimeter);//float variable for cost (calculated from area, perimeter, and costs)

        System.out.println("Your total cost is:" + cost); //println prints our cost
        
    }
    

    
}
