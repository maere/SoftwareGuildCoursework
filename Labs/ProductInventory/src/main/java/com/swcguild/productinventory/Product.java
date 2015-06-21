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
public class Product {
    protected String type;
    protected Product productType;
    protected String productName;
    protected float price;
    protected Integer sku;
    
    protected int count;
    protected float costPerUnit;
    protected int units;
    protected String vendor;
    
    public Product(String productName){
        this.productName = productName;
        this.productType = productType;
        this.sku = sku;
        //this.productType = productType;
        //this.type = type;
        //this.price = price;
        //this.costPerUnit = costPerUnit;
        //this.units = units;
        //this.vendor = vendor;
        //this.count = count;
       
    }

    public Product getProductType() {
        return productType;
    }

    public void setProductType(Product productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /*
    public int getInventoryCount() {
        //return inventoryCount;
    }*/

    public void setInventoryCount(int inventoryCount) {
        //this.inventoryCount = inventoryCount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Integer getSku() {
        return sku;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    
    
}
