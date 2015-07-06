/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SummingNumsFromFiles134 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(System.in);
        System.out.println("Enter the name for the file that contains the numbers you would like to add: ");
        
        String fileChoice= fileInput.nextLine();
        int total;
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(fileChoice)))) {
           
            total = 0;
            while(sc.hasNext()){
                int current = sc.nextInt();
                total = current+total;
                
            }
        }
        System.out.println("Your total sum from this file is:" + total);
         
    }
   
    
}
