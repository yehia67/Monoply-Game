/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */


 public abstract class  Tile extends JPanel{
    private BufferedImage backgroundImage;
    public String imgName;
    private JLabel[] playerImgs = new JLabel[4];
    private JLabel[] housesImgs = new JLabel[2];
    private JPanel playerImgsPanel;
    private JPanel houseImgsPanel; 
    private ImageIcon hotelImg;
    
    public Tile(String imgName) {
        try {
           this.imgName=imgName;
            backgroundImage = ImageIO.read(new File("Monopoly Board/" 
                    + imgName));
            Dimension size = new Dimension(backgroundImage.getWidth(),
            backgroundImage.getHeight());
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            this.setLayout(new GridLayout(1,2));
            
            playerImgsPanel = new JPanel();
            playerImgsPanel.setOpaque(false);
            houseImgsPanel = new JPanel();
            houseImgsPanel.setOpaque(false);
             this.add(playerImgsPanel);
             this.add(houseImgsPanel);
             
            
    
            playerImgsPanel.setLayout(new GridLayout(4, 1));
            houseImgsPanel.setLayout(new GridLayout(2, 1));
            
             for(int i =0; i<4; i++)
             {
                 playerImgs[i] = new JLabel();
                 playerImgsPanel.add(playerImgs[i]);
                 playerImgs[i].setHorizontalAlignment(JLabel.CENTER);
                // playerImgs[i].setSize(playerImgsPanel.getWidth(), playerImgsPanel.getHeight()/4);
             }
             
             for(int i = 0; i < 2; i++) {
                 housesImgs[i] = new JLabel();
                 houseImgsPanel.add(housesImgs[i]);
                 housesImgs[i].setHorizontalAlignment(JLabel.CENTER);
             }
       
            
          ImageIcon monopolydog = new ImageIcon(new ImageIcon(getClass().getResource("/monopolydog.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
          ImageIcon monopolycar = new ImageIcon(new ImageIcon(getClass().getResource("/monopolycar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
           ImageIcon monopolyhat = new ImageIcon(new ImageIcon(getClass().getResource("/monopolyhat.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            ImageIcon monopolyboot = new ImageIcon(new ImageIcon(getClass().getResource("/monopolyboot.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            
            ImageIcon houseImg = new ImageIcon(new ImageIcon(getClass().getResource("/monopolyhouse.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            hotelImg = new ImageIcon(new ImageIcon(getClass().getResource("/monopolyhotel.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
          
       
           
     
            playerImgs[0].setIcon(monopolydog);
            playerImgs[0].setVisible(false);
            playerImgs[1].setIcon(monopolycar);
            playerImgs[1].setVisible(false);
            playerImgs[2].setIcon(monopolyhat);
            playerImgs[2].setVisible(false);
            playerImgs[3].setIcon(monopolyboot);
            playerImgs[3].setVisible(false);
            
            housesImgs[0].setIcon(houseImg);
            housesImgs[0].setVisible(false);
            housesImgs[1].setIcon(houseImg);
            housesImgs[1].setVisible(false);
            /*housesImgs[2].setIcon(houseImg);
            housesImgs[2].setVisible(false);
            housesImgs[3].setIcon(houseImg);
            housesImgs[3].setVisible(false);*/
            //playerImgs[0].setText("HELLO");
           /* playerImgs[1].setIcon(monopolycar);
            playerImgs[2].setIcon(monopolyhat);
            playerImgs[3].setIcon(monopolyboot);
            
       */
                 
      
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
    
    public BufferedImage GetImage()
    {
        return this.backgroundImage;
    }
    
    public JLabel[] GetLabels()
    {
        return this.playerImgs;
    }
    
    public JLabel[] getHousesImgs() {
        return housesImgs;
    }
    
    public void showHotel() {
        housesImgs[0].setIcon(hotelImg);
        housesImgs[0].setVisible(true);
        housesImgs[1].setVisible(false);
        /*housesImgs[2].setVisible(false);
        housesImgs[3].setVisible(false);*/
    }
     public abstract void performAction(Player player);
         
     
    
}
