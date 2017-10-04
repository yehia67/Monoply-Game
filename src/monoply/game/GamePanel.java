/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */
public class GamePanel extends JPanel {

    private BufferedImage image;
    Color[] colorArray = new Color[8];
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Places> placesArr = new ArrayList<Places>();
    private int offset = 0;
    public int turn = 0;

    public void rendercoords() {
        //int mPrice, int mFees, Color mCountryColor,   String mName, Coordinates coords)

        placesArr.add(new SpecialPlaces("GO", new Coordinates(570, 580)));
        placesArr.add(new Country(60, 60, new Color(165, 42, 42), "Mediteranean Avenue", new Coordinates(500, 580)));
        placesArr.add(new SpecialPlaces("Community Chest", new Coordinates(450, 580)));
        placesArr.add(new Country(60, 60, new Color(165, 42, 42), "Baltic Avenue", new Coordinates(400, 580)));
        placesArr.add(new SpecialPlaces("Income Tax", new Coordinates(350, 580)));
        placesArr.add(new SpecialPlaces("Reading RailRoad", new Coordinates(300, 580)));
        placesArr.add(new Country(60, 60, Color.CYAN, "Crental Avenue", new Coordinates(250, 580)));
        placesArr.add(new SpecialPlaces("Chance", new Coordinates(200, 580)));
        placesArr.add(new Country(100, 100, Color.CYAN, "Vermont Avenue", new Coordinates(150, 580)));
        placesArr.add(new Country(120, 120, Color.CYAN, "Connectcut Avenue", new Coordinates(100, 580)));
        placesArr.add(new SpecialPlaces("Jail", new Coordinates(50, 580)));

        placesArr.add(new Country(140, 140, Color.PINK, "ST.CHARLES PLACE", new Coordinates(50, 500)));
        placesArr.add(new SpecialPlaces("ELECTRIC COMPANY", new Coordinates(50, 450)));
        placesArr.add(new Country(140, 140, Color.PINK, "STATES AVENUE", new Coordinates(50, 400)));
        placesArr.add(new Country(160, 160, Color.PINK, "VIRGINIA AVENUE", new Coordinates(50, 350)));
        placesArr.add(new SpecialPlaces("PENNSYLVANIA RAILROAD", new Coordinates(50, 300)));
        placesArr.add(new Country(180, 180, Color.ORANGE, "ST.JAMES PLACE", new Coordinates(50, 250)));
        placesArr.add(new SpecialPlaces("COMMUNITY CHEST", new Coordinates(50, 200)));
        placesArr.add(new Country(180, 180, Color.ORANGE, "TENNESSEE AVENUE", new Coordinates(50, 150)));
        placesArr.add(new Country(200, 200, Color.ORANGE, "NEW YORK AVENUE", new Coordinates(50, 100)));
        placesArr.add(new SpecialPlaces("Parking", new Coordinates(50, 50)));

        placesArr.add(new Country(220, 220, Color.RED, "Kentucky Avenue", new Coordinates(100, 50)));
        placesArr.add(new SpecialPlaces("Chance", new Coordinates(150, 50)));
        placesArr.add(new Country(220, 220, Color.RED, "Indiana Avenue", new Coordinates(150, 50)));
        placesArr.add(new Country(240, 240, Color.RED, "Illinois Avenue", new Coordinates(250, 50)));
        placesArr.add(new SpecialPlaces("B&O RailRoad", new Coordinates(300, 50)));
        placesArr.add(new Country(260, 260, Color.YELLOW, "Atlantic Avenue", new Coordinates(350, 50)));
        placesArr.add(new Country(260, 260, Color.YELLOW, "Ventor Avenue", new Coordinates(400, 50)));
        placesArr.add(new SpecialPlaces("Water Works", new Coordinates(450, 50)));
        placesArr.add(new Country(280, 280, Color.YELLOW, "Marvin Gardens", new Coordinates(500, 50)));
        placesArr.add(new SpecialPlaces("Go to Jail", new Coordinates(570, 50)));

        placesArr.add(new Country(300, 300, Color.GREEN, "PACIFIC AVENUE", new Coordinates(570, 90)));
        placesArr.add(new Country(300, 300, Color.GREEN, "NORTH CAROLINA AVENUE", new Coordinates(570, 140)));
        placesArr.add(new SpecialPlaces("COMMUNITY CHEST", new Coordinates(570, 190)));
        placesArr.add(new Country(320, 320, Color.GREEN, "PENNSYLVANIA AVENUE", new Coordinates(570, 240)));
        placesArr.add(new SpecialPlaces("SHORT LINE", new Coordinates(570, 290)));
        placesArr.add(new SpecialPlaces("CHANCE", new Coordinates(570, 340)));
        placesArr.add(new Country(350, 350, Color.BLUE, "PARK PLACE", new Coordinates(570, 390)));
        placesArr.add(new SpecialPlaces("LUXURY TAX", new Coordinates(570, 440)));
        placesArr.add(new Country(400, 400, Color.BLUE, "BOARDWALK", new Coordinates(570, 490)));

    }

    public GamePanel(int playersCount) {
        rendercoords();
        colorArray[0] = Color.BLUE;
        colorArray[1] = Color.GREEN;
        colorArray[2] = Color.RED;
        colorArray[3] = Color.YELLOW;
        colorArray[4] = Color.ORANGE;
        colorArray[5] = Color.GRAY;
        colorArray[6] = Color.PINK;
        colorArray[7] = Color.WHITE;

        for (int i = 0; i < playersCount; i++) {
            players.add(new Player("mohamed", 570, 580, colorArray[i]));
        }

        try {
            image = ImageIO.read(new File("monopolyimg.jpg"));
            Dimension size = new Dimension(image.getWidth(), image.getHeight());
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

        for (int i = 0; i < players.size(); i++) {
            g.setColor(players.get(i).color);
            g.fillOval(players.get(i).x, players.get(i).y, 15, 15);
        }

    }
}
