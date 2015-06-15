/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
apparently you can construct two classes inside one file, but this didn't seem to work for me when 
I got to trying to draw access the properties of the object--so I broke out into another class

public class Capital{
	String capNam;
	int pop;
	int sqMiles;
}

*/
/**
 *
 * @author apprentice
 */
public class StateCapitals2 {
        
    //properties
        HashMap<String, Capital> capitalsMap;
        Scanner sc;
        
    //StateCapitals2 constructor
       public StateCapitals2(){
           capitalsMap = new HashMap();  
       }
       
 //method to add key/value data to our HashMap of states and their capital objects
       public void addKeyValueToStateHash(String stateName, Capital capName){
            //we use the .put method to build our HashMap and add our key, value pairs (state/cap)
                capitalsMap.put(stateName, capName);//"Alabama", montgomery                   
                //capitalsMap.put();                //"Alaska", juneau
       }

    // prints out info from HashMap      
       public void printOutCapitalObjInfo(){  //prints out the data for each Capital object in the HashMap
           System.out.println("STATE/CAPITAL PAIRS:");
           System.out.println("===================");
           
           //Set<String> keys = capitalsMap.keySet(); //create a key set of all the key values (state names)
   
           //had to also create a Collection because I needed the .value() method to pull the objects
           Collection<Capital> stateCollectionSet = capitalsMap.values(); //pull the values from the HashMap
           
            //for/each, print the key (state name)
            //for (String s : keys)
            //{
            //    System.out.println(s);
            //    System.out.println(capitalsMap.get(s.capName));
            //}    
        
           
           //then once I had a collection of objects, I could user the .property method to get the properties from the object
           for (Capital c : stateCollectionSet)
            {   
            System.out.println(c.stateN + " - " + c.capName + " | Pop: "+ c.pop +" | Area: "  + c.sqMiles);
        
            }
           /*
Alabama - Montgomery | Pop: 205000 | Area: 156 sq mi
           */
           
           //for (Capital c : stateCollectionSet)  
            //{                                       
            //System.out.println(c); // this is just the object as reference # in memory
            //}
          
          // (hint - use the *key set* to get each capital object out of the map one by one 
            //and then print each field of the Capital object to the screen)
       
       }
    
       public void testForPopulation(){
           //asks user for userInput (min pop)
          
           sc =  new Scanner(System.in);
           System.out.println("Please enter a lower limit for population:");
           int popSearch = sc.nextInt();
           System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN: " + popSearch);
           
           //for each/loop where the code pulls population and examines value
          Collection<Capital> stateCollectionSet = capitalsMap.values(); //pull the values from the HashMap
          
           for (Capital c : stateCollectionSet)
            {   
                if(c.pop>popSearch)
                {
                System.out.println(" - " + c.capName + " | Pop: "+ c.pop +" | Area: "  + c.sqMiles);
        
                }
           
            }
                //if the value is over useInput print out all info for capital obj
       }
 
 }//end primary class
           

/*
       public Capital assignValues(){
       //we will try to do the capital object creation & input programatically 
       // using Encode/Decod to read fields from a .txt file:
            Capital montgomery = new Capital();
		montgomery.capNam = "montogmery";
		montgomery.pop   = "";
		montgomery.sqMiles  = ""; 
       }
*/
           

  //creates Capital data objects               /// don't need this method becuase we are doing with constructor
       //public void createCapitalDataObjects(){   //could also do with a properties accessor
          
                    
                //Capital littlerock = new Capital();
                    //montgomery.capName = "Little Rock";
                    //montgomery.pop   = 193000;
                    //montgomery.sqMiles  = 113; 
                    
     
           //} 
         

    
    //this is our Object constructor, we use it to create a capital objects
    //public StateCapitals2 ()
    /*{
        this.stateName = stateName;
        this.cityName = cityName;
        this.population = population;
        this.squareMiles = squareMiles;
    */
           // }
    
   
    //------------------
    //we need to create 4 objects (instantiate)
       
        /*
    StateCapitals2 montgomery = new StateCapitals2("Alabama", "Montgomery", 205000, 156);
     StateCapitals2 juneau = new StateCapitals2("Alaska", "Juneau", 31000, 3255);
      StateCapitals2 phoenix = new StateCapitals2("Arizona", "Phoenix", 1445000, 517);
    */
 
       
 //now we need a simple method that returns an object -- each one of the above is a capitals object 
    /* 
    public Object accessObject(StateCapitals2 capitalName){ //object of type StateCapitals2
           return capitalName;
       }
    */
    
//this is our print out method, it prints the requested data for each object in the specified format we can call in our loop
    /*
    public void printout(String cityName)
    {
        System.out.println(stateName+ " - " +cityName+ " - pop: " + population+ " - SqMiles: " +squareMiles);
    }
       */
    
    
    
    
  
    
