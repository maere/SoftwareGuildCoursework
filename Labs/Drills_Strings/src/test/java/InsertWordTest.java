/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class InsertWordTest {
    InsertWord testObj;
    
    public InsertWordTest() {
    }
    
    
    @Before
    public void setUp() {
        testObj  = new InsertWord(); 
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
   
    @Test //InsertWord("<<>>", "Yay") -> "<<Yay>>"
    public void Yay() {
    String actual = "<<Yay>>";
    String result = testObj.InsertWord("<<>>", "Yay");
    Assert.assertEquals(result, actual);
    }
    
    @Test //InsertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    public void WooHoo(){
    String actual = "<<WooHoo>>";
    String result = testObj.InsertWord("<<>>", "WooHoo");
    Assert.assertEquals(result, actual);
    }
    
    @Test //InsertWord("[[]]", "word") -> "[[word]]"
    public void word(){
    String actual = "[[word]]";
    String result = testObj.InsertWord("[[]]", "word");
    Assert.assertEquals(result, actual);
    
    }
    
    
}



