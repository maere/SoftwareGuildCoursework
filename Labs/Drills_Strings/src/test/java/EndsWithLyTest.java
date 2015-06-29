/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class EndsWithLyTest {

    EndsWithLy myTestObj;

    public EndsWithLyTest() {
    }

    @Before
    public void setUp() {
     myTestObj = new EndsWithLy();
    }
        

    @After
    public void tearDown() {
    }

    @Test //EndsWithLy("oddly") -> true
    public void oddly() {
        boolean result = myTestObj.EndsWithLy("oddly");
        Assert.assertTrue(result);  
    }

    @Test//EndsWithLy("y") -> false
    public void y() {
        boolean result = myTestObj.EndsWithLy("y");
        Assert.assertFalse(result);
    }

    @Test//EndsWithLy("oddy") -> false
    public void oddy() {
        boolean result = myTestObj.EndsWithLy("oddy");
        Assert.assertFalse(result);

    }

    // public void hello() {}
}
