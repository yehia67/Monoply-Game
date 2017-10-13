/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */


public class CurrentPanel extends JPanel{
 
    public JLabel TileImageLabel;    
    public String test1;
     public CurrentPanel() {
              System.out.println("Current Constructor");
        init();
    }
     
    private void init()
    {
   
      this.setLayout(new GridLayout(8,1));
     this.setPreferredSize(new Dimension(200,200));
      
//     Board.players.get(Board.turn)                                                                                                                                                                                                                                                                                                                                                                                                                                   
     JPanel sample = new JPanel();
    JTextField messageTextField = new JTextField("Message goes here ");
    JLabel message = new JLabel("Hello");
    this.add(messageTextField);
    this.add(message);
    TileImageLabel = new JLabel();
  TileImageLabel.setSize(new Dimension(50,50));
  System.out.println("/"+ MonopolyBoardPanel.allTiles[0].imgName+ ".png");
    TileImageLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/"+ MonopolyBoardPanel.allTiles[0].imgName)).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    this.add(TileImageLabel);
   
    }
    
    public void UpdateCurrentDetails()
    {
          int location = MonopolyBoardPanel.players.get(MonopolyBoardPanel.returnTurn()).place;
    
         if(location>= 0 && location<11)
    {
          ImageIcon currImg = new ImageIcon(new ImageIcon(getClass().getResource("/"+ MonopolyBoardPanel.allTiles[location].imgName+ ".png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
           this.TileImageLabel.setIcon(currImg);
    }
 
    }
    

 
    
}
