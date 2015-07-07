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
public class SpeedSkateEvent implements Event {

    @Override
    public String compete() {
        System.out.println("Skating  really, really fast...."); //To change body of generated methods, choose Tools | Templates.
        return "SpeedSkate"; //what the event returns is how we grab it as a bean
    }
    
}
