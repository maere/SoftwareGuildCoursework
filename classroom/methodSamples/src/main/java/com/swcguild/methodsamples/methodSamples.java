/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.methodsamples;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class methodSamples {
    public static void main(String[] args) {
        
        //Scanner sc = new Scanner(System.in);
        
        //String result = sc.nextLine();
        
        float testFloat = Float.parseFloat("42.3");
        
        printHiYa();
        
        double pi = calculatePi();
        System.out.println("Pi: "+ pi);
        
      int value = add(3,5);
      System.out.println("Your two numbers add to " + value);
      
        
    }//psvm this is the scope of the function -- you can collapse main wiht the minus
    
    public static void printHiYa(){
        
    System.out.println("HiYa");
    }
    
      public static double calculatePi(){
          return 3.14;
      }
      

       public static int add1And1(){
            return 1+1;
        }
            public static int add1And2(){
            return 1+2;
            }
            
                public static int add1And3(){
                    return 1+3;
                }
                
                    public static int add(int a, int b){
                        return a+b;
                    } 
}