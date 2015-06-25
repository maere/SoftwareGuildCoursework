/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import static com.swcguild.flooringmasterylab.Order.counter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderFactory {
    
    double area;
    HashMap<String, Double> taxMap;
    HashMap<String, double []> materialsMap;
    
    Materials matObjRef = new Materials();
    Taxes taxObjRef = new Taxes();
    
   
    //constructor--default
    public OrderFactory() {
        try {
            matObjRef.loadMatCosts();
             taxMap = taxObjRef.loadTaxes();
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    public Order createFinalOrder(String lastName, double length, double width, String flooringType, String state){
        
        area = calculateArea(length, width);
        //we have enough to instantiate
        Order newOrder = new Order(lastName, flooringType, state, area);

        //need to get data from the Materials dataMap corresponding to the flooring type
        //double [] tempArray = new double [2];
        //tempArray =  matObjRef.materialsMap.get(flooringType);
        //double [] tempArray = materialsMap.get(flooringType);
        double materialCostSqFt = matObjRef.getMaterial(flooringType)[0]; //.get(flooringType)[0];
        double laborCostSqFt = matObjRef.getMaterial(flooringType)[1];

        //need to get tax rate data according to state
        double taxRate = taxMap.get(state);

        //need to run some calculations to add the following properties to the object
        double totalLaborCost = laborCost(area, laborCostSqFt);
        double totalMatCost = calculateMaterials(area, materialCostSqFt);
        double orderTotal = calcOrderTotal(totalLaborCost, totalMatCost, state);

        //set remaining fields to order object
        newOrder.setLaborCostSqFt(area);
        newOrder.setMaterialCostSqFt(area);
        newOrder.setTaxRate(taxRate);
        newOrder.setTaxAdded(taxRate * orderTotal);
        newOrder.setTotalLaborCost(totalLaborCost);
        newOrder.setTotalMatCost(totalMatCost);
        newOrder.setTotalCost(orderTotal);
        return newOrder;
        
    
    }
    
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
