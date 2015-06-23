/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class OrderController {
   

    boolean configMode;
    ConsoleIO io = new ConsoleIO();
    String date;
    
    //String state
    //
    String flooringType;
    
    OrderBook testBook = new OrderBook(); //if it gets cranky will pull this
    Materials matObjRef = new Materials();
    Taxes taxObjRef = new Taxes();
    //Map<String, double[]> materialsMap; 
    Map<String, Double> taxMap;
    OrderFactory calcGenerator = new OrderFactory();
       
    
    Map<Integer, Order> orderBook = new HashMap<>(); 
  
    //ArrayList<Order> orders = new ArrayList();
    ArrayList<Order> orders;

    //made constructor to pull in tax and materials data etc--didn't work
    public OrderController(){
 
            
    }

//--methods
    
    //public boolean checkConfig(){}
    
    public void run() {

    }

    public void addOrder() {
        String date = io.readString("Please enter the date as: MMDDYYYY"); //try catch exception?
        testBook.loadOrderFile(date); //can't run this without loading file from memory first -- breaking point

        //set next Id for object creation equal to +1 of the length of the list of orders
        Order lastOrder = orders.get(orders.size() - 1);
        int tempId = lastOrder.getOrderNum();
        int newId = tempId + 1;

        String lastName = io.readString("Enter customer's last name: ");
        String state = io.readString("Please enter the state in this format (XX)");
        int userFloorPref = io.readInt("Select your flooring type:\n1. Wood\n2.Carpet \n3. Laminate \n4.Tile \n", 1, 4);
        switch (userFloorPref) {
            case 1:
                flooringType = "Wood";
                break;
            case 2:
                flooringType = "Carpet";
                break;
            case 3:
                flooringType = "Laminate";
                break;
            case 4:
                flooringType = "Tile";
                break;
            default:
                break;
        }
        double length = io.readDouble("Enter the length of the room you want to renovate: ");
        double width = io.readDouble("Enter the width of the room as well: ");
        
        double area = calcGenerator.calculateArea(length, width);

        //we have enough to instantiate
        Order newOrder = new Order(lastName, flooringType, state, area);
        
        //need to get data from the Materials dataMap corresponding to the flooring type
        //double [] tempArray = new double [2];
        //tempArray =  matObjRef.materialsMap.get(flooringType);
        //double [] tempArray = materialsMap.get(flooringType);
        double materialCostSqFt = matObjRef.materialsMap.get(flooringType)[0];
        double laborCostSqFt =  matObjRef.materialsMap.get(flooringType)[1];    
        
        //need to get tax rate data according to state
        double taxRate = taxMap.get(state);
        
        //need to run some calculations to add the following properties to the object
        double totalLaborCost = calcGenerator.laborCost(area, laborCostSqFt);
        double totalMatCost = calcGenerator.calculateMaterials(area, materialCostSqFt);
        double orderTotal = calcGenerator.calcOrderTotal(totalLaborCost, totalMatCost, state);
        
        
        //set remaining fields to order object
        newOrder.setLaborCostSqFt(area);
        newOrder.setMaterialCostSqFt(area);
        newOrder.setTaxRate(taxRate);
        newOrder.setTaxAdded(taxRate*orderTotal);
        newOrder.setTotalLaborCost(totalLaborCost);
        newOrder.setTotalMatCost(totalMatCost);
        newOrder.setTotalCost(orderTotal);
        
        //write to memory - hashmap
        orderBook.put(newId, newOrder);
        
        //write to file

    }

    public void displayOrders() {
        String date = io.readString("Please enter the date as: MMDDYYYY");
        orders = testBook.loadOrderFile(date);
       //testBook.loadOrderFile(date);

        //take values in HashMap and push to ArrayList
        //orders.
        for (int i = 0; i < orders.size(); i++) {

            System.out.println("Order #: " + orders.get(i).getOrderNum()
                    + " Name: " + orders.get(i).getLastName()
                    + " Flooring Type " + orders.get(i).getFlooringType() + " Square Footage: " + orders.get(i).getArea());

        }

    }

    public void editOrder() {
    }

    public void removeOrder() {
    }

    public void saveWork() {
    }

    public void quit() {
    }

}
