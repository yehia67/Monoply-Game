/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */
public class PlayersContainerPanel extends JPanel {
    private ArrayList<PlayerPanel> playerPanel = new ArrayList<PlayerPanel>();
    private JPanel btnsPanel = new JPanel();
    private JPanel playersPanel = new JPanel();
    private JButton buyBtn = new JButton("Buy");
    private JButton sellBtn = new JButton("Sell");
    
    public PlayersContainerPanel(int numOfPlayers) {
        this.setLayout(new BorderLayout());
        playersPanel.setLayout(new GridLayout(2,2));
        for(int i = 0; i < numOfPlayers; i++) {
            playerPanel.add(new PlayerPanel(MonopolyBoardPanel.players.get(i)));
            playersPanel.add(playerPanel.get(i));
        }
        
        this.add(playersPanel);
        
        btnsPanel.setLayout(new GridLayout(1, 2));
        btnsPanel.add(buyBtn);
        btnsPanel.add(sellBtn);
        
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerPlace = MonopolyBoardPanel.players.get(MonopolyBoardPanel.turn).place;
                
                if(MonopolyBoardPanel.allTiles[playerPlace] instanceof Country) {
                    MonopolyBoardPanel.players.get(MonopolyBoardPanel.turn)
                            .addCountry((Country)MonopolyBoardPanel.allTiles[playerPlace]);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you can't buy this place",
                            "", 3);
                }
            }
        });
        
        this.add(btnsPanel, BorderLayout.SOUTH);
    }
}
