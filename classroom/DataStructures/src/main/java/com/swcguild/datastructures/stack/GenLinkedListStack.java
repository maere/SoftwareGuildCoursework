/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class GenLinkedListStack<T> implements GenStack<T> {

    //we will build our nodes directly inisde of stack--taking same data structure and using it in very simple way
    //bc w a stack we don't need a last one
    //variables we will need in the class
    private Node<T> first;      //we had to insert a private inner class below to be able to use this
    private int numItems;
    
    
    
    @Override //we could either use the length or just use the list itself...bc the size keeps grwoing and shrinking
    public boolean isEmpty() {
        return first == null; 
    }

    @Override
    public int size() {
       return numItems;
    }

    @Override
    public void push(T item) {
       Node prevFirst = first;
       first = new Node<>(); //we don't need to explicity say Node<T> bc we did this in the class field above
       first.item = item;
       first.next = prevFirst;
       numItems++;
    }

    @Override
    public T pop() {
       T retNode = first.item; //T is our generic for linked list, and Item is our generic for Node
       first = first.next;
       numItems--;
       return retNode;
    }

    @Override
    public Iterator iterator() { //if I tried to call for/each without instantiating a Linked list iterator, it wouldnt know how to traverse
        return new LinkedListIterator();//To change body of generated methods, choose Tools | Templates.
    }

    //private class--four our nodes
    private class Node<Item> { //we changed the Type bc we don't want the type to be shadowing, so he made them different

        Item item;
        Node next;
    }
    private class LinkedListIterator implements Iterator{ //we are implementing as a private class in our class

        //needs a field
        private Node<T> current = first;
        
        @Override
        public boolean hasNext() {
            return current !=null;//
        }

        @Override
        public T next() { //could also return the type Object....
          if(current==null){
              return null;
          }
          T retNode = current.item;
          current = current.next;
          return retNode;
          
        }
    
    }

}
