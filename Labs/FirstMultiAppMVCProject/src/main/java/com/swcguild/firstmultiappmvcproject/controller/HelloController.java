package com.swcguild.firstmultiappmvcproject.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/hello"}) //everything slash hello comes to this controller
public class HelloController {
        
    public HelloController() {
    }
    
    @RequestMapping(value="/sayhi", method=RequestMethod.GET)//anything that is relative to this path comes to this method
    
    public String sayHi(Map<String, Object> model) { //this method takes a model to interact with 
        model.put("message", "Hello from the controller" ); //it also puts a message to the model
        
        return "hello";  //this method returns the view to the user -- hello.jsp view --  suffix, prefix set up allows uys to do this 
                         
                                    //this is the equivalent of the requestDispatcher("hello.jsp")- Spring now handles the *response for us with this return
        
    }
}
