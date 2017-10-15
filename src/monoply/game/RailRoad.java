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
public class RailRoad {
  Player Owner;//ex
  boolean availble = false;
  int price = 50;
  static ArrayList<Places> placesArr = new ArrayList<Places>();
  public void init(){
  placesArr.add(new SpecialPlaces("Reading RailRoad", new Coordinates(300, 580), 0, -7));
  placesArr.add(new SpecialPlaces("PENNSYLVANIA RAILROAD", new Coordinates(50, 300), -5, 0));
  placesArr.add(new SpecialPlaces("B&O RailRoad", new Coordinates(300, 50),  0, -7));
  placesArr.add(new SpecialPlaces("SHORT LINE", new Coordinates(570, 290), -5 , 0));
  }
  void setOwner(Player pl)
  {
     Owner = pl;
  }
  
  void payment(Player pl){
      int c = 1;
      for(int i = 0; i < placesArr.size();i++)
      {
          if(placesArr.get(i).isOwner(pl))
          {
              c++;
          }
      }
    pl.money = price*c;
  }
}
