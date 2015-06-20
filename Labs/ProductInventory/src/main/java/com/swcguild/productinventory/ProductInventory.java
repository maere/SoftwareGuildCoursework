/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.productinventory;

/**
 *
 * @author apprentice
 */
public class ProductInventory {
    
}
/*
Create a program that manages multiple products such as:
shirts, pants, coats and other products in inventory. 
(will do with vending machine, so candy, chips, gum, granola bar, etc. and then could extend further into specific brands?)

Allow the user to:
//add products to inventory,                      - inventory DAO class with add method to write to HashMap<String, Integer> name and count--reads from file and also outputs to ArrayList(?)
//add/remove stock to an existing product,        - add/remove product to data file list which needs to persist, but be updated
//calculate the total value of a product (?) and  - products need to have properties of cost, and the DAO needs to calculate cost*quantity (value of goods?)
// the total value of the entire inventory.       - iterate through objects and sum totals for value of all goods

//When inventory levels for a product fall below a certain number // (this should be configurable--set to a variable or property and abstracted for all items),
//the system should warn the user that they need to restock.        //(e.g. public void levelsWarning() - 
                                                                    //this check should be run when the inventory is loaded from the data (when loadInventory is called)

This program is essentially a product shop in a box. It could be a department store, a specialty shop or a grocery store.
//Inventory must be read from and stored to a file.
-----------------------------
This is good for practicing the idea of Object Oriented Programming (OOP), inheritance and
polymorphism. 

//It starts off with the creation of a Product base class from which  -- Product -- product has cost, invCount, name, 
    //each of the specific product classes are derived.    -- Candy, Gum, Chips, GranolaBar, Popcorn, Nuts, extends Product

//Each of these products are then stored in, and managed by, an Inventory class.-- Inventory has an ArrayList that lists all inventory w. index from data file
                                                                                          ..when this list is constructed onthe fly, if invCount is <X is warning, and if there is none, it is not listed out to the user  

//1. Start first by creating the *Product base class. 
//What would be common to all products?  (type, name, cost, invCount, brand, size, vendor, etc.)
//Would you make anything abstract? Why? -- only to force an item to define it's own methods --- why would a product need a method?
Make sure you fully flesh out this base class and keep in
mind that *you will be extending this class*.

//2.  Next, design your *file format:
//how will products be stored?   - in a text file called inventory
//How many files will you need?  - one with many delmited fields
//How will you tell a shirt from a pair of pants (or other product)?  - type
// How will you instantiate/construct the different types of product? - they should all get instantiated (minimally) with a String name, a cost, a type, -- HashMap is <String Object> name/objname 

//3. Finally, design the Inventory class. 
//What data structure will you use to store your products?  HashMap stores the products by name, ArrayList will list out products, file is storage of inventory data
//What methods will the Inventory class have? (see above)
// How will you persist product inventory? inventory.txt
// How will you load product inventory?  loadInventory, writeToInventory


*/