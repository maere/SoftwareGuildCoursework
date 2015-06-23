/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_loops.ArrayFront9;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ArrayFront9Test {
    
    ArrayFront9 testObj;
    
    public ArrayFront9Test() {
    }
 
    @Before
    public void setUp() {
        testObj = new ArrayFront9();
    }
    
    @After
    public void tearDown() {
    }

    
    // @Test
    // public void hello() {}
    
    @Test//ArrayFront9({1, 2, 9, 3, 4}) -> true
    public void nineIn3(){
       int [] testArray = {1, 2, 9, 3, 4}; 
       boolean result = testObj.ArrayFront9(testArray);
       Assert.assertTrue(result);
        
    }
    
    @Test//ArrayFront9({1, 2, 3, 4, 9}) -> false
    public void nineIn5(){
         int [] testArray = {1, 2, 3, 4, 9}; 
         boolean result = testObj.ArrayFront9(testArray);
         Assert.assertFalse(result);
    }
    
    @Test//ArrayFront9({1, 2, 3, 4, 5}) -> false
    public void noNine(){
        int [] testArray = {1, 2, 3, 4, 5};
        boolean result = testObj.ArrayFront9(testArray);
        Assert.assertFalse(result);
    }
  
}
