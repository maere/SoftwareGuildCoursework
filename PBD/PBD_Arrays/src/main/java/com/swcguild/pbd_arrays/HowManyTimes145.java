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
public class HowManyTimes145 {

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number you would like to search for: ");
        int searchNum = sc.nextInt();
        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (searchNum == randNums[i]) {
                count++;
            }

        }

        System.out.println("There was " + count + " instance(s) of your number " + searchNum);

    }
}
