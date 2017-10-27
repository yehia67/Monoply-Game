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
//import static monoply.game.GamePanel.MessageTextField;
import static monoply.game.MonopolyBoardPanel.allTiles;
import static monoply.game.MonopolyBoardPanel.turn;

/**
 *
 * @author yehia
 */
public class Player {

    public int money = 1500, place = 0;
   
    Dice dice;
    public String name;
    public boolean HasJailCard;
    public static MonopolyBoardPanel panel;
    private boolean inJail;
    private int jailOffset;
    private int intialPlace;
    public int houses,hotels,railroads,utility;
    private CountriesGroup[] groups = new CountriesGroup[8];
    private ArrayList<PropertyTile> properties = new ArrayList<PropertyTile>();
    private static boolean flag=false;
    
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
    
    public ArrayList<PropertyTile> getProperties() {
        return properties;
    }
    
    public void addProperty(PropertyTile property) {
        if(property instanceof Country) {
            addCountry((Country) property);
        } else {
            properties.add(property);
        }
    }
    
    public CountriesGroup[] getGroupsArray() {
        return groups;
    }

    void move(int place) {
        intialPlace = this.place;
        int secondPlace = (place) % allTiles.length;
        if (secondPlace==0||this.place==0) flag=true;

        /*allTiles[firstPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(false);
        allTiles[secondPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(true);
        
        this.place=secondPlace;*/
        Player currentPlayer = this;

        Timer timer = new Timer(200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (intialPlace == secondPlace) {
                    System.out.println("Stopped");
                    allTiles[secondPlace].GetLabels()[MonopolyBoardPanel.turn].setVisible(true);
                    currentPlayer.place = (currentPlayer.place + 1) % allTiles.length;
                    System.out.println("place: " + currentPlayer.place);
                    flag= false;
                    if (currentPlayer.place!=10){
                    allTiles[secondPlace].performAction(currentPlayer);
                    }
                    MainPanel b = (MainPanel) panel.getParent();
                    b.currentPanel.UpdateCurrentDetails();
                    MonopolyBoardPanel.RollButton.setEnabled(true);
                    
                    ((Timer) e.getSource()).stop();

                } else {
                    currentPlayer.animate();
                    MonopolyBoardPanel.RollButton.setEnabled(false);

                }

            }
        });
 timer.start();
      

    }

      public void animate ()
    {
        System.out.println("Here");
        this.place=intialPlace;
          if (this.place==0&& !flag) {
                        allTiles[0].performAction(this);
                        System.out.println("Money:"+this.money);

                    }
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
        railroads=0;
        utility=0;
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
    public void payRent (Player owner, int fees)
    {
        if (this.money- fees >= 0){
            owner.money+= fees;
            this.money-= fees;
        }
        else {
            //Sell properties
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
