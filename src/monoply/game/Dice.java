/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.Random;

/**
 *
 * @author yehia
 */
public class Dice {
   private static Random rand = new Random();
   
   public static int getDice(){
      return rand.nextInt(11) + 2;
       
   }
}
