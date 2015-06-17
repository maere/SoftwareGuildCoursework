/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_conditionals.Front3;
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
public class Front3Test {

    private Front3 testObjF;

    public Front3Test() {

    }

    @Before
    public void setUp() {
        testObjF = new Front3();
    }

    @After
    public void tearDown() {
    }

    @Test
    // public void hello() {}
    public void Microsoft() {
        String str = "Microsoft";
        String result = testObjF.front3(str);
        Assert.assertEquals("MicMicMic", result);
    }

    @Test
    public void Chocolate() {
        String str = "Chocolate";
        String result = testObjF.front3(str);
        Assert.assertEquals("ChoChoCho", result);
    }

    @Test
    public void at() {
        String str = "at";
        String result = testObjF.front3(str);
        Assert.assertEquals("atatat", result);
    }

}
//Front3("Microsoft") -> "MicMicMic"
//Front3("Chocolate") -> "ChoChoCho"
//Front3("at") -> "atatat"
