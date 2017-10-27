/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author mahmoud
 */
public class MainFrame extends JFrame {
    public static MainPanel mp = new MainPanel();
    private int prevwidth;
    private int prevheight;
    public MainFrame()
    {
    
        
        this.setSize(1260,945 );
        prevwidth=1260;
        prevheight=945;
        this.setMinimumSize(new Dimension(1000,725));
      //  this.set
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mp);
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
    //@Override
/*public void componentResized(ComponentEvent arg0) {
    
int W = 4;
int H = 3; 
Rectangle b = arg0.getComponent().getBounds();
arg0.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);

}*/
}
