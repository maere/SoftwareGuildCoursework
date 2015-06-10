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
public class AnonymousClasses {
    //we need to define a public interface for our class before we can enter
    // but we'll define methods inline -- don't need to be after psvm
    public static void main(String[] args) {

        Die die = new Die()
        {                // this is how we public int roll()
            {
            Random r = new Random();
            return r.nextInt(6) +1;
            }
        }; //semicolon follows
        
        System.out.println("Single roll: " + die.roll());
        
    }
  //but we do need a public interface, so we'll make a class
    class Die{
        public int roll(){
            return 0;
        }
    }
    
}
