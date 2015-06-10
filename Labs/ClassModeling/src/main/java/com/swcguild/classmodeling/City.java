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
public class City {
//properties of this object:  state, population, latitude, longitude, primary economic base

//fields
String state;
int population;
double latitude;
double longitude;
    
//constructor
public City(String stateLocation, int cityPop, double cityLat, double cityLong){
    this.state = stateLocation;
    this.latitude = cityLat;
    this.longitude = cityLong;
    this.population = cityPop;

}
    
//getters and setters

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getState() {
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
    //other methods and behaviors
    
}
