/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import com.swcguild.flooringmasterylab.dto.Order;
import com.swcguild.flooringmasterylab.operations.OrderFactory;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class OrderFactorUnitTest {

    OrderFactory factoryObj;

    public OrderFactorUnitTest() {

    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        factoryObj = ctx.getBean("orderFactory", OrderFactory.class);
        //because we have an orderFactory bean already with constructor args set up for our main class, we don't need to craete anything again in the test
        //we just reference the bean, adn the constructor-args will instantiate the other classes we need when we inject it here

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreateFinalOrder() { //you never need to pass anything into a test -- it all gest done below

        String lastName = "Sweeney";
        double length = 11;
        double width = 10;
        String flooringType = "Wood";
        String state = "OH";
        String date = "06272015";

        Order order = factoryObj.createFinalOrder(lastName, length, width, flooringType, state, date);
        Assert.assertEquals(lastName, order.getLastName());
       

    }

    @Test
    public void testCreateEditedOrder() {
        //use factory to create final order
        
          //set - buildign orig order
        String lastName = "Sweeney";
        double length = 11;
        double width = 10;
        String flooringType = "Wood";
        String state = "OH";
        String date = "06272015";

        Order order = factoryObj.createFinalOrder(lastName, length, width, flooringType, state, date);
        order.setState("MI");
        double expectedResult = order.getTotalCost();
        //act - just testing the method, usually one line - this is the call taht matthers
        Order orderResult = factoryObj.createEditedOrder(order);
       
        //assert
        Assert.assertTrue(expectedResult!=orderResult.getTotalCost());
    
    }
}
