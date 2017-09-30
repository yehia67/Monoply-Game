package monoply.game;

import java.awt.Color;

public class Country {
    private int id;
    private String name;
    private int price;
    private int totalFees;
    private Color countryColor;
    
    public Country(int mPrice, int mFees, Color mCountryColor, int mId, 
            String mName) {
        price = mPrice;
        totalFees = mFees;
        countryColor = mCountryColor;
        id = mId;
        name = mName;
    }
    
    public int getId() {
        return id;
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
