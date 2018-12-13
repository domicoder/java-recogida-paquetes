/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recogidapaquete.interfaces;

import com.recogidapaquete.BD.ConexionMySQL;
import com.recogidapaquete.base.*;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author El cibernetico
 */
public class AddCliente extends javax.swing.JFrame {


    private int xMove;
    private int yMove;
    ConexionMySQL conexionMySQL = ConexionMySQL.getInstance();
    private String email = null;
    
    public AddCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Agregando grupo de RadioButons
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnM);
        group.add(rbtnF);
        
        //Icoco Ventana
        this.setIconImage(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/LOGO.png")).getImage());

    }

    public void salir(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del Login?","Salir",dialogButton);
        
        if(result==0){
            System.exit(0);
        }
    }
    
    public String validarCorreo(){
        String signoValidar = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(signoValidar);
        Matcher valido = pattern.matcher(tfCorreo.getText());
        
        if(tfCorreo.getText()!= signoValidar){
            
            if (!valido.find()){
                JOptionPane.showMessageDialog(null, "El correo no es valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
            }else{
                email = tfCorreo.getText();
            }
        }
       return email;
    }
    
    public int parametros(){

        int validate = 0;
        
        if(tfnombre.getText().isEmpty()){
            validate = 1;
        }else if(tfApellido.getText().isEmpty()){
            validate = 1;
        }else if(tfDireccion.getText().isEmpty()){
            validate = 1;
        }else if (tfEmail.getText().isEmpty()){
            validate = 1;
        }else if(rbtnM.isSelected()==false && rbtnF.isSelected()==false){
            validate = 1;
        }else if(tfUsuario.getText().isEmpty()){
            validate = 1;
        }else if(jpassContrasena.getText().isEmpty()){
            validate = 1;
        }
        return validate;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        lblBarra = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jpRegresar = new javax.swing.JPanel();
        lblRegresar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblDireccion = new javax.swing.JLabel();
        lblFormularioCrear = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        tfnombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        tfEmail = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        rbtnF = new javax.swing.JRadioButton();
        rbtnM = new javax.swing.JRadioButton();
        lblApellido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpassContrasena = new javax.swing.JPasswordField();
        jpAddCliente = new javax.swing.JPanel();
        lbAddCliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/repaq.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 520));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 118, 255));
        jPanel1.setForeground(new java.awt.Color(0, 118, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 30));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/minimize_normal.png"))); // NOI18N
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseMoved(evt);
            }
        });
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });
        jPanel1.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 30, 30));

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
        jPanel1.add(lblBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 740, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 560, 30));

        jPanel3.setBackground(new java.awt.Color(109, 157, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegresar.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresar.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpRegresarMouseMoved(evt);
            }
        });
        jpRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpRegresarMouseExited(evt);
            }
        });
        jpRegresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresar.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresar.setText("Regresar");
        lblRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarMouseMoved(evt);
            }
        });
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarMouseExited(evt);
            }
        });
        jpRegresar.add(lblRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 40));

        jPanel3.add(jpRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 200, -1));

        jPanel4.setBackground(new java.awt.Color(109, 151, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 136, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDireccion.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección:");
        jPanel4.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 150, 30));

        lblFormularioCrear.setFont(new java.awt.Font("Open Sans Extrabold", 1, 24)); // NOI18N
        lblFormularioCrear.setForeground(new java.awt.Color(255, 255, 255));
        lblFormularioCrear.setText("Formulario para crear Clientes");
        jPanel4.add(lblFormularioCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 380, 30));

        lblnombre.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText("Nombre:");
        jPanel4.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 30));
        jPanel4.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 230, -1));
        jPanel4.add(tfnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 230, -1));
        jPanel4.add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 230, -1));

        tfEmail.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(255, 255, 255));
        tfEmail.setText("Correo Electrónico:");
        jPanel4.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 170, 30));
        jPanel4.add(tfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 230, -1));

        lblUsuario.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario:");
        jPanel4.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 150, 30));
        jPanel4.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 230, -1));

        lblContrasena.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lblContrasena.setText("Contraseña:");
        jPanel4.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 150, 30));

        jPanel5.setBackground(new java.awt.Color(109, 151, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 130, 255)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSexo.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSexo.setText("Sexo:");
        jPanel5.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 30));

        rbtnF.setText("Femenino");
        jPanel5.add(rbtnF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        rbtnM.setText("Masculino");
        jPanel5.add(rbtnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 230, 70));

        lblApellido.setFont(new java.awt.Font("Open Sans Extrabold", 1, 16)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");
        jPanel4.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/usuario.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 70));
        jPanel4.add(jpassContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 230, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 780, 390));

        jpAddCliente.setBackground(new java.awt.Color(0, 80, 255));
        jpAddCliente.setForeground(new java.awt.Color(0, 80, 255));
        jpAddCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpAddCliente.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpAddClienteMouseMoved(evt);
            }
        });
        jpAddCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpAddClienteMouseExited(evt);
            }
        });
        jpAddCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAddCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbAddCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/save.png"))); // NOI18N
        lbAddCliente.setText("Agregar");
        lbAddCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAddCliente.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbAddClienteMouseMoved(evt);
            }
        });
        lbAddCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAddClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAddClienteMouseExited(evt);
            }
        });
        jpAddCliente.add(lbAddCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 40));

        jPanel3.add(jpAddCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 200, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 820, 490));

        jPanel2.setBackground(new java.awt.Color(0, 110, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 104, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/package.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/repaq1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        jLabel4.setFont(new java.awt.Font("Open Sans Extrabold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RePAQ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    
    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        salir();
    }//GEN-LAST:event_lblCloseMouseClicked
    
    private void lblRegresarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseMoved
        jpRegresar.setBackground(new Color(0,0,255));
        jpRegresar.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarMouseMoved
    
    private void lblRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseExited
        jpRegresar.setBackground(new Color(0,80,255));
        jpRegresar.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarMouseExited
    
    private void jpRegresarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarMouseMoved
        jpRegresar.setBackground(new Color(0,0,255));
        jpRegresar.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpRegresarMouseMoved
    
    private void jpRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarMouseExited
        jpRegresar.setBackground(new Color(0,80,255));
        jpRegresar.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpRegresarMouseExited
    
    private void lbAddClienteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddClienteMouseMoved
        jpAddCliente.setBackground(new Color(0,0,255));
        jpAddCliente.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lbAddClienteMouseMoved
    
    private void lbAddClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddClienteMouseExited
        jpAddCliente.setBackground(new Color(0,80,255));
        jpAddCliente.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lbAddClienteMouseExited
    
    private void jpAddClienteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddClienteMouseMoved
        jpAddCliente.setBackground(new Color(0,0,255));
        jpAddCliente.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpAddClienteMouseMoved
    
    private void jpAddClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddClienteMouseExited
        jpAddCliente.setBackground(new Color(0,80,255));
        jpAddCliente.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpAddClienteMouseExited
    
    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        this.setVisible(false);
        AdministradorGrafica administrador = new AdministradorGrafica();
        administrador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void lblBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMousePressed
        xMove = evt.getX();
        yMove = evt.getY();
    }//GEN-LAST:event_lblBarraMousePressed

    private void lblBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMove, y - yMove);
    }//GEN-LAST:event_lblBarraMouseDragged

    private void lbAddClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddClienteMouseClicked
        MediadorConcreto mediador = new MediadorConcreto();
        Cliente cliente = new Cliente(mediador);
        
        cliente.setNombre(tfnombre.getText());
        cliente.setApellido(tfApellido.getText());
        cliente.setDireccion(tfDireccion.getText());
        cliente.setUsuario(tfUsuario.getText());
        cliente.setContrasena(jpassContrasena.getText());
        
        if (rbtnM.isSelected()) {
            cliente.setSexo(rbtnM.getText());
        }else if(rbtnF.isSelected()){
            cliente.setSexo(rbtnF.getText());
        }
        
        if(validarCorreo() != null){
            cliente.setCorreo(validarCorreo());
            conexionMySQL.introducirCliente(cliente);
        }
        
        
        if(parametros() == 1){
            JOptionPane.showMessageDialog(null, "No puede dejar ningún campo vacio.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lbAddClienteMouseClicked
    
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
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCliente().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jpAddCliente;
    private javax.swing.JPanel jpRegresar;
    private javax.swing.JPasswordField jpassContrasena;
    private javax.swing.JLabel lbAddCliente;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFormularioCrear;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JRadioButton rbtnF;
    private javax.swing.JRadioButton rbtnM;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JLabel tfEmail;
    private javax.swing.JTextField tfUsuario;
    private javax.swing.JTextField tfnombre;
    // End of variables declaration//GEN-END:variables
}
