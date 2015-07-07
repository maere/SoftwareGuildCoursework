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
