/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring;

import java.util.Date;

/**
 *
 * @author apprentice
 */
public class Auditor {
    
    private Date dateStamp;
    
    public void writeEntryToFile(){
    //copy over write to file method
        
        //must *append* and not overwrite data....so it should read in all info first
        
          // String stamps out Date/Time -- order #x -- edited + action (add, remove, change)
    }
    
    
}
/*
a. Audit Aspect: 
This aspect must write an entry to a file 
each time an Order is created, edited, or removedd in the system.  

This aspect must append data to the file so we have a running log of system activity.  
Each entry should have a date and time associated with it.

*/