/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arraylists;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrayList2 {
    public static void main(String[] args) {
        ArrayList<Integer> kittyList = new ArrayList<>();
        Random r = new Random();
    
        for(int i=0; i<10; i++){
            int x = 1 + r.nextInt(100);
            kittyList.add(x);
        }
        System.out.println("ArrayList of random nums: " + kittyList);
    }
    
    
    
}
/*
Create an ArrayList of Integers. 
Fill up the list with ten random numbers, each from 1 to 100. 
Then display the contents of the ArrayList on the screen.

You must use a loop to fill up the list. 
However, you may display it the easy way (no loop needed) like so:

System.out.println( "ArrayList: " + whateverYourArrayListVariableIsCalled );

ArrayList: [45, 87, 39, 32, 93, 86, 12, 44, 75, 50]

*/