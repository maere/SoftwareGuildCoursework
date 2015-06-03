/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.agewarmup;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AgeWarmUp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is your age?");
        int age = userInput.nextInt();
        
        if (age <= 18){
            System.out.println("Yyou must be in school");
        } else if (age > 18 && age < 65){
            System.out.println("Time to go to work.");
        } else {
            System.out.println("Enjoy retirement.");
        }
        
    }
    
}
