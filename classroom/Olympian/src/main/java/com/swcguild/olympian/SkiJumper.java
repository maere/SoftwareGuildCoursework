/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

/**
 *
 * @author apprentice
 */          //ski jumper is also a type of impl, tho not to interface...it just uses the event class, so we need as a field--
                //in this case we want the ski jumper to compete...so they need to have an event to compete in...
                    //so this skiJumper class has a compositional rel to the Event class..will implement it's METHODS
                                                                    
public class SkiJumper {
    private Event event;
    
    ///constructor
    public SkiJumper(){
    
     //we are going to create the skijumper event inside the SkiJumper
    event = new SkiJumpEvent();
    }
    //one methed that the jumper does--he competes
    public String competeInEvent(){
        return event.compete();
    }
   
    
    
}
