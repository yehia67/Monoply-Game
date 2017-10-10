package monoply.game;

import java.awt.Color;

public class Country extends Places {

    private String name;
    private int price;
    private int totalFees;
    private Color countryColor;
    public Player Owner;
    
    private int index;
    
    private int housesNumber = 0;
    
    private boolean available = true;
    private boolean canBuildHousesFlag = false;
    private boolean canBuildHotelFlag = false;
         
    public Country(int mPrice, int mFees, Color mCountryColor, String mName, 
            Coordinates coords, int mIndex) {
        super(coords);
        price = mPrice;
        totalFees = mFees;
        countryColor = mCountryColor;

        name = mName;
        
        index = mIndex;
    }
   void setOwner(Player O)
   {
       Owner = O;
   }
    Country() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void SoldCountry(){
         Owner.money += getPrice();
         available = true;
         Owner = null;
     }
    public void buildHouse() {
        if(canBuildHousesFlag) {
            price += 20;
            housesNumber++;
            Owner.houses++;
            if(housesNumber >= 2) {
                canBuildHousesFlag = false;
                canBuildHotelFlag = true;
            }
        }
    }
    
    public void buildHotel() {
        if(canBuildHotelFlag) {
            price += 20;
            Owner.hotels++;
            canBuildHotelFlag = false;
        }
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
        available = false;
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
    
    public boolean getCanBuildHousesFlag() {
        return canBuildHousesFlag;
    }
    
    public void setCanBuildHousesFlag(boolean flag) {
        canBuildHousesFlag = flag;
    }
    
    public boolean getCanBuildHotelFlag() {
        return canBuildHotelFlag;
    }
    
    public void setCanBuildHotelFlag(boolean flag) {
        canBuildHotelFlag = flag;
    }
    
    public int getHousesNumber() {
        return housesNumber;
    }
}
