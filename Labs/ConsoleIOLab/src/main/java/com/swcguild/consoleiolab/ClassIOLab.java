/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.consoleiolab;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ClassIOLab {
    //properties: prompt, int value, int max, int min, string value, float value, float max, float min, 
    // (cont.): double value, double max, double min
    
    //fields
    private String stringOutVal;
    private String promptVal;
    
    private int minVal;
    private int maxVal;
    
    private float floatVal;
    private double dblVal;
    private int intVal;
    
    //construtor
    public ClassIOLab(String promptVal, String stringOutVal, int minVal, int maxVal, float floatVal, double dblVal, int intVal){
        this.promptVal = promptVal;
        this.stringOutVal = stringOutVal;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.intVal = intVal;
        this.dblVal = dblVal;
        this.floatVal = floatVal;
    }
    
    //methods--generalized
        //take input (int, float, double, string)
        //conversion methods (convert to string, or cast to int, float, double)
        //output (string) -- print to screen (string)
        //range validator (takes max, min)
    
    //methods--converted from requirements
        //display prompt, read in an integer
            //The prompt value should be passed in as a parameter and the value that is read in *should be the return value* of the method.
        public int returnInt(String prompt, int intVal){
            Scanner scInt = new Scanner(System.in);
            System.out.println(prompt);
            intVal = scInt.nextInt();
            return intVal;
        }
        
        //display prompt and read in an integer...with min and max value
            //prompt val, min and max passed in as params--return value is the value read in
                //must keep asking for value until is within the appropriate range
        public int intakeValidator(String prompt, int intVal, int minVal, int maxVal){
            do {
            Scanner scInt = new Scanner(System.in);
            System.out.println(prompt);
            intVal = scInt.nextInt();
            }
            while (intVal<minVal ||intVal>maxVal);
            return intVal;
            
        }
        //display prompt and read in a string, return the string read in
        public String stringOut(String prompt, String stringOutVal){
            Scanner strSc = new Scanner(System.in);
            System.out.println(prompt);
            String currString = strSc.next();
            return currString;
        
}
        //display prompt and read float, return float
        public float floatReader(String prompt, float floatVal){
            Scanner fltSc = new Scanner(System.in);
            System.out.println(prompt);
            float currFloatVal = fltSc.nextFloat();
            return currFloatVal;
        }
    
        //display prompt and read float, validate for min/max values
            //prompt val, min, max are passed in as params -- return is value read in
                //must keep asking until is within range
        public float floatValidator(String prompt, float floatVal, int minVal, int maxVal){
            do {
            Scanner fltSc = new Scanner(System.in);
            System.out.println(prompt);
            floatVal = fltSc.nextFloat();
            }
            while (floatVal<minVal ||floatVal>maxVal);
            return floatVal;
            
        }
        
        //display prompt for double, read in 
        public double doubleReader(String prompt, double dblVal){
            Scanner dblSc = new Scanner(System.in);
            System.out.println(prompt);
            dblVal = dblSc.nextDouble();
            return dblVal;
        }
    
        
        //display prompt for double, read in value, min, max, and run until within range, ret val
         public double doubleReader(String prompt, double dblVal, double dblMin, double dblMax){
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

/*

The objective of this lab is to practice designing and implementing programs
that have more than one class (i.e. an app.class w. psvm, and a object.class with props & methods)

Requirements:

Design a class (no main method) that has methods to ask for and retrieve keyboard input
from the user and to print information out to the console. 

You must have methods that do the following:

1. Display a prompt to the user and read in an integer. The prompt value should be passed
in as a parameter and the value that is read in should be the return value of the method.

2. Display a prompt to the user and read in an integer between max val and min val. The
prompt value, min, and max should be passed in as parameter. The value read in from
the console should be the return value of the method. This method must keep asking
the user for input until the value is in range.

3. Display a prompt to the user and read in a String. The prompt value should be passed in
as a parameter and the value that is read in should be the return value of the method.

4. Display a prompt to the user and read in a float. The prompt value should be passed in
as a parameter and the value that is read in should be the return value of the method.

5. Display a prompt to the user and read in a float between max val and min val. The
prompt value, min, and max should be passed in as parameter. The value read in from
the console should be the return value of the method. This method must keep asking
the user for input until the value is in range.

6. Display a prompt to the user and read in a double.

7. Display a prompt to the user and read in a double between max val and min val. The
prompt value, min, and max should be passed in as parameter. The value read in from
the console should be the return value of the method. This method must keep asking
the user for input until the value is in range.

8. Print a given String to the console. The prompt value should be passed in as a
parameter.

After completing this class, refactor your Simple Calculator program to use this object for all of
its console input and output.

Before coding you must create a flowchart and class diagram (in Dia) for your program.

*/
