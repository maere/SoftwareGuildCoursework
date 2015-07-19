/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeControllerNoAjax {
    
    private ContactListDao dao; // we create an instanbce of our dao class

    // //before we we forceing injextijn in xml file, now we are doing it through annoatation
    //tells spring to go to spring-persitstance, it will seek out bean an inject it for us
    @Inject    
    public HomeControllerNoAjax(ContactListDao dao) { //we pass in parameter of DAO
        this.dao = dao;
    }
    
    @RequestMapping(value = "/displayContactListNoAjax", method = RequestMethod.GET)
    public String displayContactListNoAjax(Model model) { //Type available in spring
        
        //the reference to the model is the param we pass in
        List<Contact> cList = dao.getAllContacts();
        
        //next we are going to add an attribute to our model
        model.addAttribute("contactList", cList); //this is how we are returning our element to our view 
        
        //(yesterday we used a map, today we are using a model) 
        //but the model gets used outside, in our view   
        return "displayContactListNoAjax";
    }

    //now we'll go back in and add our methods to match what we indicated in our displayContactListNoAjax.jsp
    @RequestMapping(value = "/displayNewContactFormNoAjax", method = RequestMethod.GET)
    public String displayNewContactFormNoAjax() {
        return "newContactFormNoAjax";   //make a jsp to match as well, copy home.jsp and paste into this new Jsp
    }
    
    @RequestMapping(value = "/addNewContactNoAjax", method = RequestMethod.POST)
    public String addNewContactNoAjax(HttpServletRequest req) {
                                                            //just made a form in the jsp to enter this stuff
        //going to pull all of the parameters we just created in the form jsp by name
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String company = req.getParameter("company");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        Contact contact = new Contact();

        //now we need to set the params that we got and set them to the object before we push 
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setCompany(company);
        contact.setEmail(email);
        contact.setPhone(phone);
        
        dao.addContact(contact);

        //new approach - the string we are returning is a redirect
        return "redirect:displayContactListNoAjax"; //before we were returning a string that would find a jsp view, but now
        //the redirect will initite calling the endpiont that is goign to transfer the results in vfalue
        //bc when we have addd a contact, the workflow is to go back ot the list
        
    }
    
    @RequestMapping(value = "/deleteContactNoAjax", method = RequestMethod.GET)
    public String deleteContactNoAjax(HttpServletRequest req) {
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        dao.removeContact(contactId);
        
        return "redirect:displayContactListNoAjax";
    }
    
    @RequestMapping(value = "/displayEditContactFormNoAjax", method = RequestMethod.GET)
    public String displayEditContactFormNoAjax(HttpServletRequest req, Model model) { //we are passing in both the request and the model
        
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        
        Contact contact = dao.getContactById(contactId);
        
        //tell model to add attributes
        model.addAttribute("contact", contact);
        
        return "editContactFormNoAjax"; //instead of using name="" in the jsp, we are going to use path=""
    }
    
     @RequestMapping(value = "/editContactNoAjax", method = RequestMethod.POST)
    public String editContactNoAjax(@Valid @ModelAttribute("contact") Contact contact, 
                                    BindingResult result) { //is always only one model, but the model itself coudl be complex
                            //this is the modelattribute="contact" that we passed in request the editContactForm.jsp
                            //it does reflection--I have a think that is goign to be named a certain way and I will match one-to-one and put the value in
        
        if(result.hasErrors()){
                            //we indicate that this is the method the validation applies to, and we also have but @annotations in our DTO on the fields to call out the fields we are validating
            return "editContactFormNoAjax";
                //we go back to this view again after it displays errors
                //now will go mess with our view (editContactFormNoAjax)
        }
        
        dao.updateContact(contact);
         return "redirect:displayContactListNoAjax";
    }
    
    /*
    Reflection is a very useful approach to deal with the Java class at runtime, it can be use to load the Java class, call its methods or analysis the class at runtime. In this example, you will load a class called “AppTest” and call each of its methods at runtime.Jan 17, 2010
How to use Reflection to call Java method at runtime
    */
}
