/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mahmoud
 */
public class StartPanel extends JPanel{
    JButton startButton;
    JButton exitButton;
    private JPanel btnSouth = new JPanel();
    private JTextField[] txts = new JTextField[4];
    private JPanel txtPnl = new JPanel();
    
    public StartPanel()
    {
        txtPnl.setLayout(new FlowLayout());
        for(int i = 0; i < 4; i++) {
            txts[i] = new JTextField();
            txtPnl.add(txts[i]);
        }
        
        startButton = new JButton("Play");
        exitButton = new JButton("Exit");
        this.setLayout(new BorderLayout());
        
        startButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae){
     StartPanel.this.setVisible(false);
   
    //MainFrame.mp.setVisible(true);
       
       }
      });
   
    exitButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae){
     System.exit(0);
       
       }
      });
    
    btnSouth.setLayout(new GridLayout(3, 2));
   
    
    btnSouth.add(startButton);
    btnSouth.add(exitButton);
    this.add(txtPnl);
    this.add(btnSouth, BorderLayout.SOUTH);
     
   
    }
          
}
