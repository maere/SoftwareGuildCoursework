/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WhatIsYourNumber {
    public static void main(String[] args) {
    
    //Implement code in the main method that does the following:
    //Asks the user for an integer
        Scanner sc = new Scanner(System.in);
    System.out.println("Please input an integer.");
        int userInput = sc.nextInt();
    //Prints that integer to the screen
        System.out.println("The number you gave me was" + userInput);
        
    //Prints all of the number from 0 to the user’s number to the screen, one number per line
        for (int i=0; i<=userInput; i++){
            System.out.println("Let's count: " + i);
        }
    //Prints “Thank you for playing” to the screen
        System.out.println("Thank you for playing.");

        
        
    }
    
}

