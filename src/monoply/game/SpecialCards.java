package monoply.game;


import UserInterface.MainPanel;
import UserInterface.MonopolyBoardPanel;
import static UserInterface.MonopolyBoardPanel.allTiles;

import java.util.ArrayList;
import java.util.Collections;


public class SpecialCards {
    private ArrayList<Card> chest ;
    private ArrayList<Card> chance;
    private Card FreeCard;
    private Card DrawnCard ;
    private int [] railroads = {5,15,25,35};
    private int [] utilities = {12,28};
    public SpecialCards ()
    {
    chest = new ArrayList<Card>();
    chance = new ArrayList<Card>();
    createCards();
    shuffleCards(); 
    }
    private void createCards (){
        
        //chance
        chance.add(new Card ("Railroad","Advance to the nearest Railroad",1));//finished
        chance.add(new Card ("Decrease Money","for each house you own pay $25 for each hotel $100",1));// half finished
        chance.add(new Card ("Broadwalk","Take a walk to the Broadwalk",1));//finished
        chance.add(new Card ("Utility","Advance token to nearst utility",1));//finished
        chance.add(new Card ("Go","Advance to \"GO\" \n Reminder: If you pass go collect $200",1));//finished
        chance.add(new Card ("Bank pays you dividend of $50"," Bank pays you dividend of $50",1));//finished
        chance.add(new Card ("Pay poor tax of $15","Pay poor tax of $15",1));//finished
        chance.add(new Card ("Take a trip to Reading Railroad","Take a trip to Reading Railroad If you pass Go, collect $200",1));//finished
        chance.add(new Card ("You have been elected Chairman of the Board","You have been elected Chairman of the Board Pay each player $50",1));//finished
        chance.add(new Card ("You have won a crossword competition","You have won a crossword competition Collect $100",1));//finished
        
        //chest
        chest.add(new Card ("Go to Jail","Go directly to jail",2));// finished
        chest.add(new Card ("Increase Money","From Sale of stock you get $45",2));//finished
        chest.add(new Card ("Grand Opera Openning","collect $50 from every player",2));// finished
        chest.add(new Card ("GO","Advance to \"GO\"",2));//finished
        chest.add(new Card ("Bank error in your favor","Bank error in your favor Collect $200 ",2));//finished
        chest.add(new Card ("Doctor's fees ","Doctor's fees Pay $50",2));//finished
        chest.add(new Card ("Sales","From sale of stock you get $50",2));//finished
        chest.add(new Card ("Holiday  Fund matures","Holiday  Fund matures Receive  $100",2));//finished
        chest.add(new Card ("Income tax refund","Income tax refund Collect $20",2));//finished
        chest.add(new Card ("It is your birthday","It is your birthday Collect $10 from each player",2));//finished
        chest.add(new Card ("Life insurance matures","Life insurance matures Collect $100",2));//finished
        chest.add(new Card ("Pay hospital fees of $100","Pay $100",2));//finished
        chest.add(new Card ("Receive $25 consultancy fee","Receive $25 consultancy fees for services $25",2));//finished
        chest.add(new Card ("You have won second prize in a beauty contest","You have won second prize in a beauty contest Collect $10",2));//finished
        chest.add(new Card ("You inherit $100","You inherit $100",2));//finished
        FreeCard=new Card ("Freed","Get out of jail free",2);//finished
        chest.add(FreeCard);
    
    }
    private void shuffleCards()
    {
        Collections.shuffle(chest);
        Collections.shuffle(chance);
    }
    public void performAction (Player player,ArrayList<Player> players)
    {  //Actions to be edited 
        if (DrawnCard.getType()==1){
            switch(DrawnCard.getName()){
                case "Railroad":
                    this.move2(player,2);
                    break;
                case "Decrease Money":
                    this.pay(player);
                    break;
                case "Broadwalk":
                    this.move(player,39);
                    break;
                case "Utility":
                     this.move2(player,1);
                    break;
                case "Go":
                    this.move(player,0);
                    break;
                case "Bank pays you dividend of $50":
                    player.money += 50;
                    break; 
                
                case "Pay poor tax of $15":
                    player.money -= 15;
                    break;
                case "Take a trip to Reading Railroad":
                     this.move2(player,2);
                    break; 
                
                case "You have been elected Chairman of the Board":
                     this.reduceMoney(player,players,50);
                    break;
                
                case "You have won a crossword competition ":
                    player.money += 100;
                    break;    
               
            }
        }
        else {
          switch(DrawnCard.getName()){
                case "Go to Jail":
                    this.move(player,10);
                    Jail jail = (Jail)MonopolyBoardPanel.allTiles[10];
                    jail.setInjail(player);
                    break;
                    
                //increases money of current player   
                case "Increase Money":
                    player.money+=45;
                    break;
                    
                //loops over arraylist and reduce money of each player  
                case "Grand Opera Openning":
                   this.reduceMoney(player,players,50);
                   
                    break;
                    
                    
                case "GO":
                    this.move(player,0);
                    break;
                    
                case "Bank error in your favor" :
                    player.money+=200;
                    break; 
                
                case "Doctor's fees" :
                    player.money -=50;
                    break;  
                
                case "Sales" :
                    player.money +=50;
                    break;
                
                case "Holiday  Fund matures" :
                    player.money +=100;
                    break;  
                case "Income tax refund" :
                    player.money +=20;
                    break;     
                
                case "It is your birthday":
                   this.reduceMoney(player, players,10);
                   
                    break;    
                
                case "Life insurance matures" :
                    player.money +=100;
                    break;    
                
                case "Pay hospital fees of $100" :
                    player.money -=100;
                    break; 
                
                case "Pay school fees  of $150" :
                    player.money -=150;
                    break;
                
                case "Receive $25 consultancy fee" :
                    player.money +=25;
                    break; 
                
                case "You have won second prize in a beauty contest" :
                    player.money +=10;
                    break;
                
                case "You inherit $100" :
                    player.money +=100;
                    break;    
          }
        }
    }
    public void DrawCard (int type, Player Player,ArrayList<Player> players)
    {
        System.out.println("here");
        if (type ==2)
        {
            this.DrawnCard = chest.get(0);
            

            Collections.rotate(chest, -1);
        }
        else {
            this.DrawnCard = chance.get(0);
            
            if(DrawnCard.getName()=="Freed"){
                Player.HasJailCard=true;
                chance.remove(DrawnCard);
            }
            else
            Collections.rotate(chance, -1);
        }
        //Display Message Here *DrawnCard.getDescription()*
        //DrawnCard=chance.get(2);
        //GamePanel.MessageTextField.setText(DrawnCard.getDescription());
        System.out.println("Drawn Card"+DrawnCard.getDescription());
        this.performAction(Player,players);
    }
   
    private void reduceMoney(Player player,ArrayList<Player> players,int money){
         for(int i=0;i<players.size();i++){
                        if(players.get(i)==player){}
                        else{
                            if (players.get(i).money-money>=0){
                            players.get(i).money-=money;
                            player.money+=money;
                            }
                            else {
                                //lost ////////////////////////////////////////////    
                                    }
                                    }
                    }
    }
    private void increaseMoney(Player player,ArrayList<Player> players,int money){
         for(int i=0;i<players.size();i++){
                        if(players.get(i)==player){}
                        else{
                            if (players.get(i).money-money>=0){
                            players.get(i).money +=money;
                            player.money-=money;
                            }
                            else {
                                //lost ////////////////////////////////////////////    
                                    }
                                    }
                    }
    }
    public void returnFreeCard(Player player){
        chance.add(FreeCard);
        player.HasJailCard=false;
        
    }
    private void pay (Player p)
    {
        if (p.money-25*p.houses+100*p.hotels>=0)
        {
            p.money -= 25*p.houses+100*p.hotels;
        }
        else {
            // ma3oosh floos 
        }
    }
    private void move ( Player player,int index)
    {
        System.out.println("here22");
        //player.x = place.coords.x;
        //player.y= place.coords.y;
        //player.place= index;
       if (DrawnCard.getName().equalsIgnoreCase("Go to Jail")){
        allTiles[player.place].GetLabels().get(MonopolyBoardPanel.turn).setVisible(false);
           player.place= 10;
        allTiles[player.place].GetLabels().get(MonopolyBoardPanel.turn).setVisible(true);
            MainPanel b = (MainPanel) Player.panel.getParent();
                    b.currentPanel.UpdateCurrentDetails();
       }
       else{
        player.move(index);
       }
       // playPanel.gp.repaint();
    }
    
    private void move2(Player player,int x)
    {
        /*int index=0;
        for (int i =0; i< Board.placesArr.size();i++){
            if (player.x==Board.placesArr.get(i).coords.x && player.y==Board.placesArr.get(i).coords.y)
                index = i;
        }*/
        if (x==1)
        {
            if (player.place>=utilities[utilities.length-1] )
            {
                this.move( player, utilities[0]);
            } 
            else {
            for (int i =0; i<utilities.length;i++){
               if (player.place < utilities[i])
               {
                   this.move( player, utilities[i]);
                   break;
               }
            }
            }

        }
        else 
        {
            if (player.place>=railroads[railroads.length-1] )
            {
                this.move( player, railroads[0]);
            }
            else {
           for (int i =0; i<railroads.length;i++){
               if (player.place < railroads[i])
               {
                   this.move( player,railroads[i]);
                   break;
               }
            } 
            }
        }

    }
    
    public Card getDrawnCard() {
        return DrawnCard;
    }
}