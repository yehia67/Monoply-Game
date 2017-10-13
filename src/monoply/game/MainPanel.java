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
    private CurrentPanel currentpanel;
    private MonopolyBoardPanel board;
    private PlayerPanel playerpanel;
     private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    int turn;
    public MainPanel() {
        this.setLayout(new BorderLayout());
       board = new MonopolyBoardPanel(4);
        westPanel = new CurrentPanel();
     
        this.add(board);
         eastPanel = new PlayerPanel();
         
       
        this.add(westPanel, BorderLayout.WEST);
          this.add(board, BorderLayout.CENTER);
        
        this.add(eastPanel, BorderLayout.EAST);
       
         
        
    }
    
   
}
