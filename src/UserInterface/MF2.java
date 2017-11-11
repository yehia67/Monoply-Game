/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import static UserInterface.MainFrame.mp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author eslam
 */
public class MF2 extends javax.swing.JFrame {
    public static MainPanel mp;
    public static playPanel pp;

    /**
     * Creates new form MF2
     */
    public MF2() {
        MF2 mf = this;
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
            private JButton loadBtn;
            Image background ;

            public startPanel() {
                this.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                this.setLayout(null);
                
                start = new JButton("New game");
                start.setSize(300, 75);
                start.setLocation((this.getWidth()-start.getWidth())/2, 250);
                this.add(start);
                exit = new JButton("Exit");
                exit.setSize(300, 75);
                exit.setLocation((this.getWidth()-exit.getWidth())/2, 550);
                this.add(exit);
                loadBtn = new JButton("Load");
                loadBtn.setSize(300, 75);
                loadBtn.setLocation((this.getWidth()-loadBtn.getWidth())/2, start.getY()+(exit.getY()-start.getY()+start.getHeight()-loadBtn.getHeight())/2);
                this.add(loadBtn);
                this.setVisible(true);
                try {
                    background = ImageIO.read(new File("Monopoly Board/Background.jpg")).getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
                } catch (Exception ex) {
                    System.out.println("FAIL");
                }

                pp = new playPanel();
                
                JPanel panel = new JPanel();
                panel.setOpaque(false);
                //panel.setLayout(null);
               // panel.setBackground(Color.red);
                panel.setSize(600, 450);
                panel.setLocation(start.getWidth()+start.getX()+10,this.getHeight()*1/4);
               // pp.setLocation(0, 0);
                panel.add(pp);
                this.add(panel);
                startPanel sp = this;
                
                start.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        /*try {
                            FileInputStream fis = new FileInputStream("game.data");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            System.out.println("hereeeeeeeeeeee");
                            MonopolyBoardPanel board = loadGame(fis, ois);
                            sp.setVisible(false);
                            MF2.mp = new MainPanel(board, mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                            mp.setVisible(true);
                            //mp.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                            mp.setLocation(0, 0);
                            mf.add(mp);
                        } catch(IOException ex) {
                            JOptionPane.showMessageDialog(MF2.this, "No saved game found", "", 2);
                            sp.setVisible(false);
                            System.out.println("Spinner "+pp.getSpinnerValue());
                            MF2.mp = new MainPanel(mf.getContentPane().getWidth(),mf.getContentPane().getHeight(),pp.getSpinnerValue());
                            mp.setVisible(true);
                            //mp.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                            mp.setLocation(0, 0);
                            mf.add(mp);
                        } catch(ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(MF2.this, ex.getMessage(),
                                    "", 2);
                        }*/

                        
                            sp.setVisible(false);
                            System.out.println("Spinner "+pp.getSpinnerValue());
                            MF2.mp = new MainPanel(mf.getContentPane().getWidth(),mf.getContentPane().getHeight(),pp.getSpinnerValue());
                            mp.setVisible(true);
                            //mp.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                            mp.setLocation(0, 0);
                            mf.add(mp);
                    }
                });
                
                loadBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            FileInputStream fis = new FileInputStream("game.data");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            System.out.println("hereeeeeeeeeeee");
                            MonopolyBoardPanel board = loadGame(fis, ois);
                            sp.setVisible(false);
                            MF2.mp = new MainPanel(board, mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                            mp.setVisible(true);
                            //mp.setSize(mf.getContentPane().getWidth(),mf.getContentPane().getHeight());
                            mp.setLocation(0, 0);
                            mf.add(mp);
                        } catch(IOException ex) {
                            JOptionPane.showMessageDialog(MF2.this, "No saved game found", "", 2);
                        } catch(ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(MF2.this, ex.getMessage(),
                                    "", 2);
                        }
                    }
                });
                
                exit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        System.exit(0);
                    }
                });

            }
@Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
}

        }
  
        startPanel sp = new startPanel();
      // sp.setLocation((this.getWidth()-sp.getWidth())/2, (this.getHeight()-sp.getHeight())/2);
       sp.setLocation(0, 0);
      //playPanel pp = new playPanel();
    // pp.setVisible(true);
    // sp.add(pp);
    this.add(sp);
        initComponents();
    }
    private Dimension getDimension()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width= screenSize.width-100*screenSize.width/screenSize.height;
        screenSize.height= screenSize.height-100*screenSize.height/screenSize.width;
        return screenSize;
    }
    
    public MonopolyBoardPanel loadGame(FileInputStream fis, ObjectInputStream ois) 
            throws IOException, ClassNotFoundException{
        int playersNum = ois.readInt();
        MonopolyBoardPanel board = new MonopolyBoardPanel(playersNum, MF2.this.getContentPane().getHeight());
        board.loadGame(fis, ois);
        return board;   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(getDimension());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MF2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MF2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MF2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MF2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MF2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
