/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import UserInterface.MonopolyBoardPanel;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author mahmoud
 */
public abstract class PropertyTile extends Tile {

    private Player owner;
    private String name;
    private int price;
    public boolean mortgaged = false;

    public PropertyTile(String imgName, int mPrice, String mName) {
        super(imgName);

        price = mPrice;
        name = mName;
    }

    public void setOwner(Player player) {
        owner = player;
        if (owner != null) {
            owner.money -= price;
        }
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

    boolean isOwner(Player o) {
        if (o == getOwner()) {
            return true;
        }
        return false;
    }

    public void save(FileOutputStream fos, ObjectOutputStream oos)
            throws IOException {
        oos.writeInt(MonopolyBoardPanel.players.indexOf(owner));
        oos.writeInt(price);
        oos.writeUTF(name);
    }

    public void load(FileInputStream fis, ObjectInputStream ois)
            throws IOException, ClassNotFoundException {
        int index = ois.readInt();
        if (index != -1) {
            this.owner = MonopolyBoardPanel.players.get(index);
        }
        price = ois.readInt();
        name = ois.readUTF();
    }

}
