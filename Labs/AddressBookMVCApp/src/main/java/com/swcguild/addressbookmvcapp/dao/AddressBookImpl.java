/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.dao;

import com.swcguild.addressbookmvcapp.model.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookImpl implements AddressBookAPI{
 //8. AddressBookImpl class that implements the AddressBook interface -
//you must use Lambdas, Streams, and Aggregates in your implementation.
    
    //to store our addresses
    public static final String ADDRESSES_FILE = "addresses.txt";
    public static final String DELIMITER = "::";

    static int idNumber;
    //Address addressObject;

    //constructor
    HashMap<Integer, Address> addressMap = new HashMap<>();

//
//    @Override
//    public void loadAddresses() throws FileNotFoundException {
//        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESSES_FILE)));
//        Integer highestId = 0; //always need to initialize!!
//        String currentLine;
//        String[] currentTokens;
//
//        while (sc.hasNextLine()) {
//            currentLine = sc.nextLine();
//            currentTokens = currentLine.split(DELIMITER); //why not "::"?
//
//            Address currentAddress = new Address(); //we have to parseInt bc evertying out of a file reader is a string
//            currentAddress.setIdNumber(Integer.parseInt(currentTokens[0]));
//            currentAddress.setFirstName(currentTokens[1]);
//            currentAddress.setLastName(currentTokens[2]);
//            currentAddress.setStreet(currentTokens[3]);
//            currentAddress.setCity(currentTokens[4]);
//            currentAddress.setState(currentTokens[5]);
//            currentAddress.setZipCode(Integer.parseInt(currentTokens[6]));
//            
//            
//            if (currentAddress.getIdNumber()>highestId){
//                highestId= currentAddress.getIdNumber();
//            }
//            addressMap.put(currentAddress.getIdNumber(), currentAddress);
//        }
//        //setting id for next item 
//        idNumber = highestId++;
//        
//        sc.close();
//    }

    @Override
    public Address getAddress(int idNumber) throws FileNotFoundException {
        
        return addressMap.get(idNumber);
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAddressToBook(Address addressObject) throws IOException {
    idNumber++;
    addressObject.setIdNumber(idNumber);
        
    addressMap.put (idNumber, addressObject); //Object is in the HashMap, but has not yet been written to the file
   
    }

    @Override
    public void removeAddress(int idNumber) throws FileNotFoundException{
         addressMap.remove(idNumber); //from the hash
    }

    @Override
    public ArrayList<Address> getAllAddresses() {
          Set<Integer> keys = addressMap.keySet();

        ArrayList addressArray = new ArrayList<>();

        for (Integer k : keys) {
            //k.toString();  -- this just converts the uniqueID to a string
            addressArray.add(addressMap.get(k));
        }

        return addressArray;  //this is a object arrayLIst of all the addresses   
    }
//    
//    @Override
//    public void writeToAddresses() throws IOException {
//        PrintWriter out = new PrintWriter(new FileWriter(ADDRESSES_FILE));
//
//        //this is the ArrayList we get from all the objects we just pulled from our hash
//        ArrayList<Address> addressKeys = this.getAllAddresses(); 
//
//        for (Address currentAddress : addressKeys)//this is a bunch of objects (the values)
//        {
//            String strId = Integer.toString(currentAddress.getIdNumber());
//
//            out.println(strId + DELIMITER
//                    + currentAddress.getFirstName() + DELIMITER
//                    + currentAddress.getLastName() + DELIMITER
//                    + currentAddress.getStreet() + DELIMITER
//                    + currentAddress.getCity() + DELIMITER
//                    + currentAddress.getState() + DELIMITER
//                    + currentAddress.getZipCode());
//            //flush before you leave the loop
//            out.flush();
//        }
//        //and close
//        out.close();
//
//    }//end write method
    
    @Override
    public List<Address> nameSearch(String lastName){
        
        List<Address> all = getAllAddresses();
        return all
                .stream().filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());

    }
    
    
    @Override//added after interface--should I include in interface?
    public List<Address> citySearch(String city){
        
          List<Address> all = getAllAddresses();
          return all
                .stream().filter(s -> s.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList()); //this DOA method will return a list to this method in the controller
}
    
    
    @Override
    public List<Address> zipSearch(int zipCode){
        
         List<Address> all = getAllAddresses();
        return all
                .stream().filter(z -> z.getZipCode() == zipCode)
                .collect(Collectors.toList()); //could also get a range of zips --e.g. plus 10 in either direction to capture surrounding areas
}
    
    @Override
    public Map<String, List<Address>> stateSearch(String state){
        
        Map<String, List<Address>> citiesInState;
        citiesInState= 
                addressMap.values().stream().filter(s ->s.getState().equalsIgnoreCase(state))
                .collect(Collectors.groupingBy(Address::getCity)); //groupingBy returns a hashmap
 
        return citiesInState;
}

    @Override
    public void loadAddresses() throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeToAddresses() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}//end class
