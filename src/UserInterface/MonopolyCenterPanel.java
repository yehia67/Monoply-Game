/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MonopolyCenterPanel extends JPanel {
    
       private BufferedImage backgroundImage;
    public MonopolyCenterPanel(String imgName) {
        try {
            backgroundImage = ImageIO.read(new File("Monopoly Board/" 
                    + imgName));
            Dimension size = new Dimension(backgroundImage.getWidth(),
            backgroundImage.getHeight());
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
           
        } catch(Exception e) {
          
            System.out.println(e.getMessage());
        }
      //
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
     g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), 
              null);
        
    }
}