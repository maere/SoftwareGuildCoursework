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
public class Cache {
    
    // private inner classs
    private class CacheEntry //if we change this to "public static class CacheEntry" 
                            // we *would* be able to access it from our App, but then would break out into a separate method
             //and if we change to public static class CacheEntry we could also create a "new" one/instantiate
    
    {   
    //fields for our nested class
        public long timeInserted = 0;
        //this is when we made the
        public Object value = null;
    }
    
   //instead of new CacheEntry --- we can now only do a new CacheEntry inside this file
    
    //fields for our outer class
    private CacheEntry[] entries; // this is a field/class variable that's an array, that will 
    //be a bucketfuyll of CachEntry references
    private int index = 0;
    
    public Cache(int size) //method of this class
    {
        //this makes a bunch of reference placeholders, not an Cache object
        entries = new CacheEntry[size];
    
    }
    //our methods
    
    public int store(Object value){  //going to pass in the object he's going to store
    //we are going to pass our value in, figure out what our index is and pass that out
    //so we need a field in Cache for this, and we'll go add that along with our other fields
        CacheEntry entry = new CacheEntry(); //now we have made a cache entry on a heap
        entry.timeInserted = System.currentTimeMillis(); //got time
        entry.value = value;  // got value to store
        //now we are going to feed this entry we just made into our array
        entries[index] = entry; //this stores it into the array
        return index++; //return the value of the index as incremented
    }
    
    public Object get(int i){ //params are temp placeholder names just for use in the function
    //want to check whether the index we passed in is in the bounds of our array, if not return null
        if(index<entries.length && index>0){
        return entries[i].value; // this field value is a public field, and this is away to access a property in Java
                                // .value (give me back the value) -- I think this is like JS 
        }
        return null;
    }
    
    /* eg.
     ?????? something about new, but now sure what he's trying to communicate
    public CacheEntry getCacheEntry(){
        CacheEntry entry = cache.getCacheEntry(1);
    }
    
    */
    
    public void retire(){
        // will go through our list of values and and look at indiv elements and if the element has 
        //been around longer than a minute we will lose hte reference to it
        for(int i=0; i<entries.length; i++){
            if(entries[i]!=null && (entries[i].timeInserted - System.currentTimeMillis()>60000))//60000 millseconds = 1 minute
            {
                entries[i] = null;
            }    
                
                
        }  
        
    }
        
}
/*
nested classes are only used in specific type of cases--this is a good example

what you see as a public interface in the class is that you have a way to create it and get info back
but behind the scenes you have this cacheEntry that is essentially to our functoinality....
...but the people getting stuff out don't need to know what's going on in the background

*/