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
public class Card {

    private String name;
    private String Description;
    private int type;

    public Card(String name, String Description, int type) {
        this.name = name;
        this.Description = Description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public int getType() {
        return type;
    }

}
