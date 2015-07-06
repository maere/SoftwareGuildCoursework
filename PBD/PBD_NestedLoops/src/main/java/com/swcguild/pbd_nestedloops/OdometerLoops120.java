/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_nestedloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OdometerLoops120 {
    public static void main(String[] args) throws InterruptedException {
        
  Scanner sc = new Scanner(System.in);
        System.out.println("Enter a base to count by (2-10): ");
        int base = sc.nextInt();
// Delete all the open braces and close braces from all the outer for loops. (Leave the curly braces that belong to the innermost loop (the "ones" loop).) 
//Does it still work? 
//Yes, it still works--exactly the same 
        for ( int thous=0; thous<base; thous++ )
            
//Change all the loops so that they count from 0 to 7 instead of 0 to 9. 
//This will display numbers in "octal" (base 8) instead of "decimal" (base 10).
		
			for ( int hund=0; hund<base; hund++ )
			
				for ( int tens=0; tens<base; tens++ )
				
					for ( int ones=0; ones<base; ones++ )
					{
						System.out.print( " " + thous + "" + hund + "" + tens + "" + ones + "\r" );
						Thread.sleep(500);
					}
				
			
		

		System.out.println();
    }
}



//    
//Change the code so that the human gets to type in a number for the base, and your odometer counts up to that instead of 
//8. You might want to increase the delay (put a bigger number (like maybe 500) inside the Thread.sleep()).
