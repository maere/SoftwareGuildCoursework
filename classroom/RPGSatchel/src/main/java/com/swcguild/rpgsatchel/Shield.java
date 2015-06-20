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
public class Shield implements Item{
    
    //we addes some fields that sheild will need
    private String name;
    private int weight;
    
    public Shield(String name, int weight) //why did we make a constructor for this one and none of the others?
    {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getItemName() {
        return name;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getItemWeight() {
        return weight;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //add antoher method
    public void block(){
        System.out.println("Blocking....");
    }
    
}
