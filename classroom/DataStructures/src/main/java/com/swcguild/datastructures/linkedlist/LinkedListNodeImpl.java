/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.linkedlist;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListNodeImpl<T> implements LinkedList<T> { //after you type in, have to implement all abstract methods of the interaface

    private Node first; //a linked list keeps track of the first Node obj
    private Node last; //the last node obj
    private int numItems; //and how many items are in the linked list in total--so will increment each time a node is created

    //Node object contains only two props: an *item (obj)* and a *reference* (to another Node obj)
    @Override  //we build append first
    public void append(T item) {    //we also created a private class called Node below and defined these properties so we could use Node and the properties next and item
        //this adds a node the list
        //make a node
        Node prevLast = last; //placeholder---look at tail end and we shuffle that to be the previous node

        last = new Node(); //we create a new node and set it equal to last 

        last.item = item; //this is the object (if type T)  we are going to shove into the node and here, we shove

        //now we need to check if the last item is empty
        if ((isEmpty())) { //is being called on the LinkedList, just looks at the size....in numItems

            first = last; //now we reassign our first, which we never assigned--both are referencing the same object
            //this only happens ONCE in a linked list, unless we reassign
        } else {
            prevLast.next = last;
        }
        numItems++;

    }

    @Override   // getter for getting object out of node
    public T get(int index) {

        if (index == 0) {
            //what if it's hte first time we traverse tho?
            if (numItems == 0) //could also use our "isEmpty()" method which checks to see if the linked list has any items yet (numItems)
            {
                throw new IndexOutOfBoundsException("Linked list is empty. Index out of bounds.");
            }
            return first.item;
        } else if (index == numItems - 1) {
            return last.item;
        } else {
            return getNode(index).item; //this is what we just wrote, this uses that method, goes to the node, and grabls the OBJECT at that node
        }

    }

    @Override //inserts a node of object T, at index X
    public void insert(int index, T item) {
        //
        if (index == numItems - 1) {
            append(item);

        } else {
            Node nodeAtIndex = getNode(index);

            Node newNode = new Node();
            newNode.item = item;
            //going to piont our new nodes pointer to the thing we are holding in our hands
            newNode.next = nodeAtIndex.next;
            //new node we just made, index is now going to point to it
            nodeAtIndex.next = newNode;
            numItems++;
        }

    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;//
    }

    @Override //puts it as the first Node
    public void prepend(T item) { //inserts to the head of the list

        Node prevFirst = first;  //placeholder of Type Node, this is a stash box for our node value

        first = new Node();  //create a Node

        first.item = item; //first new node is now equal to the itme that we mpassed into the method

        first.next = prevFirst; // the pointer for first points to the value of the previous first --gets reassigned to the current node
        numItems++;

        if (numItems == 1) { //if we only have one item in our linked list, first and last are same object
            last = first; //so if this is the first time we add a node to the list, the first and last are the same item
        }

    }

    //we are going to build a method that will allow us to get a node at a given index
    private Node getNode(int index) {  //we pass in index # we are looking for
        if (index > numItems - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index of out bounds. Must be between 0 and " + (numItems - 1) + " inclusive.");
            //this is our boundary checking
        }

        Node nodeAtIndex = first; //placeholder again of type node, starts at the first node because it knows where that is

        for (int i = 0; i < index; i++) { //this travels/walks through the list untill until it gets to the index number we passed inb
            nodeAtIndex = nodeAtIndex.next; //next is a property of the Node...it just holds a reference pointer, this is an accessor for that property
        }
        return nodeAtIndex; //returns the item of # we are looking for
    }

    @Override //removes both the object and node....so we remove and let the garbage collector come and dispose of it
    public T remove(int index) {
        T retNode = null; //while we remove, we will also return the object of type T in the node
        
        if (index == 0) { //if there is only one item
            retNode = first.item;
            first = first.next;

        } else {
            Node nodeBefore = getNode(index -1);
            retNode = nodeBefore.next.item; //this goes to the previous node bc it points to the node we want to remove--we get the item obj and store it here
            nodeBefore.next = nodeBefore.next.next; //the node before the node we care for, neeeds to point to the node AFTER the one we care for
            
            if(index==numItems-1){
                last = nodeBefore;
            }
        }                       //on line 130: reassigning the value of .next on nodeBefore by accessing the value two nodes down...
                                //...leaves the guy in the middle out, it becomes null, and the reference isn't needed anymore
                                //so the garbage collector will come along and get rid of the one that's no longer needed bc we've reassigned everything
                                 //this is part of the magic of java vs. C++ wehre we would have to manage this pointer using up our memoryt
        numItems--;
        return retNode;
    }

    @Override  //size of our linked list--number of nodes
    public int size() {
       return numItems;
    }

    @Override  //our method for Iterable....
    public Iterator iterator() {
         return new LinkedListIterator();   
        
    }
//we make a private class Node...because we need it inside the linked list to function but nobody implementing cares how we do it

    private class Node {

        T item;
        Node next; //node class can have a pointer to itself or objects of its own type
    }
    
    
    //makeing our own iterator
    private class LinkedListIterator implements Iterator{ //when we implement, we have to implement all abstract methods and will populate below
        
        Node current = first; //our iterator starts at the first node
        

        @Override //checks if there is a next Node, this will let us now
        public boolean hasNext() {
           return current !=null; 
        }

        @Override //returns an item object of Type T that is in the next node
        public T next() {
            if(current==null){
                return null;
            } 
            T retNode = current.item; // this is the object in current
            current = current.next; //reassigne current to next so it walks through 
            return retNode;
            
        }
        
    }
    
    

}
