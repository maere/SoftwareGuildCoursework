/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills.FirstLast6;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author apprentice
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class DrillsTestSuite {

     //set up field declaration-- variable for the class
     FirstLast6 myFirstLast; 

    @Before
    public void setUp() throws Exception {
        myFirstLast = new FirstLast6(); //move our constructor here
    }

    @After
    public void tearDown() throws Exception {
    }
   
    @Test
    public void sixLast(){
        int [] numbers = {1, 2, 6};
        boolean result;
        result = myFirstLast.firstLast6(numbers);
        Assert.assertTrue(result);
        
    
    }
    
    
    @Test
    public void sixFirst(){
        int [] numbers = {6, 1, 2, 3};
        boolean result;
        result = myFirstLast.firstLast6(numbers);
        Assert.assertTrue(result);
    
    }
    
    
    @Test
    public void sixMiddle(){
        int [] numbers = {13, 6, 1, 2, 3};
        boolean result;
        result = myFirstLast.firstLast6(numbers);
    
    }
     
}
  /*  
 @Test
    public void greatPartyWith30AndWeekday(){
        boolean result;
        result = myparty.greatParty(30, false); //we've change the test....we now want it to return true - so we need to change code!
        Assert.assertFalse(result);  
    }

@Test
    public void greatPartyGuests(){
        boolean result;
        result = myparty.numberOfGuests();
        Assert.assertEquals(result >15 && result <50);
    }
    
  */
