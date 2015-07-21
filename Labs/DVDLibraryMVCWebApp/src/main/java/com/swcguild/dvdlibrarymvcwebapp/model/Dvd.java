/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcwebapp.model;

import java.util.ArrayList;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Dvd {
    public int id;//later we can make this an integer and do the casting and parsing--for now it's a STring
    
    @NotEmpty(message="You must supply a value for the Title")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=50, message="Title must be no more than 50 characters in length")
    String title;
    
    @NotEmpty(message="You must supply a release date")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=10, message="Date is YYYY-DD-MM, with exactly 10 characters")
    String releaseDate;
    
    @NotEmpty(message="You must supply a value for the MPAA rating")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=5, message="Rating must be no more than 5 characters in length")
    String mpaaRating;
    
    @NotEmpty(message="You must supply a value for the directors name")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=40, message="Director's  name must be no more than 40 characters in length")
    String director;
    
    @NotEmpty(message="You must supply a value for the studio")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=20, message="First name must be no more than 20 characters in length")
    String studio;
    
    @NotEmpty(message="You must supply a value for your personal notes about the film")    
    @Length(max=100, message="First name must be no more than 50 characters in length")
    String note; //later we will make into an ArrayList<String> 
    
//the annotation goes with the field we want to validate--we must have a name
    
    //static int counter = 0; //we want this to be available to DVDLibrary class
    
   
    //constructor
   Dvd() {
        //this.id = ++counter; //every time we make a DVD we increment the counter
    
   }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

    /*
    public void setId(Integer id) {
        this.id = id;
    }
   */ 
   
    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
    
}
