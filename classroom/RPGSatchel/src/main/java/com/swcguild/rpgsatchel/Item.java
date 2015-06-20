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
public interface Item {
    public String getItemName();
    public int getItemWeight();
    
}
//all this wants is the name and the item and the weight--bc we are going to be filling up our satchel 
//with items of various classes