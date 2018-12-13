/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recogidapaquete.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author El cibernetico
 */
public class Splash extends javax.swing.JFrame {
    
    private Login login = new Login();
    private Timer timer;
    private ActionListener ac;
    
    public Splash() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ac = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            progressBar();
        }
        };
        timer = new Timer(50,ac);
        timer.start();
        
        //Icoco Ventana
        this.setIconImage(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/LOGO.png")).getImage());

    }

    public void progressBar(){
      int n = progressBar.getValue();
      
      if(n<100){
        n++;
        progressBar.setValue(n);
      } else{
        timer.stop();
        login.setVisible(true);
        this.setVisible(false);
        this.dispose();
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/repaq.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 520));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(109, 157, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 680, 40));

        jLabel2.setFont(new java.awt.Font("DialogInput", 3, 55)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido a");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 410, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 3, 55)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RePAQ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 180, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/REPAQ_Progress.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 230, 230));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
