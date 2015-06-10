/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classmodeling;

/**
 *
 * @author apprentice
 */
public class Car {
    
//properties of this object: make, model, mileage, color, condition, price, hasUSB
//methods: drive, reverse, brake, signal,     

//fields
    private String model;
    private String condition;
    private int value;
    private int mileage;
    
//constructor
    public Car(String carModel, String carCondition, int carCurrentValue, int carMiles){
        this.model = carModel;
        this.condition = carCondition;
        this.value = carCurrentValue;
        this.mileage = carMiles;
    
    }
    
//getters and setters
    public String getModel() {
        return model;
    }


    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMileage() {
        return mileage;
    }


        

//other methods and behaviors
    public void addMiles(){
    
    }
    
    
}
