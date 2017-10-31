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
    private ArrayList<playerPanel> playerPanel = new ArrayList<playerPanel>();
    private JPanel btnsPanel = new JPanel();
    private JPanel playersPanel = new JPanel();
    private JButton buyBtn = new JButton("Buy");
    private JButton sellBtn = new JButton("Sell");
    private JButton buildBtn = new JButton("Build");
    
    public PlayersContainerPanel(int numOfPlayers) {
        this.setLayout(new BorderLayout());
        playersPanel.setLayout(new GridLayout(2,2));
        for(int i = 0; i < numOfPlayers; i++) {
            playerPanel.add(new playerPanel(MonopolyBoardPanel.players.get(i)));
            playersPanel.add(playerPanel.get(i));
        }
        
        this.add(playersPanel);
        
        btnsPanel.setLayout(new GridLayout(2, 1));
        JPanel buySellPnl = new JPanel(new GridLayout(1, 2));
        buySellPnl.add(buyBtn);
        buySellPnl.add(sellBtn);
        
        JPanel buildBtnPnl = new JPanel();
        buildBtnPnl.add(buildBtn);
        btnsPanel.add(buySellPnl);
        btnsPanel.add(buildBtnPnl);
        
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
                        showWarning("You have to get all the countries of the same color");
                    }
                }
            }
        }
    }
    
    public JButton getBuyBtn() {
        return buyBtn;
    }
}
