/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recogidapaquete.interfaces;

import com.recogidapaquete.BD.ConexionMySQL;
import com.recogidapaquete.base.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author El cibernetico
 */
public class Login extends javax.swing.JFrame {

    private int xMove;
    private int yMove;
    private ConexionMySQL conexionMySQL;
    private MediadorConcreto mediador;

    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        mediador = new MediadorConcreto();
        
        //Icoco Ventana
        this.setIconImage(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/LOGO.png")).getImage());
        conexionMySQL = ConexionMySQL.getInstance();
    }
    
    public void salir(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del Login?","Salir",dialogButton);
        
        if(result==0){
            System.exit(0);
        }
    }
    
    public int ocultarLogin(){
        int salir = mediador.ocultar;
        return salir;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        fpPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxTipoUsuario = new javax.swing.JComboBox<>();
        jpIniciar = new javax.swing.JPanel();
        lblIniciar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        lblBarra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(900, 630));
        setMaximumSize(new java.awt.Dimension(820, 520));
        setMinimumSize(new java.awt.Dimension(820, 520));
        setUndecorated(true);
        setSize(new java.awt.Dimension(820, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/logoLogin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 420, 490));

        jPanel6.setBackground(new java.awt.Color(16, 16, 16));
        jPanel6.setMaximumSize(new java.awt.Dimension(200, 630));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 630));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 630));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 110, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 110, 255));
        jLabel4.setText("Login_");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 170, 60));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de Usuario:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, 20));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/userlogin.png"))); // NOI18N
        jLabel6.setText("Usuario:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 140, 40));

        tfUser.setBackground(new java.awt.Color(16, 16, 16));
        tfUser.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        tfUser.setForeground(new java.awt.Color(0, 110, 255));
        tfUser.setText("Ingrese usuario");
        tfUser.setBorder(null);
        tfUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUserMouseClicked(evt);
            }
        });
        jPanel6.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 270, 40));

        fpPassword.setBackground(new java.awt.Color(16, 16, 16));
        fpPassword.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        fpPassword.setForeground(new java.awt.Color(0, 110, 255));
        fpPassword.setText("ddddddd     ");
        fpPassword.setBorder(null);
        fpPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fpPasswordMouseClicked(evt);
            }
        });
        jPanel6.add(fpPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 270, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 110, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 110, 255));
        jPanel6.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 290, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 110, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 110, 255));
        jPanel6.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 130, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 110, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 110, 255));
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 290, 10));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/password.png"))); // NOI18N
        jLabel8.setText("Contraseña:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 150, 40));

        jPanel1.setBackground(new java.awt.Color(16, 16, 16));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 40));

        cbxTipoUsuario.setBackground(new java.awt.Color(0, 110, 255));
        cbxTipoUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbxTipoUsuario.setForeground(new java.awt.Color(0, 110, 255));
        cbxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Receptor", "Cliente" }));
        cbxTipoUsuario.setBorder(new javax.swing.border.MatteBorder(null));
        cbxTipoUsuario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cbxTipoUsuarioMouseMoved(evt);
            }
        });
        jPanel6.add(cbxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 150, -1));

        jpIniciar.setBackground(new java.awt.Color(16, 16, 16));
        jpIniciar.setForeground(new java.awt.Color(16, 16, 16));
        jpIniciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciar.setBackground(new java.awt.Color(255, 255, 255));
        lblIniciar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIniciar.setForeground(new java.awt.Color(255, 255, 255));
        lblIniciar.setText("Iniciar Sesión");
        lblIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIniciar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblIniciarMouseMoved(evt);
            }
        });
        lblIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIniciarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIniciarMouseExited(evt);
            }
        });
        jpIniciar.add(lblIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel6.add(jpIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 130, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/pass2.png"))); // NOI18N
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 70, 70));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 400, 490));

        jPanel2.setBackground(new java.awt.Color(41, 111, 173));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/iconClose_normal.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCloseMouseMoved(evt);
            }
        });
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });
        jPanel2.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 30));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/minimize_normal.png"))); // NOI18N
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseMoved(evt);
            }
        });
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });
        jPanel2.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 30, 30));

        lblBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBarraMouseDragged(evt);
            }
        });
        lblBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBarraMousePressed(evt);
            }
        });
        jPanel2.add(lblBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fpPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fpPasswordMouseClicked
         fpPassword.setText("");
    }//GEN-LAST:event_fpPasswordMouseClicked

    private void tfUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseClicked
       tfUser.setText("");  
    }//GEN-LAST:event_tfUserMouseClicked
    
    private void cbxTipoUsuarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoUsuarioMouseMoved
        cbxTipoUsuario.setBackground(new Color(78,41,230));
    }//GEN-LAST:event_cbxTipoUsuarioMouseMoved

    private void lblIniciarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIniciarMouseMoved
        jpIniciar.setBackground(new Color(0,110,255));
    }//GEN-LAST:event_lblIniciarMouseMoved
    
    private void lblIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIniciarMouseExited
        jpIniciar.setBackground(new Color(16,16,16));
    }//GEN-LAST:event_lblIniciarMouseExited
    
    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
       jPanel1.setBackground(new Color(78,41,230));
    }//GEN-LAST:event_jPanel1MouseMoved
    
    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
       jPanel1.setBackground(new Color(16,16,16));
    }//GEN-LAST:event_jPanel1MouseExited
    
    private void lblIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIniciarMouseClicked
        Administrador administrador = new Administrador(mediador);
        Receptor receptor = new Receptor(mediador);
        Cliente cliente = new Cliente(mediador);
        
        int usuarios = cbxTipoUsuario.getSelectedIndex();
        
        if(usuarios == 0){
            mediador.setAdministrador(administrador);
            administrador.sendTipo(tfUser.getText(), fpPassword.getText());
            
            if (ocultarLogin() == 1) {
                this.setVisible(false);
                this.dispose();
            }
        }else if(usuarios == 1){
            mediador.setReceptor(receptor);
            receptor.sendTipo(tfUser.getText(), fpPassword.getText());
            
            if (ocultarLogin() == 1) {
                this.setVisible(false);
                this.dispose();
            }
            
        }else if(usuarios == 2){
            mediador.setCliente(cliente);
            cliente.sendTipo(tfUser.getText(), fpPassword.getText());
            
            if (ocultarLogin() == 1) {
                this.setVisible(false);
                this.dispose();
            }
        }

    }//GEN-LAST:event_lblIniciarMouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        salir();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseMoved
        lblClose.setIcon(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/iconClose_Animacion.png")));
    }//GEN-LAST:event_lblCloseMouseMoved

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        lblClose.setIcon(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/iconClose_normal.png")));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblMinimizeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseMoved
        lblMinimize.setIcon(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/minimizea_animacion.png")));
    }//GEN-LAST:event_lblMinimizeMouseMoved

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        lblMinimize.setIcon(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/minimize_normal.png")));
    }//GEN-LAST:event_lblMinimizeMouseExited
    
    private void lblBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMove, y - yMove);
    }//GEN-LAST:event_lblBarraMouseDragged

    private void lblBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMousePressed
        xMove = evt.getX();
        yMove = evt.getY();
    }//GEN-LAST:event_lblBarraMousePressed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipoUsuario;
    private javax.swing.JPasswordField fpPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jpIniciar;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIniciar;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
