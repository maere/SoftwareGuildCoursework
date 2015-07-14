/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculatorwebapp;

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
@WebServlet(name = "InterestCalcServlet", urlPatterns = {"/InterestCalcServlet"})
public class InterestCalcServlet extends HttpServlet {

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
        
        //declare object of the class
        InterestCalcRfDao calculatorObj;
      
        //this is the input sent from the user/use request  object (the params submitted) to work with 
        String strMoney = request.getParameter("moneyInvested");
        String strYears = request.getParameter("yearsInvested");
        String strRate =  request.getParameter("interestRate");
        
        float currentBalance = Float.parseFloat(strMoney);
        int years = Integer.parseInt(strYears);
        float intRate = Float.parseFloat(strRate);
        
        //instantiate object & set the initial params to run the method(s)
        calculatorObj = new InterestCalcRfDao(currentBalance, years, intRate);
    
        calculatorObj.EOY(); //would be easiest to get this to return an arrayList of objects with data for each year
                            //pushed into the object on each iteration
        
        //print outs are handled in the view
                    //with an Object, can just send back the list or 
        
        
        
        //return the params to the jsp, where you can // print out results in a for each loop
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response); //this dispatcher will just keeps forwarding messages 

        
    }

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
