/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.lambdasexample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerInventoryMapExample {
    public static void main(String[] args) {
        
        Map<String, Server> serverMap = new HashMap<>();
        
        //now we are making a bunch of servers to add to our ArrayList
        Server one = new Server(); //we could have called this "server" instaed of one
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumProcessors("9");
        one.setPurchaseDate(LocalDate.parse("2010-01-01",DateTimeFormatter.ISO_DATE)); //.parse parses a string into date time--takes a string and the formater object
    
        serverMap.put(one.getName(), one);
    
         one = new Server(); //when we instantiate it will just start fresh with a new object
        one.setName("db01");
        one.setIp("192.168.45");
        one.setMake("HP");
        one.setRam("16GB");
        one.setNumProcessors("24");
        one.setPurchaseDate(LocalDate.parse("2013-01-01",DateTimeFormatter.ISO_DATE));
        
          serverMap.put(one.getName(), one);
        
        
        one = new Server(); //when we instantiate it will just start fresh with a new object
        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setMake("IBM");
        one.setRam("16GB");
        one.setNumProcessors("12");
        one.setPurchaseDate(LocalDate.parse("2014-01-01",DateTimeFormatter.ISO_DATE));
        
         serverMap.put(one.getName(), one);
        
        one = new Server();
        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setMake("HP");
        one.setRam("4GB");
        one.setNumProcessors("8");
        one.setPurchaseDate(LocalDate.parse("2001-01-01",DateTimeFormatter.ISO_DATE));
        
          serverMap.put(one.getName(), one);
        
        one = new Server();
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setMake("HP");
        one.setRam("8GB");
        one.setNumProcessors("16");
        one.setPurchaseDate(LocalDate.parse("2001-01-01",DateTimeFormatter.ISO_DATE));
        
          serverMap.put(one.getName(), one);
          
          String make = "Dell";
          System.out.println("F1 outtput: All " + make + " servers in the inventory: ");
          
//basic difference between array and hashmap is how we call the objects up:
          serverMap.values()
                  .stream()
                  .filter(s -> s.getMake().equalsIgnoreCase(make))
                  .forEach(e -> System.out.println(e.getName()));
          
          System.out.println("Next function tests for servers over 3 years: ");
          
//want to return servers over 3 years old, so create a test value to pass in...returns a boolean
          int testAge = 3;
          serverMap.values()
                  .stream()
                  .filter(s ->s.getServerAge() > testAge)
                  .forEach(e -> System.out.println(e.getName()));
          
           System.out.println("next function just gets the name of all the older servers: ----------------------------");
          
//to get all servers out of the gate, we will create a collection--we want to return a collection
          Collection<Server> oldServers = serverMap.values()
                  .stream()
                  .filter(s -> s.getServerAge() > testAge)
                  .collect(Collectors.toList());
          
          System.out.println(oldServers.size());
          oldServers.forEach(s -> System.out.println(s.getName()));
          
           System.out.println("Next function calculates average age ----------------------------");
                 
//to get average age of servers - next example...we're looking for a doubl result....
           double averageAge = serverMap.values()
                   .stream()
                   .mapToLong(Server::getServerAge)
                   .average()
                   .getAsDouble();
           System.out.println("Average age of servers is: " + averageAge);
           
           
           
    }//end psvm
            
}//end class
