/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import static monoply.game.GamePanel.MessageTextField;

/**
 *
 * @author mahmoud
 */
public class MonopolyBoardPanel extends JPanel{
    private int Playernumber;
    private static Tile centerTile;
    private static int turn=0;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    private JButton RollButton;
    private Dice dice1;
    private Dice dice2;
    private int diceNumber;
    Player currentPlayer;
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    
    public static Tile[] allTiles = new Tile[40];
    
    private String[] southTilesNames = {"Jail.png", "Connecticut Avenue.png",
        "Vermont Avenue.png", "Chance Down.png", "Oriental Avenue.png", 
        "Reading RailRoad.png", "Income Tax.png", "Baltic Avenue.png",
        "Community Chest Down.png", "Mediteranean Avenue.png", "GO.png"};
    
    private String[] northTilesNames = {"Free Parking.png", 
        "Kentucky Avenue.png", "Chance Top.png", "Indiana Avenue.png",
        "Illinois Avenue.png", "B&O RailRoad.png", "Atlantic Avenue.png",
        "Ventor Avenue.png", "Water Selection.png", "Marvin Gardens.png",
        "Go To Jail.png"};
    
    private String[] westTilesNames = {"New York Avenue.png", 
        "Tennesse Avenue.png", "Community Chest Left.png", "St.png", 
        "Pennsylvania RailRoad.png", "Virginia Avenue.png", "States Avenue.png",
        "Electric Company.png", "St Charles Place.png"};
    
    private String[] eastTilesNames = {"Pacific Avenue.png", 
        "North Carolina Avenue.png", "Community Chest Right.png", 
        "Pennsylvania Avenue.png", "Short Line.png", "Chance Right.png", 
        "Park Place.png", "Luxury Tax.png", "BoardWalk.png"};

    
    public MonopolyBoardPanel(int playerNumber) {
        
        this.Playernumber=playerNumber;
             System.out.println("MonopolyBoard Constructor");
        init();
        for(int i =0; i<playerNumber; i++)
        {
           players.add(new Player("Dummy-Name"));
           allTiles[0].GetLabels()[i].setVisible(true);
        
        }
      
    }
    
    private void init() {
      
        this.setLayout(new BorderLayout());
        int allIndex=southTilesNames.length-1;
        JPanel centerPart = new MonopolyCenterPanel("Mid-Part.png");
        
        southPanel = new JPanel();   //0 - 10
        southPanel.setLayout(new GridLayout(1, 11));
        for(int i = 0; i<southTilesNames.length ; i++) {
            allTiles[allIndex] = new Tile(southTilesNames[i]);
            southPanel.add(allTiles[allIndex]);
            allIndex--;
        }
        
         westPanel = new JPanel();
        
        westPanel.setLayout(new GridLayout(9, 1));
      
            allIndex=southTilesNames.length + westTilesNames.length-1;
        for(int i = 0; i<westTilesNames.length ; i++) {
            allTiles[allIndex] = new Tile(westTilesNames[i]);
            westPanel.add(allTiles[allIndex]);
            allIndex--;
        }
        
        northPanel = new JPanel();
        
       
        northPanel.setLayout(new GridLayout(1, 11));
        
            allIndex=southTilesNames.length+westTilesNames.length;
        for(int i = 0; i<northTilesNames.length ; i++) {
            allTiles[allIndex] = new Tile(northTilesNames[i]);
            northPanel.add(allTiles[allIndex]);
            allIndex++;
        }
     
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(9, 1));
        allIndex=southTilesNames.length+ westTilesNames.length + northTilesNames.length;
       for(int i = 0; i<eastTilesNames.length ; i++) {
            allTiles[allIndex] = new Tile(eastTilesNames[i]);
            eastPanel.add(allTiles[allIndex]);
            allIndex++;
        }
        
        
        
        this.add(centerPart, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        
        
       RollButton = new JButton("Roll Dice");
         Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        
        centerPart.add(dice1);
        centerPart.add(dice2);
        RollButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
                
       
       
         int dice1Num = dice1.getDice();
        int dice2Num = dice2.getDice();
        diceNumber = dice1Num + dice2Num;
    MonopolyBoardPanel.this.move(diceNumber);
        
            }
       
        }
               );   
                centerPart.add(RollButton);
             
    }
    
    
    
    public void move (int diceNumber){
     
       currentPlayer = this.players.get(this.turn);
      
       
        while(currentPlayer.getInJail()) {
            currentPlayer.setInJail(false);
            Board.turn = (Board.turn + 1) % this.players.size();
            currentPlayer = Board.players.get(Board.turn);
        }
        
  
        int firstPlace = currentPlayer.place;
    
        int secondPlace = (firstPlace + diceNumber) % allTiles.length;
        
        allTiles[firstPlace].GetLabels()[this.turn].setVisible(false);
        allTiles[secondPlace].GetLabels()[this.turn].setVisible(true);
        
        players.get(turn).place=secondPlace;
        
       
     MainPanel  b = (MainPanel)this.getParent();
        b.currentPanel.UpdateCurrentDetails();
        
        turn= (turn+1)%this.Playernumber;
  
    }
    
 
    
    public static int returnTurn()
    {
        return MonopolyBoardPanel.turn;
    }
    
    public static void setTurn(int turn)
    {
       MonopolyBoardPanel.turn = turn;
    }
    
     public static Tile[] getTileArr()
    {
        return MonopolyBoardPanel.allTiles;
    }
    
    
}
