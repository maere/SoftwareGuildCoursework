/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild._pbd;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WeekdayCalculator_103 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt();
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

//Find the number of years since 1900, and put it into a variable called yy. Simply subtract 1900 from the year to get this.
        int yy = yyyy - 1900;
//Divide the number of years since 1900 by 4. Put the quotient in a variable called total. eg, if the person was born in 1983, divide 83 by 4 and store 20 in total.
//Also add the number of years since 1900 to total.

        int total = yy/4  + yy;

//    Add the day of the month to total.
        total = total + dd;
        
//    Using the function month_offset() you wrote, find the "month offset" and add it to total.
        
        
//    If the year is a leap year and if the month you are working with is either January or February, then subtract 1 from the total. You can use the function is_leap() provided to determine if the year is a leap year.

//    Find the remainder when total is divided by 7. Pass this remainder to the function weekday_name() you wrote to determine the day of the week the person was born.
        
//    Finally, build up a single String value containing the whole date (day of week, month, day, year). 
        //You'll need to use the function month_name() you wrote to show the month name rather than its number.
        
//    Return that String value. 
        System.out.println("Welcome to Mr. Mitchell's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();
        System.out.println("Some automatic tests....");
        System.out.println("12 10 2003 => " + weekday(12, 10, 2003));
        System.out.println(" 2 13 1976 => " + weekday(2, 13, 1976));
        System.out.println(" 2 13 1977 => " + weekday(2, 13, 1977));
        System.out.println(" 7  2 1974 => " + weekday(7, 2, 1974));
        System.out.println(" 1 15 2003 => " + weekday(1, 15, 2003));
        System.out.println("10 13 2000 => " + weekday(10, 13, 2000));
        System.out.println();

        // put a function call for weekday() here
        System.out.println("You were born on ");
    }

}
/*
Using the functions you wrote in previous assignments and the leap year function provided, write a function to 
determine the day of the week a person was born given his or her birthday. 

The following steps should be used to find the day of the week corresponding to any date from 1901 through the present.

In the following explanation, the following terms will be helpful. 
Assuming I type in my birthday as "6 10 1981":

The month is 6.
The day of the month is 10.
The year is 1981.


Whew. Here's some code to get you started.
*/
