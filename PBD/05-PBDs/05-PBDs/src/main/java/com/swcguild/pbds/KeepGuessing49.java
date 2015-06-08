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
public class KeepGuessing49 {
    public static void main(String[] args) {
        
        int secretNum = 8;
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        
        int guess;
        Scanner sc = new Scanner(System.in);
        guess = sc.nextInt();
        
        System.out.println("Your guess is: " + guess);
        
        while (guess!=8){
             System.out.println("That is incorrect. Guess again.");
             guess = sc.nextInt();
        
            System.out.println("Your guess is: " + guess);
          
        }
        
        System.out.println("That's right! You're a good guesser.");
        
        /*
        if (guess==secretNum){
            System.out.println("That's right! You're a good guesser.");
        }
        else{
            System.out.println("That is incorrect. Guess again.");
        }
        */
        
    }
    
}
/*
Modify your previous number-guessing game so that they can guess until
they get it right. That means it will keep looping as long as the guess is 
different from the secret number. Use a while loop.

I have chosen a number between 1 and 10. Try to guess it.
Your guess: 5
That is incorrect. Guess again.
Your guess: 4
That is incorrect. Guess again.
Your guess: 8
That is incorrect. Guess again.
Your guess: 6
That's right! You're a good guesser.

*/