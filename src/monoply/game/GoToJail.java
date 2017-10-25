/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author eslam
 */
public class GoToJail extends NonPropertyTile  {

    public GoToJail(String imgName) {
        super(imgName);
    }
    @Override
    public void performAction(Player player)
    {
        player.move(10);
        Jail jail = (Jail)MonopolyBoardPanel.allTiles[10];
       jail.setInjail(player);
    }
}
