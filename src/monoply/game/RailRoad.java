/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;
//import static monoply.game.Board.placesArr;
import static monoply.game.RailRoad.placesArr;

/**
 *
 * @author yehia
 */
public class RailRoad extends PropertyTile {
  boolean availble = false;
  int price = 50;
  static ArrayList<RailRoad> placesArr = new ArrayList<RailRoad>();

    
    private String southStation = "Reading RailRoad.png", westStation ="Pennsylvania RailRoad.png", 
            northStation = "B&O RailRoad.png",eastStation = "Short Line.png";

    public RailRoad(String imgName, int mPrice, String mName) {
        super(imgName, mPrice, mName);
    }
   
    
   
     
  // public RailRoad(int mPrice, int mFees, Color mCountryColor, String mName, String imgName) {
        //super(mPrice, mFees, mCountryColor, mName, imgName);
    //}
  public void init(){
  placesArr.add(new RailRoad(southStation,50,"Reading RailRoad"));
  placesArr.add( new RailRoad(westStation ,50,"PENNSYLVANIA RAILROAD"));
  placesArr.add(new RailRoad(northStation,50,"B&O RailRoad"));
  placesArr.add(new RailRoad(eastStation,50,"SHORT LINE"));
  }
   
  int payment(Player owner){
      init();
      int c = 1;
      for(int i = 0; i < placesArr.size();i++)
      {
          if(placesArr.get(i).isOwner(owner))
          {
              c++;
          }
      }
     return  price*c;
  }
    
    @Override
    public void performAction(Player player) {
        if (!(player==this.getOwner()) && this.getOwner() != null)
        {
          player.money -= payment(this.getOwner());
        }
    }
}

