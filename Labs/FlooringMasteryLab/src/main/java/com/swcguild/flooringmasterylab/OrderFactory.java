/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class OrderFactory {
    
    double area;
    HashMap<String, Double> taxMap;
    HashMap<String, double []> materialsMap;
    
    
    //constructor--default
    
    public double calculateArea(double length, double width){
      area = length*width;
      return area;
    
    }
    
    public double calculateMaterials(double area, double materialCostSqFt){
        double currentMatCost = area*materialCostSqFt; 
        return currentMatCost;
        
    
    }
    
    public double laborCost(double area, double laborCostSqFt){
    double currentLaborCost=area*laborCostSqFt;
    return currentLaborCost;
    
    }
    
    public double calcOrderTotal(double currentLaborCost, double currentMatCost, String state){
        
        
        double orderTotal = (currentLaborCost + currentMatCost)*(taxMap.get(state));
                
        return orderTotal;        
                
    }
    
}
