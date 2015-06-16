/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills.SameFirstLast2;
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
@Suite.SuiteClasses({FirstLast6test.class, DrillsTestSuite.class})
public class SameFirstLast2test {

    //declare field;
    SameFirstLast2 mySameFirstLast;

    @Before
    public void setUp() throws Exception {
    //instantiate test Object
        mySameFirstLast = new SameFirstLast2();
        
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void onlyFirst(){
        int [] numbers = {1, 2, 3};
        boolean result;
        result = mySameFirstLast.sameFirstLast(numbers);
        Assert.assertFalse(result);
    
    }
    
    @Test
    public void bothFirstLastEven(){
       int [] numbers = {1, 2, 3, 1};
        boolean result;
        result = mySameFirstLast.sameFirstLast(numbers);
        Assert.assertTrue(result);
    
    }
    
    @Test
    public void bothFirstLastOdd(){
        int [] numbers = {1,2,1};
        boolean result;
        result = mySameFirstLast.sameFirstLast(numbers);
        Assert.assertTrue(result);
    
    }
    
    
}
/*
Given an array of ints, return true if the array is length 1 or more, 
and the first element and the last element are equal. 

SameFirstLast({1, 2, 3}) -> false
SameFirstLast({1, 2, 3, 1}) -> true
SameFirstLast({1, 2, 1}) -> true

public boolean SameFirstLast(int[] numbers) {

}

*/