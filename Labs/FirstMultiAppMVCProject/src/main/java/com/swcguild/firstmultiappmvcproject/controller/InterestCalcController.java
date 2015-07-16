/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.controller;

import com.swcguild.firstmultiappmvcproject.model.FiscalYear;
import com.swcguild.firstmultiappmvcproject.services.InterestCalcRf;
import java.util.List;
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
public class InterestCalcController {

    @RequestMapping(value = "/InterestCalcController", method = RequestMethod.GET) //get is "read" from DB
    public String displayInterestCalcForm(HttpServletRequest request, Model model) { //this is a viewbag - a bucket to put data into so you have access it in your view

        //all this method does is give  you the form entry page for lucky sevens from the DB
        return "interestcalc";
        
    }

    @RequestMapping(value = "/InterestCalcController", method = RequestMethod.POST) //get is "read" from DB
    public String postInterestCalculations(HttpServletRequest request, Model model) { //this is a viewbag - a bucket to put data into so you have access it in your view
    
        //declare object of the class
        InterestCalcRf calculatorObj;
      
        //this is the input sent from the user/use request  object (the params submitted) to work with 
        String strMoney = request.getParameter("moneyInvested");
        String strYears = request.getParameter("yearsInvested");
        String strRate =  request.getParameter("interestRate");
        
        float currentBalance = Float.parseFloat(strMoney);
        int years = Integer.parseInt(strYears);
        float intRate = Float.parseFloat(strRate);
        
        //instantiate object & set the initial params to run the method(s)
        calculatorObj = new InterestCalcRf(currentBalance, years, intRate);
    
        List<FiscalYear> list = calculatorObj.EOY();
  
        request.setAttribute("list",list);
    
        return "icresponse";
    }

}
