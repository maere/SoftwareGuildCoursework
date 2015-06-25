/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import static com.swcguild.flooringmasterylab.Order.counter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class OrderController {

    boolean configMode;
    ConsoleIO io = new ConsoleIO();
    //String date;

    //String state
    //
    String flooringType;

    Materials matObjRef = new Materials();
    Taxes taxObjRef = new Taxes();

    //Map<String, double[]> materialsMap; 
    Map<String, Double> taxMap;
    OrderFactory calcGenerator = new OrderFactory();

    OrderBook testBook = new OrderBook(); //if it gets cranky will pull this
    //HashMap<Integer, Order> orderBook = new HashMap<Integer, Order>();

    //ArrayList<Order> orders = new ArrayList();
    ArrayList<Order> orders;  //orders should be a List, when you instantiate it you set it as ArrayList

    //made constructor to pull in tax and materials data etc--didn't work
    public OrderController() {

    }

//--methods
    //public boolean checkConfig(){}
    public void run() throws IOException {

        String date = bootUp();
        matObjRef.loadMatCosts();
        taxObjRef.loadTaxes();
        printProdTestMenu();
        int menuSelection1 = io.readInt("Choose option [1 or 2]", 1, 2);

        switch (menuSelection1) {
            case 1:
                io.print("Loading test version...");
                printMenu();
                break;
            case 2:
                io.print("Loading production version...");
                printMenu();
                break;
            default:
                io.print("Invalid selection");
                break;

        }

        boolean keepGoing = true;
        int counter = 0;
        while (keepGoing) {

            if (counter > 0) {
                printMenu();
            }
            int menuSelection2 = io.readInt("Please choose from the options [1-6]: ", 1, 6);

            switch (menuSelection2) {
                case 1:
                    io.print("Displaying orders...");
                    displayOrders();
                    break;
                case 2:
                    io.print("Adding order...");
                    addOrder();
                    break;
                case 3:
                    io.print("Editing order...");
                    break;
                case 4:
                    io.print("Removing order...");
                    break;
                case 5:
                    io.print("Saving all current work...");
                    saveWork(date);
                    break;
                case 6:
                    io.print("Exiting...");
                    keepGoing = false;
                    saveWork(date);
                    break;

            }
            counter++;

        }

    }

    private String bootUp() throws IOException {
        OrderBook testBook = new OrderBook(); //if it gets cranky will pull this
        //String fileName;
        DateFormat df = new SimpleDateFormat("MMddyyyy");

        Date today = Calendar.getInstance().getTime();

        String date = df.format(today);

        testBook.loadOrderFile(date);
//        try {
//            String date = io.readString("Please enter the date as: MMDDYYYY");
//            testBook.loadOrderFile(date);
//            System.out.println("Orders for " + date + " loaded successfully.");
//
//        } catch (FileNotFoundException e) {
//            //file not found--will write a new file
//            fileName = "Orders_" + date + ".txt";
//            newDateFile(date);
//
//            System.out.println("No file found for this date. Any orders created in this session \n "
//                    + "will generate a new order file named: " + fileName + ".");
//        }
        return date;
    }

    private void newDateFile(String date) throws IOException {
        String fileName = "Orders_" + date + ".txt";
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        //out.print("42,Test42,OH42,42,Wood,42,42,42,42,42,42,42");
        out.flush();
        out.close();

    }

    public void addOrder() throws FileNotFoundException, IOException {
        //String date = io.readString("Please enter the date as: MMDDYYYY"); //try catch exception?

        //testBook.loadOrderFile(date); //can't run this without loading file from memory first -- breaking point
        //set next Id for object creation equal to +1 of the length of the list of orders
//        Order lastOrder = orders.get(orders.size() - 1);
//        int tempId = lastOrder.getOrderNum();
//        int newId = tempId + 1;
        String lastName = io.readString("Enter customer's last name: ");
        String state = io.readString("Please enter the state in this format (XX)");
        int userFloorPref = io.readInt("Select your flooring type:\n1. Wood\n2. Carpet \n3. Laminate \n4. Tile \n", 1, 4);
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

        //need to instantiate business object and call methods from our business logic 
        Order myOrder = calcGenerator.createFinalOrder(lastName, length, width, flooringType, state); //this is to assign the value of the returned object

        //write to memory - hashmap
        testBook.putOrders(myOrder);
        //orderBook.put(orderNum, currentOrder);
        //write to file

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``
        //this is our business logic which belongs in DAO
    }

    public void displayOrders() throws FileNotFoundException {
        //int dateInt = io.readInt("Please enter the date as: MMDDYYYY",1012013, 12312015);

        String month = String.format("%02d", io.readInt("Please enter the month [1-12]:", 1, 12));
        String day = String.format("%02d", io.readInt("Please enter the day as [1-31]:", 1, 31));
        String year = String.format("%04d", io.readInt("Please enter the year as [2000-2015]:", 2000, 2015));

        String date = month + day + year;
        //String date = String.format("%08d",dateInt);
        //orders = testBook.loadOrderFile(date);
        try {
            testBook.loadOrderFile(date);
            testBook.listOrders(date);
        } catch (NullPointerException e) {
            System.out.println("No file found");
        }

        //orders = testBook.listOrders(date);
        //take values in HashMap and push to ArrayList
        //orders.
//        for (int i = 0; i < orders.size(); i++) {
//            io.print("====================");
//            System.out.println("Order #: " + orders.get(i).getOrderNum()
//                    + "\nName: " + orders.get(i).getLastName()
//                    + "\nFlooring Type: " + orders.get(i).getFlooringType() + "\nSquare Footage: " + orders.get(i).getArea());
//            io.print("");
//        }
    }

    public void editOrder() {
        //enter an 8 digit date
        //load text file from memory
        //display orders
        //enter order id of order you want to edit
        //displays order
        //step through order and edit order properties on thy fly or enter to skip
        //saves to hashmap and committed to memory

    }

    public void removeOrder() {
    }

    public void saveWork(String date) throws IOException {
        //testBook is our instance of the OrderBook class
        //ArrayList<Order> dailyOrders =  testBook.orderMap.values();
        Collection<Order> keys = testBook.orderMap.values();

        for (Order k : keys) {
            testBook.putOrders(k);
            testBook.writeOrderFile(date);
        }
        //testBook.writeOrderFile();

    }

    public void quit() {
    }

    private void printMenu() {
        io.print("=============================================================");
        io.print("\t\t        ++++++++++++++++++++");
        io.print("\t\t\t| Flooring Program |");
        io.print("\t\t        ++++++++++++++++++++");
        io.print("");
        io.print("1. Display Orders\n2. Add an Order\n3. Edit an Order\n4. Remove an Order\n5. Save Current Work\n6. Quit");
        io.print("");
        io.print("=============================================================");
    }

    private void printProdTestMenu() {
        io.print("Select:\n1. Test\n2. Production");

    }

}
