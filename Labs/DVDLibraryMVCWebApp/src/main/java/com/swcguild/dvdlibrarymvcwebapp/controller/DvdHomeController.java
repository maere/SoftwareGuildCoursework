package com.swcguild.dvdlibrarymvcwebapp.controller;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DvdHomeController {
    
    DvdLibraryDao dao;
        
    @Inject                 //could I also have injected my model here? Model DVD? - used a bean instead
    public DvdHomeController(DvdLibraryDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String homeDisplay() {
        return "home";
    }
    
    @RequestMapping(value="/addDvdForm", method=RequestMethod.GET)
    public String displayAddDvdForm(){
        return "addDvdForm";
    }
    
     @RequestMapping(value="/addDvdForm", method=RequestMethod.POST)
    public String addDvdToModel(HttpServletRequest req) { //this still needs to be an Http*Servlet*Request --
        //get params
        String movieTitle = req.getParameter("title");
        String movieRating = req.getParameter("mpaaRating");
        String movieRelease = req.getParameter("releaseDate");
        LocalDate dtRelease = LocalDate.parse(movieRelease);
                
        String movieDirector = req.getParameter("director");
        String movieStudio = req.getParameter("studio");
        String movieNotes = req.getParameter("note");
        
        //create dvd object
        Dvd dvd = new Dvd();
        //add to dvd object
        dvd.setTitle(movieTitle);
        dvd.setMpaaRating(movieRating);
        
        //dvd.setReleaseDate(dtRelease);
   
        dvd.setDirector(movieDirector);
        dvd.setStudio(movieStudio);
        dvd.setNote(movieNotes);
        
        //add to dao (map)
        dao.add(dvd);
        
        //then should redirect to the list to show us we've just addded
        return "redirect:displayDvdTitles";
    }
    
     @RequestMapping(value="/displayDvdTitles", method=RequestMethod.GET)
    public String listDvdTitles(Model model) {
        List<Dvd> dvdList = dao.listAll();
        model.addAttribute("dvdList", dvdList);
        return "displayDvdTitles";
    }
    
//delete method
    @RequestMapping(value="/deleteDvd", method=RequestMethod.GET)
    public String deleteDvd(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.remove(id);
        
        return "redirect:displayDvdTitles";
    }
    
    @RequestMapping(value = "/displayEditDvdForm", method = RequestMethod.GET)
    public String displayEditDvdForm(HttpServletRequest req, Model model) { //we are passing in both the request and the model
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        Dvd dvd = dao.getById(id);
        
        //tell model to add attributes
        model.addAttribute("dvd", dvd);
        
        return "editDvdTitle"; //instead of using name="" in the jsp, we are going to use path=""
    }
    
    
     @RequestMapping(value="/editDvd", method=RequestMethod.POST)//should really be post
    public String EditDvd(@Valid @ModelAttribute("dvd") Dvd dvd,//in our DTO on the fields to call out the fields we are validating
                                    BindingResult result){
        //there is no "update" method in the Dvd Dao -- do we write one here?
        // Dvd currentDvd = dao.getById(dvd.getId());
         
        if(result.hasErrors()){
            return "editDvdTitle"; //we go back to this view again after it displays errors
                 
        }
        
        return "redirect:displayDvdTitles";
    }
    
    
     @RequestMapping(value="searchDvdCollection", method=RequestMethod.GET)
    public String displaySearchDvdPage() {
        return "searchDvdCollection";
    }
}

