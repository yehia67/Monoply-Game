/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Color;

/**
 *
 * @author eslam
 */
public class playPanel extends javax.swing.JPanel {

    /**
     * Creates new form playPanel
     */
    public playPanel() {
        initComponents();
       /*player3TextField.setVisible(false);
        player4TextField.setVisible(false);
        label4.setVisible(false);
        label3.setVisible(false);*/
      
        System.out.println("Intialized");
       
       

    }
public String getP1Name()
{
    return player1TextField.getText();
}
public String getP2Name()
{
    return player2TextField.getText();
}
public String getP3Name()
{
    return player3TextField.getText();
}
public String getP4Name()
{
    return player4TextField.getText();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label5 = new java.awt.Label();
        jSpinner1 = new javax.swing.JSpinner();
        player1TextField = new java.awt.TextField();
        player2TextField = new java.awt.TextField();
        player3TextField = new java.awt.TextField();
        player4TextField = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();

        label5.setText("label5");

        setToolTipText("");
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(450, 450));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setName(""); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(400, 250));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(4, 2, 4, 1));
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        player1TextField.setText("Player 1");
        player1TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player1TextFieldMouseClicked(evt);
            }
        });
        player1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1TextFieldActionPerformed(evt);
            }
        });

        player2TextField.setText("Player 2 ");
        player2TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player2TextFieldMouseClicked(evt);
            }
        });

        player3TextField.setText("Player 3");
        player3TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player3TextFieldMouseClicked(evt);
            }
        });
        player3TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player3TextFieldActionPerformed(evt);
            }
        });

        player4TextField.setText("Player 4");
        player4TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player4TextFieldMouseClicked(evt);
            }
        });
        player4TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player4TextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Choose No. of players:");

        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setText("Player 1:");

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setText("Player 2:");

        label4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label4.setText("Player 4:");

        label3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label3.setText("Player 3:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(player1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(player2TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                            .addComponent(label1)
                            .addComponent(label2))
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(player3TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(player4TextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(label3))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1)
                    .addComponent(label3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(player1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(label4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jSpinner1.getAccessibleContext().setAccessibleName("spinner");
    }// </editor-fold>//GEN-END:initComponents

    private void player1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player1TextFieldActionPerformed

    private void player3TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player3TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player3TextFieldActionPerformed

    private void player4TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player4TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player4TextFieldActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
int value = (Integer) jSpinner1.getValue(); 
switch (value) {
            case 2:
                player3TextField.setVisible(false);
                player4TextField.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
         
                break;
            case 3:
                player3TextField.setVisible(true);
                player4TextField.setVisible(false);
                label3.setVisible(true);
                label4.setVisible(false);
                System.out.println("Changed");
                break;
            case 4:
                player3TextField.setVisible(true);
                player4TextField.setVisible(true);
                label3.setVisible(true);
                label4.setVisible(true);
 
                break;
        }
       
    }//GEN-LAST:event_jSpinner1StateChanged
    
    public int getSpinnerValue()
    {
        return (Integer) jSpinner1.getValue();
    }
    private void player1TextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player1TextFieldMouseClicked
player1TextField.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_player1TextFieldMouseClicked

    private void player3TextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player3TextFieldMouseClicked
       player3TextField.setText("");        // TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_player3TextFieldMouseClicked

    private void player2TextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player2TextFieldMouseClicked
player2TextField.setText("");        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_player2TextFieldMouseClicked

    private void player4TextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player4TextFieldMouseClicked
player4TextField.setText("");        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_player4TextFieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private java.awt.Label label5;
    private java.awt.TextField player1TextField;
    private java.awt.TextField player2TextField;
    private java.awt.TextField player3TextField;
    private java.awt.TextField player4TextField;
    // End of variables declaration//GEN-END:variables
}