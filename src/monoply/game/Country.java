package monoply.game;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Country extends PropertyTile {

    private int totalFees;
    private int tax ;
    private Color countryColor;
    
    private int housesNumber = 0;
    private int hotelsNumber = 0;
    
    private boolean available = true;
    private boolean canBuildHousesFlag = false;
    private boolean canBuildHotelFlag = false;
         
    public Country(int mPrice, int mFees, Color mCountryColor, String mName,
            String imgName) {
        super(imgName, mPrice, mName);
        totalFees = mFees;
        tax =mFees/4;
        countryColor = mCountryColor;
    }
    
     public void SoldCountry(){
         super.getOwner().money += getPrice();
         available = true;
         super.setOwner(null);
     }
    public void buildHouse() {
        if(canBuildHousesFlag) {
            housesNumber++;
            tax+=2000;
            super.getOwner().houses++;
            if(housesNumber >= 2) {
                canBuildHousesFlag = false;
                canBuildHotelFlag = true;
                tax+=30;
            }
        }
    }
    
    public void buildHotel() {
        if(canBuildHotelFlag) {
            hotelsNumber++;
            super.getOwner().hotels++;
            canBuildHotelFlag = false;
        }
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
    
    public int getHotelsNumber() {
        return hotelsNumber;
    }

    boolean isOwner(Player o) {
        if (o == super.getOwner()) {
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
    
    public Country getCountry(){
        return this;
    }

    @Override
    public void performAction(Player player) {

        if (!(player==this.getOwner()) && this.getOwner() != null && !this.mortgaged )
        {
            System.out.println("here");
            player.payRent(this.getOwner(), this.getTax());
        }
        }
    
    @Override
    public void save(FileOutputStream fos, ObjectOutputStream oos) 
            throws IOException {
        super.save(fos, oos);
        oos.writeInt(totalFees);
        oos.writeInt(tax);
        oos.writeInt(housesNumber);
        oos.writeInt(hotelsNumber);
        oos.writeObject(countryColor);
        oos.writeBoolean(available);
        oos.writeBoolean(canBuildHotelFlag);
        oos.writeBoolean(canBuildHousesFlag);
    }
    
    
    @Override
    public void load(FileInputStream fis, ObjectInputStream ois) 
            throws IOException, ClassNotFoundException {
        super.load(fis, ois);
        totalFees = ois.readInt();
        tax = ois.readInt();
        housesNumber = ois.readInt();
        hotelsNumber = ois.readInt();
        countryColor = (Color)ois.readObject();
        available = ois.readBoolean();
        canBuildHotelFlag = ois.readBoolean();
        canBuildHousesFlag = ois.readBoolean();
        
    }
}
