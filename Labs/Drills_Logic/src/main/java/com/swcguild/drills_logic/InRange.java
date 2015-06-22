/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drills_logic;

/**
 *
 * @author apprentice
 */
public class InRange {

    public boolean InRange(int n, boolean outsideMode) {
        
        boolean result;
                
        if (outsideMode) {
            if (n<=1 || n>=10){
                result = true;
            }
            else{
                result = false;
            }
            

        } else {
            if (n>=1 && n<=10) 
            {
             result = true;
            }
            else{
            result = false;
            }
        }
        return result;
    }//end method

}//end class
/*
 Given a number n, return true if n is in the range 1..10, inclusive. 
 Unless "outsideMode" is true, in which case return true if the number is less or equal to 1, 
 or greater or equal to 10. 

 InRange(5, false) → true
 InRange(11, false) → false
 InRange(11, true) → true


 */
