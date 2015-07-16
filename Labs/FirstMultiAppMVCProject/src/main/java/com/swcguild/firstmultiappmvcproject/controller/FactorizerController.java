/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.controller;

import com.swcguild.firstmultiappmvcproject.services.FactorizerRefactor;
import java.util.ArrayList;
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
public class FactorizerController {
    
    
     @RequestMapping(value="/FactorizerController", method=RequestMethod.GET) //get is "read" from DB
    public String displayFactorizerForm(HttpServletRequest request, Model model){ //this is a viewbag - a bucket to put data into so you have access it in your view
       
     //all this method does is give  you the form entry page for lucky sevens from the DB
        return "factorizer";
    }
    
    @RequestMapping(value="/FactorizerController", method=RequestMethod.POST)
    public String FactorizerFormResponse(HttpServletRequest request, Model model){
        
        
        FactorizerRefactor factorizerInstance; 
        
        String strNumber = request.getParameter("userNum");
        Integer number = Integer.parseInt(strNumber);
        
        factorizerInstance = new FactorizerRefactor(number);
        
        //now we have an object of the class we can call our methods on
        //factorizerInstance.queryNum();
        factorizerInstance.gatherResultsArray();
        boolean isPerfect = factorizerInstance.perfectNums();
        boolean isPrime = factorizerInstance.primeNums();
        //factorizerInstance.printResult();
        
       
        int factors = factorizerInstance.factorArray[2];
        
        ArrayList<Integer> allFactorsList = factorizerInstance.gatherResultsArray();
        
        // go to the Jsp which isiplays our response called "response.jsp" -- will take in the param "myAnswer"
        //request.setAttribute("message", result); // message we put in brackets in our jsp is  == to this first "message"
        request.setAttribute("number", strNumber);
        request.setAttribute("numOfFactors", factors);
        request.setAttribute("boolPerfect", isPerfect); //boolPerfect is what we pass to JSP *NOT* isPerfect--isPerfect is for the servlet
        request.setAttribute("boolPrime", isPrime);
        request.setAttribute("list", allFactorsList);

        
        return "factresponse";
    }
    
    
}
