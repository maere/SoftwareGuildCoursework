/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalcrfconsoleio;

/**
 *
 * @author apprentice
 */
public class App {
     public static void main(String[] args) {
        //instantiate object
        // instantiate UI class here, but NOT the calculator--calculator gets instantiated in the UI class
        CalcUIRf myCalcUI = new CalcUIRf();
        
        myCalcUI.returnInt("What do you want to do? (1-4)");
        
        //now we run methods on our instantiated object
        myCalcUI.requestInput();
        int op = myCalcUI.userCalcRequest();
        myCalcUI.getCalcFunctions(op);
       
        
        
        
    }
    
}
