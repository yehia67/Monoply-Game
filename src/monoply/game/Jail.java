package monoply.game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eslam
 */
public class Jail {

    public Jail() {
    }
    public static void jailAction(Player player)
    {
        if(player.getJailOffset()>1)
        {
            player.setJailOffset(1);
        }
        else if (player.getJailOffset()==1)
        {
            player.setInJail(false);
            player.setJailOffset(0);
        }
        
    }
    public static void setInjail(Player player){
        if (player.HasJailCard){
            MonopolyBoardPanel.cards.returnFreeCard(player);
        }
        else {
            player.setInJail(true);
            player.setJailOffset(2);
        }
    }
}
