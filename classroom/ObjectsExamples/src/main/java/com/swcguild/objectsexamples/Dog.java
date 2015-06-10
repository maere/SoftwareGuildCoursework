/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.objectsexamples;

/**
 *
 * @author apprentice
 */
public class Dog {
    //set of fields for the class - we will make the variables public
    //public String dogName; //note that it looks like a regular declaration, but we give it an accessor before
    //public int age;
    //public int weight;
    
    //now we want to create getters and Setters so will change to private
    private String dogName; //note that it looks like a regular declaration, but we give it an accessor before
    private int age;
    private int weight;
    
    //counter and static field--each time we call a constructor  it will add to that number - method below
    private static int numberOfDogs =0;
    
    
    //the constructor--initially we created a dog witout this...bc java will default to creating a dog if we 
                    //use the keyword "new" --- you can also devise a way to NOT let people call the default new
                    //this would be called a "private" constructor and we'll cover later
//you can have multiple constructors--default constructor, constructor with params
    //fields on tops, then constructors, the getters and setters, 
    
    public Dog(String nameIn, int ageIn, int weightIn)
            //bc our params are passed in, they can't be named the same as our fields
    {
        this.dogName = nameIn; // name in is only a parameter, not necessarily a variable
        this.age = ageIn;
        this.weight = weightIn;
        numberOfDogs++; //this counter becomes part of the class constructor
        
        
    }
    //accessor to count number of dogs made
    public static int getNumberOfDogs(){
        return numberOfDogs;
    }
    
    //our getters annd setters to access our private variables
    //the method name for the getter is a naming convention that we need to stick with getFieldName
    public String getDogName(){ 
    return dogName;
    }
    
    public int getAge(){
    return age; //we are not required to do a this.field bc there is not conflict, unlike with the setter
    }
    
    //the setters for a private field of our class
    
    public void setAge(int age){
    //there is a problem bc we already have an "age" field
        this.age = age;
        //this is what makes the distinction between ? and ? 
    }
    //right-click in your class, and you will get a drop down with the option to Insert Code (Alt+Insert)
    //gives you Contstructors, Getters and setters, et al. 
    //sets up a dialog with your variables, and any that are still available/not set and makes them for you!
    //you can check encapsulate in this dialoge and will make your fields private

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    //methods
    public void bark(){
        System.out.println(dogName + " says Woof!");
    }
    
    public void sit(){
        System.out.println("Sitting....");
    }
    //there is NO MAIN in this code...there is no entry point in this code
    //so we need to make an entry point, will make a new class in our package called "app.java" and we will 
    //put psvm in there and it will hold the main/entry piont
    //the JVM knows that these are in the same apackage
    
}
