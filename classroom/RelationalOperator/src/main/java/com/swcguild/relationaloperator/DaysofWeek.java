/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.relationaloperator;

/**
 *
 * @author apprentice
 */
public class DaysofWeek {
    public static void main(String[] args) {
        
        //declare our vars
        int day = 4; // we are just going to do this instead of asking for input
        String dayName = "";
        
        if (day==1)
        {    
           dayName = "monday"
        }
        else if (day ==2){
            dayName = "tuesday";
        }
        else if (day==3){
            dayName = "wednesday"
        }
        else if (day==4){
            dayName = "thursday"
        }
        else if (day==5){
            dayName = "friday"
        }
        else if (day==6)
    }
        //...  else
        // { say this is not valid}
        
        
        
        
        
                //...then refactored to be a switch case...
        //our last else {} statement was replaced with default when switch
        
        /*switch(day)
        case 1: 
            dayName = "monday"
            break;
        case 2: 
            dayName = "Tuesday";
            break;
        */
    
        switch(day){
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            typeOfDay = "weekday";
            break;
        case 6:
        case 7:
            typeOfDay = "weekend"
        default:
            typeOfDay = "Invalid Day"
        }
        
        System.out.println(typeOfDay);
        
        
        
        
}
