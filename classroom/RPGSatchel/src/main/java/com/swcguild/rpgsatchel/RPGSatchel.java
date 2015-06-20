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
public class RPGSatchel {
    public static void main(String[] args) {
        //we are going to make a number of elements that are "items" in our satchel
        //item is the interface
        
        //went to make an item interface, and then a Sword class that implemented an item (interface object))
        
        Sword weapon = new Sword();
        //can't define a constructor in an interface!  Can only be defined in a class-- so we made a shield class
        
        Shield protection = new Shield("Large Shield", 30);
        
        //need a satchel, will go make a class
        Satchel backpack = new Satchel(50);
        backpack.addToSatchel(weapon); //added the sword object we created above
        backpack.addToSatchel(protection); //added 
        
        //iinstantiate item as magic
        Item magic = new Potion();
        backpack.addToSatchel(magic);
        
        String[] items = backpack.listItemsInSatchel();
        
        for (String item: items){
            System.out.println(item);
        }
        
        
    }
            
    
}
