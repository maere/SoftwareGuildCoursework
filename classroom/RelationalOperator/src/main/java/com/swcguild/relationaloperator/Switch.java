/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.relationaloperator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Switch {
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Please enter the follwoing");
        System.out.println("1 for helloworld");
         System.out.println("2 for I love Akron");
          System.out.println("3 for I love Java");
             System.out.println("4 for I quit");
             
             int userInput = sc.nextInt();
        
          switch (userInput){ //this is the expression I'm evaluating
              case 1: 
                  System.out.println("Hello World");
                  break;
              case 2:
                  System.out.println("I love Akron");
                  break;
              case 3:
                   System.out.println("I love Java");
                  break;
                  //we don't need 4 because it will 
              case 4:
                   System.out.println("Thank you for playing.");
                  break;
              // this is the default in case it's not 1-4- just needs to be an integer
              default:
                   System.out.println("Please enter a numerical value");
                  //no break after default
          }
        
        
    }
    
}
