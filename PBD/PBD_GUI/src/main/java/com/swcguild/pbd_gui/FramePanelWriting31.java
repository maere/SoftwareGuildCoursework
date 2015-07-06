/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.pbd_gui;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author apprentice
 */
public class FramePanelWriting31 {
    
    public static void main(String[] args) {
        Frame613 f = new Frame613();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}    


class Frame613 extends JFrame{
    public Frame613(){
        setTitle("613 Rocks!");
        setSize(300, 200);
        setLocation(100, 200);
        
        Panel1613 panel = new Panel1613();
        Container cp = getContentPane();
        cp.add(panel);
    }

 
}
 
class Panel1613 extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Hi", 75, 100);
    }
    
}

    

