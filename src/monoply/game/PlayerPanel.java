/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author ASUS
 */
public class PlayerPanel extends JPanel{
    
     JLabel[] labels;
  
    
    
     public PlayerPanel() {
         System.out.println("PlayerPanel Constructor");
        init();
    }
     
    private void init()
    {
    
   
      //  hideButton();
    }
    
    private void initLabels(int numberofPlayers) {
 
      this.setLayout(new GridLayout(8,1));
     JPanel sample = new JPanel();
    JLabel label = new JLabel("Player Name");
    label.setForeground(Color.blue);
    label.setBackground(Color.lightGray);
    label.setOpaque(true);
    this.add(label);
    
    
      
      
      
      
    }
}
