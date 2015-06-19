/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_logic.CaughtSpeeding;
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
public class CaughtSpeedingTest {
    CaughtSpeeding carTestObj;
    
    public CaughtSpeedingTest() {
       //default constructor
    }
    
    
    @Before
    public void setUp() 
    {
        carTestObj = new CaughtSpeeding();
    }
    
    @After
    public void tearDown() 
    {
        
    }

   @Test
//CaughtSpeeding(60, false) → 0
    
    @Test
//CaughtSpeeding(65, false) → 1
    
    @Test
//CaughtSpeeding(65, true) → 0
    
    // @Test
    // public void hello() {}
}
