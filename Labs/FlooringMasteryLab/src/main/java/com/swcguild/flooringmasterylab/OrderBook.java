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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderBook implements OrderBookDAOFileImpl {

    //String date;
    HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>(); // this will change dynamically depending on the date and datefile
    ArrayList<Order> orders = new ArrayList<Order>();

    //constructor
    @Override
    public void loadOrderFile(String date) {
        String fileName = "Orders_" + date + ".txt";

        Scanner sc = null;

        DateFormat df = new SimpleDateFormat("MMddyyyy");

        Date today = Calendar.getInstance().getTime();

        String dateCompare = df.format(today);

        try {
            sc = new Scanner(new BufferedReader(new FileReader(fileName)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();
                String[] currentToken = currentLine.split(",");

                int orderNum = Integer.parseInt(currentToken[0]); //will get assigned when we push into the array list
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

                Order currentOrder = new Order(lastName, flooringType, state, area);

                currentOrder.setOrderNum(orderNum);
                currentOrder.setTotalMatCost(totalMatCost);
                currentOrder.setTotalLaborCost(totalLaborCost);
                currentOrder.setTotalCost(totalCost);
                currentOrder.setTaxRate(taxRate);
                currentOrder.setTaxAdded(taxAdded);
                currentOrder.setMaterialCostSqFt(materialCostSqFt);
                currentOrder.setLaborCostSqFt(laborCostSqFt);

                orderMap.put(orderNum, currentOrder);

            }
            //orders.add(currentOrder);
            sc.close();
            System.out.println("Orders for " + date + " loaded successfully.");

        } catch (FileNotFoundException ex) {
            if (date.equalsIgnoreCase(dateCompare)) {
                System.out.println("");
            } else {
                System.out.println("\n** No orders found for " + date+" **");
            }
                
            
        }
//        } catch (FileNotFoundException ex) {
//            //file not found--will write a new file
//            System.out.println("No file found for this date. Any orders created in this session \n "
//                    + "will generate a new order file named: " + fileName + ".");
//        }
        //listOrders(date);
        //return orders;
        //sc.close();
    }

    @Override
    public void writeOrderFile(String date) throws IOException {   //we are trying IOException, but we expect it to write a new file if one doen'st exist

        String fileName = "Orders_" + date + ".txt";
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        //create a keyset of our orderbook and use that to iterate through them
        Set<Integer> keys = orderMap.keySet();

        for (Integer k : keys) {
            Order currentOrder = orderMap.get(k);

            out.println(currentOrder.getOrderNum() + ","
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
                    + currentOrder.getTotalCost());
            out.flush();

        }

        out.close();

    }
    //------

    //public void writeToFile(){}
    @Override
    public ArrayList listOrders(String orderDate) throws FileNotFoundException {
        //loadOrderFile(orderDate);    
        Set<Integer> keys = orderMap.keySet();

        for (Integer k : keys) {
            Order currentOrder = orderMap.get(k);

            System.out.println("====================");
            System.out.println("Order #: " + orderMap.get(k).getOrderNum()
                    + "\nName: " + orderMap.get(k).getLastName()
                    + "\nFlooring Type: " + orderMap.get(k).getFlooringType() + "\nSquare Footage: " + orderMap.get(k).getArea() 
                    + "\nTotal Cost: $"+ orderMap.get(k).getTotalCost());
            System.out.println("");

        }
        return orders;

    }

    @Override
    public void putOrders(Order order) throws IOException {
        orderMap.put(order.id, order);

        //writeOrderFile();
    }

    @Override
    public void getOrder(int orderNum) {
    }

    @Override
    public void removeOrder(int orderNum) {
    }

}
