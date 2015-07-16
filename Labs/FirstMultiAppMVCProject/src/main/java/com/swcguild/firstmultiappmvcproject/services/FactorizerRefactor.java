/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.firstmultiappmvcproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FactorizerRefactor {
//start refactor

    // fields
    private int numFact = 0;
    private int sum = 0;
    private int number = 0;
    public int[] factorArray; //equivalent to delcaring an object value
    //int tempNumb = 0;

    //constructor
    public FactorizerRefactor(int number) {
        //only need params in constructor if I want to change them when I "new" it up/instantiate 
        this.number = number;

    }

    public ArrayList<Integer> gatherResultsArray() { //changed to return list
        factorArray = new int[3];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = number; i >= 1; i--) {
            //tempNumb = number;// 6, 3,2,1
            if (number % i == 0) {
                // The program must print out each factor of the number (not including the number itself).
                //w. refactor, if the num is a factor, I need to push into the array, so..
                list.add(i);
                //System.out.println(i);
                sum = sum + i;
                numFact++;

            }
        }
        factorArray[0] = number;
        factorArray[1] = sum;
        factorArray[2] = numFact;

        return list;
    }


//
        //moved this method to the view
//    public void printResult() {
//        // this was pulled from my loop, need to do a for/each on the array
//        //to do the printing>>
//        for (int value : factorArray) {
//            System.out.println(value);
//        }
//
//        System.out.println("There are " + numFact + " factors for your number " + number);
//        //return sum;
//    }
    public boolean perfectNums() {
        // The program must print out whether or not the number is perfect.
        int sumCorrection = sum - number;
        //System.out.println("sumCorris now: " + sumCorrection);

        boolean perfectResult = false;
        if (number == sumCorrection) {
            perfectResult = true;
        }
        return perfectResult;
    }

    public boolean primeNums() {

        boolean primeResult = false;

// The program must print out whether or not the number is prime.
        if (numFact == 2) {
            primeResult = true;
        }
        return primeResult;
    }

//when you finish refactoring, he wants us to create  a "run" method 
    //in the class that does the callling of the methods in the class for the object
    //ultimately we only want to call run(); in our app.class.
}//end class
