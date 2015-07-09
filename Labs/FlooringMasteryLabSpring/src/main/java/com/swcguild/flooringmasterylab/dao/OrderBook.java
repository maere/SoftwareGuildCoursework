/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab.dao;

import com.swcguild.flooringmasterylab.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public interface OrderBook {
    
    public void loadOrderFile(String date) throws FileNotFoundException;
    
    public void writeOrderFile() throws IOException; //removed string parameter from this method
    
    public ArrayList getOrdersByDate(String orderDate) throws FileNotFoundException;
    
    public void putOrders(Order order) throws IOException;
    
    public Order getOrder(int orderNum);
    
    public void removeOrder(int orderNum);
    
    public void putEditedOrder(Order order) throws IOException;  
    
    public Set<String> getUniqueDate();
    
    //we added these methods to do the test/production mode from a config file, and ended up putting our id counter in the same config file 
    // but let us know if it's better  to move them to the controller and open that up to the outside (?)(it sets our id)
    public String readConfig() throws FileNotFoundException;
    public void saveConfig() throws IOException;
    

}
