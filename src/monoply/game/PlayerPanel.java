/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author ASUS
 */
public class PlayerPanel extends JPanel{
    private Player player;
    private JLabel playerNameLbl = new JLabel("Player : ");
    private JLabel playerMoneyLbl = new JLabel("Money : ");
    private JComboBox playerCountriesComboBox = new JComboBox();
    
    public PlayerPanel(Player player) {
        this.player = player;
        this.setLayout(new GridLayout(3, 1));
        System.out.println("PlayerPanel Constructor");
        init();
    }
     
    private void init()
    {
        playerNameLbl.setText(playerNameLbl.getText() + player.name);
        playerMoneyLbl.setText(playerMoneyLbl.getText() + player.money);
        this.add(playerNameLbl);
        this.add(playerMoneyLbl);
        this.add(playerCountriesComboBox);
    }
    
    /*private void initLabels(int numberofPlayers) {
        this.setLayout(new GridLayout(8,1));
        JPanel sample = new JPanel();
        JLabel label = new JLabel("Player Name");
        label.setForeground(Color.blue);
        label.setBackground(Color.lightGray);
        label.setOpaque(true);
        this.add(label);
    }*/
    
    public void updatePanel() {
        playerMoneyLbl.setText(playerMoneyLbl.getText() + player.money);
        playerCountriesComboBox.removeAllItems();
        
        CountriesGroup[] groups = player.getGroupsArray();
        
        if(groups == null) {
            System.out.println("hello");
        }
        
        for(int i = 0; i < groups.length; i++) {
            ArrayList<Country> countries = groups[i].getCountries();
            for(int j = 0; j < countries.size(); j++) {
                playerCountriesComboBox.addItem(countries.get(j).getName());
            }
        }
    }
}
