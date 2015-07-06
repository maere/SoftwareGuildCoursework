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
public class LinkedListDriver {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedListNodeImpl<>(); // we made our own generic container, and now we're going to declare it a string linked list

        System.out.println("Size: " + ll.size());
        
        //crate strings
         String item1 = "item1";
         
//        for(int i=0, i<6, i++){
//       
//String item = "" + i.toString();
//        }
        //
         ll.prepend(item1);
         
         //see if it works
         System.out.println("Size: " + ll.size());
         System.out.println(ll.get(0));
         
         ll.remove(0);
            System.out.println("Size: " + ll.size());
         
            //add thre more objects
            ll.prepend(item1);
            ll.prepend(item1);
            ll.prepend(item1);
            
            //print out results
            
            
            for(Object s: ll){
                System.out.println(s);
            }
            
            
            
            //pull ilya's est code off of git
            
            //only difference between enhancd for loop to walk through and iterator, is that iterator is explicit
            
            Iterator iter = ll.iterator(); // we are making an iterator
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        
    }

}
