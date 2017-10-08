/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Color;

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

    void move() {
        place += dice.getDice();
    }
   Player(){}
    public Player(String n, int x, int y, Color c) {
        name = n;
        this.x = x;
        this.y = y;
        this.color = c;
    }

}
