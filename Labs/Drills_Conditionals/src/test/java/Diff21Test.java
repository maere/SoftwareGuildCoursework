/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_conditionals.Diff21;
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
public class Diff21Test {
    Diff21 tester21;
   
    
    @Before
    public void setUp() {
         tester21 = new Diff21();
    }
    
    @After
    public void tearDown() {
    }

   //TESTS
    
    @Test //Diff21(23) -> 4
    public void test23(){
        int n=23;
        int result = tester21.Diff21(n);
        Assert.assertEquals(4, result);
       
    }
   
    @Test  //Diff21(10) -> 11
    public void test10(){
        int n=10;
        int result = tester21.Diff21(n);
        Assert.assertEquals(11, result);
    }
    
    @Test //Diff21(21) -> 0
    public void test0(){
        int n=21;
        int result = tester21.Diff21(n);
        Assert.assertEquals(0, result);
        
    }
}
/*



*/