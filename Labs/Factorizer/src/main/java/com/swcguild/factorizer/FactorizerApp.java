/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizer;

/**
 *
 * @author apprentice
 */
public class FactorizerApp {
    public static void main(String[] args) {
        //we need to instantiate and object from our related class so we can act on that object
                                                                    //i.e. run our methods on it
        FactorizerRefactor iAmObject = new FactorizerRefactor(0, 0, 0);
        
        //now we have an object of the class we can call our methods on
        iAmObject.queryNum();
        iAmObject.gatherResultsArray();
        iAmObject.printResult();
       
        
    }
         
    
}
