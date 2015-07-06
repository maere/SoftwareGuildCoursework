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
public class SimpleFileInput_130 {
    public static void main(String[] args) throws FileNotFoundException {
                                    //buffered reader needs a file reader to work 
        Scanner sc = new Scanner(new BufferedReader(new FileReader("name.txt")));
        
        while(sc.hasNextLine()){
            
            String current = sc.nextLine();
            System.out.println(current);
        
        }
        
    }
      
    
    
    
}
