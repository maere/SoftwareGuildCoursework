/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_conditionals.AreWeInTrouble;
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
public class AreWeInTroubleTest2 {
    AreWeInTrouble myTestObject;
    
    public AreWeInTroubleTest2() {
        //create object to test on
        //AreWeInTrouble myTestObject;
    }
    
  
    @Before
    public void setUp() {
        //instantiate
        AreWeInTrouble myTestObject = new AreWeInTrouble();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // @Test
    // public void hello() {}
    
    @Test //AreWeInTrouble(true, true) -> true
    public void trueTrue(){
        boolean aSmile = true;
        boolean bSmile = true;
        boolean result = myTestObject.areWeInTrouble(aSmile, bSmile);
        Assert.assertEquals(result, true);
    }
    
    @Test //AreWeInTrouble(false, false) -> true
    public void falseFalse(){
        boolean aSmile = false;
        boolean bSmile = false;
        boolean result = myTestObject.areWeInTrouble(aSmile, bSmile);
        Assert.assertEquals(result, true);
        //Assert.assertTrue
    
    }
    
    @Test //AreWeInTrouble(true, false) -> false
    public void trueFalse(){
        boolean aSmile = true;
        boolean bSmile = false;
        boolean result = myTestObject.areWeInTrouble(aSmile, bSmile);
        Assert.assertEquals(result, false);
        
        //Assert.AssertFalse
    
    }
    
    
    
}
