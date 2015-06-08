/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingWithForLoop {
    
    
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println( "Type in a message, and I'll display it five times." );
        System.out.print( "Message: " );
        String message = keyboard.nextLine();

        for ( int n =2 ; n <= 10 ; n = n+2 )
        {
            System.out.println( n + ". " + message );
        }

    }
    
}
/*
What does n = n+1 do? Remove it and see what happens. (Then put it back.)
//n+1 counts, in this case it counts each increments of the loop. If you don't have it you will create an infinite loop.

What does int n = 1 do? Remove it and see what happens. (Then put it back.)
//it declares the variable to hold the counting mechanism

Change the code so that the loop repeats ten times instead of five.


See if you can change the for loop so that the message starts at 2 and counts by twos, like so: 

What For loops are good for:
Do this five times.
Pick a random number, and do it that many times.
Take this list of items, and do it one time for each item in the list. 
*/