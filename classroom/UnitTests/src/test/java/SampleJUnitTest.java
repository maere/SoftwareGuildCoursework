/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SampleJUnitTest {
    
    //set up field declaration-- variable for the class
     GreatParty myparty; 
 
     
//this allows us to do a "setup", before each method runs, the set up is gonna run before every single test...
    
    @Before //will run before test
    public void setUp() {
        
    myparty = new GreatParty(); //move our constructor here
        
    }
    
    // individual test gets run here it runs the test
    
    ///then it runs the after stuff to tear down
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test //annotation that signals to the compiler
    //public void greatPartyTest(){ //splitting these out into 4 tests
      public void greatPartyWith20CigarsAndWeekend(){  
        
      //GreatParty myParty = new GreatParty();
       //we moved this to the top of the class
       
        boolean result; //we separate our declaration and assignment bc we will have several results
        
  //    result = myParty.greatParty(70, true);  moved this to it's own test
    //  Assert.assertFalse(result);
        
        result = myparty.greatParty(20, true); //we've change the test....we now want it to return true - so we need to change code!
        Assert.assertTrue(result);
        
        //result = myParty.greatParty(20, true);
        //Assert.assertFalse(result);
        
        
    }
    @Test
    public void greatPartyWith30AndWeekday(){
        boolean result;
        result = myparty.greatParty(30, false); //we've change the test....we now want it to return true - so we need to change code!
        Assert.assertFalse(result);
        
    }
    
    @Test
    public void greatPartyWith50CigarsAndWeekday(){
        boolean result;
        result = myparty.greatParty(50, false);
        Assert.assertTrue(result);
    }
    
    @Test
    public void greatPartyWith70CigarsAndWeekday(){
        boolean result;
        result = myparty.greatParty(70, true);
        Assert.assertTrue(result);
    
    }
    
  /*  @Test
    public void greatPartyGuests(){
        boolean result;
        result = myparty.numberOfGuests();
        Assert.assertEquals(result >15 && result <50);
    }
    
  */
    

   // public SampleJUnitTest(GreatParty myparty) {
       // this.myparty = myparty;
    //}

    
}
