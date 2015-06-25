/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public interface MaterialsDAOFileImpl {
    
    public void loadMatCosts()throws FileNotFoundException;
    
    public double[] getMaterial(String key);
    
}
