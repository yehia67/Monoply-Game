/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author mahmoud
 */
public  class NonPropertyTile extends Tile {
    public NonPropertyTile(String imgName) {
        super(imgName);
    }

    @Override
    public void performAction(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
