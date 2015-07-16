package com.swcguild.addressbookmvcapp.controller;

import com.swcguild.addressbookmvcapp.dao.AddressBookAPI;
import com.swcguild.addressbookmvcapp.dao.AddressBookImpl;
import com.swcguild.addressbookmvcapp.model.Address;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //the rule is: different model, different controller (same model, same controller)
@RequestMapping(value = "/")// this is the absolute path
public class HomeAddressBookController {

    private AddressBookAPI dao;

    @Inject
    public HomeAddressBookController(AddressBookAPI dao) {
        this.dao = dao;

    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHome() {
        return "home";
    }

    @RequestMapping(value = "/createAddressForm", method = RequestMethod.GET)
    public String displayAddAddressForm() {
        return "createAddressForm";
    }

    @RequestMapping(value = "/displayAddressConfirmation", method = RequestMethod.GET)
    public String displayAddress() {
        return "displayAddressConfirmation";
    }

    @RequestMapping(value = "/displayAllAddresses", method = RequestMethod.GET)
    public String displayListOfAddresses() {
        return "displayAllAddresses";
    }

    @RequestMapping(value = "/editAddressForm", method = RequestMethod.GET)
    public String displayEditAddressForm() {
        return "editAddressForm";
    }

    @RequestMapping(value = "/searchAddressForm", method = RequestMethod.GET)
    public String searchAddressForm() {
        return "searchAddressForm";
    }

    @RequestMapping(value = "/addNewAddressToModel", method = RequestMethod.POST)
    public String addNewAddressToModel(HttpServletRequest req) throws IOException {
        //just made a form in the jsp to enter this stuff
        //going to pull all of the parameters we just created in the form jsp by name
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String street = req.getParameter("street");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zipCode = req.getParameter("zipCode");
        int zip = Integer.parseInt(zipCode);
//        String idNumber = req.getParameter("idNumber");
//        int id = Integer.parseInt(idNumber);


        Address address = new Address();

        //now we need to set the params that we got and set them to the object before we push 
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZipCode(zip);
        
//        contact.setCompany(company);
//        contact.setEmail(email);
//        contact.setPhone(phone);

        dao.addAddressToBook(address);

        //new approach - the string we are returning is a redirect
        return "displayAddressConfirmation"; //before we were returning a string that would find a jsp view, but now
        //the redirect will initite calling the endpiont that is goign to transfer the results in vfalue
        //bc when we have addd a contact, the workflow is to go back ot the list

    }
    
     @RequestMapping(value = "/displayAllAddresses", method = RequestMethod.GET)
    public String listAllAddresses(Model model) throws IOException { //the model is the middleman-woman -- it's not the user asking for this, it's our own program. which is why we pass in the model not the request.
        ArrayList<Address> list = dao.getAllAddresses();
        model.addAttribute("list", list);
        return "displayAllAddresses";
        
//        <s:url value="deleteAddress" var="deleteAddress_url"><!--won't be produced on the screen, but used by other elements -->
//                                <s:param name="idNumber" value="${address.idNumber}"></s:param><!-- -->
//                            </s:url>  
//
//                            <s:url value="editAddressForm" var="editAddress_url">
//                                <s:param name="idNumber" value="${addy.idNumber}"></s:param>
//                            </s:url>
    }
    
//   @RequestMapping(value="/deleteAddress", method=RequestMethod.POST)
//   public String deleteFromList()

}
