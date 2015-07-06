/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_arrays;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ParallelArrays151 {
    public static void main(String[] args) {
        String [] names = {"Apple", "Bob", "Candice", "Delia", "Ellie"};
        double [] gpa = {4.5, 4.0, 3.5, 3.0, 2.75};
        int [] idNum = {1111, 2222, 3333, 4444, 5555};
        
        System.out.println("Values: \n");
        for(int i=0; i<names.length; i++){
   
            System.out.println(names[i] + " " +String.valueOf(gpa[i]) + " " + Integer.toString(idNum[i]));
            
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Whose record would you like to review (enter ID):");
        int response = sc.nextInt();
        //search through ID array for matched ID
        for (int i=0; i<idNum.length; i++){
        
                if(response==idNum[i]){
                    System.out.println("Found in slot " +i+ ":");
                    System.out.println(names[i] + " " +String.valueOf(gpa[i]) + " " + Integer.toString(idNum[i]));
                    
                
                }
            
        }
        //print values of that student to screen7
        
        
    }
    
}
/*
double total = 44;
String total2 = String.valueOf(total);
*/

/*
Create three arrays to store data about five people.
The first array should be Strings and should hold their last names. 
The next array should be doubles and should hold a grade average (on a 100-point scale). 
The last array should be ints, should hold their student id numbers.

Give each of the arrays values (using array initializers). 
Then print the values of all three arrays on the screen.

Finally, ask the user for an ID number to lookup. 
Search through the ID array until you find that ID, 
and then print out the values from the same slot number of the other two arrays.
*/
