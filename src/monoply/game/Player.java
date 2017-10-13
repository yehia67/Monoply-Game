/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import static monoply.game.GamePanel.MessageTextField;
import static monoply.game.MonopolyBoardPanel.allTiles;

/**
 *
 * @author yehia
 */
public class Player {

    public int money = 1500, place = 0;
   
    Dice dice;
    public String name;
    public boolean HasJailCard;
    private MonopolyBoardPanel panel;
    private boolean inJail;
    private int jailOffset;
    private int intialPlace;
    public int houses,hotels;
    private CountriesGroup[] groups = new CountriesGroup[8];
    
    private void initGroups() {
        groups[0] = new CountriesGroup(3); //cyan
        groups[1] = new CountriesGroup(3); //yellow
        groups[2] = new CountriesGroup(3); //pink
        groups[3] = new CountriesGroup(3); //green
        groups[4] = new CountriesGroup(3); //red
        groups[5] = new CountriesGroup(3); //orange
        groups[6] = new CountriesGroup(3); //blue
        groups[7] = new CountriesGroup(2); //brown
        
    }
    
    public CountriesGroup[] getGroupsArray() {
        return groups;
    }

    void move(int place) {
        intialPlace = this.place;
        int secondPlace = (place) % allTiles.length;

        /*allTiles[firstPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(false);
        allTiles[secondPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(true);
        
        this.place=secondPlace;*/
        Player currentPlayer = this;

        Timer timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (intialPlace == secondPlace) {
                    System.out.println("Stopped");
                    allTiles[secondPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(true);
                    currentPlayer.place = (currentPlayer.place + 1) % allTiles.length;
                    System.out.println("place: " + currentPlayer.place);

                    if (currentPlayer.place == 30) {
                        GoToJail.GoToJailAction(currentPlayer);
                    } else if (currentPlayer.place == 2 || currentPlayer.place == 17 || currentPlayer.place == 33) {
                        panel.cards.DrawCard(2, currentPlayer, panel.players);
                    } else if (currentPlayer.place == 7 || currentPlayer.place == 22 || currentPlayer.place == 36) {
                        panel.cards.DrawCard(1, currentPlayer, panel.players);

                    }
                    MainPanel b = (MainPanel) panel.getParent();
                    b.currentPanel.UpdateCurrentDetails();
                    MonopolyBoardPanel.RollButton.setEnabled(true);
                    ((Timer) e.getSource()).stop();
                    if ((secondPlace) > 39 && (secondPlace != 0)) {
                        currentPlayer.money += 200;
                    }
                } else {
                    currentPlayer.animate();
                }

            }
        });
 timer.start();
      

    }

      public void animate ()
    {
        System.out.println("Here");
        this.place=intialPlace;
        allTiles[intialPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(false);
        intialPlace= (intialPlace+1)%allTiles.length;
        allTiles[intialPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(true);
        System.out.println("Intial Place: "+intialPlace);
    }
    public Player(String n) {
        name = n;
        this.HasJailCard= false;
        houses = 0;
        hotels=0;
        jailOffset=0;
        initGroups();
    }
    
    public void addCountry(Country boughtCountry) {
        Color c = boughtCountry.getColor();
        
        if(c == Color.CYAN) {
            groups[0].addCountry(boughtCountry);
        } else if(c == Color.YELLOW) {
            groups[1].addCountry(boughtCountry);
        } else if(c == Color.BLUE) {
            groups[6].addCountry(boughtCountry);
        } else if(c == Color.PINK) {
            groups[2].addCountry(boughtCountry);
        } else if(c == Color.GREEN) {
            groups[3].addCountry(boughtCountry);
        } else if(c == Color.RED) {
            groups[4].addCountry(boughtCountry);
        } else if(c == Color.ORANGE) {
            groups[5].addCountry(boughtCountry);
        } else {
            groups[7].addCountry(boughtCountry);
        }
    }
    
    public void setInJail(boolean flag) {
        inJail = flag;
    }
    
    public boolean getInJail() {
        return inJail;
    }

    public void setJailOffset(int jailOffset) {
        this.jailOffset = jailOffset;
    }

    public int getJailOffset() {
        return jailOffset;
    }

    public void setPanel(MonopolyBoardPanel panel) {
        this.panel = panel;
    }
  
  
}
