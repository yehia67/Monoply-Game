/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import static UserInterface.MonopolyBoardPanel.getCurrentPlayerName;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import static monoply.game.MonopolyBoardPanel.getCurrentPlayerName;
import monoply.game.*;
import monoply.game.RotatedIcon;

/**
 *
 * @author ASUS
 */


public class CurrentPanel extends JPanel{
    private BufferedImage backgroundImage;
    public PlayersContainerPanel playerContainerRef;
    public JLabel TileImageLabel; 
    public ImageIcon currImage;
    public JLabel LabelName;
    public static JLabel savinglabel;
    public static JLabel tosavelabel;
    public String test1;
    private JButton saveBtn = new JButton("Save");
   // private JPanel btnsPanel = new JPanel();
    JPanel buySellPnl = new JPanel(new GridLayout(1, 2));
    public JButton buyBtn = new JButton("Buy");
    private JButton sellBtn = new JButton("Sell");
     public CurrentPanel() {
        
            
        init();
    }
     
    public void init()
    {    
         
        
        TileImageLabel = new JLabel();
            LabelName   =   new JLabel("Hello world!");
            savinglabel =  new JLabel("Saving...");
            tosavelabel = new JLabel("<html>To save game press \"CTRL+S\" or press <br>  \"ALT\" to view and hide menu bar<html>");
            savinglabel.setVisible(false);
         
        try
        {
    backgroundImage = ImageIO.read(new File("Monopoly Board/monopolybg3.jpg" ) );
        }
        catch(Exception ex)
        {
            System.out.println("FAIL");
        }
        
               
            Dimension size = new Dimension(backgroundImage.getWidth(),
            backgroundImage.getHeight());
            
      this.setLayout(new GridLayout(7,1));
    //  this.setSize(200, 200);
    // this.setPreferredSize(new Dimension(200,200));
      
//     Board.players.get(Board.turn)                                                                                                                                                                                                                                                                                                                                                                                                                                   
     JPanel sample = new JPanel();
   

  TileImageLabel.setSize(new Dimension(200,200));
  System.out.println("/"+ MonopolyBoardPanel.allTiles[0].imgName+ ".png");
   try{
               currImage = new ImageIcon(ImageIO.read(new File("Monopoly Board/" 
                    + MonopolyBoardPanel.allTiles[0].imgName)));
                       }
               catch(Exception ex){
                  System.out.println("Failed man");
               }

           this.TileImageLabel.setIcon(currImage);
             buySellPnl.setLayout(new GridLayout(1, 2));
              buySellPnl.add(buyBtn);
          buySellPnl.add(sellBtn);
        
          this.TileImageLabel.setHorizontalAlignment(JLabel.CENTER);
         //  this.TileImageLabel.setVerticalAlignment(JLabel.CENTER);
           this.TileImageLabel.setAlignmentY(CENTER_ALIGNMENT);
          this.add(Box.createVerticalGlue());
         this.add(Box.createVerticalGlue());
        // this.add(buySellPnl);
           this.add(TileImageLabel);
          this.add(LabelName);
         LabelName.setSize(50, 100);
         LabelName.setText(getCurrentPlayerName());
         
         
    
     
        
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerPlace = MonopolyBoardPanel.currentPlayer.place;
                if(MonopolyBoardPanel.allTiles[playerPlace] instanceof PropertyTile) {
                    PropertyTile property = (PropertyTile)MonopolyBoardPanel.allTiles[playerPlace];
                    if(property.getOwner() == null) {
                        property.setOwner(MonopolyBoardPanel.currentPlayer);
                        System.out.println(MonopolyBoardPanel.currentPlayer.money);
                        MonopolyBoardPanel.currentPlayer.addProperty((PropertyTile)MonopolyBoardPanel.allTiles[playerPlace]);
                       
                      MainPanel main = (MainPanel) CurrentPanel.this.getParent();
                        main.getPlayersContainer().updatePanels();
                      
                      
                    } else {
                        showWarning("Sorry you can't buy this place");
                    }
                } else {
                    showWarning("Sorry you can't buy this place");
                }
            }
        });
        
        sellBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentPlayerIndex = MonopolyBoardPanel.players.indexOf(MonopolyBoardPanel.currentPlayer);
                //playerPanel p = playerContainerRef.playerPanel.get(currentPlayerIndex);
                MainPanel mp = (MainPanel) CurrentPanel.this.getParent();
                playerPanel p = mp.getPlayersContainer().playerPanel.get(currentPlayerIndex);
                String x = p.getSelectedItem();
                
                CountriesGroup[] groups = MonopolyBoardPanel.currentPlayer.getGroupsArray();
                for(int i = 0; i < groups.length; i++) {
                    ArrayList<Country> countries = groups[i].getCountries();
                    for(int j = 0; j < countries.size(); j++) {
                        if( x.equalsIgnoreCase(countries.get(j).getName())) {
                            MonopolyBoardPanel.currentPlayer.money += countries.get(j).getPrice();
                            countries.get(j).setTax(countries.get(j).getTotalFees());
                            countries.get(j).setOwner(null);
                            countries.remove(countries.get(j));
                            mp.update();
                            return;
                        }
                    }
                }
                
                for(int i = 0; i < MonopolyBoardPanel.currentPlayer.getProperties().size(); i++) {
                    if( x.equalsIgnoreCase(MonopolyBoardPanel.currentPlayer.getProperties().get(i).getName())) {
                        MonopolyBoardPanel.currentPlayer.money += MonopolyBoardPanel.currentPlayer.getProperties().get(i).getPrice();
                        MonopolyBoardPanel.currentPlayer.getProperties().get(i).setOwner(null);
                        MonopolyBoardPanel.currentPlayer.getProperties().remove(MonopolyBoardPanel.currentPlayer.getProperties().get(i));
                        p.updatePanel();
                        return;
                    }
                }
            }
        });
         this.add(buySellPnl);
         this.add(tosavelabel);
         this.add(savinglabel);
      /*   saveBtn.addActionListener(new ActionListener() {
           @Override
             public void actionPerformed(ActionEvent ev) {
                saveGame();
             }
         });
         
         this.add(saveBtn);*/
    }
    
   /* public void saveGame() {
        MainPanel p = (MainPanel) this.getParent();
        p.board.save();
    }*/
   
    
    
    
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
     LabelName.setText(getCurrentPlayerName());
 
    }
    
      
     public JButton getBuyBtn() {
        return buyBtn;
    }
     private void showWarning(String msg) {
        JOptionPane.showMessageDialog(null, msg,
                            "", 3);
    }
   @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
}
 
    
}
