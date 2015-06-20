/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_logic.CaughtSpeeding;
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
public class CaughtSpeedingTest {

    CaughtSpeeding carTestObj;

    public CaughtSpeedingTest() {
        //default constructor
    }

    @Before
    public void setUp() {
        carTestObj = new CaughtSpeeding();
    }

    @After
    public void tearDown() {

    }

    @Test
//CaughtSpeeding(60, false) → 0
    public void test60andFalse() {
        int result = carTestObj.CaughtSpeeding(60, false);
        Assert.assertEquals(1, result);
    }

    @Test
//CaughtSpeeding(65, false) → 1
    public void test65andFalse() {
        int result = carTestObj.CaughtSpeeding(65, false);
        Assert.assertEquals(1, result);
    }

    @Test
//CaughtSpeeding(65, true) → 0
    public void test65andTrue() {
        int result = carTestObj.CaughtSpeeding(65, true);
        Assert.assertEquals(0, result);
    }

    // @Test
    // public void hello() {}
}
