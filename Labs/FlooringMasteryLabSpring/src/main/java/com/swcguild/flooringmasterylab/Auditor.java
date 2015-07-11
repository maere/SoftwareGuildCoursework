/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import com.swcguild.flooringmasterylab.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author apprentice
 */                    //the advice classs, doesnt' take a joinpoint parameter, but the methods I want to excecvut
public class Auditor { //advice is going to be around --becuase its' the only one 

    List<String> logData = new ArrayList<>();

    public List<String> readFileData() throws FileNotFoundException, IOException {
        String filename = "changeLog.txt";
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentLine;
            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                logData.add(currentLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is now log file and one must be created.");
            PrintWriter out = new PrintWriter(new FileWriter(filename));
        }
        return logData;
    }

    //don't need to pass a JP param into every method, just the ones I want to trigger

    public void writeEntryToFile() throws IOException { //each time an order is added to this list/hashmap (add order), edit Order, or this method needs to track that
        // ilya staid first iteration: just doing a stamp each time it writes is enough--don't need to track the actual changes or methods used.

        String filename = "changeLog.txt";
//        Date currentDate = new Date();
//        String dom = currentDate.toString();
//        Timestamp currentTime = new Timestamp(currentDate.getTime());

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss");
        //System.out.println(sdf.format(cal.getTime()));
//        
      
        String logMessage = "At " + sdf.format(cal.getTime())+ "a change was made: " ; //+ order.getId()

        PrintWriter out = new PrintWriter(new FileWriter(filename));

        if (logData.isEmpty()) {
            out.println(logMessage);
        } else {
            //int last = logData.lastIndexOf(logData);
            for (String currentLine : logData) {   //changing enhanced for loop to standard - 'for (Order currentOrder : orders)'
                out.println(currentLine);
            }
            out.println(logMessage);
        }
        out.flush();
        //}
        out.close();
    }

    //System.out.println("There was an error in reading or writing to the file.");  /* does this take a param?*/
    public void logAdviceNow(JoinPoint jp) throws IOException {
        readFileData();
        writeEntryToFile();
        //call read and then write in this class

    }

    public void logPutOrders(JoinPoint jp) throws IOException {
        readFileData();
//        jp.getArgs(); //error at ::0 formal unbound in pointcut 
//        Object [] order = jp.getArgs();
//        writeEntryToFile( (Order) order[0]);
        
        Object[] signatureArgs = jp.getArgs();
        
        for (Object signatureArg: signatureArgs) {
        System.out.println("Arg: " +  (Order) signatureArg); // signatureArg.
        }
        
        
    }

//       public void logEditedOrder(JoinPoint jp) throws IOException{
//        readFileData();
//        writeEntryToFile();
//   
//    }
    /*
     public void putOrders(Order order) throws IOException;
    
     public void putEditedOrder(Order order) throws IOException;  
    
     public Order getOrder(int orderNum);
    
     public void removeOrder(int orderNum);
    
     */
}

        //copy over our write to file method (will need to load a file, and write to file as an append--so can run a loop, reading lines until hasNext==false (or !true))
//when it get to that point, it will write the our special we created from the hash, which keeps track of order #, and method called
// String stamps out current Date/Time +  order #x  + order date and action taken edited + action (add, remove, change)
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
