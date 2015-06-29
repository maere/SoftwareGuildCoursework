/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
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
    /*
    @Test
    public void loadData() throws FileNotFoundException {
        OrderBookDAOFileImpl ob = new OrderBookDAOFileImpl();
        ob.loadOrderFile("JUNIT_TEST-06262015");
    }

    @Test
    public void loadTaxData() {

        TaxesDAOFileImpl tx = new TaxesDAOFileImpl();

        try {
            HashMap blah = tx.loadTaxes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void loadMatData() {

        MaterialsDAOFileImpl mt = new MaterialsDAOFileImpl();

        try {
            HashMap matMap = mt.loadMatCosts();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void writeFile() throws IOException {
        

        OrderBookDAOFileImpl ob = new OrderBookDAOFileImpl();
        ob.loadOrderFile("JUNIT_TEST-06262015");
        
        ob.writeOrderFile("JUNIT_TEST-06262015");

    }

    @Test
    public void getOrdersByDate() throws FileNotFoundException {

        OrderBookDAOFileImpl ob = new OrderBookDAOFileImpl();
        ob.getOrdersByDate("JUNIT_TEST-06262015");

    }
*/
    @Test
    public void testUniqueDateSet() throws FileNotFoundException{
        OrderBookDAOFileImpl ob = new OrderBookDAOFileImpl();
        ob.loadOrderFile("JUNIT_TEST-06262015");
        //may need orders
        Set<String> resultSet = new HashSet<String>();
        resultSet = ob.getUniqueDate();
        boolean testDate = resultSet.contains("06262015");
        Assert.assertTrue(testDate);
        
    
    }
    
    
}
