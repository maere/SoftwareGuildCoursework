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
public class IfStatements {
    public static void main(String[] args) {
        
        int ourValue = 22;
        
        if ((ourValue>=15) && (ourValue<=20)){
            System.out.println("Value is in the 15..20 range" + ourValue);    
        }
        // could add else if too:
        //else if (){
        // value is in the [x..y] range
        // }
        
        else{
             System.out.println("Value is outside of the 15..20 range =>" + ourValue);  
        } 
        
    }
        
       
    }
    
}
