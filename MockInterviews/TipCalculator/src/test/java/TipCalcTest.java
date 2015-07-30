/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class TipCalcTest {
    
    private Calculator target;
    public TipCalcTest() {
    }

    @Before
    public void setUp() {
        target = new Calculator();
    }

    @After
    public void tearDown() {
    }

    //int add, takes in a string of numbers
    @Test
    public void shouldAddNumbers1_2_ReturnSum_3() throws Exception {
      
        int result = target.add("1,2");
        int expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAddNumbers1_2_3ReturnSum_6() throws Exception {
        
        int result = target.add("1,2,3");
        int expected = 6;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAllowForMultipleLineBreaksAsDelimitersWhenAdding() throws Exception {
        
        int result = target.add("1\n2", "\n");
        int expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAllowForMultipleLineBreaksAsDelimitersWhenAddingAsWellAsMultipleNumberReturns() throws Exception {
       
        int result = target.add("1\n2\n4", "\n");
        int expected = 7;
        Assert.assertEquals(expected, result);
    }
    
     @Test
    public void shouldThrowErrorMessageNegatives_Not_Allowed_withAllNegativeNumbersreturned() throws Exception {
       
        int result = target.add("1,-4,-2");
        Assert.fail("Negatives Not Allowed: -4,-2");
    }
    //call an add with -number: returns "negative not allowed" message
    //if there are multiple negative numbers shows them all in the error message
}
