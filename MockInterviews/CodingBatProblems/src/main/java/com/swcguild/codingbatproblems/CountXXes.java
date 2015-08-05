/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.codingbatproblems;

/**
 *
 * @author apprentice
 */
public class CountXXes {

    public int countXX(String str) {
        int count = 0;
        //int index = 0;
        String tempString;

        while (str.length() > 0 && str.contains("xx")) {

            if (str.contains("xx")) {
                count++;
                
            }

            int currIndex = str.indexOf("x");
            //index++;
            tempString = str.substring(currIndex+1);
            str = tempString;
        }

        return count;
    }

}
