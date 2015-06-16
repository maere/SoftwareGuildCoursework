/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills.Sum;
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
public class SumTest {
    //
    Sum mySumObj;
    
    @Before
    public void setUp() {
        mySumObj = new Sum();
    }
    
    @After
    public void tearDown() {
    }

    // The methods must be annotated with annotation @Test. For example:
    // @Test
    // public void hello() {}
    
    @Test
    public void oneTwoThree(){
    int[] numbers  = {1, 2, 3};
    int result = mySumObj.sum(numbers);
    Assert.assertEquals(6, result);
    }
    
    
    @Test
    public void five11and2(){
    int[] numbers  = {5, 11, 2};
    int result = mySumObj.sum(numbers);
    Assert.assertEquals(18, result);
    }
    
    @Test
    public void sevenAndZeros(){
    int[] numbers  = {7, 0, 0};
    int result = mySumObj.sum(numbers);
    Assert.assertEquals(7, result);
    }
    

}
/*
float result;
        result = myCalculator.add(2, 2);
        Assert.assertEquals(4, result, 0);


Sum({1, 2, 3}) -> 6
Sum({5, 11, 2}) -> 18
Sum({7, 0, 0}) -> 7
    
*/