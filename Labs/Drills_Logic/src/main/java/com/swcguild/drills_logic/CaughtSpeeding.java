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
public class CaughtSpeeding {

    public int CaughtSpeeding(int speed, boolean isBirthday) {
        int ticket=0;

        if (isBirthday == true) {
            speed = speed - 5;
        }

        if (speed <= 60) {
            ticket = 0;
        } else if (speed >= 61 && speed <= 80) {
            ticket = 1;
        } else if(speed >80){
            ticket = 2;
        }

        return ticket;

    }//end method
}//end class   
    /*
     You are driving a little too fast, and a police officer stops you. 
     Write code to compute the result, encoded as an int value: 

     0=no ticket, 1=small ticket, 2=big ticket. 

     If speed is 60 or less, the result is 0. 
     If speed is between 61 and 80 inclusive, the result is 1. 
     If speed is 81 or more, the result is 2. 

     Unless it is your birthday -- on that day, 
     your speed can be 5 higher in all cases. 

//CaughtSpeeding(60, false) → 0  - not a birthday AT 60 so speed = 60
//CaughtSpeeding(65, false) → 1 - not a birthday over 60 so speed = 65
//CaughtSpeeding(65, true) → 0 - is a birthday, over 60 (so speed = 60

     */
