/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.relationaloperator;

/**
 *
 * @author apprentice
 */
public class RelationionalOp {
    public static void main(String[] args) {
        boolean test = (5==3+2);
        System.out.println("eval 5== 3+2 => " + test);
        
        //!=
        int value = 15;
        test = (value !=17); //compares left side and right side this evals to true
        System.out.println("eval " +value + " !=17");
        
        int value2 = 32;
        System.out.println("eval value < value2 is " + (value<value2)); //doing eval inline
                
        //greater than
         System.out.println("eval value > value2 is " + (value>value2));
         
         //greater than or equal to
          System.out.println("eval value < value2 is " + (value>=32));
         
         //less than or equal to
         System.out.println("eval value < value2 is " + (value<=15));
         
         
        
        
    }
    
}
