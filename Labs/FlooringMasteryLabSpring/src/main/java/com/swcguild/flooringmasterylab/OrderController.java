/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

//import static com.swcguild.flooringmasterylab.Order.counter;
import com.swcguild.flooringmasterylab.dao.Materials;
import com.swcguild.flooringmasterylab.dto.Order;
import com.swcguild.flooringmasterylab.operations.OrderFactory;
import com.swcguild.flooringmasterylab.dao.OrderBookDAOFileImpl;
import com.swcguild.flooringmasterylab.dao.MaterialsDAOFileImpl;
import com.swcguild.flooringmasterylab.dao.OrderBook;
import com.swcguild.flooringmasterylab.dao.Taxes;
import com.swcguild.flooringmasterylab.dao.TaxesDAOFileImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class OrderController {
    
    //we need to adjust for these in spring--just put them in as fields...so we can pass them into the constructor - the constructor will need any classes it uses
    /* the following four need to be in teh constructor
    matObjRef - for Materials dao
    taxObjRef - for Taxes dao
    calcGenerator - for OrderFactory dao
    testBook - dao instance
    
    io - addeded as a field
    date -added as a field
   
    */

    boolean configMode;
    ConsoleIO io = new ConsoleIO();
    String date;
    String flooringType;
    
    private String mode;
    private int globalId;
    
    Map<String, Double> taxMap;

    
    private OrderBook daoBook; //OrderBookDAOFileImpl testBook = new OrderBookDAOFileImpl(); //if it gets cranky will pull this
    private OrderFactory daoCalc;   //OrderFactory calcGenerator = new OrderFactory();
    private Materials daoMaterials;//MaterialsDAOFileImpl matObjRef = new MaterialsDAOFileImpl();
    private Taxes daoTaxes;//TaxesDAOFileImpl taxObjRef = new TaxesDAOFileImpl();


    //made constructor to pull in tax and materials data etc--didn't work
    public OrderController(OrderBook daoBook, OrderFactory daoCalc, Materials daoMaterials, Taxes daoTaxes) {
        this.daoBook = daoBook;
        this.daoCalc = daoCalc;
        this.daoMaterials = daoMaterials;
        this.daoTaxes = daoTaxes;

    }

//methods
    //public boolean checkConfig(){}
    public void run() throws IOException {

        date = bootUp();
        daoMaterials.loadMatCosts();
        daoTaxes.loadTaxes();

        boolean keepGoing = true;

        while (keepGoing) {
            printMenu();

            int menuSelection = io.readInt("Please choose from the options [1-6]: ", 1, 6);

            switch (menuSelection) {
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
                    editOrder();
                    break;
                case 4:
                    io.print("Removing order...");
                    removeOrder();
                    break;
                case 5:
                    io.print("Saving all current work...");
                    saveWork(date);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    quit();
                    keepGoing = false;
//                    String quit = io.readYorN("Did you save your work for this session? If not, please select \"n\" "
//                            + "to go back into the main menu and save your work. If you've saved your work \n"
//                            + "select y to exit:");
//
//                    if (quit.equals("n")) {
//                        printMenu();
//                    } else if (quit.equals("y")) {
//                        keepGoing = false;
//                        io.print("Exiting...");
//                    }

                    break;
            }
//            counter++;
        }

    }
    
    

    private String bootUp() throws FileNotFoundException, IOException /*throws IOException*/ {

        //daoBook = new OrderBookDAOFileImpl(); //if it gets cranky will pull this

        //read config file
        mode = daoBook.readConfig();

        //hand these items to the DAO
        String fileName; //will create filename

        DateFormat df = new SimpleDateFormat("MMddyyyy");
        Date today = Calendar.getInstance().getTime(); //system date
        String systemDate = df.format(today);


        date = io.readDateMMddyyyy("Please enter the date as: MMDDYYYY.\nHit 'enter' to use system date " + systemDate + " .");
    
        date = (date.isEmpty()) ? systemDate : date;

        try {
            daoBook.loadOrderFile(date);
            //System.out.println("Orders for " + date + " loaded successfully.");

        } catch (FileNotFoundException e) {
            date = (date.isEmpty()) ? systemDate : date;
            //file not found--will write a new file
            fileName = "Orders_" + date + ".txt";
            newDateFile(date);

            System.out.println("No file found for this date. Any orders created in this session \n "
                    + "will generate a new order file named: " + fileName + ".");
        }
        //System.out.println("Orders for " + date + " loaded successfully.");
        return date;
    }

    private void newDateFile(String date) throws IOException {
        String fileName = "Orders_" + date + ".txt";
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        out.flush();
        out.close();

    }

    public void addOrder() throws FileNotFoundException, IOException {
        //String date = io.readString("Please enter the date as: MMDDYYYY"); //try catch exception?

        String lastName = io.readString("Enter customer's last name: ");
        String state = io.readStateOHMIPAIN("Please enter the state in this format (OH/MI/PA/IN):");
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
        Order myOrder = daoCalc.createFinalOrder(lastName, length, width, flooringType, state, this.date); //this is to assign the value of the returned object

        //myOrder.setId(id);
        
        //write to memory - hashmap
        daoBook.putOrders(myOrder);
        //orderBook.put(orderNum, currentOrder); -- changed to ID
        //write to file

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``
        //this is our business logic which belongs in DAO
    }

    public void displayOrders() throws FileNotFoundException 
    {
      
        String date = io.readDateMMddyyyy("Please enter the date as: MMDDYYYY");
          
        try {

            daoBook.loadOrderFile(date);

            ArrayList<Order> ordersByDate = daoBook.getOrdersByDate(date);
        
            
            for (Order o : ordersByDate) {

                //this needs to iterate
                System.out.println("====================");
                System.out.println("Date: "+o.getDate()+"\nOrder #: " + o.getId()//.getOrderNum()
                        + "\nName: " + o.getLastName()
                        + "\nFlooring Type: " + o.getFlooringType() + "\nSquare Footage: " + o.getArea()
                        + "\nTotal Cost: $" + o.getTotalCost());
                System.out.println("");

            }
        
        } catch (NullPointerException e) {
            System.out.println("No file found");

        
    }

    } 

    public void editOrder() throws FileNotFoundException, IOException {

        String currentName;
        String newName;
        String currentArea;
        String newArea;
        String currentType;
        String newType;

        displayOrders();

        //enter order id of order you want to edit
        int orderId = io.readInt("Please enter the order ID that you wish to edit: ");

        //displays order
        Order currentOrder = daoBook.getOrder(orderId);

        //step through order and edit order properties on thy fly or enter to skip
        io.print("Displaying order information.");

        currentName = currentOrder.getLastName();
        newName = io.readString("Current name is: " + currentName + "\nHit \"enter\" to keep or enter new data to replace.");
        newName = (newName.isEmpty()) ? currentName : newName;
        currentOrder.setLastName(newName);

        currentArea = Double.toString(currentOrder.getArea());
        newArea = io.readString("Current area is: " + currentArea + "\nHit \"enter\" to keep or enter new data to replace.");
        newArea = (newArea.isEmpty()) ? currentArea : newArea;  //Is isEmpty only a 'string' method, or can it be used with ints/doubles/floats?
        currentOrder.setArea(Double.parseDouble(newArea));

        currentType = currentOrder.getFlooringType();
        String userChoice = io.readString("Current flooring type is " + currentType + "\nHit \"enter\" to keep or select from the following options to replace.\n1. Wood\n2. Carpet\n3. Laminate\n4. Tile");

        if (userChoice.isEmpty()) {
            newType = currentType;

        } else {

            int floorChoice = Integer.parseInt(userChoice);
            switch (floorChoice) {
                case 1:
                    newType = "Wood";
                    break;
                case 2:
                    newType = "Carpet";
                    break;
                case 3:
                    newType = "Laminate";
                    break;
                case 4:
                    newType = "Tile";
                    break;

                default:
                    newType = currentType;
                    break;

            }
        }

        //newType = (newType.isEmpty()) ? currentType : newType;
        currentOrder.setFlooringType(newType);
        //saves to hashmap and committed to memory
        Order editedOrder = daoCalc.createEditedOrder(currentOrder);
        daoBook.putEditedOrder(editedOrder);

        io.print("Updated order appears below, to save changes select option 5 from Main Menu");
        io.print("Name: " + editedOrder.getLastName());
        io.print("Area: " + editedOrder.getArea());
        io.print("Flooring Type:" + editedOrder.getFlooringType());
        io.print("Total Cost: $" + editedOrder.getTotalCost());

    }

    public void removeOrder() throws FileNotFoundException {
        displayOrders();
        int tempId= io.readInt("Enter the id of the order you would like to remove: ");
        Order o = daoBook.getOrder(tempId);
        //this needs to iterate
                System.out.println("====================");
                System.out.println("Order #: " + o.getId()//.getOrderNum()
                        + "\nName: " + o.getLastName()
                        + "\nFlooring Type: " + o.getFlooringType() + "\nSquare Footage: " + o.getArea()
                        + "\nTotal Cost: $" + o.getTotalCost());
                System.out.println("");
        
        String confirm = io.readYorN("Are you sure you want to delete this order? (type y or n)");
        
        if(confirm.equals("y"))
        {
         daoBook.removeOrder(tempId);
         
         io.print("Order deleted, but you must selected option 5 from the  main menu to save these changes.");
        }
        else{
        io.print("Deletion aborted.");
        
        }
       
        
        
    }

    public void saveWork(String date) throws IOException {
       
        if (mode.equalsIgnoreCase("p")){
        
        daoBook.writeOrderFile();
        } else {
        io.print("You are in TEST mode, changes will not be saved to disk.");
        
        }
        
    }

    public void quit() throws IOException {
      
        io.print("Goodbye.");

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

}
