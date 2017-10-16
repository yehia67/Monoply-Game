/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class MainFrame2 extends JFrame{
    
  public static MainPanel mp;
  public static StartingPanel sp;
   
   
   public MainFrame2()
    {
       mp = new MainPanel();
    
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
   // this.setUndecorated(true);
    this.setVisible(true);
   
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mp);
       
        sp = new StartingPanel();
        
        this.add(sp);
        mp.setVisible(false);
        sp.setVisible(true);
       this.pack();
       
        
    }
}
