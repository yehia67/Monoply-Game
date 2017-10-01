package monoply.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class SpecialCards {
    ArrayList<Card> chest ;
    ArrayList<Card> chance;
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
        chest.add(new Card ("Grand Opera Openning","collect $50 from every player",2));
        chest.add(new Card ("GO","Advance to \"GO\"",2));
        chest.add(new Card ("Freed","Get out of jail free",2));
    
    }
    private void shuffleCards()
    {
        Collections.shuffle(chest);
        Collections.shuffle(chance);
    }
    public void performAction (Players player)
    {  //Actions to be edited 
        if (DrawnCard.getType()==1){
            switch(DrawnCard.getName()){
                case "Go to Jail":
                    player.money +=100;
                    break;
                case "Decrease Money":
                    player.money -=100;
                    break;
                case "Broadwalk":
                    player.money +=100;
                    break;
                case "Utility":
                    player.money -=100;
                    break;
                case "Freed":
                    player.money +=100;
                    break;
               
            }
        }
        else {
          switch(DrawnCard.getName()){
                case "Railroad":
                    player.money +=100;
                    break;
                case "Increase Money":
                    player.money -=100;
                    break;
                case "Grand Opera Openning":
                    player.money +=100;
                    break;
                case "GO":
                    player.money -=100;
                    break;
                case "Go":
                    player.money +=100;
                    break;
               
            }
        }
    }
    public void DrawCard (int type, Players Player)
    {
        if (type ==1)
        {
            this.DrawnCard = chest.get(0);
            Collections.rotate(chest, -1);
        }
        else {
            this.DrawnCard = chance.get(0);
            Collections.rotate(chance, -1);
        }
        //Display Message Here *DrawnCard.getDescription()*
        this.performAction(Player);
    }
    //adding chest cards into the board
   /* public void addChestCards(){
	chest.add(new String("1"));
	chest.add(new String("2"));
	chest.add(new String("3"));
	chest.add(new String("4"));
	chest.add(new String("5"));
	}
    
    //adding chance card into the board
    public void addChanceCards(){
		chance.add(new String("1"));
		chance.add(new String("2"));
		chance.add(new String("3"));
		chance.add(new String("4"));
		chance.add(new String("5"));
	}*/
    
    
    //adds the effect of each special card based on if condition
    /*public void cardsIntoAction(){
        
        //position is to be taken first pos
        
        if (/* curren location pos== location of treasure) {
            Action drawChest = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
                                Random rand = new Random();
				int i = rand.nextInt(5);
				String card = chest.get(i);

				if(card.equals("PENALTY")){
					message.setText("Penalty! You must pay 80!");
					player.setMoney(-80);
					money.setText("Money: "+String.valueOf(player.getMoney()));
				}
				else if(card.equals("FINED")){
					message.setText("Tax cheat! You must pay 100!");
					player.setMoney(-100);
					money.setText("Money: "+String.valueOf(player.getMoney()));
				}
				else if(card.equals("PAY")){
					message.setText("Income tax refund. 200 collected!");
					player.setMoney(200);
					money.setText("Money: "+String.valueOf(player.getMoney()));
				}
				//endTB.setEnabled(true);
		}
	};
        }
        
        
        if (/* curren location pos== location of treasure ) {
        Action drawChance = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
                                Random rand = new Random();
				int i = rand.nextInt(3);
				String card = chance.get(i);

				if(card.equals("BIRTHDAY")){
					message.setText("It's your birthday today!\n");
					player1.setMoney(20);
					player2.setMoney(-20);
					money.setText("Money: "+String.valueOf(player.getMoney()));
				}
				else if(card.equals("JAIL")){
					message.setText("You have a Free Jail card!\n");
					player.haveJC = true;
				}
				else if(card.equals("REPAIR")){
					message.setText("Make repairs on all of your rooms!\n");
					ArrayList<Place> nyL = player.getProps();
					int cash = 0;
					for(Place p : nyL)
						cash+=10;
					player.setMoney(-(cash));
					money.setText("Money: "+String.valueOf(player.getMoney()));
				}
				//endTB.setEnabled(true);
		}
	};
    }
    
    
    
    
    } */
}
