/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

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
        this.setLayout(new FlowLayout());
        this.setSize(width,height);
       board = new MonopolyBoardPanel(4);
        currentPanel = new CurrentPanel();
      

       // this.add(board);
         playerPanel = new PlayersContainerPanel(4);
         
       
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
