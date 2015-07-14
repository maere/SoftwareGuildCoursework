/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizerwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "FactorizerServlet", urlPatterns = {"/", "/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

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

        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response); //this dispatcher dude just keeps forwarding messages

        
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
        RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
        rd.forward(request, response); 
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
