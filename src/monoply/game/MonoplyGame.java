/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yehia
 */
public class MonoplyGame {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]){
        ArrayList<Player> players= new ArrayList<Player>();
        //Dice dice = new Dice();
        mainFrame mF = new mainFrame();
        mF.setVisible(true);
        Random rand = new Random();
      //  Countries countries = new Countries();
        /*
        int i = 0, d;
        String o;
        while(true)
        {
        System.out.println("press any key to roll the dices");
        o = x.next();
        d = rand.nextInt(12) + 1;
        System.out.println("Dices = "+ d );
        players.get(i).place +=  d;
        Country defaultCountry = countries.getCountries(players.get(i).place);
        System.out.println("Weclome to "+ defaultCountry.getName());
        if(defaultCountry.isOwner(players.get(i).name)){
            System.out.println("Weclome to your place Mr. " +players.get(i).name);
        }
        else if(defaultCountry.checkAvailable())
        {
             System.out.println("Dear Mr. " +players.get(i).name);
             System.out.println("you can buy " + defaultCountry.getName() + " for just "
                      + defaultCountry.getPrice() + "$"  );
             System.out.println("To buy it press Y else press any button");
             String y = x.next();
             if(y.equals("y") || y.equals("Y") )
             {
                 if(players.get(i).money >= defaultCountry.getPrice())
                 {
                     players.get(i).money -= defaultCountry.getPrice();
                     System.out.println("Congratulation you have succufuly buy that city");
                     System.out.println("your credit now is =  " + players.get(i).money +"$" );
                     defaultCountry.sold();
                     
                 }
                 else
             {
                 System.out.println("Sorry you don't have enought money to buy this city");
             }
             }
             
        }
        else{
            players.get(i).money -= defaultCountry.getTotalFees();
         System.out.println("You pay   " + defaultCountry.getTotalFees()+"$" + "for vistimg "
                 + "our beautiful country"); 
            System.out.println("your credit now is =  " + players.get(i).money +"$" );
         
        }
        System.out.println("Next TURN!!");
        i++;
        if(i == playerNo)    
        {
                i = 0;
            }
        
        }
        
        
   */ }
    
}
