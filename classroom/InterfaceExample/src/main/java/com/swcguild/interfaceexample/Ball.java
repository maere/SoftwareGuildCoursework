/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interfaceexample;

/**
 *
 * @author apprentice
 */                                 //Started with Debugabble, but also wanted the specific methods for DebugLogging, which is an extension of Debuggble, so we can implement that instead and kill two birds with one stone
public class Ball implements Colorable, DebugLogging{ //you get an error out of the  gate
    //because you have to use the methods out of the gate--
    //so click on the bulb and implement all abstrat methods--insterted below
    
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void displayStatus(String id) {
        System.out.println("Our status is: " + id);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayError(String error) {
        System.out.println("Our error is: " + error); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logStatus(String status) {
        System.out.println("Status2: " + status);
    }

    @Override
    public void logError(String error) {
        System.out.println("Error 2: " + error);//To change body of generated methods, choose Tools | Templates.
    }
    
    
}
