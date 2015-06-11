/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens;
/**
 *
 * @author apprentice
 */
public class AppLuckySevens {
    public static void main(String[] args) {
        
        LuckySevensRefactored testRun = new LuckySevensRefactored(0,0, 0,500);
        //I am calling non-static methods from a static thing
        int moneyTest = testRun.getPlayerMoney();
        System.out.println(moneyTest);
        
      
        //playOn();
        //rollDice();
        //moneyTracker(playerMoney);
        
    }
    
}
