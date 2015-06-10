/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classmodeling;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        House sweeneys = new House("123 Elm", "Lakewood", "white", 6, 30);
        sweeneys.sold();
        sweeneys.saleDate();
        
    }
    
}
