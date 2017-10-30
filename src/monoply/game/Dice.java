/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author yehia
 */
public class Dice extends JLabel implements Serializable {
    private Random rand = new Random();
    
    private String []s={"Dice1.gif","Dice2.gif","Dice3.gif","Dice4.gif","Dice5.gif","Dice6.gif"};

    public Dice(){
        this.setVisible(false);
        this.setLayout(new GridLayout(0, 1));
        this.setText("");
        this.setOpaque(true);
       
    }

    public int getDice(){
        if(!this.isVisible()) {
            this.setVisible(true);
        }
        
        int num = rand.nextInt(6) + 1;
        ImageIcon origIcon = new ImageIcon(s[num - 1]);
        Dice d = this;
        
        this.setIcon(new ImageIcon(origIcon.getImage()
            .getScaledInstance(30, 30,
                    Image.SCALE_SMOOTH)));
        
        return num;
    }
}
