/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals;

/**
 *
 * @author apprentice
 */
public class AppStateCapitals {
     public static void main(String[] args) {
         
       //StateCapitals (1)                                  
       //StateCapitals name = new StateCapitals();  //instantiate a new StateCapital object -- although in this instance it uses the default constructor
       //name.run(); //call the run method on our statecaptials object name
       
       //-------------------------

       StateCapitals2 testObj = new StateCapitals2(); //we now have a hash to put key/value pairs in
       
      //we use the Capital constructor to create new Capital object to store properties/data
                Capital montgomery = new Capital("Alabama", "Montogmery", 2015000, 156);
                Capital juneau = new Capital("Alaska", "Juneau", 31000, 13255);
                Capital phoenix = new Capital("Arizona", "Phoenix", 1445000, 517);
                Capital littlerock = new Capital("Arkansas", "Little Rock", 193000, 113);
       
      //this stores key/value pairs with the name of the state and the capital in our hash
       testObj.addKeyValueToStateHash("Alaska", juneau);
       testObj.addKeyValueToStateHash("Alabama", montgomery);
       testObj.addKeyValueToStateHash("Arizona", phoenix);
       testObj.addKeyValueToStateHash("Arkansas", littlerock);
       
       testObj.printOutCapitalObjInfo();
       testObj.testForPopulation();
       
//
    }
    
}
