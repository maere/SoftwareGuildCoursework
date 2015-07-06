/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FindingValueInArray144 {

    public static void main(String[] args) {
        int[] randNums;
        randNums = new int[10];
        
        Random r = new Random();  
        
        for(int i=0; i<10; i++){
            int x = 1+r.nextInt(50);
            randNums[i] = x;
        }
        for (int i=0; i<10; i++){
            System.out.println(randNums[i]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number you would like to search for: ");
        int searchNum = sc.nextInt();
        
        for (int i=0; i<10; i++){
            if (searchNum==randNums[i]){
                System.out.println("We found an instance of "+randNums[i]);
            }
            
            
            
        }
    }

}
/*
Create an array that can hold ten integers, 
and fill each slot with a different random value from 1-50. 
Display those values on the screen, 
and then prompt the user for an integer.
Search through the array, and if the item is present, say so. 

It is not necessary to display anything if the value was not found.
If the item is in the array multiple times, it's okay if the program prints the message more than once.
*/
