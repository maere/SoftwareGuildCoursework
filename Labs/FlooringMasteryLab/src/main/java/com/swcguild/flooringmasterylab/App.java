/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        OrderController testRun = new OrderController();
        Materials matRun = new Materials();
        Taxes taxRun = new Taxes();
        
        matRun.loadMatCosts();
        taxRun.loadTaxes();
        
        testRun.displayOrders();
        testRun.addOrder();
    }
    
}
