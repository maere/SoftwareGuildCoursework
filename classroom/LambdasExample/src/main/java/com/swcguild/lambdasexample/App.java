/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.lambdasexample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>(); //alwsays better to write generic (i.e. List) and than instantiate specfic type (i.e. ArrayList)
                                        //if you do the second half without the dimond brackets, 
                                        //it will instantiate without a reference of type...so as long as we are using 
                                        //a server object we are okay, but if we don't do that we are screwed and will do wierd stuff
   
    //now we are making a bunch of servers to add to our ArrayList
        Server one = new Server(); //we could have called this "server" instaed of one
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumProcessors("9");
        one.setPurchaseDate(LocalDate.parse("2010-01-01",DateTimeFormatter.ISO_DATE)); //.parse parses a string into date time--takes a string and the formater object
    
        servers.add(one);
    
         one = new Server(); //when we instantiate it will just start fresh with a new object
        one.setName("db01");
        one.setIp("192.168.45");
        one.setMake("HP");
        one.setRam("16GB");
        one.setNumProcessors("24");
        one.setPurchaseDate(LocalDate.parse("2013-01-01",DateTimeFormatter.ISO_DATE));
        
        servers.add(one);
        
        
        one = new Server(); //when we instantiate it will just start fresh with a new object
        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setMake("IBM");
        one.setRam("16GB");
        one.setNumProcessors("12");
        one.setPurchaseDate(LocalDate.parse("2014-01-01",DateTimeFormatter.ISO_DATE));
        
        servers.add(one);
        
        one = new Server();
        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setMake("HP");
        one.setRam("4GB");
        one.setNumProcessors("8");
        one.setPurchaseDate(LocalDate.parse("2001-01-01",DateTimeFormatter.ISO_DATE));
        
        servers.add(one);
        
        one = new Server();
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setMake("HP");
        one.setRam("8GB");
        one.setNumProcessors("16");
        one.setPurchaseDate(LocalDate.parse("2001-01-01",DateTimeFormatter.ISO_DATE));
        
        servers.add(one);
        
        
        //now we will print out names of all the Dell servers in our collection
        String make = "Dell";       // we declare the make within the scope of our MAIN  method...means we can use it inside the lambda
        System.out.println("All " + make  + " servers in inventory: " );
        
//IN ORDER TO USE LAMBDAS: need to make sure POM.xml file specifies version 1.8 -- not 1.7!!
        
        //now we will turn our servers into a stream-- this method turns the collection into a stream ( steram is  a java object)
                        
        servers.stream() //we don't need to put a dot here, after stream-- we can put it on the next line and the compiler will be able to read it
                .filter((Server s) -> { //s or (Server s)   -> s.getMake or {} around this, but will have to return so it's verbose 
                        return s.getMake().equalsIgnoreCase(make); //if we want to return EVERY server...just say return true;
                        }) //this statement returns true/falase (make does)
                        // s is something we define, it's standing for server
                .forEach(e-> System.out.println(e.getName()));
        
        //we are passing in a paramter that is our DTO from teh collection,a nd the return is true or false
        //if this filter returns true, it will pass that object in as part of the filtered collection
        
  //2nd example - set a test -- here is age, and return only servers that pass this test -- since is a # we need <, ==, >
        
        long testAge = 4;
        System.out.println("All servers older than " + testAge + "years in age in inventory: ");
        
        servers.stream().filter(s -> s.getServerAge()>testAge)
                .forEach(e-> System.out.println(e.getName()));
        
        
 //3rd example - collect method
            //lets create a List of our old servers called servers...
        
        List<Server> oldServers = servers
                .stream().filter(s ->s.getServerAge()> testAge)
                .collect(Collectors.toList()); //Collectors is a Type -- has it's own methods...includeing toList
        
        System.out.println("You have " + oldServers.size() + " old servers."); //this will print out our count
        
        oldServers.forEach(s -> System.out.println(s.getName()));
        
//4th example - another aggregator--maptoLong
        double averageAge = servers.stream()      //not mapping the method to a long, but the stream to a long... a stream of server objects 
                .mapToLong(Server::getServerAge) //every server that comes into MapToLong is going to get server age for that server and return that
                                //double colon just says we are calling a method from WITHIN that Type--uinuqe to lambdas
                
                //we could paramaterize maptoLong by returning 
                //.mapToLong(s-> s.getServerAge()) //this is the same as above, but clearer--the above is shorthand
                .average()
                .getAsDouble();
        
        System.out.println("Average of our servers is: " + averageAge + " years.");
        
        //terminals are calls to .forEach, .collect, or 
        //you can only call a lamdba  on things that are prefined...like a predicate, and a few other things....
            //filters take the form of a predicate...Predicate is an interface (Type) that is specifically used for Lambdas
        
 //mary's test for a .collect(Collector.x) call
        double total = servers.stream().collect(Collectors.counting());
        System.out.println("Total number of servers is:" + total);
        
 //mary's test for .map
        String allServers = servers.stream().map(s -> s.getName())
                .collect(Collectors.joining(","));
        System.out.println(allServers);
        
        //ilya's example for collection of servers by Map<string, list>
        Map<String, List<Server>> groupedServers = 
                servers.stream()
                .collect(Collectors.groupingBy(Server::getMake)); //grouping by returns a hashmap
        for (String svrMake : groupedServers.keySet())   //string in mapo is get make = bc he chose at
                
        {
            System.out.println("server make: " + svrMake);
                for(Server s:groupedServers.get(svrMake))
                {
                        System.out.println("\tServername: " + s.getName());
                }
        
        }
        
       
    }//end psvm
    
}//end class

/*
 // Compute sum of salaries of employee
     int total = employees.stream()
                          .collect(Collectors.summingInt(Employee::getSalary)));

or 

// Convert elements to strings and concatenate them, separated by commas
     String joined = things.stream()
                           .map(Object::toString)
                           .collect(Collectors.joining(", "));
*/