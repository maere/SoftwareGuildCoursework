/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rpgsatchel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class Satchel {//this one will not implement

    private int weightLimit;
    private int currentWeight = 0;
    //ASK ILYA -    to repeat teh below sentance
    Map<String, Item> itemMap = new HashMap<>(); //cannot instantiate an interace, but something that implements an inteface??

    //constructor
    public Satchel(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Boolean addToSatchel(Item item) {
        if (item.getItemWeight() + currentWeight > weightLimit) {
            return false;
        } else {
            currentWeight += item.getItemWeight();
            itemMap.put(item.getItemName(), item);
            return true;
        }
    }

    public Item removeFromSatchel(String itemName) {
        Item temp = itemMap.remove(itemName);
        if (temp != null) {
            currentWeight -= temp.getItemWeight();

        }
        return temp;
    }

    public String[] listItemsInSatchel() {
        Set<String> keySet = itemMap.keySet();
        String[] keyArray = keySet.toArray(new String[0]); //can instantiate an array of 0 on the fly
        return keyArray;
    }
    
    
    

}//end class

