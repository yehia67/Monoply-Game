/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author yehia
 */
public class Players {
    public int money = 1500 ,turns, place = 0; 
     Dice dice;
     private String name;
    void move(){
         turns += dice.getDice();
    }
    Players(String n){
        name = n;
    }
    /*void setName(String n)
    {
        name = n;
    }
    String getName(){
        return name;
    }*/
}
