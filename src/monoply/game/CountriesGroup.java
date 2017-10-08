/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;

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
    
    public int getSize() {
        return countries.size();
    }
}
