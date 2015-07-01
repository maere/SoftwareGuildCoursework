/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

/**
 *
 * @author apprentice
 */
public interface Stack extends Iterable{ //we are now (2nd step) going to make it iterable so we extend the interface Iterable...
                                        //this will add functionality that we didn't have before -- will have to change our implementation
    
    public boolean isEmpty();
    
    public int size();
    
    public void push(Object item);
   
    public Object pop();
    
}
