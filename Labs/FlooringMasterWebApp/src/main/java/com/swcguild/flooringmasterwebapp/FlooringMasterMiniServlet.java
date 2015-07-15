/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterwebapp;

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
@WebServlet(name = "FlooringMasterMiniServlet", urlPatterns = {"/FlooringMasterMiniServlet"})
public class FlooringMasterMiniServlet extends HttpServlet {

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
        
        //send back the response via a dispatcher object
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);
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
