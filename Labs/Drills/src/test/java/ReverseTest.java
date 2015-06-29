/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills.Reverse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ReverseTest {
    Reverse testObj;
    
    public ReverseTest() {
    }
   
    
    @Before
    public void setUp() {
        testObj = new Reverse();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void threeItems() {
    int [] guide = {3,2,1};    
    int [] params = {1, 2, 3};
    int [] result = testObj.reverse(params);
    Assert.assertArrayEquals(guide, result);
    
    }
    
    
    
    
    
}
