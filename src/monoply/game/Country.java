package monoply.game;

import java.awt.Color;

public class Country {
    private int id;
    private String name;
    private int price = 200;
    private int totalFees = 20; 
    private Color countryColor;
    private String Owner = "name";
    private boolean available = true;
    public Country(int mPrice, int mFees, Color mCountryColor, int mId, 
            String mName) {
        price = mPrice;
        totalFees = mFees;
        countryColor = mCountryColor;
        id = mId;
        name = mName;
    }
    boolean isOwner(String o)
    {
        if(o == Owner)
        {
            return true;
        }
        return false;
    }
    boolean checkAvailable(){
        return available;
    }
    void sold()
    {
        available = true;
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
