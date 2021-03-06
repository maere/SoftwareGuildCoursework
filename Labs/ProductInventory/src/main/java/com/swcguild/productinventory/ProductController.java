/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.productinventory;

/**
 *
 * @author apprentice
 */
public class ProductController {

    private final ConsoleIO con;
    ProductInventory currentInventory = new ProductInventory();
    private String productName;
    private float price;
    private Integer sku; //none of these really need to be class level varaiables because only need them to create product

    public ProductController() {
        this.con = new ConsoleIO();

    }

    public void run() {
    }

    public void mainMenu() {
    }

    public void createProductInSystem() {

        //add info about product using fields from the Product constructor
        productName = con.readString("Enter the name of the product you would like to add: \n");
        String type = con.readString("Enter the type of product you are entering (e.g. Chips, Gum, Candy, Bar: \n");
        price = con.readFloat("Enter the price you will sell the product at: \n ");
        sku = con.readInt("Enter the SKU of the product");

        Product currentProduct = null;  //need to initialize it (ie. set it to null) or it won't work below!! 
                                        //declaring is not enough
        //instantiate product object to put stuff in
        if (type.matches("Chips")) {
           currentProduct = new Chips(productName, price);
        } else if (type.matches("Bar")) {
           currentProduct = new Bar(productName, price);
        } else if (type.matches("Candy")) {
            currentProduct = new Candy(productName, price);
        } else if (type.matches("Gum")) {
            currentProduct = new Gum(productName, price);
        } else {
            System.out.println("Something is not working. Make sure you entered the required information.");
        }
        
        //set the new object's propteries
        
        //add to the collection

    }

    public void addStock(String productName, int quantity, float costPerUnit) {
    }

    public void removeStock(String productName, int quantity, float price) {
    }

    //might need to move these calculations to the ProductInventory class and just have a getvalue here
    public void getProductValue() {
    }

    public void getValueOfAllProducts() {
    }

}
