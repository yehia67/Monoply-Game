/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author yehia
 */
public class Utilties extends PropertyTile {
  static ArrayList<Utilties> placesArr = new ArrayList<Utilties>();
  void init(){
      placesArr.add(new Utilties ("Water Selection.png",150,"Water Works"));
  placesArr.add( new Utilties ("Electric Company.png" ,150,"Electric Company"));
  }
    public Utilties(String imgName, int mPrice, String mName) {
        super(imgName, mPrice, mName);
    }
    
   int diceRoll(){
    Dice dice1 = new Dice();
   Dice dice2 = new Dice();
   int dice1Num = dice1.getDice();
   int dice2Num = dice2.getDice();
   int diceNumber = dice1Num + dice2Num;
   JPanel centerPart = new MonopolyCenterPanel("Mid-Part.png");
   centerPart.add(dice1);
   centerPart.add(dice2);
   // MonopolyBoardPanel.move(diceNumber); msh 3rf ezay hatl3 7arkt el panel fl board
    return diceNumber;
   }
   int payment(Player Owner)
   {
       init();
       int c = 4;
       for(int i = 0; i < placesArr.size();i ++)
       {
           if(placesArr.get(i).isOwner(Owner))
           {
               c *= 2;
           }
       }
     return c * diceRoll();
   }
          

    
    @Override
    public void performAction(Player player) {
        if (!(player==this.getOwner()) && this.getOwner() != null)
        {
          player.money -= payment(this.getOwner());
          this.getOwner().money += payment(this.getOwner());
        }
    }
    
}
