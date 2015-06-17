/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_logic.CanHazTable;
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
public class CanHazTableTest {
    CanHazTable testTable;
    
    public CanHazTableTest() {
      //default constructor 
    }

    @Before
    public void setUp() {
        testTable = new CanHazTable();  
    }
    
    @After
    public void tearDown() {
    }

  
    
    @Test //CanHazTable(5, 10) → 2
    public void Test5and10() {
    int yourStyle= 5;
    int dateStyle=10;
    int result = testTable.canHazTable(yourStyle, dateStyle);
    Assert.assertEquals(2, result);
    }
   
    
    @Test //CanHazTable(5, 2) → 0
    public void test5and2() {
    int yourStyle= 5;
    int dateStyle=2;
    int result = testTable.canHazTable(yourStyle, dateStyle);
    Assert.assertEquals(0, result);
    }
    
    
    @Test //CanHazTable(5, 5) → 1
    public void test5and5() {
    int yourStyle= 5;
    int dateStyle=5;
    int result = testTable.canHazTable(yourStyle, dateStyle);
    Assert.assertEquals(1, result);  
    } 
}