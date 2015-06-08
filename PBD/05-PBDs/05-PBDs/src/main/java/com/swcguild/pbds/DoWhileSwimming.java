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
public class DoWhileSwimming {
    
    public static void main( String[] args ) throws Exception
    {
        Scanner keyboard = new Scanner(System.in);

        String swimmer1 = "GALLANT";
        String swimmer2 = "GOOFUS ";

        double minimumTemperature = 79.0; // degrees Fahrenheit
        double currentTemperature;
        double savedTemperature;
        int swimTime;

        System.out.print("What is the current water temperature? ");
        currentTemperature = keyboard.nextDouble();
        savedTemperature = currentTemperature; // saves a copy of this value so we can get it back later.

        System.out.println( "\nOkay, so the current water temperature is " + currentTemperature + "F." );
        System.out.println( swimmer1 + " approaches the lake...." );

        swimTime = 0;
        while ( currentTemperature >= minimumTemperature )
        {
            System.out.print( "\t" + swimmer1 + " swims for a bit." );
            swimTime++;
            System.out.println( " Swim time: " + swimTime + " min." );
            Thread.sleep(600); // pauses for 600 milliseconds
            currentTemperature -= 0.5; // subtracts 1/2 a degree from the water temperature
            System.out.println( "\tThe current water temperature is now " + currentTemperature + "F." );
        }

        System.out.println( swimmer1 + " stops swimming. Total swim time: " + swimTime + " min." );

        currentTemperature = savedTemperature; // restores original water temperature

        System.out.println( "\nOkay, so the current water temperature is " + currentTemperature + "F." );
        System.out.println( swimmer2 + " approaches the lake...." );

        swimTime = 0;
        do
        {
            System.out.print( "\t" + swimmer2 + " swims for a bit." );
            swimTime++;
            System.out.println( " Swim time: " + swimTime + " min." );
            Thread.sleep(600);
            currentTemperature -= 0.5;
            System.out.println( "\tThe current water temperature is now " + currentTemperature + "F." );

        } while ( currentTemperature >= minimumTemperature );

        System.out.println( swimmer2 + " stops swimming. Total swim time: " + swimTime + " min." );
    }
    
}
/*

Run the program, and type in 80.5 for the current water temperature. 
Do Goofus and Gallant swim for the same amount of time? 
Put your answer in a comment 
// Yes, they swim the same amoutn of time.

Run the program again, but this time enter 78 for the starting temperature. What changes?
//The minimum temp is the same for both swimmers, but they are controlled by two different types of loops--
//--Gallant's loop will not run if 78 is the temp bc the while loop will never execute.
//--Goofus is bound by a do/while loop, so it will execute at least once before it checks the condition.
//So even though the temperature is below the minimum, Goofus will swim once.

Does Gallant check the water temperature first, or does he just dive right in?
//Gallant checks the water tempertaure first, before he will swim.

What about Goofus? Does he check the water temperature first or just dive in?
//Goofus will enter the water (i.e. dive right in) and then check.

What is the difference between a while loop and a "do-while" loop?
//The while loop will only run if the condition is met, the do/while will run at least once--whether or not the condition is met, 
//but will run again if the condition is met, and stop if it is not after the initial "do"

One of these loops is sometimes called a "pre-test loop", and the other is called a "post-test loop". 
Which one is which? 
//The while loop is the "pre-test" and the do/While is the "post-test" loop.


*/
