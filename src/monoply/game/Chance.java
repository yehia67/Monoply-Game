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
public class Chance extends NonPropertyTile {

    public Chance(String imgName) {
        super(imgName);
    }

    @Override
    public void performAction(Player player) {
        MonopolyBoardPanel.cards.DrawCard(1, player, MonopolyBoardPanel.players);
    }
    
}