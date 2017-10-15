/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author moaz
 */
public class GO extends NonPropertyTile {
    
    public GO(String imgName){
        super(imgName);
    }
    
    public void performAction(Player player)
    {
        player.money+=200;
    }
}
