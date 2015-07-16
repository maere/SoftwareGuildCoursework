/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.controller;

import com.swcguild.firstmultiappmvcproject.services.TipCalculator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class TipCalcController {
    
     @RequestMapping(value="/TipCalcController", method=RequestMethod.GET) //get is "read" from DB
    public String displayTipForm(HttpServletRequest request, Model model){ //this is a viewbag - a bucket to put data into so you have access it in your view
       
     //all this method does is give  you the form entry page for lucky sevens from the DB
        return "tipcalc";
    }
    
    @RequestMapping(value="/TipCalcController", method=RequestMethod.POST)
    public String returnTipCalcResults(HttpServletRequest request, Model model){
        
        
        //get parameters from the request
        String strService = request.getParameter("amountOfService");
        double service = Double.parseDouble(strService);
        
        String strTip = request.getParameter("tipPercentage");
        double percentage = Double.parseDouble(strTip); 

        //make object to run calculations
        TipCalculator calcObj = new TipCalculator(service, percentage);//should it require params for constructor--yes
        double currentTip = calcObj.calculateTip(); //dblTip -- tried to format
        
        //format object to two decimal places
        //tring currentTip = calcObj.roundValue(dblTip);
        
        
        //set attributes 
        request.setAttribute("tip", currentTip);
        //request.setAttribute("", total);
        
        return "tcresponse";
    
    }
    
}
