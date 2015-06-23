/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.drills_loops.StringX;
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
public class StringXTest {

    StringX testObj;

    public StringXTest() {
    }

    @Before
    public void setUp() {
        //
        testObj = new StringX();
    }

    @After
    public void tearDown() {
    }

    // @Test
    // public void hello() {}
    @Test//StringX("xxHxix") -> "xHix"
    public void xBeginEndx() {
    }

    @Test //StringX("abxxxcd") -> "abcd"
    public void xMiddle() {
    }

    @Test//StringX("xabxxxcdx") -> "xabcdx"
    public void xMiddleAndEnd() {
    }

}
