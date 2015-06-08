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
public class HowOld {
    public static void main(String[] args) {
        
            Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your name?");
        String name= sc.nextLine();
        
        System.out.println("Okay " + name + ", what is your age?");
        int response = sc.nextInt();
        
        if(response <16){
            System.out.println("You can't drive");
        
        }
        
        if(response <18){
            System.out.println("You can't vote.");
        
        }
        if(response < 25){
            System.out.println("You can't rent a car.");
        
        }
        if(response >= 25){
            System.out.println("You can do anything that's legal.");
        
        }
    
   
}
    
}
