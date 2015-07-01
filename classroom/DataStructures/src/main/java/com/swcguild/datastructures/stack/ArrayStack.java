/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator; //we had to import this because our interface implemented it

/**
 *
 * @author apprentice
 */
public class ArrayStack implements Stack {

    private static final int DEFAULT_INITIAL_SIZE = 4; //set a start size for the size
    private Object[] items;
    private int numItems; //private variable for a class, of type integer will always default to zero--when you new a class it will intialize it for you....an object will always default to null

    //we are creating two constructors--one that defaults, and if it does, it calls the OTHER constructor (so we call the other)
    public ArrayStack() {
        this(DEFAULT_INITIAL_SIZE); //this calls the OTHER constructor
        //if you don't decide what your initial size is, this is what it will initialize to
    }

    public ArrayStack(int size) {
        items = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;

    }

    @Override
    public void push(Object item) {
        //we need to check it if it's reached the end of the array, and if so, resize it.
        //if performance were not an issue, you could just resize to 1+, but that's expensive...so we do factors
        if (numItems == items.length) {
            resize(2 * items.length); //we created this on the fly...NetBeans inserted below for us to complete later
                                    //check each time whether we need to resize because we are putting stuff in....we are being proactive
        }
        items[numItems++] = item; //this is what we want it to do: push the next thing into the array
    }

    @Override
    public Object pop() {

        if (numItems == 0) {
            return null; //if it's empty can't pop -- this is anormal behavior of any collection if there are no itmes--it returns null
        }
        //
        Object item = items[--numItems]; //takes items and subtracts one, then returns that value in item
        items[numItems] = null;
        
        if (numItems > 0 && numItems == items.length / 4) { //decision to shrink....because we are pulling, we want to free up memory if needed..if items are a quarter of the size of the array....
            resize(items.length / 2); //but only shrink here, and shrink to half the size
        }
        return item; //Steve and Dan had a typo--had "items" so it returnd the whole array which was a problem
    }

    //we create a new method to do the resize...which we call in pop and push...
    private void resize(int newSize) {  //we resize it to whatever pop and push want...we decide it within those calls
        Object[] temp = new Object[newSize]; //while we're copying things over, both things exist...so we're using up 2x the memory
        for (int i = 0; i < numItems; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override //made this -- OUR iterator needs to use the iteratrion method we defined below....so when iteration (e.g. for/each) is called
    public Iterator iterator() {
        return new ReverseArrayIterator(); //returning a variable of Type Iterator....
                                    //so something on the outside doesn't know about ReverseArrayIterator....just knows the type
                                        //and that it can execute hasNext and next()
    }

    //-- we'll use an inner class & it's also private ------
                                        //is better to do as an inner class vs. in the package when we will never ever use it anywhere else
    private class ReverseArrayIterator implements Iterator {
        //this will allow us to walk through the array backwards
        
        private int i = numItems; //this line is why we have to have a private class...we want to tell the inner class about what's going on outside
                                //Iterator needs to have access to the inner elements of what it's iterating through

        //we are setting our internal counter, we have a private counter in our iterator == to numItems
        //inner class has access to private variables of outer class

        @Override
        public boolean hasNext() {
           return i>0;
        }

        @Override
        public Object next() {
           return items[--i];//
        }
        //if we comment out all the popping, we can now use this method!
        
        
        
        
        
    }

}
