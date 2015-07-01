/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ArrayStackTest {

    public ArrayStackTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayStack instance = new ArrayStack();
        instance.push("representation of string object");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertTrue(!result);

    }

    /**
     * Test of size method, of class ArrayStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayStack instance = new ArrayStack();
        instance.push("representation of string object");
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void OverStackSize() {
        System.out.println("Pushing 56items to default stack of 4");
        ArrayStack instance = new ArrayStack();
        instance.push("0");
        instance.push("1");
        instance.push("2");
        instance.push("3");
        instance.push("4");
        instance.push("5");
     
        int result = instance.size();
        int expResult = 6;
        assertEquals(expResult, result);
    }

    /**
     * Test of push method, of class ArrayStack. //
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object item = "HAPPY TEST";
        ArrayStack instance = new ArrayStack();
        instance.push(item);
        boolean result = instance.isEmpty();
        Assert.assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of pop method, of class ArrayStack.
//     */

    @Test
    public void testPop() {
        System.out.println("pop");
        ArrayStack instance = new ArrayStack();

        instance.push("string");

        String result = (String) instance.pop();//can also do Object (because to the compiler it will just be a random object--it will not investigate)

        String expResult = "string";  //then this would also be object

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class ArrayStack.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        ArrayStack instance = new ArrayStack();

        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
