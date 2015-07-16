package com.swcguild.firstmultiappmvcproject.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// we only need the @RequestMapping on the class, if we want something in the route to proceeed the route on the method below---@RequestMapping({"/homecontroller"}) 
//everything after slash comes to this controller
@Controller
public class HomeController {
        
    public HomeController() {
    }
 
    
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)//anything that is relative to this path (from above, if we have in class) comes to this method
     public String displayHomePage(){
         
         
        return "home";  //this will return home.jsp as the responese
                        //this replaces requestDispatcher's response.jsp in the servlet
    }
}
/* example one:
 
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)//anything that is relative to this path (from above, if we have in class) comes to this method
     public String displayHomePage(){
         
         
        return "home";  //this will return home.jsp as the responese
                        //this replaces requestDispatcher's response.jsp in the servlet
    }

example 2:
Note there is one method for the get and one for the post for each page/controller

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


*/