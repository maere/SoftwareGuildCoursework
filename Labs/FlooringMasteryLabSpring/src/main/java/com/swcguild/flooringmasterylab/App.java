/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws IOException {
          //need to instantiate the ctx and pass in applicationContext.xml
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    //instantiate instance of entry class via get bean
    OrderController controls = ctx.getBean("controller", OrderController.class);
    
    //call method in interface on object
     controls.run();
    }
  
    
}

