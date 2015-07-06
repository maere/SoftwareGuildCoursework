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
public class GenLinkedListQueueTest {

    public GenLinkedListQueueTest() {
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
    public void isSize() {
        System.out.println("What is the size? Is it accurate?");
        GenLinkedListQueue<String> testQ = new GenLinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            String item = "hello" + i;
            testQ.enqueue(item);
        }
        int result = testQ.size();
        assertEquals(5, result);
    }

    @Test
    public void isEmpty() {
        System.out.println("What is the size? Is it accurate?");
        GenLinkedListQueue<String> testQ = new GenLinkedListQueue<>();
        assertTrue(testQ.isEmpty());

    }

    @Test
    public void enqueFirstTest() {
        System.out.println("Can we add nodes to our queue?---");
        GenLinkedListQueue<String> testQ = new GenLinkedListQueue<>();

        testQ.enqueue("apple");
        int result = testQ.size();
        Assert.assertEquals(1, result);
    }

    @Test
    public void dQFirstTest() {
        System.out.println("Can we add and then subtract an item?");
        GenLinkedListQueue<String> testQ = new GenLinkedListQueue<>();

        testQ.enqueue("apple");
        testQ.dequeue();
        boolean result = testQ.isEmpty();
        Assert.assertTrue(result);
    }

    @Test // multiple enquue/ deque
    public void testMultiples() {
        System.out.println("Can we add & subtract multiples?");
        GenLinkedListQueue<String> testQ = new GenLinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            String item = "hello" + i;
            testQ.enqueue(item);
        }

        for (int i = 0; i < 5; i++) {
            testQ.dequeue();
        }

        int result = testQ.size();
        Assert.assertEquals(5, result);

    }

    @Test
    public void testIterator() {
        System.out.println("Can we iterate?");
        GenLinkedListQueue<String> testQ = new GenLinkedListQueue<>();

        Iterator iter = testQ.iterator();
        System.out.println("Test one hasNext:");
        Assert.assertTrue(!iter.hasNext());

        for (int i = 0; i < 5; i++) {
            String item = "hello" + i;
            testQ.enqueue(item);
        }

        int i = 0;
        while (iter.hasNext()) {
            String j = (String) iter.next();

            if (i == 0) {
                assertEquals("hello1", j);
            } else if (i == 1) {
                assertEquals("hello2", j);
            } else if (i == 2) {
                assertEquals("hello3", j);
            } else if (i == 4) {
                assertEquals("hello5", j);
            }
            i++;

        }
        assertTrue(!iter.hasNext());

    }

}//end tests
//
// for (int i = 0; i < 20; i++) {
//            Object item = "hello" +i;
//            instance.enqueue(item);
//        }
//
//        for (int i=0; i<5; i++){
//           instance.dequeue();
//        }
