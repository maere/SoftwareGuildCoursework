/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class Randomness41 {
    public static void main(String[] args) {
        
        //new Random number generator object
        Random r = new Random();
        
//with the seed you get the same output each time   -- 124151 for 12345 or 255254 for 12343      
//Random r = new Random(12353); -- it is a sort of key, bc is software generators are pseudorandom
        
        //declare variable to store it in, and set bound
        int x = 1 +r.nextInt(10);
        System.out.println( "My random number is " + x );

		System.out.println( "Here are some numbers from 1 to 5!" );
                
                //the 1+ makes it <== vs. simply less than the number parameter
		// 3 + will shift range from 0 to 3-7
                System.out.print(1 + r.nextInt(5) + " " );
		System.out.print(1 + r.nextInt(5) + " " );
                System.out.print(1 + r.nextInt(5) + " " );
                System.out.print(1 + r.nextInt(5) + " " );
                System.out.print(1 + r.nextInt(5) + " " );
                System.out.print(1 + r.nextInt(5) + " " );
                
                
                
                
                
                System.out.println();

		System.out.println( "Here are some numbers from 1 to 100!" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.println();

		int num1 = 1 + r.nextInt(10);
		int num2 = 1 + r.nextInt(10);

		if ( num1 == num2 )
		{
			System.out.println( "The random numbers were the same! Weird." );
		}
		if ( num1 != num2 )
		{
			System.out.println( "The random numbers were different! Not too surprising, actually." );
		}
        
    }
    
}
