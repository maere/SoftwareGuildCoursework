/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int userInput = 0;
        int total = 0;
        int count = 0;
        int min = 0;
        int max = 0;
        
        System.out.println("Please enter a value greater than or equal to 0.");
        userInput = sc.nextInt();
        min = userInput;
        max = userInput;
        
        while(userInput >=0){
           
            total += userInput; //total = total + userInput
            if (userInput>max){
                max = userInput;
            }
            
            if (userInput<min){
                min = userInput;
            }
            
            count++;
            
            System.out.println("Please enter a value greater than or equal to 0.");
            userInput = sc.nextInt();
            
            
        }     
        // why are these both in parentehsis
                    System.out.println("min is " +min+ "max is " +max+ "average is " + (double) (total/count));

        
    }
    
}
