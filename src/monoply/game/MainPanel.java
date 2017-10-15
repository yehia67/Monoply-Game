/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
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
    public MainPanel() {
        this.setLayout(new BorderLayout());
       board = new MonopolyBoardPanel(4);
        currentPanel = new CurrentPanel();
      

        this.add(board);
         playerPanel = new PlayersContainerPanel(4);
         
       
        this.add(currentPanel, BorderLayout.WEST);
          this.add(board, BorderLayout.CENTER);
        
        this.add(playerPanel, BorderLayout.EAST);
       
       
      
    }
    
   
    

   
}
