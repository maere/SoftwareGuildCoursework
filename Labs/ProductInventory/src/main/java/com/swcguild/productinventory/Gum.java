/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.productinventory;

/**
 *
 * @author apprentice
 */
public class Gum extends Product {

    public Gum(String productName) {
        super(productName);
        this.productName = productName;
        //this.type = "Gum"; - if I need a subtype like sugarless, or sugared--would create a new class
    }

    
    
}
