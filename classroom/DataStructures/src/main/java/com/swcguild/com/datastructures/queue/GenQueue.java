/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.com.datastructures.queue;

/**
 *
 * @author apprentice
 */
public interface GenQueue<T> extends Iterable {
    
    public void enqueue(T item);
    public Object dequeue();
    public boolean isEmpty();
    public int size();
    
    
}
