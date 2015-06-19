/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interfaceexample;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        Colorable ball = new Ball(); //similar to a base class -- we are assigning
        ball.setColor("Purple");
        System.out.println("Start wearing " + ball.getColor());
        
        //we cast ball as Debuggable--will get its methods after the dot
        ((Debuggable)ball).displayError("It worked!"); //"we are looking at this through this prism--temporarily
        Debuggable test = (Debuggable) ball;//we are now looking at this through this prism, permanently 
        test.displayStatus("123WIN");
        
//can also change the above now to: Debuggable test = (DebugLogging) ball; -- woudl work
            //but better is:
        DebugLogging log = (DebugLogging) ball;
        
        //but we couldn't Debuggable test = ball; -- because it's of type 
   
        log.logError(""); //now we get both log error, and display error options
        
    }
    
}
