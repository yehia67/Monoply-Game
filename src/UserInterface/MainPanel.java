/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import monoply.game.*;

/**
 *
 * @author mahmoud
 */
public class MainPanel extends JPanel {

    public MonopolyBoardPanel board;

    public CurrentPanel currentPanel;
    public PlayersContainerPanel playerPanel;

    public int turn;

    public MainPanel(int width, int height, int nplayers) {
        //this.setLayout(new BorderLayout());
        this.setLayout(null);
        this.setSize(width, height);
        System.out.println("Width main panel: " + width + "\n Height main panel: " + height);
        Thread t1 = new Thread(new Runnable() {
            public void run() {

                board = new MonopolyBoardPanel(nplayers, height);
            }
        });
        t1.start();
        try {

            t1.join();

        } catch (InterruptedException ex) {
            System.out.print(ex);
        }
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                playerPanel = new PlayersContainerPanel(nplayers);
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            public void run() {

                currentPanel = new CurrentPanel();
            }
        });
        t3.start();

        try {
            t3.join();

            t2.join();
        } catch (InterruptedException ex) {
            System.out.print(ex);
        }
        currentPanel.setLocation(0, 0);
        currentPanel.setSize((width - height) / 3, height);

        // this.add(board);
        board.setLocation(currentPanel.getWidth(), 0);
        playerPanel.setLocation(currentPanel.getWidth() + board.getWidth(), 0);
        playerPanel.setSize(width - board.getWidth() - currentPanel.getWidth(), height);
        MF2.currentpanel = this;
        this.add(currentPanel);

        this.add(board);

        this.add(playerPanel);
        //this.setFocusable(false);

    }

    public MainPanel(MonopolyBoardPanel board, int w, int h) {
        this.board = board;
        this.setLayout(null);
        this.setSize(w, h);
        currentPanel = new CurrentPanel();
        currentPanel.setLocation(0, 0);
        currentPanel.setSize((w - h) / 3, h);
        playerPanel = new PlayersContainerPanel(this.board.getPlayersNumber());
        board.setLocation(currentPanel.getWidth(), 0);
        playerPanel.setLocation(currentPanel.getWidth() + board.getWidth(), 0);
        playerPanel.setSize(w - board.getWidth() - currentPanel.getWidth(), h);
        this.add(currentPanel);

        this.add(board);

        this.add(playerPanel);

        board.updateBoard();
        update();
        currentPanel.UpdateCurrentDetails();
    }

    public void update() {
        if (playerPanel != null) {
            playerPanel.updatePanels();
        }

    }

    public MonopolyBoardPanel getMonopolyBoardPanel() {
        return board;
    }

    public PlayersContainerPanel getPlayersContainer() {
        return playerPanel;
    }
}
