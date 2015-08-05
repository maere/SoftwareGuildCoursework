/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.codingbatproblems.CountXXes;
import com.swcguild.codingbatproblems.MakeTags;
import com.swcguild.codingbatproblems.MonkeyPlay;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class CodingBatTests {

    public CodingBatTests() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void MonkeyTest() {

        MonkeyPlay runnerObj = new MonkeyPlay();
//        monkeyPlay(true, true) → true
//        monkeyPlay(true, false) → false
        boolean result1 = runnerObj.monkeyTrouble(true, true);
        Assert.assertTrue(result1);

        boolean result2 = runnerObj.monkeyTrouble(true, false);
        Assert.assertFalse(result2);

    }

    @Test
    public void MakeTagsTest() {
//        makeTags("i", "Yay") → "<i>Yay</i>"
//        makeTags("i", "Hello") → "<i>Hello</i>"
//        makeTags("cite", "Yay") → "<cite>Yay</cite>"

        String expected = "<cite>Yay</cite>";
        MakeTags runnerObj = new MakeTags();
        
        String actual = runnerObj.makeTags("cite", "Yay");
        Assert.assertEquals(expected, actual);

    }
    
//    countXX("abcxx") → 1
//    countXX("xxx") → 2
//    countXX("xxxx") → 3
    @Test
    public void CountXXTests(){
        
    CountXXes testObj = new CountXXes();
    
    int exp1 = 1;
    int exp2 = 2;
    int exp3 = 3;
    int exp4 = 2;
    
    int r1 = testObj.countXX("abcxx");
    int r2 = testObj.countXX("xxx");
    int r3 = testObj.countXX("xxxx");
    int r4 = testObj.countXX("Hexxo thxxe");
    
    Assert.assertEquals(exp1, r1);
    Assert.assertEquals(exp2, r2);
    Assert.assertEquals(exp3, r3);   
    Assert.assertEquals(exp4, r4);
    }


}
