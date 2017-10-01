package monoply.game;

import com.sun.java.accessibility.util.AWTEventMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StartPage extends JFrame {
	
     
            public static JFrame window;
            public static JPanel  panel;

  int WIDTH=1024;
 int HEIGHT=800;
   int buttonWidth=300;
                   int buttonHeight=100;
       private JButton start;
	   private JButton MULTIPLIER;
	   private JButton leaderboard;
	   private JButton exit;
           //private static dashboard board;
	  public static  int mode ;
	 //static  Game game;
	 //static  GameMulti game2;
	
            
	   public void setButtonProp (JButton b,int y )
           {
               b.setBounds((WIDTH/2)-(buttonWidth/2),y , buttonWidth, buttonHeight);
               b.setFont(new Font("AR DARLING",Font.PLAIN,35));

               b.setContentAreaFilled(false);
               b.setForeground(Color.red);
               b.setBorderPainted(false);
               b.setOpaque(false);
               
           }
            
	  
           
           public void Display() 
           {
                window = new JFrame();
                panel = new JPanel();
                JPanel gamepanel = new JPanel()
                {
                         @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         BufferedImage image = null;
     try
     {
    image = ImageIO.read(new File("D:monopolyimg.jpg"));
                }
     catch(IOException io)
     {
         
     }
   Image scaled = image.getScaledInstance(getWidth(), getHeight()-36, Image.SCALE_SMOOTH);
   g.drawOval(mode, mode, WIDTH, HEIGHT);
      g.drawImage(scaled,0,0,null);
   
    g.setColor(Color.RED);
    g.fillOval(950,740,20,20);
     g.setColor(Color.YELLOW);
    g.fillOval(950,720,20,20);
     g.setColor(Color.GREEN);
    g.fillOval(950,680,20,20);
     g.setColor(Color.BLUE);
    g.fillOval(950,700,20,20);
               
                };
                };
                
                window.getContentPane();
                gamepanel.setLayout(null);
                gamepanel.setSize(WIDTH,HEIGHT);
                panel.setLayout(null);
                panel.setSize(WIDTH,HEIGHT);
               
                gamepanel.setLayout(null);
                panel.setCursor(Cursor.getDefaultCursor());
                window.setLayout(null);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                window.setBounds(0,0,WIDTH,HEIGHT);
                window.setResizable(false);
                window.setTitle("Monopoly");
                window.setLocationRelativeTo(null);
                window.add(panel);
                window.add(gamepanel);
                gamepanel.setVisible(false);
                gamepanel.setOpaque(true);
                gamepanel.setBackground(Color.black);
                
           
         
             
	   start = new JButton("Play");
                setButtonProp(start,HEIGHT/6);
                            start.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                            panel.setVisible(false);
                        
                            gamepanel.setVisible(true);
                            
                            mode = 1;
                          
		       
               
                       }
                   });
                       panel.add(start);
                       
                       
		   MULTIPLIER = new JButton("Menu Item #2");
                   setButtonProp(MULTIPLIER,HEIGHT/3);
 MULTIPLIER.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                            panel.setVisible(false);
                            mode = 2;
                   //         game2 = new GameMulti(window.getContentPane().getWidth(),window.getContentPane().getHeight());
                       }
                   });
                      panel.add(MULTIPLIER);
		 
//<<<<<<< HEAD
		   leaderboard = new JButton("Menu Item #3");
                   setButtonProp(leaderboard,HEIGHT/2);
                    leaderboard.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                            panel.setVisible(false);
             //board = new dashboard (window.getContentPane().getWidth(), window.getContentPane().getHeight());
		  //       window.addKeyListener(board);
                       }
                   });

		       panel.add(leaderboard);

     window.add(panel);
      window.setVisible(true);
           }
	   

}
	
