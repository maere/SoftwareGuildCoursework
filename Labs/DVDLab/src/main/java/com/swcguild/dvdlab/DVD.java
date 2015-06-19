/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlab;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class DVD {
    public int id;//later we can make this an integer and do the casting and parsing--for now it's a STring
    String title;
    String releaseDate;
    String mpaaRating;
    String director;
    String studio;
    String userReview; //later we will make into an ArrayList<String> 
    
    static int counter = 0; //we want this to be available to DVDLibrary class
    
   
    //constructor
   DVD() {
        this.id = ++counter; //every time we make a DVD we increment the counter
    }

    /*
    public void setId(Integer id) {
        this.id = id;
    }
   */ 
   
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

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }
    
    
    
    
}
