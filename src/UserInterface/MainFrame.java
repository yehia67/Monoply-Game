/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import monoply.game.*;

/**

 *
 * @author mahmoud
 */
public class MainFrame extends JFrame {

    public static MainPanel mp;

    public MainFrame() {
        MainFrame mf = this;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width-100*screenSize.width/screenSize.height, screenSize.height-100*screenSize.height/screenSize.width);
        //this.setSize(1260, 945);

        //this.setMinimumSize(new Dimension(1000, 725));
        
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Monoply Game");
        this.setLayout(null);
        class startPanel extends JPanel {

            private JButton start;
            private JButton exit;
            private playPanel pp;

            public startPanel() {
                this.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                this.setLayout(null);
                
                start = new JButton("Start");
                start.setSize(300, 75);
                start.setLocation((this.getWidth()-start.getWidth())/2, 250);
                this.add(start);
                exit = new JButton("Exit");
                exit.setSize(300, 75);
                exit.setLocation((this.getWidth()-exit.getWidth())/2, 550);
                this.add(exit);
                this.setVisible(true);
                
                pp = new playPanel();
                
                JPanel panel = new JPanel();
                //panel.setLayout(null);
                panel.setBackground(Color.red);
                panel.setSize(600, 600);
                panel.setLocation(start.getWidth()+start.getX()+10, 0);
               // pp.setLocation(0, 0);
               // panel.add(pp);
                this.add(panel);
                startPanel sp = this;
                
                start.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        sp.setVisible(false);
                        MainFrame.mp = new MainPanel(mf.getContentPane().getWidth(),mf.getContentPane().getHeight(),pp.getSpinnerValue());
                        mp.setVisible(true);
                        //mp.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                        mp.setLocation(0, 0);
                        mf.add(mp);


                    }
                });
                exit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        System.exit(0);
                    }
                });

            }

        }
  
        startPanel sp = new startPanel();
      // sp.setLocation((this.getWidth()-sp.getWidth())/2, (this.getHeight()-sp.getHeight())/2);
       sp.setLocation(0, 0);
      //playPanel pp = new playPanel();
    // pp.setVisible(true);
    // sp.add(pp);
    this.add(sp);
  }

}

