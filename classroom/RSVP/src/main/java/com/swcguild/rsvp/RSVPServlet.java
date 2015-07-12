/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rsvp;

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
@WebServlet(name="RSVPServlet", urlPatterns ={"/RSVPServlet"})
public class RSVPServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            //this is like what we were doing with consoleIO and printing out lines
//            //this treats the browser like our console
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RSVPServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RSVPServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
             RequestDispatcher rd = request.getRequestDispatcher("entry.jsp"); //
             rd.forward(request, response);//we are customizing--got rid of the default: 
             //processRequest(request, response);
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
        
        //the stuff that comes back from the post--there are three values we are looking for--user may submit all or none
            String myAnswer = request.getParameter("myAnswer");//the request will always be an available object
            
            String myReason = request.getParameter("myReason");//we try to match the request to the parameter passed
            String myNotes = request.getParameter("myNotes");//processRequest(request, response);
    
    //<!--our response -->
            String message = ""; //instanitate bc we set in loop but want it available outside loop
            if ("No".equals(myAnswer)){
            message = "Sorry you can't make it.";
            }
            else {
            message = "Can't wait to see you";
            }   //now we have a value for our message that we will pass into our reponse
            
           // go to the Jsp which dsiplays our response called "response.jsp" -- will take in the param "myAnswer"
            request.setAttribute("message", message); // message we put in brackets in our jsp is  == to this first "message"
                                    //set the message attribute in the jsp to this message object
            
            RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
            rd.forward(request, response); //this dispatcher dude just keeps forwarding messages
            
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
