package monoply.game;


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
        chance.add(new Card ("Decrease Money","for each house you own pay $25 for each hotel $100",1));
        chance.add(new Card ("Broadwalk","Take a walk to the Broadwalk",1));//finished
        chance.add(new Card ("Utility","Advance token to nearst utility",1));//finished
        chance.add(new Card ("Go","Advance to \"GO\" \n Reminder: If you pass go collect $200",1));//finished
        //chest
        chest.add(new Card ("Go to Jail","Go directly to jail",2));// finished
        chest.add(new Card ("Increase Money","From Sale of stock you get $45",2));//finished
        chest.add(new Card ("Grand Opera Openning","collect $50 from every player",2));//half finished
        chest.add(new Card ("GO","Advance to \"GO\"",2));//finished
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
                    
                    break;
                case "Broadwalk":
                    this.move(Board.getPlace(Board.placesArr.size()-1),player);
                    break;
                case "Utility":
                     this.move2(player,1);
                    break;
                case "Go":
                    this.move(Board.getPlace(0),player);
                    break;
               
            }
        }
        else {
          switch(DrawnCard.getName()){
                case "Go to Jail":
                    this.move(Board.getPlace(10),player);
                    break;
                    
                //increases money of current player   
                case "Increase Money":
                    player.money+=45;
                    break;
                    
                //loops over arraylist and reduce money of each player  
                case "Grand Opera Openning":
                   this.reduceMoney(player, players);
                    break;
                    
                    
                case "GO":
                    this.move(Board.getPlace(0),player);
                    break;

            }
        }
    }
    public void DrawCard (int type, Player Player,ArrayList<Player> players)
    {
        if (type ==1)
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
        this.performAction(Player,players);
    }
   
    private void reduceMoney(Player player,ArrayList<Player> players){
         for(int i=0;i<players.size();i++){
                        if(players.get(i)==player)
                            continue;
                        else{
                            if (players.get(i).money-50>=0){
                            players.get(i).money-=50;
                            player.money+=50;
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
    private void move (Places place , Player player)
    {
        player.x = place.coords.x;
        player.y= place.coords.y;
        
    }
    private void move2(Player player,int x)
    {
        int index=0; ; 
        for (int i =0; i< Board.placesArr.size();i++){
            if (player.x==Board.placesArr.get(i).coords.x && player.y==Board.placesArr.get(i).coords.y  )
                index = i;
        }
        if (x==1)
        {
            if (index>=utilities[utilities.length-1] )
            {
                this.move(Board.placesArr.get( utilities[0]), player);
            }
            else {
            for (int i =0; i<utilities.length;i++){
               if (index < utilities[i])
               {
                   this.move(Board.placesArr.get( utilities[i]), player);
                   break;
               }
            }
            }

        }
        else 
        {
            if (index>=utilities[railroads.length-1] )
            {
                this.move(Board.placesArr.get( railroads[0]), player);
            }
            else {
           for (int i =0; i<railroads.length;i++){
               if (index < railroads[i])
               {
                   this.move(Board.placesArr.get( railroads[i]), player);
                   break;
               }
            } 
            }
        }

    }
}