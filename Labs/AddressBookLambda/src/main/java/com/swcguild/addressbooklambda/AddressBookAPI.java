/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public interface AddressBookAPI {
    
    public void loadAddresses() throws FileNotFoundException;

    //getters and setters
    public Address getAddress(int idNumber) throws FileNotFoundException;
    
//methods

    //adds to HASH
    public void addAddressToBook(Address addressObject) throws IOException;

    //removes from Hash
    public void removeAddress(int idNumber) throws FileNotFoundException;

    //get all addresses from hash
    ArrayList<Address> getAllAddresses();
    
    public void writeToAddresses() throws IOException;
    
    public List<Address> citySearch(String city);
    
    public List<Address> zipSearch(int zipCode);
    
    public Map<String, List<Address>> stateSearch(String state);
    
    public List<Address> nameSearch(String lastName);

    
    
    
}
