/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
   
    //method dsiplay homepage -- these two "home" values are not directly related
                        //the first is the endpoint it is resolving from the UROL...
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)   //we need values for our potential endpoints--there are two values going in
                                        //this means that more than one URL can resolve to this endpoint
                                         //will hit web.xml first, if it doesn't find this file within our root folder
                                         //will go to router and look to resolve the route--this is our alternate default page
    // the 2nd param above comes from Spring framework - .web.bind.annoation -- method=RequestMethod.GET is an enum
    public String displayHomePage(){
        return "home"; //this will return home.jsp as the responese
                        //..this home will be passsed back and will have a .jsp added, but we haven't bulilt that page yet
    }
    
    //dispatcher will go look at all the request mapping annoations
    
    
}
