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
//MagicItem will extend the interface into another interface w suoperpowers--
//doesn't have to name the methods bc will inherit from Item -- like extrended a class
                                        //Q for ILYA: extends vs. implements
public interface MagicItem extends Item {
    public int getItemSpellPower();
    
    
}
