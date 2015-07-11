/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author apprentice
 */
public class TimerAspect {   //Type  PJP carries a method inside of it, so taht whatever method was our cut point it will allow us to run this method by calling on jp.proceed          
                             //I am passing my method in as a paramte-- jp.proceed is going to execute the method for me
    public Object logToConsole(ProceedingJoinPoint jp) throws IOException{
        Object retValueFromMethod = null; //I set my object to null and it returned null, because I never reassigned retTimer to jp.proceed
        
        try{
            long start = System.currentTimeMillis();
            retValueFromMethod = jp.proceed();  //we have to reassign the value & retTimer will be equal to whatever value our method returned
                        //bewteen these two times something has to happen at our joinpoint
            long end = System.currentTimeMillis();
            System.out.println("The method " + jp.getSignature().getName() + " took " + (end-start) + "ms to execute.");
            
                                        //the signature and name of the method at the joinpint
        }
        catch (Throwable e){
            System.out.println("There was a problem with this method.");
        }
          return retValueFromMethod;
    }
    
}
/*
b. Timing Aspect:  
This aspect must log (to the Console) how long it takes for your application to to the following:
i. Read the Products from file
ii. Read the sales tax entries from file
iii. Read the orders for a given date from file
iv. Write the orders for a given date from file
*/