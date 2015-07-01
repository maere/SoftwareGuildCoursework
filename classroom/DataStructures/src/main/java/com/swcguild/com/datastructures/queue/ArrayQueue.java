/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.com.datastructures.queue;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayQueue implements Queue {

    private static final int DEFAULT_INITIAL_SIZE = 10; //set a start size for the size
    private Object[] items; //this is the array - we are starting at 10 
    private int numItems; //size--this is the queue.size() = numItems

    private int head;//when this gets initialized, this will get set to 0 head=0 these are just teh i numbers
    private int tail; //will change based on queue

    //we are creating two constructors--one that defaults, and if it does, it calls the OTHER constructor (so we call the other)
    public ArrayQueue() {
        this(DEFAULT_INITIAL_SIZE); //this calls the OTHER constructor
        //if you don't decide what your initial size is, this is what it will initialize to
    }

    public ArrayQueue(int size) {
        items = new Object[size];

    }

    @Override
    public void enqueue(Object item) {
        //Insert object o at the rear of the queue - Input: Object; Output: none 
        //add item at tail

        if (numItems >= items.length) {
            resize(2 * items.length);
        }
        items[tail] = item;
        tail++;
        numItems++;

    }

        //Remove the object from the front of the queue and return it; an error occurs if the queue is empty-- remove item at head     
    //Input: none; Output: Object
    @Override
    public Object dequeue() {

        if (numItems == 0) {
            return null; //if it's empty can'tdequeue
        }

        Object item = items[head];
        items[head] = null; //can we do head--?

        if (head == items.length - 1) {
            head = 0;
        } else {
            head++;
        }
        numItems--;

        if (numItems < items.length / 2) //this not neededed: numItems >0 && 
        {
            resize(items.length * 2);
        }

        return item;

    }

    //we create a new method to do the resize
    private void resize(int newSize) {
//         head = 0;//reset head and reset tail -- down to other end
//         tail = head+numItems;

        Object[] temp = new Object[newSize]; //while we're copying things over, both things exist...so we're using up 2x the memory
        for (int i = 0; i < numItems; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
        //Return a boolean value that indicates whether the queue is empty Input: none; Output: boolean 
    }

    @Override
    public int size() {
        //Return the number of objects in the  - Input: none; Output: integer
        return numItems;
    }

    //@Override
    public int getHead() {

        return head;
    }

    public int getNumItems() {
        return numItems;
    }

    public int getItemsLength() {
        return items.length;
    }

    @Override
    public Iterator iterator() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    private class myIteratorMethod(){
//    
//    }
}
