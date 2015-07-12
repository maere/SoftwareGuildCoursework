/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevenswebapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "LuckySevensServlet", urlPatterns = {"/LuckySevensServlet"})
public class LuckySevensServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //declare LuckySevens object
        LuckySevensRefactored game;
        
        //get amount of money for bet
        String playerMoneyString = request.getParameter("playerBet");
        int playerMoney = Integer.parseInt(playerMoneyString);
        
        //instantiate & initialize 
        game = new LuckySevensRefactored(0,0,0,playerMoney);
        
        //call the getPlayerMoney method on object
        //int result =
                game.playOn();
                
    
        //return the resulting parameter(s) to the program
        int rolls= game.getRollsCounter(); //this worked
                
        //int peak = game.getPeakRolls(); //tried moving Peak&Max into the playOn loop as void methods that checked  values
        int highDollar = game.getMaxMoney();
        int peak = game.getPeakRolls();
        
        // go to the Jsp which isiplays our response called "response.jsp" -- will take in the param "myAnswer"
        //request.setAttribute("message", result); // message we put in brackets in our jsp is  == to this first "message"
        request.setAttribute("peak", peak);                
        request.setAttribute("rolls", rolls); 
        request.setAttribute("highDollar", highDollar); 
        
            RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
            rd.forward(request, response); //this dispatcher dude just keeps forwarding messages
            
    }
        
        //pass back the 
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
