/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_nestedloops;

/**
 *
 * @author apprentice
 */
public class PBD_NestLoops {
    

	public static void main( String[] args )
	{
// this is #1 - I'll call it "CN" - Which variable changes faster? Is it the variable controlled by the outer loop (c) or the variable controlled by the inner loop (n)? 
                 //n changes faster--the inner loop
            
//Change the order of the loops so that the "c" loop is on the inside and the "n" loop is on the outside. 
//How does the output change?  
                //the letters now change faster than the numbers. (Though it still prints out with the letter first.)

		for (int n=1; n <= 3; n++)
		{
			for (char c='A'; c <= 'E'; c++ )
			{
				System.out.println( c + " " + n );
			}
		}

		System.out.println("\n");
                
//Look at the second set of nested loops ("AB"). Change the print() statement to println(). 
//How does the output change? 
                //println creates a line break after each loop, and print() just prints all output on the same line

		// this is #2 - I'll call it "AB"
		for ( int a=1; a <= 3; a++ )
		{
			for ( int b=1; b <= 3; b++ )
			{
				System.out.print( a + "-" + b + " " );
			}
                        System.out.println("");// * You will add a line of code here.
//Add a System.out.println() statement after the close brace of the inner loop (the "b" loop), but still inside the outer loop. 
//How does the output change? 
                        //at the end of each outer loop you get a line break
			
		}

		System.out.println("\n");

	}
}
/*







*/

