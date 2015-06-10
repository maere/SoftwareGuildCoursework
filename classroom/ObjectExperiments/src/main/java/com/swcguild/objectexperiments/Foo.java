/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.objectexperiments;

/**
 *
 * @author apprentice
 */
public class Foo {
    private String name;
    private int numberOfPokes;
    
    public Foo(String name){
    this.name = name;
    }
    
    public void poke(){
        numberOfPokes++;
        
        
        
    }
    
    public void report(){
        System.out.println(name + " was poked " + numberOfPokes + " times.");
    }
}
