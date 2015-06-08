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
public class AddingValuesInLoop {
    public static void main(String[] args) {
        
//Write a program that gets several integers from the user. 
        System.out.println("I will add up the numbers you give me. Enter a number.");
        Scanner sc = new Scanner(System.in);
        int numToAdd = sc.nextInt();
        
//Sum up all the integers they give you. 
        int sum = 0;
        
        
//Stop looping when they enter a 0. You must use a while loop.
        while (numToAdd!=0){
            
        sum = sum + numToAdd;
        
        System.out.println("Number: " + numToAdd);
        System.out.println("The total so far is: " + sum);
        numToAdd = sc.nextInt();
        
            
        }
        
        System.out.println("The total is " + sum);
        
//Display the total at the e
        
    }
    
}

/*

I will add up the numbers you give me.
Number: 6
The total so far is 6
Number: 9
The total so far is 15
Number: -3
The total so far is 12
Number: 2
The total so far is 14
Number: 0

The total is 14.

*/
