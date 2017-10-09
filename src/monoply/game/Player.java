/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author yehia
 */
public class Player {

    public int money = 1500, turns, place = 0;
    public int x, y;
    public Color color;
    Dice dice;
    public String name;
    
    public boolean HasJailCard;
    private boolean inJail;
    
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

    void move() {
        place += dice.getDice();
    }
    
    public Player(String n, int x, int y, Color c) {
        name = n;
        this.x = x;
        this.y = y;
        this.color = c;
        this.HasJailCard= false;
        
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
}
