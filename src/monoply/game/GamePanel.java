/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */
public class GamePanel extends JPanel {
    private BufferedImage image;
    
    public GamePanel() {
        try {                
            image = ImageIO.read(new File("monopolyimg.jpg"));
            Dimension size = new Dimension(image.getWidth(), image.getHeight());
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
       } catch (IOException ex) {
            System.out.println("File not found");
       }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
      }
}
