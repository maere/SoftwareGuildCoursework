/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.productinventory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MS
 */
//DAO 
public class ProductInventory {

    private HashMap<String, Product> inventoryMap;
    private ArrayList<String> productList;
    
    public Product productType;
    
    public Product productName;
    public Float price;
    public String type;
    private Integer sku;

    public ProductInventory() {
    inventoryMap = new HashMap<>();
 
    }

    public void addProductToHash(String productName, String type){
        //if (type.matches("Chips")) 
         // {
          // Product productType = Chips;
           inventoryMap.put(productName, productType);
         // }
    }
/* so it will compile.....until these are written
    
    public Product getProduct() {
        return product; //from Hash
    }

    public ArrayList<String> listInventory() {
        //creates a list of the available inventory
        return currentInventory;
    }
*/
    public void loadProductInventory() {
        //load data from persistant storage
    }
    
    public void updateInventory(String productName) {
        //write to data in persistant storage
    }

    public void restockWarning() {
    }

    public void calculateProductValue(String productName) {
    }

    public float calculateValueOfAllProducts() {
        return 0;
    }

}//end class
