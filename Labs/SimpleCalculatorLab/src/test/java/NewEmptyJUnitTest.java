/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.simplecalculatorlab.SimpleCalculator;
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
public class NewEmptyJUnitTest {
    //declare field/var of Type for the JUnit test and test all methods in this class
    SimpleCalculator myCalculator;

    
    public NewEmptyJUnitTest() {
        
        
    }
    
   //ignore the Before and After
    @Before
    public void setUp() {
        //instantiate the object
        myCalculator = new SimpleCalculator();

        
    }
    
    @After
    public void tearDown() {
        
    }
    //----------------------------------------------------------------
    // ADD TEST METHODS (aka method tests)
   
    // @Test
    // public void hello() {}
    
    //first test 
    @Test
    public void test2and2are4(){ //method name can't start w. number needs, lowercase
        float result;
        result = myCalculator.add(2, 2);
        Assert.assertEquals(4, result, 0);
    
    }
    @Test
    public void test10minus2(){
        float result;
        result = myCalculator.subtract(10, 2);
        Assert.assertEquals(8.0, result, 0);
    }
    
    /*
    @Test -- wants me to cast .5 to an integer (??)
    public void test100timespoint5(){
        double result;
        result = myCalculator.multilply(100, 0.50);
        Assert.assertEquals(50, result);
    }
    */
    @Test
    public void test3time11(){
        float result;
        result = myCalculator.multilply(3, 11);
        Assert.assertEquals(33.0, result, 0); // can also skip result and just input myCalculator.multilply(3, 11),
    }
    
    
    @Test
    public void test100dividedBy20(){
        float result;
        result = myCalculator.divide(100, 20);
        Assert.assertEquals(5, result, 0);
        
    }
}
//method name should match the test you're attempting and be lower letter
//all returns are void
// all declarations need to match Type (i.e. double result, int result, boolean result)