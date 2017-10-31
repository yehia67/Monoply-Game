/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import UserInterface.MainPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//import static monoply.game.GamePanel.MessageTextField;

import monoply.game.*;


/**
 *
 * @author mahmoud
 */
public class MonopolyBoardPanel extends JPanel implements Serializable {
    private int Playernumber;
    private static Tile centerTile;
    public static int turn=-1;
    
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    public static JButton RollButton;
    private Dice dice1;
    private Dice dice2;
    private int dice1Num , dice2Num;
    private int diceNumber;
    private boolean  diceFlag = false ; 
    public static Player currentPlayer;
    public static ArrayList<Player> players = new ArrayList<Player>();
    public static String   CurrentPlayerName;
    //public static Jail jail;
    //public static GoToJail GoJail;
    public static SpecialCards cards;
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

    
    public MonopolyBoardPanel(int playerNumber, int height) {
        
        this.Playernumber=playerNumber;
             System.out.println("MonopolyBoard Constructor");
        init();
        for(int i =0; i<playerNumber; i++)
        {
           players.add(new Player(i + 1 + ""));
           players.get(i).setPanel(this);
           allTiles[0].GetLabels()[i].setVisible(true);
            switch (i) {
                case 0:
                    if (MF2.pp.getP1Name().trim().equalsIgnoreCase(""))
                        players.get(i).name="Player 1";
                    else
                    players.get(i).name = MF2.pp.getP1Name();
                    break;
                case 1:
                    if (MF2.pp.getP2Name().trim().equalsIgnoreCase(""))
                        players.get(i).name="Player 2";
                    else
                    players.get(i).name = MF2.pp.getP2Name();
                    break;
                case 2:
                    if (MF2.pp.getP3Name().trim().equalsIgnoreCase(""))
                        players.get(i).name="Player 3";
                    else
                    players.get(i).name = MF2.pp.getP3Name();
                    break;
                case 3:
                    if (MF2.pp.getP4Name().trim().equalsIgnoreCase(""))
                        players.get(i).name="Player 4";
                    else
                    players.get(i).name = MF2.pp.getP4Name();
                    break;
            }
        
        }
        this.setSize(height , height);
        //this.setMaximumSize(new Dimension(200, 200));
               // this.setPreferredSize(new Dimension(200, 200));
                //this.setMinimumSize(new Dimension(200, 200));

            System.out.println("Height: "+  this.getHeight()+"\n Width:" +this.getWidth());
        CurrentPlayerName = "Player : " + players.get(0).name + " Turn" ;
        cards=new SpecialCards();
        
      
    }
    
    private void init() {
      
        this.setLayout(new BorderLayout());
        JPanel centerPart = new MonopolyCenterPanel("Mid-Part.png");
       
        southPanel = new JPanel();   //0 - 10
        southPanel.setLayout(new GridLayout(1, 11));
        initSouthPanel();
        
        westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(9, 1));
        initWestPanel();
        
        
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 11));
        initNorthPanel();
     
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(9, 1));
        initEastPanel();
        
        
        
        this.add(centerPart, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        
        
       RollButton = new JButton("Roll Dice");
          dice1 = new Dice();
         dice2 = new Dice();
        
        centerPart.add(dice1);
        centerPart.add(dice2);
        RollButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
                
       
       
          dice1Num = dice1.getDice();
         dice2Num = dice2.getDice();
        diceNumber = dice1Num + dice2Num;
        RollButton.setEnabled(false);
          

    MonopolyBoardPanel.this.move(diceNumber);
        
            }
       
        }
               );   
                centerPart.add(RollButton);
             
    }
    
    private void initSouthPanel() {
        int allIndex=southTilesNames.length-1;
        allTiles[allIndex--] = new Jail(southTilesNames[0]);
        allTiles[allIndex--] = new Country(120, 120, Color.CYAN,
                "Connecticut Avenue", southTilesNames[1]);
        allTiles[allIndex--] = new Country(100, 100, Color.CYAN, 
                "Vermont Avenue", southTilesNames[2]);
        allTiles[allIndex--] = new Chance(southTilesNames[3]);
        allTiles[allIndex--] = new Country(100, 100, Color.CYAN,
                "Oriental Avenue", southTilesNames[4]);
       allTiles[allIndex--] =  new RailRoad(southTilesNames[5],50,"Reading RailRoad");
        allTiles[allIndex--] = new Taxes(southTilesNames[6],200);
        allTiles[allIndex--] = new Country(60, 60, Color.WHITE,
                "Baltic Avenue", southTilesNames[7]);
        allTiles[allIndex--] = new Chest(southTilesNames[8]);
        allTiles[allIndex--] = new Country(60, 60, Color.WHITE,
                "Mediterranean Avenue", southTilesNames[9]);

        allTiles[allIndex--] = new GO(southTilesNames[10]);
        
        allIndex = southTilesNames.length-1;
        
        for(int i = 0; i<southTilesNames.length ; i++) {
            southPanel.add(allTiles[allIndex]);
            allIndex--;
        }
    }
    
    private void initWestPanel() {
        int allIndex = southTilesNames.length + westTilesNames.length - 1;
        
        allTiles[allIndex--] = new Country(200, 200, Color.ORANGE,
                "New York Avenue", westTilesNames[0]);
        allTiles[allIndex--] = new Country(180, 180, Color.ORANGE,
                "Tenessee Avenue", westTilesNames[1]);
        allTiles[allIndex--] = new Chest(westTilesNames[2]);
        allTiles[allIndex--] = new Country(180, 180, Color.ORANGE,
                "St. James Place", westTilesNames[3]);
         allTiles[allIndex--] =  new RailRoad(westTilesNames[4],50,"PENNSYLVANIA RAILROAD");
        allTiles[allIndex--] = new Country(160, 160, Color.PINK,
                "Virginia Avenue", westTilesNames[5]);
        allTiles[allIndex--] = new Country(140, 140, Color.PINK,
                "States Avenue", westTilesNames[6]);
        allTiles[allIndex--] = new Utilties ("Electric Company.png" ,150,"Electric Company");

        allTiles[allIndex--] = new Country(140, 140, Color.PINK,
                "St. Charles Place", westTilesNames[8]);
        
        allIndex = southTilesNames.length + westTilesNames.length - 1;
        
        for(int i = 0; i<westTilesNames.length ; i++) {
            westPanel.add(allTiles[allIndex]);
            allIndex--;
        }
    }
    
    private void initNorthPanel() {
        int allIndex=southTilesNames.length + westTilesNames.length;
        
        allTiles[allIndex++] = new Jail(northTilesNames[0]);
        allTiles[allIndex++] = new Country(220, 220, Color.RED,
                "Kentucky Avenue", northTilesNames[1]);
        allTiles[allIndex++] = new Chance(northTilesNames[2]);
        allTiles[allIndex++] = new Country(220, 220, Color.RED,
                "Indiana Avenue", northTilesNames[3]);
        allTiles[allIndex++] = new Country(240, 240, Color.RED,
                "Illinois Avenue", northTilesNames[4]);
        allTiles[allIndex++] =   new RailRoad(  northTilesNames[5],50,"B&O RailRoad");
        allTiles[allIndex++] = new Country(260, 260, Color.YELLOW,
                "Atlantic Avenue", northTilesNames[6]);
        allTiles[allIndex++] = new Country(260, 260, Color.YELLOW,
                "Ventnor Avenue", northTilesNames[7]);
        allTiles[allIndex++] =new Utilties ("Water Selection.png",150,"Water Works");
        allTiles[allIndex++] = new Country(280, 280, Color.YELLOW,
                "Marvin Gardens", northTilesNames[9]);
        allTiles[allIndex++] = new GoToJail(northTilesNames[10]);
        
        allIndex=southTilesNames.length + westTilesNames.length;
        
        for(int i = 0; i<northTilesNames.length ; i++) {
            northPanel.add(allTiles[allIndex]);
            allIndex++;
        }
    }
    
    private void initEastPanel() {
        int allIndex = southTilesNames.length + westTilesNames.length + 
                northTilesNames.length;
        
        allTiles[allIndex++] = new Country(300, 300, Color.GREEN,
                "Pacific Avenue", eastTilesNames[0]);
        allTiles[allIndex++] = new Country(300, 300, Color.GREEN,
                "North Carolina Avenue", eastTilesNames[1]);
        allTiles[allIndex++] = new Chest(eastTilesNames[2]);
        allTiles[allIndex++] = new Country(320, 320, Color.GREEN,
                "Pensylvania Avenue", eastTilesNames[3]);
        allTiles[allIndex++] = new RailRoad(eastTilesNames[4],50,"SHORT LINE");
        allTiles[allIndex++] = new Chance(eastTilesNames[5]);
        allTiles[allIndex++] = new Country(350, 350, Color.BLUE,
                "Park Place", eastTilesNames[6]);
        allTiles[allIndex++] = new Taxes(eastTilesNames[7],100);
        allTiles[allIndex++] = new Country(400, 400, Color.BLUE,
                "Boardwalk", eastTilesNames[8]);
        
        allIndex = southTilesNames.length + westTilesNames.length + 
                northTilesNames.length;
        
        for(int i = 0; i< eastTilesNames.length ; i++) {
            eastPanel.add(allTiles[allIndex]);
            allIndex++;
        }
    }
    
    public void move (int diceNumber){
        turn = (turn + 1) % this.players.size();
        if (diceFlag) {
            diceFlag = false;
            if (turn==0)
                turn=this.players.size()-1;
            else 
            turn = (turn - 1) % this.players.size();

        }
        if (dice1Num == dice2Num) {
            diceFlag = true;
        }
       currentPlayer = this.players.get(this.turn);
       CurrentPlayerName = "Player : " + players.get(turn).name + " Turn" ;

       
        while(currentPlayer.getInJail()) {
           allTiles[10].performAction(currentPlayer);
            this.turn = (this.turn + 1) % this.players.size();
            currentPlayer = MonopolyBoardPanel.players.get(this.turn);
        }
        
        MainPanel main = (MainPanel) this.getParent();
        main.getPlayersContainer().getBuyBtn().setEnabled(false);
        currentPlayer.move(currentPlayer.place+diceNumber);
        main.update();
      /*  int firstPlace = currentPlayer.place;
    
        int secondPlace = (firstPlace + diceNumber) % allTiles.length;
        
        allTiles[firstPlace].GetLabels()[this.turn].setVisible(false);
        allTiles[secondPlace].GetLabels()[this.turn].setVisible(true);
        
        players.get(turn).place=secondPlace;
        
       
     MainPanel  b = (MainPanel)this.getParent();
        b.currentPanel.UpdateCurrentDetails();*/
        
  
    }
    
   public static  String getCurrentPlayerName(){
       return CurrentPlayerName;
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
     
     public int getPlayersNumber() {
         return Playernumber;
     }
    
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("game.data", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(Playernumber);
            oos.writeInt(turn);
            //oos.writeUTF(CurrentPlayerName);
            oos.writeBoolean(diceFlag);
            oos.writeInt(MonopolyBoardPanel.players.indexOf(currentPlayer));
            //oos.writeObject(dice1);
            //oos.writeObject(dice2);
            
            for(int i = 0; i < players.size(); i++) {
                players.get(i).save(fos, oos);
            }
            
            for(int i = 0; i < 40; i++) {
                if(allTiles[i] instanceof PropertyTile) {
                    PropertyTile tile = (PropertyTile)allTiles[i];
                    tile.save(fos, oos);
                }
            }
            
            oos.close();
            fos.close();
            System.out.println("saved");
        } catch(IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", 2);
        }
    }
    
    public void loadGame(FileInputStream fis, ObjectInputStream ois) 
            throws IOException, ClassNotFoundException {
        
        turn = ois.readInt();
        diceFlag = ois.readBoolean();
        currentPlayer = players.get(ois.readInt());
        //dice1 = (Dice)ois.readObject();
        //dice2 = (Dice)ois.readObject();
        System.out.println("Players : " + players.size());
        for(int i = 0; i < players.size(); i++) {
            players.get(i).load(fis, ois);
        }
        
        for(int i = 0; i < 40; i++) {
            if(allTiles[i] instanceof PropertyTile) {
                PropertyTile tile = (PropertyTile) allTiles[i];
                tile.load(fis, ois);
            }
        }
        
        
        CurrentPlayerName = "Player : " + players.get(turn).name + " Turn" ;
        System.out.println("Loaded");
    }
    
    public void updateBoard() {
        for(int i = 0; i < players.size(); i++) {
            allTiles[0].GetLabels()[i].setVisible(false);
        }
        
        for(int i = 0; i < players.size(); i++) {
            allTiles[players.get(i).place].GetLabels()[i].setVisible(true);
        }
    }
}
