/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import monoply.game.*;


/**
 *
 * @author mahmoud
 */
public class MainPanel extends JPanel {
   
    public MonopolyBoardPanel board;
   
    public CurrentPanel currentPanel;
    public PlayersContainerPanel playerPanel;
    
    public int turn;
    public MainPanel(int width , int height) {
        //this.setLayout(new BorderLayout());
        this.setLayout(null);
        this.setSize(width,height);
        System.out.println("Width main panel: "+ width+ "\n Height main panel: "+ height);
       board = new MonopolyBoardPanel(4, height);
        currentPanel = new CurrentPanel();
        currentPanel.setLocation(0, 0);
        currentPanel.setSize((width-height)/3,height);

       // this.add(board);
         playerPanel = new PlayersContainerPanel(4);
         
         board.setLocation(currentPanel.getWidth(), 0);
       playerPanel.setLocation(currentPanel.getWidth()+board.getWidth(), 0);
       playerPanel.setSize(width-board.getWidth()-currentPanel.getWidth(), height);
        this.add(currentPanel);
        
          this.add(board);
        
        this.add(playerPanel);
       
       
      
    }
    
   
    public void update() {
        if(playerPanel != null) {
            playerPanel.updatePanels();
        }
    }

   
}
