/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.olympian.SkiJumper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*; //if we use this, it will know all the methods and we can write assertEquals
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//without the Assert.--but it will not give us the fill in the blank stufff

/**
 *
 * @author apprentice
 */
public class OlympianTest {
    
    public OlympianTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void SkiJumperTest(){ //this tested our POJO
        SkiJumper jumper = new SkiJumper();
        assertEquals(jumper.competeInEvent(), "SkiJump"); //so skipped separate construction
    }
    
    @Test //this tests our Spring implementation
    public void SpringSkiJumperTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkiJumper sj = ctx.getBean("superSkiJumper", SkiJumper.class);
        assertEquals("SkiJump", sj.competeInEvent());
    } 
    
//    @Test
//    public void SpeedSkateTest(){
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SpeedSkate skater = ctx.getBean("", SpeedSkateEvent.class);
//        assertEquals("", skater.competeInEvent());
//    }
    
//    @Test
//    public void CrossCountrySkiTest(){
//        
//    }
//    
//    @Test
//    public void 
    
            
}
