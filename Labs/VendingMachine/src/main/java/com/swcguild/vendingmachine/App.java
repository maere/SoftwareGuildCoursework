/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine;

/**
 *
 * @author apprentice
 */
public class App {
    
}
/*

Your assignment for this lab is to create a program that simulates a vending machine. Your

//The program should display all of the items *and* their respective prices when the
program starts along with an option to exit the program.
    - menu

//2. The user must put in some amount of money before an item can be selected.
    consoleIO- request $ and stores as variable
    // itemselection
 - con(what item would you like to purchase?) - stores as variable
    - checks to see if they have enough for that item (min value change -- console IO overloaded method)
    - if not, prints out that they have an insufficient amount
    - asks if they would like to add more money, if yes, runs add money, if not exits program

//addMoreMoney

//3. Only one item can be vended at a time.
    - can purchase item, if they want to purchase another they need to go back out and add money -- can't get two candybars
    - so progam will exit if this condition is met and an item is successfull vended--otherwise you are in a loop

//4. If the user selects an item that costs more than the amount the user put into the vending
machine the program should display a message indicating insufficient funds and then
redisplay the amount the user had put into the machine.
    - checks for min value against costg
    - print out message

//5. If the user selects an item that costs equal to or less than the amount of money that
the user put in the vending machine the program should display the change returned to
the user. 
    - calculates change to be returned
    //Change must be displayed as the number of Quarters, Dimes, Nickels, and
Pennies returned to the user.
    --method must break up change into 25, 10, 5, and 1---this is a for loop or an if/else loop
    --if greater than 25, return 25 (loops until <25), if greater than 10, loops 10, if greater than 5, loops 5, to 1.

//6. Vending machine *items* must be stored in a file. *Inventory* for the vending machine must
be read from this file *when the program starts* and must be written out to this file when
just before the program exits. ///?? think about thisi some more

//DTOs -- 3-5 objects
The program must track the following properties for each item: 
a. Item Name
b. Item Cost
c. Number of items in inventory

//7. When an item is vended, the program must update the inventory level appropriately. 
    -setter for item object (called from a method in DAO)

//If the machine runs out of an item, *it should no longer be available as an option to the user*
    - if then statement...do not display [i] (in hashmap) DAO/ui (or if (itemsRemaininng==0) continue; in loop)
    - need to separate printOutInventory loop (UI) from updateInventory Loop (DAO) (see next)

//however the items that have an inventory level of zero must still be read from and written
to the inventory file and stored in memory. -- bc the object persistss (DAO-DTO-FILEstorage)

//separate class for calculating change
HINT: To make change, *create a Change class* that takes the amount of change due to the
user (in pennies) and then calculates the number of Quarters, Dimes, Nickels, and Pennies due
back to the user. 
 -- This class should have accessors for each of the coin types.

Data storage: items are stored in a file
"inventory"/DAO reads to and from this file (load/write to)

DTO classe: data transfer object is the item
-- the numberOf field needs to be a static variable in the class

ArrayList - Inventory - options to user is an array list, because we are going to have to pull items where we run out
DAO - HashMap<string, Object> to access inventory 


*/