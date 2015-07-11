
package com.swcguild.hellomvcspringmvcwebapp;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/hello"})//this router mapping is optional
public class HelloController {
        
    public HelloController() {
    }
    //the method route mapping is NOT optional, tells the router how to resolve this value with the get method
    @RequestMapping(value="/sayhi", method=RequestMethod.GET)
    public String sayHi(Map<String, Object> model) {//map with string the jsp will look for, the object in our model
        
        model.put("message", "Hello from the controller" );//putting this into memory --this string
        return "hello";
    }
}
