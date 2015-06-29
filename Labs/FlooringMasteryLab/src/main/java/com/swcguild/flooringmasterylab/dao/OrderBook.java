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
    
    public void writeOrderFile(String date) throws IOException;
    
    public ArrayList getOrdersByDate(String orderDate) throws FileNotFoundException;
    
    public void putOrders(Order order) throws IOException;
    
    public Order getOrder(int orderNum);
    
    public void removeOrder(int orderNum);
    
    public Set<String> getUniqueDate();
    

    

}
