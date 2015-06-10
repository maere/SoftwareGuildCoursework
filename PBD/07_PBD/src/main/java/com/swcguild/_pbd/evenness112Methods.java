/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild._pbd;

/**
 *
 * @author apprentice
 */
public class evenness112Methods {
    
    //The function should return the value true if n is an even number (evenly divisible by 2) 
    //and false otherwise.
    public static boolean isEven(int n){
        
        return n%2==0;
    }
    
  //Also, write public static boolean isDivisibleBy3( int n )
//The function should return the value true if n is evenly divisible by 3 and false otherwise.
    public static boolean isDivisibleBy3( int n ){
        
        //an if/else statement is unnecessary bc when the method evaluates it will either give true or false
        //we have declared that so all we need to do is return the expression and it will do all of the work.
        
        return n%3==0;
        
    }
    // start main
    public static void main(String[] args) {
        
         for (int i=0; i<=20; i++){
    
        if (isDivisibleBy3(i) && isEven(i)){
            System.out.println(i + "<=" );
}
        else if (isEven(i)){
            System.out.println(i + "<");
            
    
}        else if (isDivisibleBy3(i)){
            System.out.println(i + "=");
            
}
        else {
            System.out.println(i);
}
        
    }
}  
  
    
}
/*



Write a main() that contains a for loop to generate all the numbers from 1 to 20. 
Use if statements inside the loop to mark the number with a "<" if it's even, with a "=" if it's 
evenly divisible by 3, and with both if it's divisible by both 2 and 3.
*/