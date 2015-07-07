/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws IOException {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       //don't have a controller yet, so will need to define one here
       DvdLibraryController control = ctx.getBean("controller", DvdLibraryController.class); //params are bean id and class name
       
       
       control.run();
       //our controller class will need to have a constructor that takes in a parameter of DVDLibraryDoa interface
       //will not call New on any of our controllers or DAOs --everything will be made be spring
       
       
       
       
    }
    
}
