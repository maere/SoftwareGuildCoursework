/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

/**
 *
 * @author apprentice
 */
public class Olympian {
    private Event event; // this is what allows aggregation--we make the related interface/class available in our class as a field--will be constructed by Spring
                    //with the old way, we would have had to included the class as a field or in our constructor explicitly (e.g. DAO new instnace)
    private String country = "USA";  //default value
    
    public Olympian(Event event){ //this is dependency injection...these two classes depend on eachother
                                //our constructor says the only way to construct this is with the object that implements the event 
    this.event = event; //the even should be the instantiated object 
    }
    public String competeInEvent(){
        System.out.println("Now competing for..." + country + ":");
        return event.compete();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
