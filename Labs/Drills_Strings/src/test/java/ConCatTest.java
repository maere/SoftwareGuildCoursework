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
public class ConCatTest {

    ConCat testObj;

    public ConCatTest() {
    }

    @Before
    public void setUp() {
        testObj = new ConCat();
    }

    @After
    public void tearDown() {
    }

    @Test //ConCat("abc", "cat") -> "abcat"
    public void abcCat() {
        String a = "abc";
        String b = "cat";
        String result = testObj.ConCat(a, b);
        Assert.assertEquals("abcat", result);

    }

    @Test //ConCat("dog", "cat") -> "dogcat"
    public void dogCat() {
        String a = "dog";
        String b = "cat";
        String result = testObj.ConCat(a, b);
        Assert.assertEquals("dogcat", result);

    }

    @Test //ConCat("abc", "") -> "abc"
    public void abcBlank() {
        String a = "abc";
        String b = "";
        String result = testObj.ConCat(a, b);
        Assert.assertEquals("abc", result);

    }

}
