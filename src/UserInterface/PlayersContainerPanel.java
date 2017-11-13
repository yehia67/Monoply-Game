/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import monoply.game.*;

/**
 *
 * @author mahmoud
 */
public class PlayersContainerPanel extends JPanel {
    public ArrayList<playerPanel> playerPanel = new ArrayList<playerPanel>();
    private JPanel btnsPanel = new JPanel();
    private JPanel playersPanel = new JPanel();
  
    private JButton buildBtn = new JButton("Build");
    
    public PlayersContainerPanel(int numOfPlayers) {
        this.setLayout(new BorderLayout());
        playersPanel.setLayout(new GridLayout(2,2));
        for(int i = 0; i < numOfPlayers; i++) {
            playerPanel.add(new playerPanel(MonopolyBoardPanel.players.get(i)));
            playersPanel.add(playerPanel.get(i));
        }
        
        this.add(playersPanel);
        
        btnsPanel.setLayout(new GridLayout(1, 1));
       
        JPanel buildBtnPnl = new JPanel();
        buildBtnPnl.add(buildBtn);
        //btnsPanel.add(buySellPnl);
        btnsPanel.add(buildBtnPnl);
        
        
        
        buildBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                build();
                
            }
        });
        
        this.add(btnsPanel, BorderLayout.SOUTH);
    }
    
    private void showWarning(String msg) {
        JOptionPane.showMessageDialog(null, msg,
                            "", 3);
    }
    
    public void updatePanels() {
        for(int i = 0; i < playerPanel.size(); i++) {
            playerPanel.get(i).updatePanel();
        }
    }
    
    private void build() {
        int currentPlayerIndex = MonopolyBoardPanel.players.indexOf(MonopolyBoardPanel.currentPlayer);
        playerPanel p = playerPanel.get(currentPlayerIndex);
        String x = p.getSelectedItem();
        
        for(int i = 0; i < MonopolyBoardPanel.allTiles.length; i++) {
            if(MonopolyBoardPanel.allTiles[i] instanceof Country) {
                Country country = (Country) MonopolyBoardPanel.allTiles[i];
                
                if(country.getName().equalsIgnoreCase(x)) {
                    if(country.getCanBuildHousesFlag()) {
                        if(MonopolyBoardPanel.currentPlayer.money > country.getPrice()) {
                            country.getHousesImgs()[country.getHousesNumber()].setVisible(true);
                            country.buildHouse();
                        } else {
                            showWarning("You don't have enough money");
                        }
                    } else if(country.getCanBuildHotelFlag()) {
                        if(MonopolyBoardPanel.currentPlayer.money > country.getPrice()) {
                            country.showHotel();
                            country.buildHotel();
                        } else {
                            showWarning("You don't have enough money");
                        }
                    } else {
                        if(country.getHotelsNumber() > 0) {
                            showWarning("You can't build on the same country anymore!");
                        } else {
                            showWarning("You have to get all the countries of the same color");
                        }
                    }
                }
            }
        }
    }
    
    
}
