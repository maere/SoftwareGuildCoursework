/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlamdbas;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVD implements Comparable<DVD>{
    public int id;//later we can make this an integer and do the casting and parsing--for now it's a STring
    String title;
    //String releaseDate;
    LocalDate releaseDate;
    String mpaaRating;
    String director;
    String studio;
    String userReview; //later we will make into an ArrayList<String> 
    List<String> reviews;
    
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

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    
    //this will return the number of years on a DVD object if you call this as a getter
    public long getDVDage(){ //copying his date method for DVDLibrary
                             //Period is a date based amount with years, months, and days--all three fields are present but may be set to 0 ... can be negative
                             //LocalDate is an interface for a date without a timezone in the ISO-8601 calendar system -- can't use == or might cause issues
    Period timePeriod = releaseDate.until(LocalDate.now());
       return timePeriod.getYears();
        
    }
    
//    public int getDVDageDays(){
//        return Period.between(LocalDate.now(), releaseDate).getDays();
//    }

    public void setReleaseDate(LocalDate releaseDate) {
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

   //setUserReview will need a special setter/getter for the ArrayList--will need to return the list, no?
    //will also need to push to this
    
    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }
    
    @Override
    public int compareTo(DVD compareDVD) {
        
          
              LocalDate release1 = this.getReleaseDate();
              LocalDate release2 = compareDVD.getReleaseDate();

//	      //ascending order
	      return release1.compareTo(release2);
 
//		
	}	    
    

}
/*
public int compareTo(Fruit compareFruit) {
 
		int compareQuantity = ((Fruit) compareFruit).getQuantity(); 
 
		//ascending order
		return this.quantity - compareQuantity;
 
		//descending order
		//return compareQuantity - this.quantity;
 
	}

public static Comparator<Fruit> FruitNameComparator 
                          = new Comparator<Fruit>() {
 
	    public int compare(Fruit fruit1, Fruit fruit2) {
 
	      String fruitName1 = fruit1.getFruitName().toUpperCase();
	      String fruitName2 = fruit2.getFruitName().toUpperCase();
 
	      //ascending order
	      return fruitName1.compareTo(fruitName2);
 
	      //descending order
	      //return fruitName2.compareTo(fruitName1);
	    }
 
	};

//    
//public static Comparator<DVD> releaseDateComparator  = new Comparator<DVD>() {
// 
//            
//	    public int compare(DVD d1, DVD d2) {
//               
//              LocalDate release1 = d1.getReleaseDate();
//              LocalDate release2 = d2.getReleaseDate();
////	      String fruitName1 = fruit1.getFruitName().toUpperCase();
////	      String fruitName2 = fruit2.getFruitName().toUpperCase();
//// 
////	      //ascending order
//	      return release1.compareTo(release2); //oldest date will be first. will return the date
// 
//	      //descending order
//	      //return fruitName2.compareTo(fruitName1);
//	    }
// 
//	};

LocalDate compareDate = (compareDVD).getReleaseDate(); 
//                                    //in this date/string/int parsing scenario higher numbers are more recent, lower numbers older dates
//                int currentDate = Integer.parseInt(this.releaseDate.toString());
//                int nextDate = Integer.parseInt(compareDate.toString());
//		//ascending order
//		//return this.releaseDate - compareDate;
// 
//		//descending order
//		//return compareQuantity - this.quantity;
//                return nextDate - currentDate;
 
    
*/