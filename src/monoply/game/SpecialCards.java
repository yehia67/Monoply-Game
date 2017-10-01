package monoply.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class SpecialCards {
    ArrayList<String> chest = new ArrayList<String>();
    ArrayList<String> chance = new ArrayList<String>();
    
    
    
    //adding chest cards into the board
    public void addChestCards(){
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
	}
    
    
    //adds the effect of each special card based on if condition
    public void cardsIntoAction(){
        
        //position is to be taken first pos
        
        if (/* curren location pos== location of treasure*/ ) {
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
        
        
        if (/* curren location pos== location of treasure*/ ) {
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
    
    
    
    
    
}
