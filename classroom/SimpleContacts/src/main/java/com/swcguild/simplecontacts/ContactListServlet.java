/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecontacts;

import com.swcguild.simplecontacts.dao.ContactsDAO;
import com.swcguild.simplecontacts.dao.ContactsDAOMockImpl;
import com.swcguild.simplecontacts.dto.Contact;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ContactListServlet", urlPatterns = {"/ContactListServlet"})
public class ContactListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // this Servlet is our controller -- just handles gets and posts and hooks it up to our view (jsp page) 
    //we have to write a method of HOW to process the request that doGet and doPost call for our particular apopp 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ContactsDAO dao = new ContactsDAOMockImpl(); //MockImpl gets instantiated here...
                                                    //this is how things get hooked up
                                                    //later we will use DI to do this...
        
        List<Contact> list = dao.getContacts();
        
        request.setAttribute("contactList", list);//we assign a string value to the parameter for 
                                                 //the list object so we can pass it to the jsp file to grab
        RequestDispatcher rd = request.getRequestDispatcher("contactList.jsp"); //this stuff will get sent to contactList.jsp
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
