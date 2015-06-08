/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlipAgain {
    public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		Random rng = new Random();

		String again;
                
                do {                
                 
                System.out.print( "Would you like to flip a coin (y/n)? " );
                again = keyboard.next();
                
                int flip = rng.nextInt(2);
			String coin;

			if ( flip == 1 )
				coin = "HEADS";
			else
				coin = "TAILS";

			System.out.println( "You flip a coin and it is... " + coin );

                    
            } while (again.equals("y"));
                    
                        
			
		
	}
}
/*

The code as given does not compile. Notice that the while loop tests if again.equals("y"), 
but the variable again doesn't have a value at first. 
Give it a value so that the code will compile and the loop will run at least once.
//adjusted so the question was asked before the loop and a value assigned to initiate

Now that program is working, change the loop from a while loop to a do-while loop. 
Make sure it still works.
//it works, but right now when you say no it still flips the coin once (then exits)

What happens if you delete what you added in step 1? Change the line back to just String again; 
Does the program still work? Why or why not? (Answer in a comment.) 
// Now the program will work if you delete the assignment before the loop, because the loop will run at least
once and the variable that was declared outside of the loop will get assigned within the loop.

*/