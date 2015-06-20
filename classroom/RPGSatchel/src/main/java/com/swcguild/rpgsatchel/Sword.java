/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rpgsatchel;

/**
 *
 * @author apprentice
 */
public class Sword implements Item {

    @Override
    public String getItemName() {
        return "Sword";//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getItemWeight() {
        return 15;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //will also need methods to swing sword and sharpen, so will go beyond the inteface and add some methods
    public void Sharpen() {
        System.out.println("Sharpening...");
    }

    public void Swing() {
        System.out.println("Swing....");
    }

}
