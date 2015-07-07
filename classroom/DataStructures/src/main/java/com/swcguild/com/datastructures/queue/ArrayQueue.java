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

    @Override //add item at tail
    public void enqueue(Object item) {
        //Insert object o at the rear of the queue - Input: Object; Output: none 
        
//we are pushing into queue, so when we are pushing we need to make sure:
        //there is space to put it in..if not resize                                                items[9] is 10 items & items.length = 10
        //where to put it? put it at tail (items[0], or items[DEFAULT_INITIAL_SIZE -1] unless:   items[tail] is == to items.length-1, 
        //if it is equal to the size of the array-1, we are going to need to make the array BIGGER and THEN increment tail & then push it in
                                                  //*then* increment the size of the tail & numItems

        if (numItems == items.length-1) { //10 items, 9 slots filled...
            
            resize(2 * items.length);
        }
        items[tail] = item; //push the item into the tail slot
        tail++;  //increment tail value
        numItems++; //increment  items which we are tracking

    }

        //Remove the object from the front of the queue and return it; an error occurs if the queue is empty-- remove item at head     
    //Input: none; Output: Object
    @Override
    public Object dequeue() {

        if (numItems == 0) {
            return null; //if it's empty can't dequeue
        }

        Object item = items[head]; //returns the value of item at the head of the queue
        items[head] = null; //we empty out that spot -- one empty spot at the front -- or 10 empty spots
        
//        if(items.length - numItems <= items.length/2){ 
//            
//            head = 0;
//            tail = numItems; //or number items -1?
//            resize(items.length/2);
//        }
//        
//        numItems--;
//        
//         return item;

        if (head == items.length-1) { //added 10, at spot 9, no empties!!
            head = 0;  //reset head to 0
                                    //we don't need to reset tail here or resize unless we are ***shrinking*****
        } else {
            head++; //if not just increment the head....
        }
        numItems--;
        

        if (numItems < items.length / 4) //this not neededed: numItems >0 && 
        {
            resize(items.length/2);
        }

        return item;
    }

    //we create a new method to do the resize
    private void resize(int newSize) {
//         head = 0;//reset head and reset tail -- down to other end
//         tail = head+numItems;

        Object[] tempArray = new Object[newSize]; //while we're copying things over, both things exist...so we're using up 2x the memory
        
        //change to while (!isEmpty())
        for (int i = 0; i < numItems; i++) {
            tempArray[i] = items[i]; //dequeue instead of using this.
            //force head to 0 and tail to however many elements we pulled -- head = 0, tail = numItems;
        }
        items = tempArray; //resets items to our new, bigger array--if it's smaller, we have a problem, bc this will throw off the numbering
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
    public int getTail(){
    return tail;
    }

    /*
    @Override  //our method for Iterable....
    public Iterator iterator() {
         return new LinkedListIterator();   
        
    }
    */
    
    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator();
    }
 
    private class ArrayQueueIterator implements Iterator{
        private int i = numItems; 

        @Override
        public boolean hasNext() {
            return (numItems!=0); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object next() {
            //return items[head]!=null; //To change body of generated methods, choose Tools | Templates.
            //or is it items[head -1]?
            return items[head];
        }
        
        
    }

       
    }


