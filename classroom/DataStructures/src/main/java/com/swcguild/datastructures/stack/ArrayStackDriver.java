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
public class ArrayStackDriver {

    public static void main(String[] args) {
        Stack st = new ArrayStack();   //we just made this class
        //we 'll declare 4 strings, and assign values
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";

//we are going to push these onto the stack and announce them as we push them
        System.out.println("Pushing " + a);
        st.push(a);                      //we call our push method
        System.out.println("Pushing " + b);
        st.push(b);
        System.out.println("Pushing " + c);
        st.push(c);
        System.out.println("Pushing " + d);
        st.push(d);

        //now we'll pop them out
//        
//        System.out.println("Popping....");
//            //because we are dealing with Objects, we have to cast each time we pop
//        System.out.println((String) st.pop());
//        System.out.println("Popping....");
//            //because we are dealing with Objects, we have to cast each time we pop
//        System.out.println((String) st.pop());
//        System.out.println("Popping....");
//            //because we are dealing with Objects, we have to cast each time we pop
//        System.out.println((String) st.pop());
//        System.out.println("Popping....");
//            //because we are dealing with Objects, we have to cast each time we pop
//        System.out.println((String) st.pop());   // we cast to get the object back as a string
//                                                //.get makes you specify what you want...cast there, 
//                                                //with .pop you don't need to do this to get it, but will need to convert
        //let's switch to our iterator, now that we've built it, to do this
        for (Object o : st) //an enhanced for loop can iterate through anything that implements Iterator, so all those things
        //we use include this in their classes so that' why we are able to call for/each (e.g. HashMap, ArrayList, et al)
        {
            System.out.println((String) o); //the o will look for an implementation of the Iterator or Iterable interface
        }           //I'm going to make a thing, it's going to be on my stack, but my things implemetns this publicly available inteface
        
        //or to be more explicit -- this is what we are doing with o above-- we are calling this behind the scenes....
        Iterator it = st.iterator();
        while(it.hasNext()){
            System.out.println((String) it.next());
        }

    }

}
//difference between Iterable and Iterator:
//      Iterable, we include in our collection....is the Inteface
//      Iterator, is the object Type...contained in Iterable

///when you call a class that implements Iterable, will call a function that returns the type of class Iterator**