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
public class Materials {

    final String PRODUCT_FILE = "Products.txt";
    
    double[] sqFtCosts = new double[2];
    Map<String, double[]> materialsMap = new HashMap<>();

    //constructor
    public void taxes() {
        //materialsMap = new HashMap<>();
        //sqFtCosts[0] = 0;
        //sqFtCosts[1] = 0;
    }

    public void loadMatCosts() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));

        while (sc.hasNextLine()) {
            String currMat = sc.next();
            String matCostSqFt = sc.next();
            String laborCostSqFt = sc.next();

            sqFtCosts[0] = Double.parseDouble(matCostSqFt);
            sqFtCosts[1] = Double.parseDouble(laborCostSqFt);
            
            materialsMap.put(currMat, sqFtCosts);
        
        }

    }

}

//our Products.txt file has type//materialSqFtCost/laborCostSqFt
