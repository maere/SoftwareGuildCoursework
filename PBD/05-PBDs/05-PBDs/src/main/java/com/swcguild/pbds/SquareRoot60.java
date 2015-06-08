/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SquareRoot60 {
    public static void main(String[] args) {
        
        int userNum;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number so we can find the square root of it.");
        userNum = sc.nextInt();
        
        while (userNum<0){
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.println("Try again: ");
            userNum = sc.nextInt();
        }
        
        double sqRoot;
        sqRoot = Math.sqrt(userNum);
        
        System.out.println("The square root of " + userNum + " is " + sqRoot);
    }
    
}


/*
Write a program to take the square root of a number typed in by the user. 
Your program should use a loop to ensure that the number they typed in is positive. 
If the number is negative, you should print out some sort of warning and make them type it in again.

Note that it is possible to do this program with either a while loop or a do-while loop. 
(Though personally, I think this one is easier with a while loop.)

You can get the square root of a number n with Math.sqrt(n). 
Make sure you don't do this until the loop is done and you know for sure 
you've got a positive number.


*/