/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yehia
 */
public class MonoplyGame {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]){
        ArrayList<Players> players= new ArrayList<Players>();
        Dice dice;
         Country[] country;
        System.out.println("Welcom to our game");
        System.out.println("Please enter the no of players");
        Scanner x = new Scanner(System.in);
        int playerNo = x.nextInt();
        String playerName;
        for(int i = 1; i <= playerNo; ++i)
        {
            System.out.println("Please enter Player" + i +"name" );
            playerName = x.next();
           Players playe = new Players(playerName);
           players.add(playe);
        }
        
    }
    
}
