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
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
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
    public ImageIcon currImage;
    public String test1;
     public CurrentPanel() {
              System.out.println("Current Constructor");
        init();
    }
     
    public void init()
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
   try{
               currImage = new ImageIcon(ImageIO.read(new File("Monopoly Board/" 
                    + MonopolyBoardPanel.allTiles[0].imgName)));
                       }
               catch(Exception ex){
                  System.out.println("Failed man");
               }

           this.TileImageLabel.setIcon(currImage);
        
           this.add(TileImageLabel);
    }
   
    
    
    
    public void UpdateCurrentDetails()
    {
        int location = MonopolyBoardPanel.players.get(MonopolyBoardPanel.returnTurn()).place;
     try{
               currImage = new ImageIcon(ImageIO.read(new File("Monopoly Board/" 
                    + MonopolyBoardPanel.allTiles[location].imgName)));
                       }
               catch(Exception ex){
                   
               }
         
    
       if(location>=0 && location<11)
       this.TileImageLabel.setIcon(currImage);
       
       else if(location>=11 && location <20)
       {
           
           RotatedIcon ri = new RotatedIcon(currImage, 270.0);
           this.TileImageLabel.setIcon(ri);
       
       }
       
       else if(location>=20 && location <=30)
       {
           
           RotatedIcon ri = new RotatedIcon(currImage, 180.0);
           this.TileImageLabel.setIcon(ri);
       
       }
       else if(location>30 && location<=39)
       {
            RotatedIcon ri = new RotatedIcon(currImage, 90.0);
           this.TileImageLabel.setIcon(ri);
       
       }
    
 
    }
    

 
    
}
