package monoply.game;


import java.util.ArrayList;
import java.util.Collections;


public class SpecialCards {
    ArrayList<Card> chest ;
    ArrayList<Card> chance;
    Card FreeCard;
    Card DrawnCard ;
    public SpecialCards ()
    {
    chest = new ArrayList<Card>();
    chance = new ArrayList<Card>();
    createCards();
    shuffleCards(); 
    }
    private void createCards (){
        
        //chance
        chance.add(new Card ("Railroad","Advance to the nearest Railroad",1));
        chance.add(new Card ("Decrease Money","for each house pay $25 for each hotel $100",1));
        chance.add(new Card ("Broadwalk","Take a walk to the Broadwalk",1));
        chance.add(new Card ("Utility","Advance token to nearst utility",1));
        chance.add(new Card ("Go","If you pass go collect $200",1));
        //chest
        chest.add(new Card ("Go to Jail","Go directly to jail",2));
        chest.add(new Card ("Increase Money","From Sale of stock you get $45",2));
        chest.add(new Card ("Grand Opera Openning","collect $50 from every player",2));//half finished
        chest.add(new Card ("GO","Advance to \"GO\"",2));
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
                    
                    break;
                case "Decrease Money":
                    
                    break;
                case "Broadwalk":
                    
                    break;
                case "Utility":
                    
                    break;
                case "Go":
                    
                    break;
               
            }
        }
        else {
          switch(DrawnCard.getName()){
                case "Go to Jail":
                    
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
    public void returnFreeCard(){
        chance.add(FreeCard);
        
    }
}