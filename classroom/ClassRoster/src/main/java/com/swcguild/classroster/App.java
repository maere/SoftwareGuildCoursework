/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classroster;

import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws IOException {
        //instantiate an instance off the contorller -- this is all our app class will ever need to do
        ClassRosterController controller = new ClassRosterController();
        controller.run();
    }
    
}
