/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Taxes {
    final String TAXES_FILE = "Taxes.txt";
    Map<String, Double> taxMap = new HashMap<>();
    
    //constructor
    public void taxes(){
    //taxMap = new HashMap<>();
    }
    
    public void loadTaxes() throws FileNotFoundException{
        
    Scanner sc = new Scanner(new BufferedReader(new FileReader(TAXES_FILE)));
    
    while(sc.hasNextLine()){
    String currentStateToken = sc.next();
    String currentRateToken = sc.next();
    
    
    
    taxMap.put(currentStateToken, Double.parseDouble(currentRateToken));
    
    }
 
    
    }
    
    
}
