/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author mahmoud
 */
public class MainPanel extends JPanel {
    private MonopolyBoardPanel board;
    
    public MainPanel() {
        this.setLayout(new GridLayout(1, 1));
        board = new MonopolyBoardPanel();
        this.add(board);
    }
}
