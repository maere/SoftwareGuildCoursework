/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterwebapp;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class FlooringMasterMini {

    //Have the program calculate how much it would cost to cover the area specified with the flooring.  
    double area;
    double costPerSqFt; //"one unit" - for now we will assume this is per square foot

    //just adding these as constant, but could be changed later
    double laborRate = 86.00;
    //int laborIncrement = 4;
    
    double length;
    double width;
    
    public FlooringMasterMini(double length, double width, double costPerSqFt){
        this.length = length;
        this.width = width;
        this.costPerSqFt = costPerSqFt;   
    
    }
    

    public double calculateArea(double length, double width) {
        area = length * width;
        return area;
    }


    public double calculateMaterials(double area, double materialCostSqFt) {
        double currentMatCost = area * materialCostSqFt;
        return currentMatCost;
    }

  
    public double calculateLaborRate() {
        
        double hours = area/20; //because they can cover 20 sqft/hr
        //e.g. quarterHours =  1 hour/4; or .25
        double laborHourIncrement = .25;
        
        double incrementedRate = laborRate*laborHourIncrement;
        double incrementedLabor = hours/laborHourIncrement;
        //
        DecimalFormat newFormat = new DecimalFormat("#.##");
        double twoDecimal = Double.valueOf(newFormat.format(incrementedLabor));
        
        //could try round half up
        
        //or if (twoDecimal%1)*100 /25  >0 && <=25, remainder = .25
            //else if ................>25 && <=50 = 50
            //else if ................>50 && <=75 = 75 
            //else if ................>75 = 100.
                
        double currentLaborCost = incrementedLabor*incrementedRate;
        //
       
        return currentLaborCost;
    }

      public double calcOrderTotal(double currentLaborCost, double currentMatCost){
       
        double orderTotal = (currentLaborCost + currentMatCost);
        return orderTotal;        
                
    }
    
}

/*
double d = 3.76628729;

DecimalFormat newFormat = new DecimalFormat("#.##");
double twoDecimal =  Double.valueOf(newFormat.format(d));

--

BigDecimal bd = new BigDecimal(Double.toString(d));
bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
return bd.doubleValue();


*/