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
public class GoToJail {

    public GoToJail() {
    }
    public static void GoToJailAction(Player player)
    {
        player.move(10);
       Jail.setInjail(player);
    }
}
