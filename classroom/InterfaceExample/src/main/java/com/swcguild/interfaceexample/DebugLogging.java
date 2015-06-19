/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interfaceexample;

/**
 *
 * @author apprentice
 */
public interface DebugLogging extends Debuggable {
    
    public void logStatus(String status);
    public void logError(String error);
    
}
