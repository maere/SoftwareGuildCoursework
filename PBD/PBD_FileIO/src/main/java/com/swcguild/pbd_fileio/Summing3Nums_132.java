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
public class Summing3Nums_132 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("3nums.txt")));
        
        System.out.println("Reading nums from the file 3nums.txt....");
        
        String [] tokens = new String [3];
        
        for (int i=0; i<3; i++){
            tokens[i]=sc.nextLine();
        }
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);
        int c = Integer.parseInt(tokens[2]);
        
        int result = a+b+c;
        //System.out.println(result);
        System.out.println(tokens[0] + "+" + tokens[1] + "+" + tokens[2] + "=" + result);
        
        
    }
    
}
