/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.com.datastructures.queue;

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
public class ArrayQueueTest {

    public ArrayQueueTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of enqueue method, of class ArrayQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object item = "hello";

        ArrayQueue instance = new ArrayQueue();
        instance.enqueue(item);
        int result = instance.size();
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertEquals(1, result);
    }

    @Test
    public void testEnqueueWithString() {
        System.out.println("enqueue");
        Object item = "hello";

        ArrayQueue instance = new ArrayQueue();
        instance.enqueue(item);
        boolean result = instance.isEmpty();
        // TODO review the generated test code and remove the default call to fail.
        Assert.assertFalse(result);
    }

    /**
     * Test of dequeue method, of class ArrayQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        ArrayQueue instance = new ArrayQueue();
        Object item1 = "hello1";
        Object item2 = "hello2";
        Object item3 = "hello3";
        instance.enqueue(item1);
        instance.enqueue(item2);
        instance.enqueue(item3);

        Object result = instance.dequeue();

        assertEquals(item1, result); //we are checking to see it return first item we added, 
        //becuase that will be the first out

    }

//    /**
//     * Test of isEmpty method, of class ArrayQueue.
//     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayQueue instance = new ArrayQueue();
        Object item1 = "hello1";
        instance.enqueue(item1);

        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

//    /**
//     * Test of size method, of class ArrayQueue.
//     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayQueue instance = new ArrayQueue();

        Object item1 = "hello1";
        Object item2 = "hello2";
        Object item3 = "hello3";
        instance.enqueue(item1);
        instance.enqueue(item2);
        instance.enqueue(item3);
        instance.dequeue();

        int expResult = 2;
        int result = instance.size();

        assertEquals(expResult, result);

    }

    @Test
    public void enqueueResize() {
        System.out.println("If we add an extra item bigger than array, resizes");
        ArrayQueue instance = new ArrayQueue();
        Object item1 = "hello1";
        Object item2 = "hello2";
        Object item3 = "hello3";
        Object item4 = "hello4";
        Object item5 = "hello5";
        Object item6 = "hello6";
        Object item7 = "hello7";
        Object item8 = "hello8";
        Object item9 = "hello9";
        Object item10 = "hello10";
        Object item11 = "hello11";

        instance.enqueue(item1);
        instance.enqueue(item2);
        instance.enqueue(item3);
        instance.enqueue(item4);
        instance.enqueue(item5);
        instance.enqueue(item6);
        instance.enqueue(item7);
        instance.enqueue(item8);
        instance.enqueue(item9);
        instance.enqueue(item10);
        instance.enqueue(item11);

        int result = instance.getItemsLength();
        int expResult = 20;

        assertEquals(expResult, result);

    }

    @Test
    public void testAdd10Subtract6() {
        System.out.println("If add 10 items, and remove none, does the head reset to 0?");
        ArrayQueue instance = new ArrayQueue();
        Object item1 = "hello1";
        Object item2 = "hello2";
        Object item3 = "hello3";
        Object item4 = "hello4";
        Object item5 = "hello5";
        Object item6 = "hello6";
        Object item7 = "hello7";
        Object item8 = "hello8";
        Object item9 = "hello9";
        Object item10 = "hello10";

        instance.enqueue(item1);
        instance.enqueue(item2);
        instance.enqueue(item3);
        instance.enqueue(item4);
        instance.enqueue(item5);
        instance.enqueue(item6);
        instance.enqueue(item7);
        instance.enqueue(item8);
        instance.enqueue(item9);
        instance.enqueue(item10);
        int result = instance.getHead();
        Assert.assertEquals(0, result);

    }

    @Test
    public void isSlotOneNullifWeDQhalf() {
        System.out.println("If we get to 10 adds, and 6 minuses, does it reset?");
        ArrayQueue instance = new ArrayQueue();
        Object item1 = "hello1";
        Object item2 = "hello2";
        Object item3 = "hello3";
        Object item4 = "hello4";
        Object item5 = "hello5";
        Object item6 = "hello6";
        Object item7 = "hello7";
        Object item8 = "hello8";
        Object item9 = "hello9";
        Object item10 = "hello10";

        instance.enqueue(item1);
        instance.enqueue(item2);
        instance.enqueue(item3);
        instance.enqueue(item4);
        instance.enqueue(item5);
        //instance.dequeue();
        instance.enqueue(item6);
        //instance.dequeue();
        instance.enqueue(item7);
        //instance.dequeue();
        instance.enqueue(item8);
        //instance.dequeue();
        instance.enqueue(item9);
        //instance.dequeue();
        instance.enqueue(item10);
                                // instance.dequeue();

        int result = instance.getHead();
        Assert.assertEquals(0, result);

    }

    /**
     * Test of iterator method, of class ArrayQueue.
     */
//    @Test
//    public void testIterator() {
//        System.out.println("iterator");
//        ArrayQueue instance = new ArrayQueue();
//        Iterator expResult = null;
//        Iterator result = instance.iterator();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
