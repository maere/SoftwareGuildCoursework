/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drills_conditionals;

/**
 *
 * @author apprentice
 */
public class Front3 {
    
    
    public String front3(String str){
        String returnStr = null;
        
        if(str.length()<3)
        {
            String clip = str.substring(0, (str.length()));
            returnStr = clip+clip+clip;
        }
        else
        
        {
            String clip = str.substring(0, 3);
            returnStr = clip+clip+clip;
        }
        
        return returnStr;
    }
    
    
}

/*
Given a string, we'll say that the front is the first 3 chars of the string. 
If the string length is less than 3, the front is whatever is there. 
Return a new string which is 3 copies of the front. 


*/
