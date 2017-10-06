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
    Places(){}   
    public Places(Coordinates c) {
        this.coords = c;
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
