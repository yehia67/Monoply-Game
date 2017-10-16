/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.GridLayout;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class StartingPanel extends JPanel{
    //Where the GUI is created:

private BufferedImage bgimage;
public StartingPanel()
{

//Create the menu bar.

this.setVisible(true);
  try
        {
    bgimage = ImageIO.read(new File("src/monopolyspbg.png" ) );
        }
        catch(Exception ex)
        {
     
        }
ImageIcon startImg = new ImageIcon("src/playnow.png");
ImageIcon exitImg = new ImageIcon("src/exitbutton.jpg");
 this.setLayout(new GridLayout(8,1));

    JButton startButton = new JButton(startImg);
    JButton exitButton = new JButton(exitImg);
   this.add(startButton);
     this.add(Box.createVerticalGlue());
     this.add(Box.createVerticalGlue());
      this.add(Box.createVerticalGlue());
      
   this.add(exitButton);
 
  
   startButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae){
     setVisible(false);
   
MainFrame2.mp.setVisible(true);
       
       }
      });
   
    exitButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae){
     System.exit(0);
       
       }
      });

}

 @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgimage, 0, 0, null);
}
 


}
