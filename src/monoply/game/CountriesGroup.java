/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import UserInterface.MonopolyBoardPanel;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author mahmoud
 */
public class CountriesGroup {
    private int countriesNumber;
    
    private ArrayList<Country> countries = new ArrayList<Country>();
    
    public CountriesGroup(int mCountriesNumber) {
        countriesNumber = mCountriesNumber;
    }
    
    public void addCountry(Country boughtCountry) {
        countries.add(boughtCountry);
        
        if(countries.size() == countriesNumber) {
            for(int i = 0; i < countries.size(); i++) {
                countries.get(i).setCanBuildHousesFlag(true);
            }
        }
    }
    
    public ArrayList<Country> getCountries() {
        return countries;
    }
    
    public String[] showCountries(){
       int sz = countries.size();
        String[] countriesName ;
        countriesName = new String[sz];
        for(int i = 0; i < countries.size(); i++) {
           countriesName[i] =    countries.get(i).getName();
            }
      return countriesName;
    }
    public int getSize() {
        return countries.size();
    }
    
    public void save(FileOutputStream fos, ObjectOutputStream oos) 
            throws IOException {
        oos.writeInt(countries.size());
        for(int i = 0; i < countries.size(); i++) {
            for(int j = 0; j < 40; j++) {
                if(countries.get(i) == MonopolyBoardPanel.allTiles[j]) {
                    oos.writeInt(j);
                }
            }
        }
    }
    
    public void load(Player p, 
            FileInputStream fis, ObjectInputStream ois) throws IOException {
        int sz = ois.readInt();
        for(int i = 0; i < sz; i++) {
            int index = ois.readInt();
            this.addCountry((Country)MonopolyBoardPanel.allTiles[index]);
        }
    }
}
