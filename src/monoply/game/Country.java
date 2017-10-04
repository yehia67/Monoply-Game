package monoply.game;

import java.awt.Color;

public class Country extends Places {

    private String name;
    private int price = 200;
    private int totalFees = 20;
    private Color countryColor;
    private Player Owner;
    private boolean available = true;

    public Country(int mPrice, int mFees, Color mCountryColor, String mName, Coordinates coords) {
        super(coords);
        price = mPrice;
        totalFees = mFees;
        countryColor = mCountryColor;

        name = mName;
    }

    boolean isOwner(Player o) {
        if (o == Owner) {
            return true;
        }
        return false;
    }

    boolean checkAvailable() {
        return available;
    }

    void sold() {
        available = true;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public Color getColor() {
        return countryColor;
    }
}
