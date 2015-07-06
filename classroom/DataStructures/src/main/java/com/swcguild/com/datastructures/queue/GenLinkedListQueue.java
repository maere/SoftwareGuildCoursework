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
public class GenLinkedListQueue<T> implements GenQueue<T> {

    private Node<T> tail;
    private int numItems;
    private Node<T> head;
 

    @Override
    public boolean isEmpty() {
        return numItems==0;
    }

    @Override
    public int size() {
        return numItems;//

    }

    @Override
    public void enqueue(T item) {
         //using last to point to the tail, what we want to enque or add to
       
        tail = new Node<T>();
        tail.item = item;
        
        if(isEmpty()){
            head = tail;
        }
        
        numItems++;
    }

    @Override
    public Object dequeue() {
 
        if(isEmpty()){
                        //throw new IndexOutOfBoundsException("There is nothing in this list");
            return null;
        }
        else{
        
        T retObj = head.item;
        
        numItems--;
        
        return retObj;
        }
 
      
    }

    @Override
    public Iterator iterator() {
       return new GenLinkedListIterator();//return something from the private class of the Iterator interface that we will implement
    }

    //private class--four our nodes
    private class Node<T> { //we changed the Type bc we don't want the type to be shadowing, so he made them different

        T item;
        Node next;
    }
    
    // need to implement private class Iterable so we can find next
    private class GenLinkedListIterator implements Iterator{

        //we need a Node to start iterating from
        private Node<T> current = head;
        
        @Override
        public boolean hasNext() {
            //just checks if there is a next thing and returns a value
            return current!=null;
        }

        @Override
        public Object next() {
            //returns the next object -- if there is an object, returns it, if there is not an object returns null
            if(current==null){
                return null;
            }
            else{
                T retObj = current.item;
                current = head.next;
                return retObj;
            }
            
            
        }
    }
    


}
