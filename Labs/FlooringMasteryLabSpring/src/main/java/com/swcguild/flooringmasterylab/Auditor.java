/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.util.Date;

/**
 *
 * @author apprentice
 */
public class Auditor {
    
    private Date dateStamp;
    
    public void writeEntryToFile(){ //each time an order is added to this list/hashmap (add order), edit Order, or this method needs to track that
        
        //first iteration: just doing a stamp each time it writes is enough--don't need to track the actual changes or methods used.
        
    //copy over write to file method (will need to load a file, and write to file as an append--so can run a loop, reading lines until hasNext==false (or !true))
        //when it get to that point, it will write the our special we created from the hash, which keeps track of order #, and method called
             // String stamps out current Date/Time +  order #x  + order date and action taken edited + action (add, remove, change)
        
    

    }
    
    
}

    
        //must *append* and not overwrite data....so it should read in all info first  //orders is the list that  is being written to file...which was constructed from the Hash in Memory
        
        //when does it get into orders from hash? 
            //in the save method, it creates a list of order, from the current Hash, by calling getOrdersByDate...and that method loads the data which it will overwrite...
        
        //**orderMap Hash (put, get, remove in DAO) is what puts to hash***...this is actually what we want to keep track of....in our auditor method
            
/*
a. Audit Aspect: 
This aspect must write an entry to a file 
each time an Order is created, edited, or removed in the system.  

This aspect must append data to the file so we have a running log of system activity.  
Each entry should have a date and time associated with it.

*/