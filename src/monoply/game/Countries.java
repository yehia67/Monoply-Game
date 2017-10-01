package monoply.game;

import java.awt.Color;

public class Countries {
    private Country[] countries;
    private int index = 0;
    
    public Countries() {
        init();
    }
    
    private void init() {
        countries = new Country[22];
        initBrownCountries();
        initBlueCountries();
        initPurpleCountries();
        initOrangeCountries();
        initRedCountries();
        initYellowCountries();
        initGreenCountries();
        initDarkBlueCountries();
    }
    
    private void initBrownCountries() {
        countries[index++] = new Country(60, 60, new Color(165, 42, 42),
                1, "Old Kent Road");
        countries[index++] = new Country(60, 60, new Color(165, 42, 42),
                2, "Whitechapel Road");
    }
    
    private void initBlueCountries() {
        countries[index++] = new Country(100, 100, Color.CYAN,
                1, "The Angel, Islington");
        countries[index++] = new Country(100, 100, Color.CYAN,
                2, "Euston Road");
        countries[index++] = new Country(120, 120, Color.CYAN, 
                3, "Pentonville Road");
    }
    
    private void initPurpleCountries() {
        countries[index++] = new Country(140, 140, Color.MAGENTA,
                1, "Pall Mall");
        countries[index++] = new Country(140, 140, Color.MAGENTA,
                2, "Whitehall");
        countries[index++] = new Country(160, 160, Color.MAGENTA,
                3, "Northumberland Avenue");
    }
    
    private void initOrangeCountries() {
        countries[index++] = new Country(180, 180, Color.ORANGE,
                1, "Bow Street");
        countries[index++] = new Country(180, 180, Color.ORANGE,
                2, "Great Marlborough Street");
        countries[index++] = new Country(200, 200, Color.ORANGE,
                3, "Vine Street");
    }
    
    private void initRedCountries() {
        countries[index++] = new Country(220, 220, Color.RED,
                1, "Strand");
        countries[index++] = new Country(220, 220, Color.RED,
                2, "Fleet Street");
        countries[index++] = new Country(240, 240, Color.RED,
                3, "Trafalgar Square");
    }
    
    private void initYellowCountries() {
        countries[index++] = new Country(260, 260, Color.YELLOW,
                1, "Leicester Square");
        countries[index++] = new Country(260, 260, Color.YELLOW,
                2, "Coventry Street");
        countries[index++] = new Country(280, 280, Color.YELLOW,
                3, "Piccadilly");
    }
    
    private void initGreenCountries() {
        countries[index++] = new Country(300, 300, Color.GREEN,
                1, "Regent Street");
        countries[index++] = new Country(300, 300, Color.GREEN,
                2, "Oxford Street");
        countries[index++] = new Country(320, 320, Color.GREEN,
                3, "Bond Street");
    }
    
    private void initDarkBlueCountries() {
        countries[index++] = new Country(350, 350, Color.BLUE,
                1, "Park Lane");
        countries[index] = new Country(400, 400, Color.BLUE,
                2, "Mayfair");
    }
Country getCountries(int index)
{
    return countries[index];
}

}
