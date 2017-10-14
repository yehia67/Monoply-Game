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
public class PropertyTile extends Tile {
    private Player owner;
    private String name;
    private int price;
    
    public PropertyTile(String imgName, int mPrice, String mName) {
        super(imgName);
        
        price = mPrice;
        name = mName;
    }
    
    public void setOwner(Player player) {
        owner = player;
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
}
