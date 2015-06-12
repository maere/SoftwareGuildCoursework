/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arraylists;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class BasicArrayLists0 {
    public static void main(String[] args) {
        ArrayList<Integer> BasicList = new ArrayList<>(); // for ArrayList API is Integer not int
       
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        BasicList.add(-113);
        
        System.out.println(BasicList.get(0));
        System.out.println(BasicList.get(1));
        System.out.println(BasicList.get(2));
        System.out.println(BasicList.get(3));
        System.out.println(BasicList.get(4));
        System.out.println(BasicList.get(5));
        System.out.println(BasicList.get(6));
        System.out.println(BasicList.get(7));
        System.out.println(BasicList.get(8));
        System.out.println(BasicList.get(9));
   
    }//end main

}//end class

///Create an ArrayList that can hold Integers. 
//Add ten copies of the number -113 to the ArrayList. 
//Then display the contents of the ArrayList on the screen.

//Do not use a loop.