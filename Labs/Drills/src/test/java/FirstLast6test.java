
import com.swcguild.drills.FirstLast6;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class FirstLast6test {
    
    
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
