/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.objectsexamples;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class LocalClassSample {
    public static void main(String[] args) {
        //we want a die object with a function of roll
        class Die // this is our local class - local classes can't have any static members
        {
            public int roll(){
            Random r = new Random();
            return r.nextInt(6) + 1;
            }
        }
        
        Die die = new Die();
        System.out.println("Single roll:" + die.roll());
    }
    
    public static void foo(){ 
        //Die die = new Die(); -- can't get to die becuase it's at the scope/function level of main
        
    }
    
    
}
