
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import com.swcguild.flooringmasterylab.dao.Materials;
import com.swcguild.flooringmasterylab.dao.MaterialsDAOFileImpl;
import com.swcguild.flooringmasterylab.dao.OrderBook;
import com.swcguild.flooringmasterylab.dao.OrderBookDAOFileImpl;
import com.swcguild.flooringmasterylab.dao.Taxes;
import com.swcguild.flooringmasterylab.dao.TaxesDAOFileImpl;
import com.swcguild.flooringmasterylab.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DAOUnitTest {
    
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");// we need our context here in order to test 
        
        private OrderBook dao; // we also need an instance of this interface that we are depending on
        private Materials daoMaterials;//MaterialsDAOFileImpl matObjRef = new MaterialsDAOFileImpl();
        private Taxes daoTaxes;
        
    
    Order order1;
    Order order2;

    public DAOUnitTest() {
    }

    

    @Before
    public void setUp() {
        dao = ctx.getBean("orderBookDao", OrderBook.class);
        daoTaxes = ctx.getBean("taxesDao", Taxes.class);
        daoMaterials = ctx.getBean("materialsDao", Materials.class);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void loadData() throws FileNotFoundException {
        dao.loadOrderFile("01011900");
        
        
        
    }

    @Test
    public void loadTaxData() {

        // don't need bc we are injection: TaxesDAOFileImpl tx = new TaxesDAOFileImpl();

        try {
//        String state= "OH";
//        boolean ohExists = daoTaxes.loadTaxes().containsKey(state);
//        Assert.assertTrue(ohExists);
            
            HashMap blah = daoTaxes.loadTaxes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }

    @Test
    public void loadMatData() {

        //don't need--injected above: MaterialsDAOFileImpl mt = new MaterialsDAOFileImpl();

        try {
            HashMap matMap = daoMaterials.loadMatCosts();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void writeFile() throws IOException {
        
        
        dao.loadOrderFile("01011900");
        Order testOrder = dao.getOrder(1);
        testOrder.setLastName("Thisworks");
        
        dao.writeOrderFile();
        dao.loadOrderFile("01011900");
        String result = testOrder.getLastName();
        
        Assert.assertEquals("Thisworks", result);
        

    }

    @Test
    public void testGetOrdersByDate() throws FileNotFoundException {

        dao.loadOrderFile("01011900");
        ArrayList<Order> testOrders = dao.getOrdersByDate("01011900");
        int arraySize = testOrders.size();
        Assert.assertEquals(1, arraySize);
    }

    @Test
    public void testUniqueDateSet() throws FileNotFoundException{
        dao.loadOrderFile("01011900");
        //may need orders
        Set<String> resultSet = new HashSet<String>();
        resultSet = dao.getUniqueDate();
        boolean testDate = resultSet.contains("01011900");
        Assert.assertTrue(testDate);
        
    
    }
    
    
}
