/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.services;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class TipCalculator {

    double costOfService;
    double percentage;
    double total;

    public TipCalculator(double costOfService, double percentage) {
        this.costOfService = costOfService;
        this.percentage = percentage;
    }

    //calculate tip method here
    public double calculateTip() {

        double tip = (costOfService * (percentage / 100));
        total = tip + costOfService;
        return tip;
    }

//    public String roundValue(double DblNum) {
//
//        DecimalFormat bdNum = new DecimalFormat("##.##");
//        String str2dNum = bdNum.format(0.912385);
//        return str2dNum;
//    }

}
/*

 
This is a very simple program where you collect the value from the user, have the user  
enter in a tip value (as a percentage), add the tip to the total and print out the result. 

If the value the user enters 
is $10.00 and the tip is 15% then the total is $10.15. 
 
Output: 
Amount: $10.00 
Tip %: 15 
Tip:     $1.50 
Total:  $11.50 
*/
