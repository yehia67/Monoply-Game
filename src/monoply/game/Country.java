package monoply.game;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Country extends PropertyTile {

    private int totalFees;
    private Color countryColor;
    
    private int housesNumber = 0;
    
    private boolean available = true;
    private boolean canBuildHousesFlag = false;
    private boolean canBuildHotelFlag = false;
         
    public Country(int mPrice, int mFees, Color mCountryColor, String mName,
            String imgName) {
        super(imgName, mPrice, mName);
        totalFees = mFees;
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
            super.getOwner().houses++;
            if(housesNumber >= 2) {
                canBuildHousesFlag = false;
                canBuildHotelFlag = true;
            }
        }
    }
    
    public void buildHotel() {
        if(canBuildHotelFlag) {
            super.getOwner().hotels++;
            canBuildHotelFlag = false;
        }
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

    @Override
    public void performAction(Player player) {

        if (!(player==this.getOwner()) && this.getOwner() != null)
        {
            System.out.println("here");
            player.payRent(this.getOwner(), this.getTotalFees());
        }
        }
    
    @Override
    public void save(FileOutputStream fos, ObjectOutputStream oos) 
            throws IOException {
        super.save(fos, oos);
        oos.writeInt(totalFees);
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
        countryColor = (Color)ois.readObject();
        available = ois.readBoolean();
        canBuildHotelFlag = ois.readBoolean();
        canBuildHousesFlag = ois.readBoolean();
    }
}
