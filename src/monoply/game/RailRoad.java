/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;
import static monoply.game.Board.placesArr;
import static monoply.game.RailRoad.placesArr;

/**
 *
 * @author yehia
 */
public class RailRoad extends PropertyTile {
  boolean availble = false;
  int price = 50;
  static ArrayList<Country> placesArr = new ArrayList<Country>();

    
    private String southStation = "Reading RailRoad.png", westStation ="Pennsylvania RailRoad.png", 
            northStation = "B&O RailRoad.png",eastStation = "Short Line.png";

    public RailRoad(String imgName, int mPrice, String mName) {
        super(imgName, mPrice, mName);
    }
   
    
   
     
  // public RailRoad(int mPrice, int mFees, Color mCountryColor, String mName, String imgName) {
        //super(mPrice, mFees, mCountryColor, mName, imgName);
    //}
  public void init(){
  placesArr.add(new Country(200,50,null,"Reading RailRoad",southStation));
  placesArr.add(new Country(200,50,null,"PENNSYLVANIA RAILROAD",westStation));
  placesArr.add(new Country(200,50,null,"B&O RailRoad", northStation));
  placesArr.add(new Country(200,50,null,"SHORT LINE", eastStation));
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
        if (!(player==this.getOwner()))
        {
          player.money -= payment(this.getOwner());
        }
    }
}

