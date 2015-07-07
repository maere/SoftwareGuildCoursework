/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlamdbas;

//import static com.swcguild.dvdlab.DVD.counter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibraryFileImpl implements DVDLibrary {

    private HashMap<Integer, DVD> dvdCollection = new HashMap<>();

    public static final String DVDS_FILE = "dvds.txt";
    public static final String DELIMITER = "::";
    // not really needed ArrayList<DVD> dvdList;
    //private DVD id;

    //constructor--defaults
    @Override
    public void addToLibrary(DVD dvd) throws FileNotFoundException {

        //counter(); //make a call to a new class we created to increment each time we add an object to the library
        //we will need to go look at the value of the counter in the DATA STORE before
        //we increment here--out counter will actually always need to reset to the last
        //record +1 (so ArrayList.size() + 1;
        //but it will need to read this from the data file first...so we will need to call
        //loadDVDs to see what we got--
        dvdCollection.put(dvd.getId(), dvd);

    }

    //this will read data from .txt file, line by line, token by token and store it in a DVD object
    @Override
    public void loadDVDdata() throws FileNotFoundException {
        //create something to read our data file
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDS_FILE)));

        //create a variable to hold the line from the reader we just created
        String currentLine;

        //create array to hold tokens we read
        String[] currentTokens;

        //read token by token and push into array, while there are lines left
        while (sc.hasNextLine()) {

            currentLine = sc.nextLine(); //on each loop we set the currentLine = to the next Line to be read

            currentTokens = currentLine.split(DELIMITER); //on each loop we set token array = the results of splitting the line by the delimter

            //now that we have an array of tokens, we need to create on object to hold them
            DVD currentDVD = new DVD();

            //we set each property of the DVD object using the setters and the values sitting in the array
            //currentDVD.setId(Integer.parseInt(currentTokens[0])); 
            currentDVD.getId();
            currentDVD.setTitle(currentTokens[1]); //we pass the appropriate token into the setter as the parameter value
/*            
             The main date-time classes provide two methods - one for formatting, format(DateTimeFormatter formatter), 
             and one for parsing, parse(CharSequence text, DateTimeFormatter formatter).
             For example:
             String text = date.toString(formatter);
             LocalDate date = LocalDate.parse(text, formatter);
             */

            LocalDate toDate = LocalDate.parse(currentTokens[2], DateTimeFormatter.BASIC_ISO_DATE); //20111203 - YYYYmmDD
            currentDVD.setReleaseDate(toDate);
            currentDVD.setMpaaRating(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            //currentDVD.setUserReview(currentTokens[6]); //when we refactor we coudl turn this into an ArrayList -- for now we will keep as a very long string!

            //push it into the Hash
            dvdCollection.put(currentDVD.getId(), currentDVD);
        }
        //don't forget to close the scanner!
        sc.close();

    }

    @Override
    public void writeToDVDdata() throws IOException {
        //instantiate object designed to print stuff to a text file
        PrintWriter out = new PrintWriter(new FileWriter(DVDS_FILE));

        for (DVD currDVD : dvdCollection.values()) {

            String strId = Integer.toString(currDVD.getId());

            out.println(
                    strId + DELIMITER
                    + currDVD.getTitle() + DELIMITER
                    + currDVD.getReleaseDate().format(DateTimeFormatter.BASIC_ISO_DATE) + DELIMITER
                    + currDVD.getMpaaRating() + DELIMITER
                    + currDVD.getDirector() + DELIMITER
                    + currDVD.getStudio() + DELIMITER
                    + currDVD.getUserReview() + DELIMITER
            );
            out.flush();
        }
        out.close();

    }

    @Override
    public List<DVD> listAllDVDs() {

        List<DVD> dvdList = new ArrayList<DVD>(dvdCollection.values());
        return dvdList;

        /* getting an array list from a collectoin
         public Type getNode(int nodeId){             (dvdCollection.getTitle())
         ArrayList<Type> myNodeList = new ArrayList<Type>(this.getVertices());
         return myNodeList(nodeId);
         }
         */
    }

    @Override
    public void removeDVD(Integer id) {
        dvdCollection.remove(id);
    }

    @Override
    public DVD getDVD(Integer id) {
        return dvdCollection.get(id);

    }

    @Override
    public int getDVDCount() {
        return listAllDVDs().size();
    }

    @Override
    public List<DVD> ageSearch(long age) {

        List<DVD> titlesByAge = dvdCollection.values().stream()
                .filter(d -> d.getDVDage() <= age).collect(Collectors.toList());
        return titlesByAge;
    }

    @Override
    public double averageAge() {

        double avgForColl = dvdCollection.values().stream().mapToLong(d -> d.getDVDage()).average().getAsDouble();
        return avgForColl;
    }

    @Override
    public DVD newestDVD() {

      return dvdCollection
                .values()
                .stream()
                .sorted()
                .max((dvd1, dvd2) -> dvd1.getReleaseDate().compareTo(dvd2.getReleaseDate())).get();
    }

    @Override
    public DVD oldestDVD() {
        //return listAllDVDs().stream().min((d1, d2) -> d1.getReleaseDate().compareTo(d2.getReleaseDate())).get(); --- this way threw an error--why?
        return dvdCollection.values().stream().sorted().min((dvd1, dvd2) -> dvd1.getReleaseDate().compareTo(dvd2.getReleaseDate())).get();
        
    }

    @Override
    public List<DVD> ratingSearch(String mpaaRating) {
        List<DVD> titlesByRating = dvdCollection.values()
                .stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(mpaaRating)).collect(Collectors.toList());
        return titlesByRating;

    }
     //we will not want a master list here, but the sublists by rating, and then will need to loop through those in the controller
    public Map<String, List<DVD>> ratingGrouping(List<DVD> thisList){ //decided to let it take a list as paramater
        //List<DVD> byRatingList = listAllDVDs(); 
        
        Map<String, List<DVD>> byRatingMap;
        byRatingMap = 
                thisList.stream().collect(Collectors.groupingBy(DVD::getMpaaRating));
                                                        //this returns a HashmPa of DVDs by rating
        return byRatingMap;
    }

    @Override
    public List<DVD> directorSearch(String director){
       List<DVD> listByDirector = dvdCollection.values().stream().filter(d ->d.getDirector().equalsIgnoreCase(director)).collect(Collectors.toList());
       
               return listByDirector;
    
    }
//    public Map<String, List<DVD>> directorSearch(String director) {
//        
//        Map<String, List<DVD>> directorMap = 
//                dvdCollection.values()
//              .stream().collect(Collectors.groupingBy(DVD::getDirector));
//                                                        //this should return a director and their DVD list
//        return directorMap;
//    }

    
    
    @Override
    public List<DVD> studioSearch(String studio) {

        List<DVD> titlesByStudio = dvdCollection.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio)).collect(Collectors.toList());
        return titlesByStudio;
    }

    @Override //this method will need to change to return calculation based on ArrayList
    public void AvgNumNotes() {
    }
    
    @Override
     public List<String> notes(String userReview){return null;
}
}

    //@Override
//    public List<String> notes(String userReview) {
//        //adds note to our Array of notes
//        
//        //and returns array 
//        //or do these need ot be two different one?
//        List notesList = dvdCollection.values().stream(). //finishe
//        //To change body of generated methods, choose Tools | Templates.
//    return notesList;
//    }
//}

    //getters and setters
//may not actually need
//    @Override
//    public HashMap<Integer, DVD> getDvdCollection() {
//        return dvdCollection;
//    }
//
//    @Override
//    public void setDvdCollection(HashMap<Integer, DVD> dvdCollection) {
//        this.dvdCollection = dvdCollection;
//    }

/*
        //Optional<DVD> collect = dvdCollection.values().stream().collect(Collectors.minBy(DVD.releaseDateComparator));
        //listAllDVDs().sort(dvdList, DVD.releaseDateComparator);
//        DVD oldest;
        //dvdCollection.values().stream().sorted(Comparator.comparing(DVD d) -> d.)
//        return this.listAllDVDs().sort
//        (Comparator.comparing((DVD o) -> o.getReleaseDate()).compare(oldest, oldest);
//                
//                .people.sort(
//                Comparator.comparing((Person p) -> p.lastName)
//                .thenComparing(p -> p.firstName));
//        people.forEach(System.out::println);
        //return collect
*/