/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import monoply.game.*;

/**
 *
 * @author ASUS
 */
public class playerPanel extends JPanel {

    private Player player;
    private JLabel playerNameLbl = new JLabel("Player : ");
    private JLabel playerMoneyLbl = new JLabel("Money : ");
    private JComboBox playerCountriesComboBox = new JComboBox();
    private BufferedImage backgroundImage;

    public playerPanel(Player player) {
        this.player = player;
        this.setLayout(new GridLayout(3, 1));
        System.out.println("PlayerPanel Constructor");
        init();
    }

    private void init() {
        /*     try
        {
    backgroundImage = ImageIO.read(new File("Monopoly Board/monopolybg2.jpg" ) );
        }
        catch(Exception ex)
        {
            System.out.println("FAIL");
        }*/

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
        playerMoneyLbl.setText("Money : " + player.money);
        playerCountriesComboBox.removeAllItems();

        CountriesGroup[] groups = player.getGroupsArray();

        if (groups == null) {
            System.out.println("hello");
        }

        for (int i = 0; i < groups.length; i++) {
            ArrayList<Country> countries = groups[i].getCountries();
            for (int j = 0; j < countries.size(); j++) {
                playerCountriesComboBox.addItem(countries.get(j).getName());
            }
        }

        for (int i = 0; i < player.getProperties().size(); i++) {
            playerCountriesComboBox.addItem(player.getProperties().get(i).getName());
        }
    }

    public String getSelectedItem() {
        return (String) playerCountriesComboBox.getSelectedItem();
    }

    public void removePlayer() {
        playerNameLbl.setEnabled(false);
        playerMoneyLbl.setEnabled(false);
        playerCountriesComboBox.setEnabled(false);
    }

    /* @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
}*/
}
