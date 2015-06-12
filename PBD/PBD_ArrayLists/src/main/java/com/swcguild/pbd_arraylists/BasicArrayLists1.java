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
public class BasicArrayLists1 {
    public static void main(String[] args) {
    
//Create an ArrayList that can hold Integers.
        ArrayList<Integer> testList = new ArrayList<>();
        
          for(int i=0; i<10; i++){
                testList.add(-113);
        }  
 
        for(int i=0; i<testList.size(); i++){
        System.out.println("Slot " +i+ " contains " + testList.get(i));
        
        }  
 

    }
    
}

/* my enhanced for loops did not work
       
 //This time, you must use a loop, both to fill up the ArrayList and to display it.
//Also, in the condition of your loop, you should not count up to a literal number-- use the size().
        for(Integer i: testList){
          //Add ten copies of the number -113 to the ArrayList. 
            testList.add(-113);

        }    
           //Then display the contents of the ArrayList on the screen.
        for(Integer i: testList){
          //Add ten copies of the number -113 to the ArrayList. 
            System.out.println(i);
        } 
*/