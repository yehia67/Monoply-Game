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
   private Random rand;
   private final int dices = rand.nextInt(12) + 1;
   int getDice(){
       return dices;
   }
}
