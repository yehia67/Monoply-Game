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
        ArrayList<Players> players= new ArrayList<Players>();
        //Dice dice = new Dice();
        StartPage sp = new StartPage();
        sp.Display();
        Random rand = new Random();
        Countries countries = new Countries();
        System.out.println("Welcom to our game");
        System.out.println("Please enter the no of players");
        int playerNo;
        Scanner x = new Scanner(System.in);
        playerNo = x.nextInt();
        while (playerNo > 8 || playerNo < 2) {
            System.out.println("Please enter a number between 2 & 8");
            playerNo = x.nextInt();
        }
        String playerName;
        for(int i = 1; i <= playerNo; ++i)
        {
            System.out.println("Please enter Player " + i +" name" );
            playerName = x.next();
           Players playe = new Players(playerName);
           players.add(playe);
        }
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
        
        
    }
    
}
