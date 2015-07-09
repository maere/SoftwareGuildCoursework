/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author apprentice
 */
public class TimerAspect {
    
    
    public String logToConsole(ProceedingJoinPoint jp){
        String timeStamp = null;
        
        try{
            long start = System.currentTimeMillis();
            jp.proceed();//bewteen these two times something has to happen at our joinpoint
            long end = System.currentTimeMillis();
            timeStamp =  "The method " + jp.getSignature().getName() + " took " + (end-start) + "ms to execute.";
                                        //the signature and name of the method at the joinpint
        }
        catch (Throwable e){
            System.out.println("There was a problem with this method.");
        }
        
        return timeStamp;
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