/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.controller;

import com.swcguild.firstmultiappmvcproject.services.LuckySevensRefactored;
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
public class LuckySevensController {
    
    @RequestMapping(value="/LuckySevensController", method=RequestMethod.GET) //get is "read" from DB
    public String displayLuckySevensForm(HttpServletRequest request, Model model){ //this is a viewbag - a bucket to put data into so you have access it in your view
       
     //all this method does is give  you the form entry page for lucky sevens from the DB
        return "luckysevens";
        
    }
    
    //get and post always go to the controller to get routed (GET, POST, DELETE, AND PUT) (delete is delete, and put is update)
    @RequestMapping(value="/LuckySevensController", method=RequestMethod.POST) //insert into DB
    public String lsInputForm(HttpServletRequest request, Model model){
            
        //declare LuckySevens object
        LuckySevensRefactored game;   
        
       //get amount of money for bet--replaces getPlayerMoney
        String playerMoneyString = request.getParameter("playerBet");
        Integer playerMoney = Integer.parseInt(playerMoneyString);
        
        
        //need error handling--this isn't it!
//        if(!(playerMoney>0 && playerMoney instanceof Integer)){
//            System.out.println("There has been an error with your input.");
//        }
//        
        //instantiate & initialize 
        game = new LuckySevensRefactored(0,0,0,playerMoney);
        
         //start the game
        game.getPlayerMoney(playerMoney);
        game.playOn();
        game.outOfMoney();
       //playerReport() is replaced by the View--will need to set up variable for that
    
        
        //return the resulting parameter(s) to the program
        int rolls= game.getRollsCounter(); //this worked               
  
        int peak = game.getPeakRolls(); //this isn't registering on the view
        //int peak = game.getPeakRolls(); //tried moving Peak&Max into the playOn loop as void methods that checked  values
        
        int highDollar = game.getMaxMoney();
        

        //add attributes to teh model, will include handle for view to grab as you have in the Servlet
        // go to the Jsp which isiplays our response called "response.jsp" -- will take in the param "myAnswer"
        //request.setAttribute("message", result); // message we put in brackets in our jsp is  == to this first "message"
        request.setAttribute("AppPeak", peak);                
        request.setAttribute("AppRolls", rolls); 
        request.setAttribute("AppHighDollar", highDollar); 
    
        return "lsresponse";
    }//end post
    

}//end class


