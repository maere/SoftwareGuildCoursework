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
public interface GenStack<T> extends Iterable {
    public boolean isEmpty();
    public int size();
    public void push(T item);
    public T pop();
    
}
