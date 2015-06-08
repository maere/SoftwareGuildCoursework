/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

/**
 *
 * @author apprentice
 */
public class NoticingEvenNumbers {
    public static void main(String[] args) {

        for (int i = 1; i<=20; i++)
        {   
            if (i%2 ==0)
            {
                System.out.println(i + "<");
            }
            else
            {
                System.out.println(i);
            }
        }
        
    }
    
}

/*
Write a program that uses a for loop to display 
all the numbers from 1 to 20, 
marking those which are even (divisible by two). 
It should use modulus by 2: if the remainder is zero, 
it's divisible by 2.

This means you'll need an if statement inside the loop.
*/
