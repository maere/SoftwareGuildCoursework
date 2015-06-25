/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author apprentice
 */
public class DAOUnitTest {
    
    public DAOUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
 
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void loadData(){
    OrderBook ob = new OrderBook();
    ob.loadOrderFile("06012013");
    }
    
    @Test
    public void loadTaxData() {
    
        Taxes tx = new Taxes();
        
        try {
            HashMap blah = tx.loadTaxes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
  
}
