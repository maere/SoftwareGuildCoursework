/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_loops.StringTimes;
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
public class StringTimesTest {
    StringTimes testObj;
    
    public StringTimesTest() {
        
    }
    
   
    
    @Before
    public void setUp() {
        testObj = new StringTimes();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
   
    @Test//StringTimes("Hi", 2) -> "HiHi"
    public void twoHis() 
    {
       // String str = "Hi";
        //int n = 2;
        String result = testObj.stringTimes("Hi", 2);
        Assert.assertEquals("HiHi", result);
    
    }
    
    @Test//StringTimes("Hi", 3) -> "HiHiHi"
    public void threeHis() 
    {
        String result = testObj.stringTimes("Hi", 3);
        Assert.assertEquals("HiHiHi", result);
    
    }
    
    @Test//StringTimes("Hi", 1) -> "Hi"
    public void oneHi() 
    {
        String result = testObj.stringTimes("Hi", 1);
        Assert.assertEquals("Hi", result);
    
    }
    
    
    
}//end class
/*



*/