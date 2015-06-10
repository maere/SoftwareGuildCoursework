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
public class Airplane {
    
//properties of this object: model, manufacturer, number of seats, year of manufacture, last maintenance date, 
//methods: accelerate, engage engines, cut engines, move wing flaps, taxi forward, reverse, 

//fields
    private final String model;
    private int seats;
    private String maintenance;
    private int speed;
    
//constructor
    public Airplane(String airModel, int noSeats, String maintDate){
        this.model = airModel;
        this.seats = noSeats;
        this.maintenance = maintDate;
    
    }
//getters and setters

    public String getModel() {
        return model;
    }
    
    public int getSeats() {
        return seats;
    }
    
    public int getSpeed(){
        return speed;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }
    
    
//other methods and behaviors
    public boolean taxiForward(boolean startTaxi){  //do booleans act like switches in method calls?
        return true;
    }
    public boolean taxiStop(boolean stopTaxi){
        return true;
    }
    
    public int accelerateSpeed(int pedal){
        if (pedal > speed){
        speed = speed + 100;
        }
        return speed;
            
    }

}
