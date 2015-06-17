/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addresslab;

import java.io.IOException;

/**
 *
 * @author apprentices: Angela and Mary
 */
public class App {
    public static void main(String[] args) throws IOException {
        //instantiate an address book controller to call our run method
        AddressBookController addressBookRunner = new AddressBookController();
        addressBookRunner.run();
    }
    
    
}
