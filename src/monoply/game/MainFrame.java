/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author mahmoud
 */
public class MainFrame extends JFrame {
    public static MainPanel mp = new MainPanel();
    
    public MainFrame()
    {
    
        
        this.setSize(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mp);
        
        
    }
    
}
