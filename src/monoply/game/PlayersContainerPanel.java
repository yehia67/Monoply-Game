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
    private ArrayList<playerPanel> playerPanel = new ArrayList<playerPanel>();
    private JPanel btnsPanel = new JPanel();
    private JPanel playersPanel = new JPanel();
    private JButton buyBtn = new JButton("Buy");
    private JButton sellBtn = new JButton("Sell");
    
    public PlayersContainerPanel(int numOfPlayers) {
        this.setLayout(new BorderLayout());
        playersPanel.setLayout(new GridLayout(2,2));
        for(int i = 0; i < numOfPlayers; i++) {
            playerPanel.add(new playerPanel(MonopolyBoardPanel.players.get(i)));
            playersPanel.add(playerPanel.get(i));
        }
        
        this.add(playersPanel);
        
        btnsPanel.setLayout(new GridLayout(1, 2));
        btnsPanel.add(buyBtn);
        btnsPanel.add(sellBtn);
        
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
                        updatePanels();
                    } else {
                        showWarning();
                    }
                } else {
                    showWarning();
                }
            }
        });
        
        sellBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentPlayerIndex = MonopolyBoardPanel.players.indexOf(MonopolyBoardPanel.currentPlayer);
                playerPanel p = playerPanel.get(currentPlayerIndex);
                String x = p.getSelectedItem();
                
                CountriesGroup[] groups = MonopolyBoardPanel.currentPlayer.getGroupsArray();
                for(int i = 0; i < groups.length; i++) {
                    ArrayList<Country> countries = groups[i].getCountries();
                    for(int j = 0; j < countries.size(); j++) {
                        if( x.equalsIgnoreCase(countries.get(j).getName())) {
                            MonopolyBoardPanel.currentPlayer.money += countries.get(j).getPrice();
                            countries.get(j).setOwner(null);
                            countries.remove(countries.get(j));
                            p.updatePanel();
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
        
        this.add(btnsPanel, BorderLayout.SOUTH);
    }
    
    private void showWarning() {
        JOptionPane.showMessageDialog(null, "Sorry you can't buy this place",
                            "", 3);
    }
    
    public void updatePanels() {
        for(int i = 0; i < playerPanel.size(); i++) {
            playerPanel.get(i).updatePanel();
        }
    }
}
