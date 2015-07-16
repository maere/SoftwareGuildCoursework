/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.controller;

import com.swcguild.firstmultiappmvcproject.services.FlooringMasterMini;
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
public class FlooringCalcController {
    
     @RequestMapping(value="/FlooringCalcController", method=RequestMethod.GET) //get is when you "read" from DB
    public String displayFlooringCalcForm(HttpServletRequest request, Model model){ //this is a viewbag - a bucket to put data into so you have access it in your view
       

        return "flooringcalc";
        
    }
    
    
     @RequestMapping(value="/FlooringCalcController", method=RequestMethod.POST) //get is "read" from DB
    public String postFlooringToView(HttpServletRequest request, Model model){ //this is a viewbag - a bucket to put data into so you have access it in your view
       
     //grab the paramaters and convert into usable Types for calculations
        //instantiate and object to perform calcualtions on object of class
        //set attributes on the model   
       //return the view (and pass params to the view for display/output)
        
         FlooringMasterMini app;
        //get parameters from the request object & parse from strings
        String strLength = request.getParameter("length");
        Double length = Double.parseDouble(strLength);
        
        String strWidth = request.getParameter("width");
        Double width = Double.parseDouble(strWidth);
        
        String strCostPerSqFt = request.getParameter("costPerSqFt");
        Double costPerSqFt = Double.parseDouble(strCostPerSqFt);
        
        //app has needs these values
        app = new FlooringMasterMini(length, width, costPerSqFt);
        
        double roomArea = app.calculateArea(length, width);
        double currentMatCost = app.calculateMaterials(roomArea, costPerSqFt);
        double currentLaborCost = app.calculateLaborRate();
        double orderTotal = app.calcOrderTotal(currentLaborCost, currentMatCost);
        double timeToComplete = roomArea/20;
        
        //set attributes for the response using "attributeName", servletVar
        request.setAttribute("currentMatCost", currentMatCost);
        request.setAttribute("currentLaborCost", currentLaborCost);
        request.setAttribute("roomArea", roomArea);
        request.setAttribute("orderTotal", orderTotal);
        request.setAttribute("timeToComplete", timeToComplete);
        
        return "fcresponse";
        
    }
    
}
