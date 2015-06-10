/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.objectsexamples;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
        
        //whenever we use the word "new" as above, it will call the DEFAULT constructor
        //so we can create a dog (puppy) even though we did not create a constructor method for our class yet
        //so it will make and object....
        
        //so we came back to our app, and now we are getting an error, becuase we just made a constructor and 
        //specified that we want parameters...so now our code is requesting that we pass parameters
        
        Dog puppy = new Dog("Sparky", 1, 12 );
        //now if we pull up the puppy object, netbeans intellisense shows us the methods we created in our 
        //class
        
        
        puppy.bark();
        //becuase the app and Dog are in the same package, the JVM knows where it is and we don't have to import
        
        Dog otherPuppy = new Dog("Pluto", 1, 11);
        
        otherPuppy.sit();
        
        System.out.println("Created " + Dog.getNumberOfDogs() + " dogs.");
        //if we compile and run this, our output is the "woof!" we created in our class
    }
    
}
