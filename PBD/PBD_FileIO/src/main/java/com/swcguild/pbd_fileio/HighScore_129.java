/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HighScore_129 {

    public static void main(String[] args) throws IOException {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your score: ");
        int userScore = scan.nextInt();
        String strScore = Integer.toString(userScore);
        
        System.out.println("Please enter your name: ");
        String name = scan.next();
        
        PrintWriter fileWriter = new PrintWriter(new FileWriter("score.txt"));
        
        fileWriter.println(name + " scored a high score of " + strScore);
       
        //fileWriter.println(strScore); //String.valueOf(userScore)
        fileWriter.println("");
        fileWriter.flush();
        
        
        fileWriter.close();
        //--- That should have written it to score.txt in two lines..
        // I checked and did not see that it did this...
        
        /*
        //if we want to get the info back out on the console we'll have to read it from the file...
        Scanner io = new Scanner(new BufferedReader(new FileReader("score.txt")));
        
        while(io.hasNext()){
            String line = io.nextLine();
            System.out.println(line);
            io.close();
        }
        */
    }

}
