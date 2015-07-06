/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.linkedlist;

/**
 *
 * @author apprentice
 */
public interface LinkedList<T> extends Iterable{ //T is the generic Type -- will get decided at compile time
                //will also have it extend iterable
                //could also write LinkedList<T extends String> above and our implementation would have to use object of the string class
    
    void append(T item); //
    T get(int index);
    void insert(int index, T item);
    boolean isEmpty();  
    void prepend(T item);//interface prepend that will insert to list
    T remove(int index);
    int size();
    
}

//C++ is called "Template"
//C# & Java called it "Generics"
