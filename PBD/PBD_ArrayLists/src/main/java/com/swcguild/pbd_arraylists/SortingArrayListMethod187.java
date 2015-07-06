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
public class SortingArrayListMethod187 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        Random r = new Random();
        int putInt;
        
        for (int i = 0; i <= 9; i++) {
            putInt = 11 + r.nextInt(100);
            myList.add(i, putInt);
        }
        
        System.out.println("ArrayList before sorting: " + myList);
        
        
        for (int i=0; i<myList.size(); i++)
		{
			for (int j=i+1;j<myList.size(); j++)
			{
                            int holder;
                            int first = myList.get(i);
                            int next = myList.get(j);
                            
				if (first>next)
				{                // swap the values in two slots
                                    holder=first;
                                    first = next;
                                    next=holder;
                            
				}
			}
		}
		
        
        System.out.println("ArrayList after sorting: "  + myList);
        
    }
    
    
    
}
