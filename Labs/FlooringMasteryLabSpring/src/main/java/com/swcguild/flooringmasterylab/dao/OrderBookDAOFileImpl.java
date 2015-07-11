/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab.dao;

import com.swcguild.flooringmasterylab.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderBookDAOFileImpl implements OrderBook {

    
    HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>(); // this will change dynamically depending on the date and datefile
    ArrayList<Order> orders = new ArrayList<Order>();
    
    private String mode;
    private int globalId;
    
    private Order order;

    //constructor
    public OrderBookDAOFileImpl() {
        

    }

    @Override
    public void loadOrderFile(String date) throws FileNotFoundException {
        String fileName = "Orders_" + date + ".txt";
        Scanner sc = null;

        try {
        sc = new Scanner(new BufferedReader(new FileReader(fileName)));
 
        while (sc.hasNextLine()) {
     
            String currentLine = sc.nextLine();    
            
            String[] currentToken = currentLine.split(",");

            //int orderNum = Integer.parseInt(currentToken[0]); //will get assigned when we push into the array list
            int id = Integer.parseInt(currentToken[0]);
            String lastName = currentToken[1];
            String state = currentToken[2];
            double taxRate = Double.parseDouble(currentToken[3]);
            String flooringType = currentToken[4];
            double area = Double.parseDouble(currentToken[5]);
            double materialCostSqFt = Double.parseDouble(currentToken[6]);
            double laborCostSqFt = Double.parseDouble(currentToken[7]);
            double totalMatCost = Double.parseDouble(currentToken[8]);
            double totalLaborCost = Double.parseDouble(currentToken[9]);
            double taxAdded = Double.parseDouble(currentToken[10]);
            double totalCost = Double.parseDouble(currentToken[11]);
            date = currentToken[12];

            Order currentOrder = new Order(lastName, flooringType, state, area, date);

            //currentOrder.setOrderNum(orderNum);
            currentOrder.setId(id);
            currentOrder.setTotalMatCost(totalMatCost);
            currentOrder.setTotalLaborCost(totalLaborCost);
            currentOrder.setTotalCost(totalCost);
            currentOrder.setTaxRate(taxRate);
            currentOrder.setTaxAdded(taxAdded);
            currentOrder.setMaterialCostSqFt(materialCostSqFt);
            currentOrder.setLaborCostSqFt(laborCostSqFt);
            currentOrder.setDate(date);

            orderMap.put(id, currentOrder);  ///orderMap. -- need to get largest key---is this available from keyset or array list?

        }
        //orders.add(currentOrder);
        sc.close();
        System.out.println("Orders for " + date + " loaded successfully.");

        } catch (FileNotFoundException e) {
           
               System.out.println("\n** No orders found for " + date+" **");
        }
//                
//            
//        }
//        } catch (FileNotFoundException ex) {
//            //file not found--will write a new file
//            System.out.println("No file found for this date. Any orders created in this session \n "
//                    + "will generate a new order file named: " + fileName + ".");
//        }
        //listOrders(date);
        //return orders;
        //sc.close();
    }

//    @Override //this method was replaced by saveOrdersByDate
//    public void writeOrderFile(String date) throws IOException {   //we are trying IOException, but we expect it to write a new file if one doen'st exist
//
    @Override
    public void writeOrderFile() throws FileNotFoundException, IOException {
        //HashMap<String, ArrayList<Order>> allClientOrders = new HashMap<>();
        
        Set<String> dates = getUniqueDate(); //?should this be orderMap.getUniqueDate?
        for (String uniqueDate : dates) {
            ArrayList<Order> orders = getOrdersByDate(uniqueDate);
            
                //push to hashmap with date as the key, and the array list as the value
                //allClientOrders.put(uniqueDate, orderByDate);
            String fileName = ("Orders_" + uniqueDate + ".txt");
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
                  //var Arraylist that we will pull out of our Arraylist hash
            
                for (Order currentOrder : orders) {   //changing enhanced for loop to standard - 'for (Order currentOrder : orders)'
                out.println(currentOrder.getId() + "," //currentOrder.getOrderNum() + ","
                        + currentOrder.getLastName() + ","
                        + currentOrder.getState() + ","
                        + currentOrder.getTaxRate() + ","
                        + currentOrder.getFlooringType() + ","
                        + currentOrder.getArea() + ","
                        + currentOrder.getMaterialCostSqFt() + ","
                        + currentOrder.getLaborCostSqFt() + ","
                        + currentOrder.getTotalMatCost() + ","
                        + currentOrder.getTotalLaborCost() + ","
                        + currentOrder.getTaxAdded() + ","
                        + currentOrder.getTotalCost() + ","// deleted order num and subbed in Id
                        + currentOrder.getDate());
                }
            out.flush();
            //}
            out.close();
            //orders.clear();
        }
    }
    //writeToFile was replaced by saveOrdersByDate--had to change it back to writeOrderFile to match interface


    @Override
    public ArrayList getOrdersByDate(String orderDate) throws FileNotFoundException {
      
        orders.clear();
        Set<Integer> keys = orderMap.keySet();

        for (Integer k : keys) {
            Order currentOrder = orderMap.get(k);

            if (currentOrder.getDate().matches(orderDate)) {

                orders.add(currentOrder);
            }
        }

        return orders;

    }

    //readConfig and saveConfig probably belong in our controller, but we used 
    //the confige file
    
    @Override
    public String readConfig() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("config.txt")));
        mode = sc.nextLine();
        globalId = Integer.parseInt(sc.nextLine());
        sc.close();
        
        return mode;
    }

    @Override
    public void saveConfig() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("config.txt"));
        out.println(mode);
        out.println(globalId);
        out.flush();
        out.close();
    }

    @Override
    public void putOrders(Order order) throws IOException {
        //will take the gloabalId
        order.setId(++globalId);
        orderMap.put(order.id, order);
        saveConfig();
    }

    @Override
    public void putEditedOrder(Order order) throws IOException {
        orderMap.put(order.id, order);
    }

    @Override
    public Order getOrder(int id) {
        //orderNum
        Order thisOrder = orderMap.get(id);
        return thisOrder;
    }

    @Override
    public void removeOrder(int id) {
        orderMap.remove(id);
        //orderNum
    }
//method from the DAO to getUniqueDate
    @Override
    public Set<String> getUniqueDate() {
        Set<String> currentDates = new HashSet<String>();
        Set<Integer> keys = orderMap.keySet();

        for (Integer k : keys) {
            Order currentOrder = orderMap.get(k);
            currentDates.add(currentOrder.getDate());//orders.add(currentOrder);
        }
        //for (Order o: orderMap){
        //   String currentDate = o.getDate();
        //}
        return currentDates;
    }
}

//    @Override //writeOrderFile was replaced by SaveOrdersByDate
//    public void writeOrderFile(String date) throws IOException {   //we are trying IOException, but we expect it to write a new file if one doen'st exist
//
////        String fileName = "Orders_" + date + ".txt";
////        PrintWriter out = new PrintWriter(new FileWriter(fileName));
////
////        //set can only have one value of each: so
////        
////           //ArrayList<Order> orderList = new ArrayList<Order>(orderMap.values());
////       
////        //create a keyset of our orderbook and use that to iterate through them
////        Set<Integer> keys = orderMap.keySet();
////           for (Integer k : keys){ //(int i= 0; i<orderList.size(); i++)
////                Order currentOrder = orderMap.get(k);
////
////            out.println(currentOrder.getId() + "," //currentOrder.getOrderNum() + ","
////                    + currentOrder.getLastName() + ","
////                    + currentOrder.getState() + ","
////                    + currentOrder.getTaxRate() + ","
////                    + currentOrder.getFlooringType() + ","
////                    + currentOrder.getArea() + ","
////                    + currentOrder.getMaterialCostSqFt() + ","
////                    + currentOrder.getLaborCostSqFt() + ","
////                    + currentOrder.getTotalMatCost() + ","
////                    + currentOrder.getTotalLaborCost() + ","
////                    + currentOrder.getTaxAdded() + ","
////                    + currentOrder.getTotalCost()); // deleted order num and subbed in Id
////           
////           }
////        //for (Integer k : keys) {
////           
////            
////            out.flush();
////
////        //}
////
////        out.close();
//
//    }
//    
//}

//    @Override //this method was replaced by saveOrdersByDate
//    public void writeOrderFile(String date) throws IOException {   //we are trying IOException, but we expect it to write a new file if one doen'st exist
//
//        String fileName = "Orders_" + date + ".txt";
//        PrintWriter out = new PrintWriter(new FileWriter(fileName));
//
//        //set can only have one value of each: so
//        //ArrayList<Order> orderList = new ArrayList<Order>(orderMap.values());
//        //create a keyset of our orderbook and use that to iterate through them
//        Set<Integer> keys = orderMap.keySet();
//        for (Integer k : keys) { //(int i= 0; i<orderList.size(); i++)
//            Order currentOrder = orderMap.get(k);
//
//            out.println(currentOrder.getId() + "," //currentOrder.getOrderNum() + ","
//                    + currentOrder.getLastName() + ","
//                    + currentOrder.getState() + ","
//                    + currentOrder.getTaxRate() + ","
//                    + currentOrder.getFlooringType() + ","
//                    + currentOrder.getArea() + ","
//                    + currentOrder.getMaterialCostSqFt() + ","
//                    + currentOrder.getLaborCostSqFt() + ","
//                    + currentOrder.getTotalMatCost() + ","
//                    + currentOrder.getTotalLaborCost() + ","
//                    + currentOrder.getTaxAdded() + ","
//                    + currentOrder.getTotalCost() + ","// deleted order num and subbed in Id
//                    + currentOrder.getDate());
//
//        }
//        //for (Integer k : keys) {
//
//        out.flush();
//
//        //}
//        out.close();
//
//    }