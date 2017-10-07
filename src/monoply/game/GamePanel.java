/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

import static monoply.game.playPanel.playersNumberSpinner;
import static monoply.game.playPanel.player1TextField;
import static monoply.game.playPanel.player2TextField;
import static monoply.game.playPanel.player3TextField;
import static monoply.game.playPanel.player4TextField;
import static monoply.game.playPanel.player5TextField;
import static monoply.game.playPanel.player6TextField;
import static monoply.game.playPanel.player7TextField;
import static monoply.game.playPanel.player8TextField;
import static monoply.game.playPanel.playersNumber;

/**
 *
 * @author mahmoud
 */
public class GamePanel extends javax.swing.JPanel {

    /**
     * Creates new form GamePlayPanel
     */
    public GamePanel() {
        initComponents();
        hideButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BoardPanel = new Board(playersNumber);
        rollDiceButton = new javax.swing.JButton();
        DiceResultLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Player1Name = new javax.swing.JLabel();
        Player1Money = new javax.swing.JLabel();
        Player2Money = new javax.swing.JLabel();
        Player2Name = new javax.swing.JLabel();
        Player3Name = new javax.swing.JLabel();
        Player3Money = new javax.swing.JLabel();
        Player4Money = new javax.swing.JLabel();
        Player4Name = new javax.swing.JLabel();
        Player5Name = new javax.swing.JLabel();
        Player5Money = new javax.swing.JLabel();
        Player6Money = new javax.swing.JLabel();
        Player6Name = new javax.swing.JLabel();
        Player7Money = new javax.swing.JLabel();
        Player7Name = new javax.swing.JLabel();
        Player8Money = new javax.swing.JLabel();
        Player8Name = new javax.swing.JLabel();
        NButton = new javax.swing.JButton();
        YButton = new javax.swing.JButton();
        MessageTextField = new javax.swing.JTextField();

        setDoubleBuffered(false);
        setPreferredSize(new java.awt.Dimension(700, 700));

        BoardPanel.setMinimumSize(new java.awt.Dimension(580, 580));

        rollDiceButton.setText("Roll Dice!");
        rollDiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollDiceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BoardPanelLayout = new javax.swing.GroupLayout(BoardPanel);
        BoardPanel.setLayout(BoardPanelLayout);
        BoardPanelLayout.setHorizontalGroup(
            BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BoardPanelLayout.createSequentialGroup()
                .addGroup(BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BoardPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(rollDiceButton))
                    .addGroup(BoardPanelLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(DiceResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        BoardPanelLayout.setVerticalGroup(
            BoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoardPanelLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(rollDiceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiceResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );

        Player1Name.setText("Player1 ");

        Player1Money.setText("Money: 1500$");

        Player2Money.setText("Money: 1500$");

        Player2Name.setText("Player2");

        Player3Name.setText("Player3");

        Player3Money.setText("Money: 1500$");

        Player4Money.setText("Money: 1500$");

        Player4Name.setText("Player4");

        Player5Name.setText("Player3");

        Player5Money.setText("Money: 1500$");

        Player6Money.setText("Money: 1500$");

        Player6Name.setText("Player6");

        Player7Money.setText("Money: 1500$");

        Player7Name.setText("Player7");

        Player8Money.setText("Money: 1500$");

        Player8Name.setText("Player8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player1Money)
                    .addComponent(Player1Name)
                    .addComponent(Player5Money)
                    .addComponent(Player5Name))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player2Money)
                    .addComponent(Player2Name)
                    .addComponent(Player6Money)
                    .addComponent(Player6Name))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player3Money)
                    .addComponent(Player3Name)
                    .addComponent(Player7Money)
                    .addComponent(Player7Name))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player4Money)
                    .addComponent(Player4Name)
                    .addComponent(Player8Money)
                    .addComponent(Player8Name)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Player2Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player2Money)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player6Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player6Money))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Player4Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player4Money))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Player3Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player3Money))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Player1Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player1Money)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Player5Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player5Money))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Player7Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player7Money))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Player8Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player8Money)))))
                .addContainerGap())
        );

        NButton.setText("N");
        NButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NButtonActionPerformed(evt);
            }
        });

        YButton.setText("Y");
        YButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YButtonActionPerformed(evt);
            }
        });

        MessageTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MessageTextField.setText("Welcome to our game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(YButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NButton))
                            .addComponent(MessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(BoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YButton)
                            .addComponent(NButton))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    Player player = new Player();

    public void playersInfo() {
        switch (playersNumber) {
            case 2:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setVisible(false);
                Player3Money.setVisible(false);
                Player4Name.setVisible(false);
                Player4Money.setVisible(false);
                Player5Name.setVisible(false);
                Player5Money.setVisible(false);
                Player6Name.setVisible(false);
                Player6Money.setVisible(false);
                Player7Name.setVisible(false);
                Player7Money.setVisible(false);
                Player8Name.setVisible(false);
                Player8Money.setVisible(false);
                break;
            case 3:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setText(player3TextField.getText());
                Player3Name.setVisible(true);
                Player3Money.setVisible(true);
                Player4Name.setVisible(false);
                Player4Money.setVisible(false);
                Player5Name.setVisible(false);
                Player5Money.setVisible(false);
                Player6Name.setVisible(false);
                Player6Money.setVisible(false);
                Player7Name.setVisible(false);
                Player7Money.setVisible(false);
                Player8Name.setVisible(false);
                Player8Money.setVisible(false);
                break;
            case 4:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setText(player3TextField.getText());
                Player4Name.setText(player4TextField.getText());
                Player3Name.setVisible(true);
                Player3Money.setVisible(true);
                Player4Name.setVisible(true);
                Player4Money.setVisible(true);
                Player5Name.setVisible(false);
                Player5Money.setVisible(false);
                Player6Name.setVisible(false);
                Player6Money.setVisible(false);
                Player7Name.setVisible(false);
                Player7Money.setVisible(false);
                Player8Name.setVisible(false);
                Player8Money.setVisible(false);
                break;
            case 5:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setText(player3TextField.getText());
                Player4Name.setText(player4TextField.getText());
                Player5Name.setText(player5TextField.getText());
                Player3Name.setVisible(true);
                Player3Money.setVisible(true);
                Player4Name.setVisible(true);
                Player4Money.setVisible(true);
                Player5Name.setVisible(true);
                Player5Money.setVisible(true);
                Player6Name.setVisible(false);
                Player6Money.setVisible(false);
                Player7Name.setVisible(false);
                Player7Money.setVisible(false);
                Player8Name.setVisible(false);
                Player8Money.setVisible(false);
                break;
            case 6:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setText(player3TextField.getText());
                Player4Name.setText(player4TextField.getText());
                Player5Name.setText(player5TextField.getText());
                Player6Name.setText(player6TextField.getText());
                Player3Name.setVisible(true);
                Player3Money.setVisible(true);
                Player4Name.setVisible(true);
                Player4Money.setVisible(true);
                Player5Name.setVisible(true);
                Player5Money.setVisible(true);
                Player6Name.setVisible(true);
                Player6Money.setVisible(true);
                Player7Name.setVisible(false);
                Player7Money.setVisible(false);
                Player8Name.setVisible(false);
                Player8Money.setVisible(false);
                break;
            case 7:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setText(player3TextField.getText());
                Player4Name.setText(player4TextField.getText());
                Player5Name.setText(player5TextField.getText());
                Player6Name.setText(player6TextField.getText());
                Player7Name.setText(player7TextField.getText());
                Player3Name.setVisible(true);
                Player3Money.setVisible(true);
                Player4Name.setVisible(true);
                Player4Money.setVisible(true);
                Player5Name.setVisible(true);
                Player5Money.setVisible(true);
                Player6Name.setVisible(true);
                Player6Money.setVisible(true);
                Player7Name.setVisible(true);
                Player7Money.setVisible(true);
                Player8Name.setVisible(false);
                Player8Money.setVisible(false);
                break;
            case 8:
                Player1Name.setText(player1TextField.getText());
                Player2Name.setText(player2TextField.getText());
                Player3Name.setText(player3TextField.getText());
                Player4Name.setText(player4TextField.getText());
                Player5Name.setText(player5TextField.getText());
                Player6Name.setText(player6TextField.getText());
                Player7Name.setText(player7TextField.getText());
                Player8Name.setText(player8TextField.getText());
                Player3Name.setVisible(true);
                Player3Money.setVisible(true);
                Player4Name.setVisible(true);
                Player4Money.setVisible(true);
                Player5Name.setVisible(true);
                Player5Money.setVisible(true);
                Player6Name.setVisible(true);
                Player6Money.setVisible(true);
                Player7Name.setVisible(true);
                Player7Money.setVisible(true);
                Player8Name.setVisible(true);
                Player8Money.setVisible(true);
                break;
        }
    }

    public void hideButton() {
        YButton.setVisible(false);
        NButton.setVisible(false);
    }

    public void showButton() {
        YButton.setVisible(true);
        NButton.setVisible(true);
    }

    private void rollDiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollDiceButtonActionPerformed
        // TODO add your handling code here:
        int diceNumber = Dice.getDice();

        player.place += diceNumber;
        DiceResultLabel.setText(diceNumber + "");

        int firstPlace = Board.players.get(Board.turn).place;
        int secondPlace = (firstPlace + diceNumber) % Board.placesArr.size();
        Board.players.get(Board.turn).x = Board.placesArr.get(secondPlace).coords.x;
        Board.players.get(Board.turn).y = Board.placesArr.get(secondPlace).coords.y;
        Board.players.get(Board.turn).place = secondPlace;

        Board.turn = (Board.turn + 1) % Board.players.size();

        this.repaint();
        MysetText(player.place);

    }//GEN-LAST:event_rollDiceButtonActionPerformed


    private void YButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YButtonActionPerformed
        // TODO add your handling code here:yes
        if (country.getPrice() <= player.money) {

            MessageTextField.setText("coungratulation you get that country!!");
            player.money -= country.getPrice();
            Player1Money.setText("Money: " + player.money);
            country.sold();
            country.setOwner(player);
            hideButton();
        } else {
            MessageTextField.setText("Sorry u dont have money");
            hideButton();
        }
    }//GEN-LAST:event_YButtonActionPerformed
    Country country;

    private void MysetText(int i) {

        country = Board.getPlace(i);
        if (i == 10 || i == 30)// jail
        {

        } else if (i == 4 || i == 38) // taxes
        {

        } else if (i == 20) // bus
        {

        } else if (i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36) {

        } else if (i == 0) {
            MessageTextField.setText("Start the new round and get 200$");
        } else {
            if (country.isOwner(player)) {
                MessageTextField.setText("Welcome to your country " + country.getName());
                hideButton();
            } else if (country.checkAvailable()) {
                MessageTextField.setText("You can buy our country for just " + country.getPrice() + "$");
                showButton();
            } else {
                MessageTextField.setText("Please pay " + country.getTotalFees() + "$ " + "for visting our country");
                player.money -= country.getTotalFees();
            }
        }
    }
    private void NButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NButtonActionPerformed
        MessageTextField.setText("preese Roll Dice button to got to next turn");
        hideButton();
    }//GEN-LAST:event_NButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BoardPanel;
    private javax.swing.JLabel DiceResultLabel;
    private javax.swing.JTextField MessageTextField;
    private javax.swing.JButton NButton;
    private javax.swing.JLabel Player1Money;
    private javax.swing.JLabel Player1Name;
    private javax.swing.JLabel Player2Money;
    private javax.swing.JLabel Player2Name;
    private javax.swing.JLabel Player3Money;
    private javax.swing.JLabel Player3Name;
    private javax.swing.JLabel Player4Money;
    private javax.swing.JLabel Player4Name;
    private javax.swing.JLabel Player5Money;
    private javax.swing.JLabel Player5Name;
    private javax.swing.JLabel Player6Money;
    private javax.swing.JLabel Player6Name;
    private javax.swing.JLabel Player7Money;
    private javax.swing.JLabel Player7Name;
    private javax.swing.JLabel Player8Money;
    private javax.swing.JLabel Player8Name;
    private javax.swing.JButton YButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rollDiceButton;
    // End of variables declaration//GEN-END:variables
}
