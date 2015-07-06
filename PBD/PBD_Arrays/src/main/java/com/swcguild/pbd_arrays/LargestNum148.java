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
public class LargestNum148 {
    public static void main(String[] args) {
        int[] randNums;
        randNums = new int[10];

        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int x = 1 + r.nextInt(50);
            randNums[i] = x;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(randNums[i]);
        }
        
        int largest=0;
        int current;
        
        for (int i = 0; i < 10; i++) {
            //current = randNums[i];
            
            if (randNums[i]>largest) {
                largest = randNums[i];
        
            }

        }

        System.out.println("The largest value in the array was " + largest);

    }
    
}
