/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author yehia
 */
public class MonoplyGame {

    /**
     * @param args the command line arguments
     */
   ;
    
    
    public static void main(String args[]){
        ArrayList<Player> players= new ArrayList<Player>();
        //Dice dice = new Dice();
        /*mainFrame mF = new mainFrame();
        mF.setVisible(true);*/
        JFrame frame = new JFrame();
        frame.add(new MainPanel());
        frame.setSize(500, 400);
        frame.setVisible(true);
        Random rand = new Random();
      }
    
}
