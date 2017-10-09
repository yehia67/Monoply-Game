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
    private boolean available = true;
    
    
    public SpecialPlaces(String name, Coordinates c){
       super(c);
        this.name=name;
    }
    
    public void SpecialPlaceAction(Player currentPlayer, SpecialCards card,ArrayList<Player> players){
        if(this.name=="Income Tax"){
           currentPlayer.money-=200; 
        }
        
        if(this.name.equalsIgnoreCase("Chance")){
            card.DrawCard(1,currentPlayer,players);
        }
        
        if(this.name.equalsIgnoreCase("COMMUNITY CHEST")){
            card.DrawCard(2,currentPlayer,players);
        }
        
        if(this.name=="Go to Jail"){
            currentPlayer.x=Board.getPlace(10).coords.x;
            currentPlayer.y=Board.getPlace(10).coords.y;
            currentPlayer.place=10;
            
            if(currentPlayer.HasJailCard) {
                Cards.returnFreeCard(currentPlayer);
                currentPlayer.HasJailCard = false;
                currentPlayer.setInJail(false);
            }
        }
        
        if(this.name=="LUXURY TAX"){
            currentPlayer.money-=75; 
        }
        
        if(this.name=="GO"){
            currentPlayer.money+=200;
        }
        
        if(this.name=="Parking"){
            
        }
    }
}

