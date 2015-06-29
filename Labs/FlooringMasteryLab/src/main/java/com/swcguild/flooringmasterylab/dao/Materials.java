/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab.dao;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface Materials {
    
    public HashMap loadMatCosts()throws FileNotFoundException;
    
    public double[] getMaterial(String key);
    
}
