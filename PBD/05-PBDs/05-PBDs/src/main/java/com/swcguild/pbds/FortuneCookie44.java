/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbds;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FortuneCookie44 {
    public static void main(String[] args) {
        
        String answer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to pick a random fortune? \"y\" for yes, and \"n\" for no.");
        answer = sc.nextLine();
       

        
        
        
        
        if (answer.equals("y")){
            
            Random r = new Random();
            int pick = 1 + r.nextInt(6);
        
            
               
            switch (pick) {

                case 1:
                     System.out.println("You will soon find what you have been looking for.");
                     break;

                    case 2:
                        System.out.println("Luck is for those who make it.");
                         break;

                        case 3:   
                            System.out.println("Love is an action.");
                             break;

                            case 4:

                                System.out.println("You will someday be old too.");
                                 break;    
                                
                            case 5:
                                System.out.println("Today is a day for butterflies and flowers.");
                                break;
                                    
                            case 6:           
                                        System.out.println("Still waters run deep.");
                                            break;
                  
                default:
                    System.out.println("There was a problem");
                      break;
                    //throw new AssertionError();
            }    
        
        }
        
        else{
        System.out.println("Okay, we'll skip the fortune.");
        }
     
         
    }
    
}
