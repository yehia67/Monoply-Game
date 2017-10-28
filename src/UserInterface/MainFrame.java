/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

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

            public startPanel() {
                this.setSize(400, 500);
                this.setLayout(null);
                
                start = new JButton("Start");
                start.setSize(300, 75);
                start.setLocation(50, 100);
                this.add(start);
                exit = new JButton("Exit");
                exit.setSize(300, 75);
                exit.setLocation(50, 400);
                this.add(exit);
                this.setVisible(true);
                
                startPanel sp = this;
                
                start.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        sp.setVisible(false);
                        MainFrame.mp = new MainPanel(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                        mp.setVisible(true);
                        mp.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
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
        sp.setLocation((this.getWidth()-sp.getWidth())/2, (this.getHeight()-sp.getHeight())/2);
        this.add(sp);
        
      /*  this.addComponentListener(new ComponentAdapter() {
    @Override
public void componentResized(ComponentEvent arg0) {
    
int W = 3;
int H = 2; 
Rectangle b = arg0.getComponent().getBounds();
if (prevwidth==b.width){
arg0.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);
prevheight= b.width*H/W;
System.out.println("resized");
}

else if (prevheight==b.height){
arg0.getComponent().setBounds(b.x, b.y, b.height*W/H, b.height);
prevwidth=b.height*W/H;
}
}
        });*/
        
    }

}

