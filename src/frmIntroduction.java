import javax.swing.JFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaihunbek Mohammadullah
 * Date : 8/23/2021
 * This is the Introduction frame
 */
public class frmIntroduction extends javax.swing.JFrame { 
    String strNameOfPlayer;  // player's username 

    /**
     * Creates new form frmIntroduction
     */
    public frmIntroduction() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnUserGuide = new javax.swing.JButton();
        lblExplain = new javax.swing.JLabel();
        lblImage1 = new javax.swing.JLabel();
        lblImage2 = new javax.swing.JLabel();
        lblExplain2 = new javax.swing.JLabel();
        lblExplain3 = new javax.swing.JLabel();
        txtNameOfPlayer = new javax.swing.JTextField();
        lblExplain4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 0, 0));
        lblWelcome.setText("Welcome to Wizard101");

        btnPlay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnUserGuide.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUserGuide.setText("Help");
        btnUserGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserGuideActionPerformed(evt);
            }
        });

        lblExplain.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblExplain.setForeground(new java.awt.Color(0, 0, 255));
        lblExplain.setText("Young Wizard, we need your skills! A monster has broken into the city!");

        lblImage1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Beyond\\Documents\\NetBeansProjects\\MohammadullahJaihunbekFinalProject\\w101loadingscreen2.jpg")); // NOI18N

        lblImage2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Beyond\\Documents\\NetBeansProjects\\MohammadullahJaihunbekFinalProject\\w101loadingscreen2.jpg")); // NOI18N

        lblExplain2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblExplain2.setForeground(new java.awt.Color(255, 0, 0));
        lblExplain2.setText("Quick Now!");

        lblExplain3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblExplain3.setForeground(new java.awt.Color(255, 0, 0));
        lblExplain3.setText("Enter your name:");

        txtNameOfPlayer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblExplain4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblExplain4.setForeground(new java.awt.Color(255, 0, 0));
        lblExplain4.setText("Then Press Play!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblExplain4)
                                        .addComponent(txtNameOfPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblExplain3)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUserGuide)
                                        .addComponent(btnPlay))
                                    .addGap(2, 2, 2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblExplain2)))
                        .addGap(26, 26, 26)
                        .addComponent(lblImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(lblWelcome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblExplain)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblExplain)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblExplain2)
                        .addGap(18, 18, 18)
                        .addComponent(lblExplain3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNameOfPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblExplain4)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlay)
                        .addGap(18, 18, 18)
                        .addComponent(btnUserGuide)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblImage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        
        // Close current frame and move onto Battle frame 
        strNameOfPlayer = txtNameOfPlayer.getText(); // reading username input 
        frmBattle myGame = new frmBattle(strNameOfPlayer); // creating next frame
        myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        myGame.setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnUserGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserGuideActionPerformed
        // TODO add your handling code here:
        frmUserGuide myGame = new frmUserGuide(); 
        myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        myGame.setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_btnUserGuideActionPerformed

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
            java.util.logging.Logger.getLogger(frmIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIntroduction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnUserGuide;
    private javax.swing.JLabel lblExplain;
    private javax.swing.JLabel lblExplain2;
    private javax.swing.JLabel lblExplain3;
    private javax.swing.JLabel lblExplain4;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtNameOfPlayer;
    // End of variables declaration//GEN-END:variables
}
