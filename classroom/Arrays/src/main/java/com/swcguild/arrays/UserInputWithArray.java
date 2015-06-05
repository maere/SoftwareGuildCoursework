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
public class UserInputWithArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] userInputs = new int[10];
        
        System.out.println("Please enter 10 values.");
            for (int i=0; i<userInputs.length; i++){
                System.out.println("Please enter value :[" + (i+1) + "]:");//because we want 1-10, not 0-9?
                userInputs[i]=sc.nextInt();
                
            }
            
            int min = userInputs[0];
            int max = userInputs[0];
            int total = 0;
            
        System.out.println("[");
        for (int num : userInputs){ // this is the loop!
            
            if(min>num){
                min = num;
            }
            if (max<num) max = num; // this is also valid if statement--but has to be in one line
            
            total +=num;
            System.out.println(num);
            
            }
            System.out.println("]");
             //this is called "casting" when we put a type in () like we do with double below
            System.out.println("Min: " +min+ "max: " + max + "average" + (double) total/userInputs.length);
       
        }
    
    
    }
    
