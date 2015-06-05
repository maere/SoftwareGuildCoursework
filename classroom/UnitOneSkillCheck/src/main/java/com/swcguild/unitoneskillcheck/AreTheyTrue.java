/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class AreTheyTrue {
    public static void main(String[] args) {
    //Implement test code in your main method that calls the howTrue method. 
     howTrue(true, true);
      howTrue(false, false);
       howTrue(true, false);
        howTrue(false, true);
/*Test with the following input values and print the results to the console:
        true and true
        false and false
        true and false
        false and true
*/  
    }
//Implement a non-static method called howTrue that takes two booleans as parameters and returns a String.  Th    
    public static String howTrue(boolean one, boolean two){
        
        String result = "null";
        //The String value returned follows these rules:
        
            //Return “NEITHER” if neither input is true
        if(one==false && two==false){
            result = "NEITHER";
        } 
            //Return “BOTH” if both inputs are true
         if(one==true && two==true){
            result = "BOTH";
        } 
                //Return “ONLY ONE” if only one of the inputs is true 
          if(one==true^two==true){
            result = "ONLY ONE";
        } 
          System.out.println( one +" and " + two + " are " + result + " true.");
          return result;
    }
    
}



