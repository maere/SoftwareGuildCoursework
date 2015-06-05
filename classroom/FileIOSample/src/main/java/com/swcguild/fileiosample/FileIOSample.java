/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.fileiosample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FileIOSample {
    public static void main(String[] args) throws Exception {  //we are getting an error in the PrintWriter line so we need to add an exception 
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
           
        out.println("First line");
         out.println("Second line.");
         out.println("Third line.");
         out.flush();
         // out.close(); if you close here, it will not get the next line you added
         out.println("Test.");
         out.flush();
         out.close();
         
         //now we can get it to read out of a file, vs. off the console
         Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
         
         while (sc.hasNextLine()){   
                 String currentLine = sc.nextLine();
                 System.out.println(currentLine);
                 
         }
    }
}   
