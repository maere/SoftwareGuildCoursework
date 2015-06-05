/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

/**
 *
 * @author apprentice
 */
public class ArraySamples {
    public static void main(String[] args) {
        
    //step 1: declaration
        int[] teamScores;
        
    //step 2: instantiate it number of elements
        teamScores = new int[10];
        
    //step 3: assign element values
        teamScores[0] = 2;
        teamScores[1] = 45;
        teamScores[2] = 8;
        teamScores[3] = 24;
        teamScores[4] = 99;
        teamScores[5] = 23;
        teamScores[6] = 28;
        teamScores[7] = 88;
        teamScores[8] = 1;
        teamScores[9] = 42;
        
    //we didn't fill in all of values -- what happens? -- it will just create empty elements with either 0 for int
    // teamScores = {1, 2, 3, ...}; -- cannot do this!
    // or "null" for strings et al
        
    //alt way to populate an array is to declar, instantiate & assigns on the fly with a collection
    // this instantiates the array we declared and assigns the elements with the # of values indicated in the collection
        int [] testArray = {2, 4, 6, 12, 42}; //this is just a "collection" of literals
        
    //collection of string literals
        String[] testStrings = {"test", "me", "please"};
        
        int currentScore = teamScores[2];
        
        teamScores[4]=109;
        
        for (int i=1; i<teamScores.length; i++){
            System.out.println("Elements = [" + i + "]=" + teamScores[i]);
        }
        
        //"out of bounds" exception gets thrown if you ask for an element that doesn't exist in an array
        //i.e. if you ask specifically for [10] in our array above that only has 0-9 elements
        
        //traverses all elements in the array without knowing lenght or the names of stuff
        //other languages call this a "for each" 
        for (int num : teamScores){ //will feed each elem seq in the variable which is declared within the loop here with num
            System.out.println("Element = " + num);
        }
        
        //declare two dim array
        String [][] cityTeams = {
            {"Cleveland", "Browns", "Cavs", "Indians"}, // note comma between subarrays
            {"Columbus", "BJ", "Bucks"},
            {"Pitts", "Steelers" }
        }; // note arrays end with semicolon
        
        for (int i = 0; i < cityTeams.length; i++){ //outer loop deals with rows
            for (int j = 0; j < cityTeams[i].length; j++){ //inner loop deals with elements in each row/collection
                System.out.println(cityTeams[i][j]+ "");
            }
            System.out.println("");
        }
        
        
        
    }
    
}
