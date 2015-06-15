/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalcrfconsoleio;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIOLab {
    //fields
        //don't need fields -- we will not need anything in this class but what's in the methods

    //construtor
    public ConsoleIOLab(){
        //will not need anything in here
    }
    
    //methods--generalized
        //take input (int, float, double, string)
        //conversion methods (convert to string, or cast to int, float, double)
        //output (string) -- print to screen (string)
        //range validator (takes max, min)
    
    //methods--converted from requirements
        //display prompt, read in an integer
            //The prompt value should be passed in as a parameter and the value that is read in *should be the return value* of the method.
        public int returnInt(String prompt){ //returning integer, so I don't need to ask for it
            Scanner scInt = new Scanner(System.in);
            System.out.println(prompt);
            int intVal = scInt.nextInt(); //delete from field
            return intVal;
        }
        
        //display prompt and read in an integer...with min and max value
            //prompt val, min and max passed in as params--return value is the value read in
                //must keep asking for value until is within the appropriate range
        public int intakeValidator(String prompt, int minVal, int maxVal){
        int intVal;
            do { //returning in val
            Scanner scInt = new Scanner(System.in);
            System.out.println(prompt);
            intVal = scInt.nextInt();
            }
            while (intVal<minVal ||intVal>maxVal);
            return intVal;
            
        }
        //display prompt and read in a string, return the string read in
        public String stringOut(String prompt){
            Scanner strSc = new Scanner(System.in);
            System.out.println(prompt);
            String currString = strSc.next();
            return currString;
        
}
        //display prompt and read float, return float
        public float floatReader(String prompt){
            Scanner fltSc = new Scanner(System.in);
            System.out.println(prompt);
            float currFloatVal = fltSc.nextFloat();
            return currFloatVal;
        }
    
        //display prompt and read float, validate for min/max values
            //prompt val, min, max are passed in as params -- return is value read in
                //must keep asking until is within range
        public float floatValidator(String prompt, int minVal, int maxVal){
            float floatVal;
            do {
            Scanner fltSc = new Scanner(System.in);
            System.out.println(prompt);
            floatVal = fltSc.nextFloat();
            }
            while (floatVal<minVal ||floatVal>maxVal);
            return floatVal;
            
        }
        
        //display prompt for double, read in 
        public double doubleReader(String prompt){
            Scanner dblSc = new Scanner(System.in);
            System.out.println(prompt);
            double dblVal = dblSc.nextDouble();
            return dblVal;
        }
    
        
        //display prompt for double, read in value, min, max, and run until within range, ret val
         public double doubleReader(String prompt, double dblMin, double dblMax){
             double dblVal;
            do {
                Scanner dblSc = new Scanner(System.in);
                System.out.println(prompt);
                dblVal = dblSc.nextDouble();
             }
            while (dblVal<dblMin ||dblVal>dblMax);
            return dblVal;
        }
    
//print a string to console--prompt value should be passed in as a param
         public String printVal(String prompt){
             System.out.println(prompt);
             return prompt;
         }
    
//when complete, refactor Simple Calulator to use these methods for accessing and outputting info
//does this mean the baby caculator from the PBD? it's not clear.
//getters and setters
    
    
    
}
