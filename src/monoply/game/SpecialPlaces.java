package monoply.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class SpecialPlaces extends Places{
    int location;                    //to be modified
    String name;                     //name of the special location ex utility,Income tax
    SpecialCards Cards;
    
    
    public SpecialPlaces(String name, Coordinates c){
       super(c);
        this.name=name;
    }
    
    
    //adds the effect of each specialplace based on location
//    public void placesIntoAction(Player p1 ,Player p2playerlocation){
//        
//        //position is to be taken first pos
//        
//        //action for chest
//        if (/* curren location pos== location of treasure*/ ) {
//            Action drawChest = new AbstractAction(){
//		public void actionPerformed(ActionEvent e){
//                    Cards.DrawCard(1, p1);
//		}
//	};
//        }
//        
//        
//        //action for chance
//        else if (/* curren location pos== location of treasure*/ ) {
//        Action drawChance = new AbstractAction(){
//		public void actionPerformed(ActionEvent e){
//                    Cards.DrawCard(2, p1);
//		}
//	};
//    }
//        
//        //action for GO
//        else if(/* curren location pos== location of go*/){
//			p1.setMoney(200);
//			p1.money.setText("Money: "+p1.getMoney());
//			//field.append(player1.getNamn()+" has returned to GO\n and collects 200!\n");   message
//	}
//    
//    
//        //action for jail
//        else if(/* curren location pos== location of jail*/){
//            Action goinJail = new AbstractAction(){
//                public void actionPerformed(ActionEvent e){
//                    //set location of player to location of jail
//                }
//            };
//        }
//        
//        
//        //action for luxury tax
//        else if(/* curren location pos== location of luxury tax*/){
//            p1.money-=100;
//        }
//        
//
//        //action for Income tax
//        else if(/* curren location pos== location of luxury tax*/){
//            p1.money-=200;
//        }
//        
//
//
//        //action for parking
//        else if(/* curren location pos== location of luxury tax*/){
//            //give message that "Just Parking Free"
//        }	
//   }
}

