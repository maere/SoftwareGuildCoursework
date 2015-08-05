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
public class MonkeyPlay {

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {

        if (aSmile ^ bSmile) {
            return false;
        }
        return true;
    }

}
