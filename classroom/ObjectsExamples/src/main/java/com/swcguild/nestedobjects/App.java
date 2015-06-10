/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.nestedobjects;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        //we can cache anything
        Cache cache = new Cache(20);
        
            for(int i =0; i<15; i++){
                cache.store(new Integer(i*2)); //we're using uppercase I so we can make an object of type Integer
            }
            
            for (int i=0; i<15; i++){
                
              
                System.out.println(cache.get(i));
            }
            
            
            //CacheEntry entry = new CacheEntry(); 
            // if you try the above...
            //it "cannot find symbol cacheEntry error" because the new CacheEntry is a private nested class
            //within the public class Cache (which is avalialbe to us)
    }
    
}
