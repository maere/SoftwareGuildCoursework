/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        //we will pass in the name of the file we just created
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");   
        
        
        //we create skijumper object--we have to do create an object to apply the bean to
        //or can do  SkiJumper sj = (SkiJumper) ctx.getBean("superSkiJumper");
        SkiJumper sj = ctx.getBean("superSkiJumper", SkiJumper.class);
        //it's better to do it the second way, becuase we cast it at runtime....
        sj.competeInEvent(); //then they compete
        
        //we are doing all of this by hand, but is still DepInjection....
        //bc we have the opp to make various Olympians...not just one. Is abstracted.
//        Event skiJumpEvent = new SkiJumpEvent();
//        Olympian olympianSkiJumper = new Olympian(skiJumpEvent);
//        olympianSkiJumper.competeInEvent();
//        
//        
        
        
        System.out.println("--------------------------------------------------");
        //let's make two more events for Olympians--we have to make the classes first
        Olympian usaSkiJumper = ctx.getBean("usaSkiJumper", Olympian.class); //inject skiJumping into an olympian
        usaSkiJumper.competeInEvent();
        //we are asking applicationContext to make these for us
        Olympian usaSpeedSkater = ctx.getBean("usaSpeedSkater", Olympian.class); //string to string - this brings back an Olympian object
        usaSpeedSkater.competeInEvent(); //we can now call this, bc the Event interface has this method
        
        Olympian canadaSpeedSkater = ctx.getBean("canadaSpeedSkater", Olympian.class);
        canadaSpeedSkater.competeInEvent();
        
        
//default behavior is this whole event ordeal....



//Event speedSkateEvent = new SpeedSkateEvent();
        
    }
    
}
