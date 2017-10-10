/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author
 */
public class Places {

    Coordinates coords;
    String Owner = "No One";
    public int offsetX, offsetY;
    
    Places(){}   
    
    public Places(Coordinates c, int offX, int offY) {
        this.coords = c;
        offsetX = offX;
        offsetY = offY;
    }
    
   boolean isOwn(String player)
   {
       if(player.equalsIgnoreCase(Owner))
       {
           return true;
       }
       else{
           return false;
       }
   }
}
