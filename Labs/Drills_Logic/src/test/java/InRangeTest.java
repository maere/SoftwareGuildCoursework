/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_logic.InRange;
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
public class InRangeTest {

    InRange testObj;

    public InRangeTest() {
        //default
    }

    @Before
    public void setUp() {
        testObj = new InRange();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test //InRange(5, false) → true
    public void fiveAndFalse() {
        boolean result = testObj.InRange(5, false);
        Assert.assertTrue(result);
    }

    @Test //InRange(11, false) → false
    public void elevenAndFalse(){
        boolean result = testObj.InRange(11, false);
        Assert.assertFalse(result);
    
    }

    @Test //InRange(11, true) → true
    public void elevenAndTrue(){
        boolean result = testObj.InRange(11, true);
        Assert.assertTrue(result);
    }

  

}
