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
public class SearchController {
    @RequestMapping(value="/search", method=RequestMethod.GET) //because we only have one value we don't need {}
                                                                //the {} is for adding an array of values, comma delimited
    public String displaySearchPage(){
        return "search";
    }
    
    
    
}
