/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderBook {

    String date;
   
    Map<Integer, Order> orderBook = new HashMap<>(); // this will change dynamically depending on the date and datefile
    ArrayList<Order> orders = new ArrayList<>();
    
    //constructor

    public ArrayList loadOrderFile(String date) {
         String fileName = "Orders_" + date + ".txt";
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));

            while (sc.hasNextLine()) {
                
                int orderNum = sc.nextInt(); //will get assigned when we push into the array list
                String lastName = sc.next();
                String state = sc.next();
                double taxRate = sc.nextDouble();
                String flooringType = sc.next();
                double area = sc.nextDouble();
                double materialCostSqFt = sc.nextDouble();
                double laborCostSqFt = sc.nextDouble();
                double totalMatCost = sc.nextDouble();
                double totalLaborCost = sc.nextDouble();
                double taxAdded = sc.nextDouble();
                double totalCost = sc.nextDouble();
                
                Order currentOrder = new Order(lastName, flooringType, state, area);
                
                currentOrder.setOrderNum(orderNum);
                currentOrder.setTotalMatCost(totalMatCost);
                currentOrder.setTotalLaborCost(totalLaborCost);
                currentOrder.setTotalCost(totalCost);
                currentOrder.setTaxRate(taxRate);
                currentOrder.setTaxAdded(taxAdded);
                currentOrder.setMaterialCostSqFt(materialCostSqFt);
                currentOrder.setLaborCostSqFt(laborCostSqFt);
                
                orderBook.put(orderNum, currentOrder);
       
                orders.add(currentOrder);

            }
            

        } catch (FileNotFoundException ex) {
            //file not found--will write a new file
            System.out.println("No file found for this date. Any orders created in this session \n "
                    + "will generate a new order file named: " + fileName + ".");
        }
        
        return orders;
    }

    public void writeOrderFile() throws IOException {   //we are trying IOException, but we expect it to write a new file if one doen'st exist
        
        String fileName = "Orders_" + date + ".txt";
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        
       //create a keyset of our orderbook and use that to iterate through them
        Set<Integer> keys = orderBook.keySet();
        
        for(Integer k: keys){
            Order currentOrder = orderBook.get(k);
            
            out.println(currentOrder.getOrderNum() + " " 
                    + currentOrder.getLastName() + " " 
                    + currentOrder.getState() + " " 
                    + currentOrder.getTaxRate() + " " 
                    + currentOrder.getFlooringType() + " " 
                    + currentOrder.getArea() + " " 
                    + currentOrder.getMaterialCostSqFt() + " " 
                    + currentOrder.getLaborCostSqFt() + " " 
                    + currentOrder.getTotalMatCost() + " " 
                    + currentOrder.getTotalLaborCost() + " " 
                    + currentOrder.getTaxAdded() + " " 
                    + currentOrder.getTotalCost());
        out.flush();
            
        }
        
        out.close();

        
    }
    //------
    
    //public void readFromFile(){}
    //public void writeToFile(){}
    
    //public ArrayList listOrders(String orderDate){}

    
    public void putOrder(int orderNum, Order currentOrder){}
    
    public void getOrder(int orderNum){}
    
    public void removeOrder(int orderNum){}
    
   
}
