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
public class EnterYourPin {
    
    public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		int pin = 12345;

		System.out.println("WELCOME TO THE BANK OF MITCHELL.");
		System.out.print("ENTER YOUR PIN: ");
		int entry = keyboard.nextInt(); 
//1. a while loop is similar to if statement in that it tests a condition in order to proceed
//2. they are different b/c an if cannot repeat if the condition is met--it will only execute once
//3. there isn't an int in front of entry inside the loop bc it is already declared in the global scope
		while ( entry != pin )
		{
			System.out.println("\nINCORRECT PIN. TRY AGAIN.");
			System.out.print("ENTER YOUR PIN: ");
			entry = keyboard.nextInt(); //if you delete this line 
                        //and the person doesn't get their PIN right the first time,
                        //it creates an infinite loop with no chance off exit
		}

		System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
	}
    
}
