/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */
public class MonopolyBoardPanel extends JPanel {
    private Tile centerTile;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    
    private Tile[] southTiles = new Tile[11];
    private Tile[] northTiles = new Tile[11];
    private Tile[] eastTiles = new Tile[9];
    private Tile[] westTiles = new Tile[9];
    
    private String[] southTilesNames = {"Jail.png", "Connecticut Avenue.png",
        "Vermont Avenue.png", "Chance Down.png", "Oriental Avenue.png", 
        "Reading RailRoad.png", "Income Tax.png", "Baltic Avenue.png",
        "Community Chest Down.png", "Mediteranean Avenue.png", "GO.png"};
    
    private String[] northTilesNames = {"Free Parking.png", 
        "Kentucky Avenue.png", "Chance Top.png", "Indiana Avenue.png",
        "Illinois Avenue.png", "B&O RailRoad.png", "Atlantic Avenue.png",
        "Ventor Avenue.png", "Water Selection.png", "Marvin Gardens.png",
        "Go To Jail.png"};
    
    private String[] eastTilesNames = {"New York Avenue.png", 
        "Tennesse Avenue.png", "Community Chest Left.png", "St.png", 
        "Pennsylvania RailRoad.png", "Virginia Avenue.png", "States Avenue.png",
        "Electric Company.png", "St Charles Place.png"};
    
    private String[] westTilesNames = {"Pacific Avenue.png", 
        "North Carolina Avenue.png", "Community Chest Right.png", 
        "Pennsylvania Avenue.png", "Short Line.png", "Chance Right.png", 
        "Park Place.png", "Luxury Tax.png", "BoardWalk.png"};
    
    public MonopolyBoardPanel() {
        init();
    }
    
    private void init() {
        this.setLayout(new BorderLayout());
        
        centerTile = new Tile("Mid-Part.png");
        
        southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 11));
        for(int i = 0; i < southTiles.length; i++) {
            southTiles[i] = new Tile(southTilesNames[i]);
            southPanel.add(southTiles[i]);
        }
        
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 11));
        for(int i = 0; i < northTiles.length; i++) {
            northTiles[i] = new Tile(northTilesNames[i]);
            northPanel.add(northTiles[i]);
        }
        
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(9, 1));
        for(int i = 0; i < eastTiles.length; i++) {
            eastTiles[i] = new Tile(eastTilesNames[i]);
            eastPanel.add(eastTiles[i]);
        }
        
        westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(9, 1));
        for(int i = 0; i < westTiles.length; i++) {
            westTiles[i] = new Tile(westTilesNames[i]);
            westPanel.add(westTiles[i]);
        }
        
        this.add(centerTile, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
    }
}
