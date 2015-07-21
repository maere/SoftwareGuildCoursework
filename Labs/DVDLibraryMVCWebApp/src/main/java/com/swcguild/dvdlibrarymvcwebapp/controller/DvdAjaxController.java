/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcwebapp.controller;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/"})
public class DvdAjaxController {
    
    //delcare any daos
    private DvdLibraryDao dao;
    
    //constructor must inject the dao & create an instance
    @Inject
    public DvdAjaxController(DvdLibraryDao dao){
        this.dao = dao;
    } 
    //wire home mapping -- changed to index for the dynamic version
    @RequestMapping(value={"/", "/index" }, method=RequestMethod.GET)
    public String displayIndexPage(){
        return "index";
    }

    //CRUD REST route mapping
   
    //Retrieve one
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.GET)
    public Dvd getDvd(@PathVariable("id") int id){ //REST methods will require a path variable annotation, note object we are expecting is an int and has to be declared
        return dao.getById(id);                         //return type must match the object we want to return
    }
   
    //Create one
    
    @RequestMapping(value="/dvd", method=RequestMethod.POST) //add @Valid when ready to validate
    @ResponseStatus(HttpStatus.CREATED) //we will also send back the status of the request in our response
    @ResponseBody public Dvd createDvd(@RequestBody Dvd dvd){  //Request Body is the paramater we are taking from the post, we are also validating the data in the Req as it comes in
        dao.add(dvd);
        return dvd; //we will also return the dvd in the response
    }
    
    //Delete one
    @RequestMapping(value="dvd/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody public void deleteDvd(@PathVariable("id") int id){ //when do we need a path varaible vs. an object or request body?  what does it take for the DAO to work?
        dao.remove(id);
       
    }
  
    //Update one
    @RequestMapping(value="/dvd/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody public void putDvdToCollection(@PathVariable("id") int id, @RequestBody Dvd dvd){
        dvd.setId(id);
        dao.update(dvd);
    }
    

    //Retrieve all
    @RequestMapping(value="/dvds", method=RequestMethod.GET)
    @ResponseBody public List<Dvd> listDvds(){
        List<Dvd> testReturnList = dao.listAll();
        return testReturnList;
    }
    
    
    
}
