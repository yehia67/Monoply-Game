/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author moaz
 */
public class Taxes extends NonPropertyTile{
	int reduceamount;
	public Taxes(String imgName, int redam){
		super(imgName);
		this.reduceamount=redam;	
	}

	
	public void performAction(Player player){
            if(reduceamount==100)
                player.money-=100;
            
            else
                player.money-=200;
	}
}