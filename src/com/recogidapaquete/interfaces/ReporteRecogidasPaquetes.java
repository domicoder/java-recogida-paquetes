
package com.recogidapaquete.interfaces;

import com.recogidapaquete.BD.ConexionMySQL;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author El cibernetico
 */

public class ReporteRecogidasPaquetes extends javax.swing.JFrame {

    private int xMove;
    private int yMove;
    ConexionMySQL conexionMySQL;
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    public ReporteRecogidasPaquetes() {
        initComponents();
        this.setLocationRelativeTo(null);
        conexionMySQL = ConexionMySQL.getInstance();
        
        //Icoco Ventana
        this.setIconImage(new ImageIcon(getClass().getResource("/com/recogidapaquete/images/LOGO.png")).getImage());
        
        // Oculatando paneles al iniciarla aplicacion
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
        jpPorctjMuj.setVisible(false);
        jpCantDia.setVisible(true);
    }

    public void salir(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del Login?","Salir",dialogButton);
        
        if(result==0){
            System.exit(0);
        }
    }
    
    public void validarNumerosEnCamposYear(KeyEvent evt, JTextField jtextfield){
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        if (jtextfield.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }        
    }

    public void exportReporteDia(String nombreReporte, String dia, String cantidad){
        try{
            File archivo = new File(ruta+"\\REPORTES");
            Calendar fecha = Calendar.getInstance();
            
            // DIA
            String DAY = Integer.toString(fecha.get(Calendar.DATE));
            
            // MES
            String MES = Integer.toString(fecha.get(Calendar.MONTH)+1);
            
            // AÑO
            String YEAR = Integer.toString(fecha.get(Calendar.YEAR));
            
            PrintWriter pw = new PrintWriter(new File(ruta+"\\REPORTES\\"+nombreReporte+"-"+(YEAR)+(MES)+(DAY)+".csv"));
            StringBuilder sb = new StringBuilder();
            
            sb.append("Dia");
            sb.append(",");
            sb.append("Cantidad");
            sb.append("\n");
            
            sb.append(dia);
            sb.append(",");
            sb.append(cantidad);
            sb.append("\n");
            
            if (archivo.isDirectory()) {
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }else{
                archivo.mkdir();
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }
            
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error " + io.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Tu archivo ha sido exportado con éxito.", "INFORMACION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void exportReporteSemana(String nombreReporte, String semana, String cantidad){
        try{
            File archivo = new File(ruta+"\\REPORTES");
            Calendar fecha = Calendar.getInstance();
            
            // DIA
            String DAY = Integer.toString(fecha.get(Calendar.DATE));
            
            // MES
            String MES = Integer.toString(fecha.get(Calendar.MONTH)+1);
            
            // AÑO
            String YEAR = Integer.toString(fecha.get(Calendar.YEAR));
            
            PrintWriter pw = new PrintWriter(new File(ruta+"\\REPORTES\\"+nombreReporte+"-"+(YEAR)+(MES)+(DAY)+".csv"));
            StringBuilder sb = new StringBuilder();
            
            sb.append("Semana");
            sb.append(",");
            sb.append("Cantidad");
            sb.append("\n");
            
            sb.append(semana);
            sb.append(",");
            sb.append(cantidad);
            sb.append("\n");
            
            if (archivo.isDirectory()) {
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }else{
                archivo.mkdir();
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }
            
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error " + io.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Tu archivo ha sido exportado con éxito.", "INFORMACION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void exportReporteMes(String nombreReporte, String mes, String cantidad){
        try{
            File archivo = new File(ruta+"\\REPORTES");
            Calendar fecha = Calendar.getInstance();
            
            // DIA
            String DAY = Integer.toString(fecha.get(Calendar.DATE));
            
            // MES
            String MES = Integer.toString(fecha.get(Calendar.MONTH)+1);
            
            // AÑO
            String YEAR = Integer.toString(fecha.get(Calendar.YEAR));
            
            PrintWriter pw = new PrintWriter(new File(ruta+"\\REPORTES\\"+nombreReporte+"-"+(YEAR)+(MES)+(DAY)+".csv"));
            StringBuilder sb = new StringBuilder();
            
            sb.append("Mes");
            sb.append(",");
            sb.append("Cantidad");
            sb.append("\n");
            
            sb.append(mes);
            sb.append(",");
            sb.append(cantidad);
            sb.append("\n");
            
            if (archivo.isDirectory()) {
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }else{
                archivo.mkdir();
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }
            
        }catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error " + io.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Tu archivo ha sido exportado con éxito.", "INFORMACION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void exportReporPorcentajePaqEntregSinEntreg(String nombreReporte, String entregados, String sinEntregar){
        try{
            File archivo = new File(ruta+"\\REPORTES");
            Calendar fecha = Calendar.getInstance();
            
            // DIA
            String DAY = Integer.toString(fecha.get(Calendar.DATE));
            
            // MES
            String MES = Integer.toString(fecha.get(Calendar.MONTH)+1);
            
            // AÑO
            String YEAR = Integer.toString(fecha.get(Calendar.YEAR));
            
            PrintWriter pw = new PrintWriter(new File(ruta+"\\REPORTES\\"+nombreReporte+"-"+(YEAR)+(MES)+(DAY)+".csv"));
            StringBuilder sb = new StringBuilder();
            
            sb.append("Entregados");
            sb.append(",");
            sb.append("Sin Entregar");
            sb.append("\n");
            
            sb.append(entregados);
            sb.append(",");
            sb.append(sinEntregar);
            sb.append("\n");
            
            if (archivo.isDirectory()) {
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }else{
                archivo.mkdir();
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }
            
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error " + io.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Tu archivo ha sido exportado con éxito.", "INFORMACION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void exportDiaSemanaMayorRecogida(String nombreReporte, String dia, String cantidad){
        try{
            File archivo = new File(ruta+"\\REPORTES");
            Calendar fecha = Calendar.getInstance();
            
            // DIA
            String DAY = Integer.toString(fecha.get(Calendar.DATE));
            
            // MES
            String MES = Integer.toString(fecha.get(Calendar.MONTH)+1);
            
            // AÑO
            String YEAR = Integer.toString(fecha.get(Calendar.YEAR));
            
            PrintWriter pw = new PrintWriter(new File(ruta+"\\REPORTES\\"+nombreReporte+"-"+(YEAR)+(MES)+(DAY)+".csv"));
            StringBuilder sb = new StringBuilder();
            
            sb.append("Dia");
            sb.append(",");
            sb.append("Cantidad");
            sb.append("\n");
            
            sb.append(dia);
            sb.append(",");
            sb.append(cantidad);
            sb.append("\n");
            
            if (archivo.isDirectory()) {
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }else{
                archivo.mkdir();
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }
            
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error " + io.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Tu archivo ha sido exportado con éxito.", "INFORMACION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void exportPorcentajeMujeresHombres(String nombreReporte, String porcentaje){
        try{
            
            File archivo = new File(ruta+"\\REPORTES");
            
            Calendar fecha = Calendar.getInstance();
            
            // DIA
            String DAY = Integer.toString(fecha.get(Calendar.DATE));
            
            // MES
            String MES = Integer.toString(fecha.get(Calendar.MONTH)+1);
            
            // AÑO
            String YEAR = Integer.toString(fecha.get(Calendar.YEAR));
            
            PrintWriter pw = new PrintWriter(new File(ruta+"\\REPORTES\\"+nombreReporte+"-"+(YEAR)+(MES)+(DAY)+".csv"));
            StringBuilder sb = new StringBuilder();
            
            sb.append("Porcentaje");
            sb.append("\n");
            
            sb.append(porcentaje);
            sb.append("\n");
            
            if (archivo.isDirectory()) {
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }else{
                archivo.mkdir();
                pw.write(sb.toString());
                pw.flush();
                pw.close();
            }
            
            
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error " + io.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Tu archivo ha sido exportado con éxito.", "INFORMACION", JOptionPane.WARNING_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jpRegresar2 = new javax.swing.JPanel();
        lblRegresar2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpRegresar3 = new javax.swing.JPanel();
        lblRegresar3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        lblBarra = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblLYC = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblPaquete = new javax.swing.JLabel();
        lblRepaqIcon = new javax.swing.JLabel();
        lblBarraTitulo = new javax.swing.JLabel();
        lblBy = new javax.swing.JLabel();
        jpCantClienteDia = new javax.swing.JPanel();
        lblCantClientes = new javax.swing.JLabel();
        jpCantClienteSem = new javax.swing.JPanel();
        lblCantClienteSem = new javax.swing.JLabel();
        jpCantClienMes = new javax.swing.JPanel();
        lblCantClienMes = new javax.swing.JLabel();
        jpPorcentajeRecg = new javax.swing.JPanel();
        lblPorcentajeRecg = new javax.swing.JLabel();
        jpSemanaRecogida = new javax.swing.JPanel();
        lblSemanaRecogida = new javax.swing.JLabel();
        jpPorcentajeH = new javax.swing.JPanel();
        lblPorcentajeH = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        lblRepaq2 = new javax.swing.JLabel();
        jpPorcentajeM = new javax.swing.JPanel();
        lblPorcentajeM = new javax.swing.JLabel();
        jpPorctjMuj = new javax.swing.JPanel();
        jpPorcentajeMujeres = new javax.swing.JPanel();
        lblCrearReportePorcRecg2 = new javax.swing.JLabel();
        lblPorctjMujeres = new javax.swing.JLabel();
        jpRegresarPorcentajeMujeres = new javax.swing.JPanel();
        lblRegresarPPR2 = new javax.swing.JLabel();
        lblPaqEntreg2 = new javax.swing.JLabel();
        cantidad13 = new javax.swing.JLabel();
        jpPorctjHom = new javax.swing.JPanel();
        jpPorcentajeHombres = new javax.swing.JPanel();
        lblCrearReportePorcRecg1 = new javax.swing.JLabel();
        lblPorctjHombres = new javax.swing.JLabel();
        jpPorcentajeHombre = new javax.swing.JPanel();
        lblRegresarPPR1 = new javax.swing.JLabel();
        lblPaqEntreg1 = new javax.swing.JLabel();
        cantidad12 = new javax.swing.JLabel();
        jpDiaSemanaMayorRecog = new javax.swing.JPanel();
        jpDiaMayorRecogida = new javax.swing.JPanel();
        lblCrearReporteSem1 = new javax.swing.JLabel();
        lblCantDiaSemanaMayorRec = new javax.swing.JLabel();
        jpAtrasDiaMayorRecogida = new javax.swing.JPanel();
        lblRegresarSemana1 = new javax.swing.JLabel();
        cantidad9 = new javax.swing.JLabel();
        lblSemana1 = new javax.swing.JLabel();
        cantidad11 = new javax.swing.JLabel();
        lblMes4 = new javax.swing.JLabel();
        lblMes5 = new javax.swing.JLabel();
        jtdia = new javax.swing.JTextField();
        cbxMes_DiaSemanaMayorR = new javax.swing.JComboBox<>();
        cantidad14 = new javax.swing.JLabel();
        lblDiaSemanaMayorRec = new javax.swing.JLabel();
        tfYear_DiaSemanaMayorR1 = new javax.swing.JTextField();
        jpPorctjPaqRec = new javax.swing.JPanel();
        jpCrearReportePorcRecg = new javax.swing.JPanel();
        lblCrearReportePorcRecg = new javax.swing.JLabel();
        lblPorctjEntreg = new javax.swing.JLabel();
        jpRegresarPPR = new javax.swing.JPanel();
        lblRegresarPPR = new javax.swing.JLabel();
        lblPaqEntreg = new javax.swing.JLabel();
        cantidad10 = new javax.swing.JLabel();
        lblPaqSinEntreg = new javax.swing.JLabel();
        lblPorctjSinEntreg = new javax.swing.JLabel();
        jpCantMes = new javax.swing.JPanel();
        jpCrearReporteMes = new javax.swing.JPanel();
        lblCrearReporteMes = new javax.swing.JLabel();
        lblReportePorMes = new javax.swing.JLabel();
        jpRegresarMes = new javax.swing.JPanel();
        lblRegresarMes = new javax.swing.JLabel();
        cantidad5 = new javax.swing.JLabel();
        cantidad8 = new javax.swing.JLabel();
        lblMes2 = new javax.swing.JLabel();
        lblMes3 = new javax.swing.JLabel();
        tfYearReporteMes = new javax.swing.JTextField();
        cbxReporteMes = new javax.swing.JComboBox<>();
        jpCantSem = new javax.swing.JPanel();
        jpCrearReporteSem = new javax.swing.JPanel();
        lblCrearReporteSem = new javax.swing.JLabel();
        lblCantidadSem = new javax.swing.JLabel();
        jpRegresarSemana = new javax.swing.JPanel();
        lblRegresarSemana = new javax.swing.JLabel();
        cantidad4 = new javax.swing.JLabel();
        lblSemana = new javax.swing.JLabel();
        cantidad6 = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblMes1 = new javax.swing.JLabel();
        tfYearSemana = new javax.swing.JTextField();
        cbxSemana = new javax.swing.JComboBox<>();
        cbxMesSemana = new javax.swing.JComboBox<>();
        jpCantDia = new javax.swing.JPanel();
        jpCrearReporteDia = new javax.swing.JPanel();
        lblCrearReporteDia = new javax.swing.JLabel();
        lblCantidadDia = new javax.swing.JLabel();
        jpRegresar = new javax.swing.JPanel();
        lblRegresar1 = new javax.swing.JLabel();
        cantidad = new javax.swing.JLabel();
        tfDia = new javax.swing.JTextField();
        cantidad3 = new javax.swing.JLabel();
        cantidad7 = new javax.swing.JLabel();

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/repaq.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(109, 157, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegresar2.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresar2.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresar2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresar2.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresar2.setText("Crear Reporte");
        lblRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresar2.add(lblRegresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 40));

        jPanel5.add(jpRegresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 190, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 100, -1));

        jLabel4.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad de Clientes:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jpRegresar3.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresar3.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresar3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresar3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresar3.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresar3.setText("Regresar");
        lblRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresar3.add(lblRegresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel5.add(jpRegresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

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
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 30, 30));

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
        jPanel1.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 30));

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
        jPanel1.add(lblBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(-280, 0, 750, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 540, 30));

        jPanel2.setBackground(new java.awt.Color(0, 110, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 104, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLYC.setFont(new java.awt.Font("Open Sans Extrabold", 1, 18)); // NOI18N
        lblLYC.setForeground(new java.awt.Color(255, 255, 255));
        lblLYC.setText("LYC");
        jPanel2.add(lblLYC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 40, 20));

        jSeparator2.setBackground(new java.awt.Color(0, 89, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 89, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, -1));

        lblPaquete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/package.png"))); // NOI18N
        jPanel2.add(lblPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 30));

        lblRepaqIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/repaq1.png"))); // NOI18N
        jPanel2.add(lblRepaqIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        lblBarraTitulo.setFont(new java.awt.Font("Open Sans Extrabold", 1, 18)); // NOI18N
        lblBarraTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblBarraTitulo.setText("RePAQ");
        jPanel2.add(lblBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 30));

        lblBy.setFont(new java.awt.Font("Open Sans Extrabold", 1, 10)); // NOI18N
        lblBy.setForeground(new java.awt.Color(255, 255, 255));
        lblBy.setText("  By");
        jPanel2.add(lblBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 20, 10));

        jpCantClienteDia.setBackground(new java.awt.Color(0, 80, 255));
        jpCantClienteDia.setForeground(new java.awt.Color(0, 80, 255));
        jpCantClienteDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCantClienteDia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCantClienteDiaMouseMoved(evt);
            }
        });
        jpCantClienteDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCantClienteDiaMouseExited(evt);
            }
        });
        jpCantClienteDia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCantClientes.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblCantClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblCantClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/group.png"))); // NOI18N
        lblCantClientes.setText("Cantidad clientes recogida por día.");
        lblCantClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCantClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCantClientesMouseMoved(evt);
            }
        });
        lblCantClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCantClientesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCantClientesMouseExited(evt);
            }
        });
        jpCantClienteDia.add(lblCantClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 40));

        jPanel2.add(jpCantClienteDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 280, 40));

        jpCantClienteSem.setBackground(new java.awt.Color(0, 80, 255));
        jpCantClienteSem.setForeground(new java.awt.Color(0, 80, 255));
        jpCantClienteSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCantClienteSem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCantClienteSemMouseMoved(evt);
            }
        });
        jpCantClienteSem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCantClienteSemMouseExited(evt);
            }
        });
        jpCantClienteSem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCantClienteSem.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblCantClienteSem.setForeground(new java.awt.Color(255, 255, 255));
        lblCantClienteSem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/support1.png"))); // NOI18N
        lblCantClienteSem.setText("Cantidad clientes recogida por sem.");
        lblCantClienteSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCantClienteSem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCantClienteSemMouseMoved(evt);
            }
        });
        lblCantClienteSem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCantClienteSemMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCantClienteSemMouseExited(evt);
            }
        });
        jpCantClienteSem.add(lblCantClienteSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 40));

        jPanel2.add(jpCantClienteSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 280, 40));

        jpCantClienMes.setBackground(new java.awt.Color(0, 80, 255));
        jpCantClienMes.setForeground(new java.awt.Color(0, 80, 255));
        jpCantClienMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCantClienMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCantClienMesMouseMoved(evt);
            }
        });
        jpCantClienMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCantClienMesMouseExited(evt);
            }
        });
        jpCantClienMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCantClienMes.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblCantClienMes.setForeground(new java.awt.Color(255, 255, 255));
        lblCantClienMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/shipping.png"))); // NOI18N
        lblCantClienMes.setText("Cantidad clientes recogida por mes.");
        lblCantClienMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCantClienMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCantClienMesMouseMoved(evt);
            }
        });
        lblCantClienMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCantClienMesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCantClienMesMouseExited(evt);
            }
        });
        jpCantClienMes.add(lblCantClienMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 40));

        jPanel2.add(jpCantClienMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 280, 40));

        jpPorcentajeRecg.setBackground(new java.awt.Color(0, 80, 255));
        jpPorcentajeRecg.setForeground(new java.awt.Color(0, 80, 255));
        jpPorcentajeRecg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPorcentajeRecg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPorcentajeRecgMouseMoved(evt);
            }
        });
        jpPorcentajeRecg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorcentajeRecgMouseExited(evt);
            }
        });
        jpPorcentajeRecg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPorcentajeRecg.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblPorcentajeRecg.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentajeRecg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/close-envelope.png"))); // NOI18N
        lblPorcentajeRecg.setText("Porcentaje paquete Recogidos.");
        lblPorcentajeRecg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPorcentajeRecg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblPorcentajeRecgMouseMoved(evt);
            }
        });
        lblPorcentajeRecg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPorcentajeRecgMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPorcentajeRecgMouseExited(evt);
            }
        });
        jpPorcentajeRecg.add(lblPorcentajeRecg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 40));

        jPanel2.add(jpPorcentajeRecg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 280, 40));

        jpSemanaRecogida.setBackground(new java.awt.Color(0, 80, 255));
        jpSemanaRecogida.setForeground(new java.awt.Color(0, 80, 255));
        jpSemanaRecogida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpSemanaRecogida.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpSemanaRecogidaMouseMoved(evt);
            }
        });
        jpSemanaRecogida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpSemanaRecogidaMouseExited(evt);
            }
        });
        jpSemanaRecogida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSemanaRecogida.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblSemanaRecogida.setForeground(new java.awt.Color(255, 255, 255));
        lblSemanaRecogida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblSemanaRecogida.setText("Dia de Semana con mayor recogida.");
        lblSemanaRecogida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSemanaRecogida.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblSemanaRecogidaMouseMoved(evt);
            }
        });
        lblSemanaRecogida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSemanaRecogidaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSemanaRecogidaMouseExited(evt);
            }
        });
        jpSemanaRecogida.add(lblSemanaRecogida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 40));

        jPanel2.add(jpSemanaRecogida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 280, 40));

        jpPorcentajeH.setBackground(new java.awt.Color(0, 80, 255));
        jpPorcentajeH.setForeground(new java.awt.Color(0, 80, 255));
        jpPorcentajeH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPorcentajeH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPorcentajeHMouseMoved(evt);
            }
        });
        jpPorcentajeH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpPorcentajeHMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorcentajeHMouseExited(evt);
            }
        });
        jpPorcentajeH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPorcentajeH.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblPorcentajeH.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentajeH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/perfil.png"))); // NOI18N
        lblPorcentajeH.setText("Porcentaje clientes hombres.");
        lblPorcentajeH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPorcentajeH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblPorcentajeHMouseMoved(evt);
            }
        });
        lblPorcentajeH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPorcentajeHMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPorcentajeHMouseExited(evt);
            }
        });
        jpPorcentajeH.add(lblPorcentajeH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 40));

        jPanel2.add(jpPorcentajeH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 280, 40));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/repaq.png"))); // NOI18N
        jPanel2.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 100, 110));

        lblRepaq2.setFont(new java.awt.Font("Open Sans Extrabold", 1, 18)); // NOI18N
        lblRepaq2.setForeground(new java.awt.Color(255, 255, 255));
        lblRepaq2.setText("RePAQ");
        jPanel2.add(lblRepaq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 70, 30));

        jpPorcentajeM.setBackground(new java.awt.Color(0, 80, 255));
        jpPorcentajeM.setForeground(new java.awt.Color(0, 80, 255));
        jpPorcentajeM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPorcentajeM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPorcentajeMMouseMoved(evt);
            }
        });
        jpPorcentajeM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpPorcentajeMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorcentajeMMouseExited(evt);
            }
        });
        jpPorcentajeM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPorcentajeM.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblPorcentajeM.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentajeM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/perfil.png"))); // NOI18N
        lblPorcentajeM.setText("Porcentaje clientes mujeres.");
        lblPorcentajeM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPorcentajeM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblPorcentajeMMouseMoved(evt);
            }
        });
        lblPorcentajeM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPorcentajeMMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPorcentajeMMouseExited(evt);
            }
        });
        jpPorcentajeM.add(lblPorcentajeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 40));

        jPanel2.add(jpPorcentajeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 520));

        jpPorctjMuj.setBackground(new java.awt.Color(109, 157, 255));
        jpPorctjMuj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorctjMujMouseExited(evt);
            }
        });
        jpPorctjMuj.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpPorcentajeMujeres.setBackground(new java.awt.Color(0, 80, 255));
        jpPorcentajeMujeres.setForeground(new java.awt.Color(0, 80, 255));
        jpPorcentajeMujeres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPorcentajeMujeres.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPorcentajeMujeresMouseMoved(evt);
            }
        });
        jpPorcentajeMujeres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorcentajeMujeresMouseExited(evt);
            }
        });
        jpPorcentajeMujeres.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReportePorcRecg2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReportePorcRecg2.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReportePorcRecg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReportePorcRecg2.setText("Crear Reporte");
        lblCrearReportePorcRecg2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReportePorcRecg2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecg2MouseMoved(evt);
            }
        });
        lblCrearReportePorcRecg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecg2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecg2MouseExited(evt);
            }
        });
        jpPorcentajeMujeres.add(lblCrearReportePorcRecg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpPorctjMuj.add(jpPorcentajeMujeres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, -1));

        lblPorctjMujeres.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblPorctjMujeres.setForeground(new java.awt.Color(255, 255, 255));
        lblPorctjMujeres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorctjMujeres.setText("0");
        jpPorctjMuj.add(lblPorctjMujeres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 100, -1));

        jpRegresarPorcentajeMujeres.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresarPorcentajeMujeres.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresarPorcentajeMujeres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresarPorcentajeMujeres.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpRegresarPorcentajeMujeresMouseMoved(evt);
            }
        });
        jpRegresarPorcentajeMujeres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpRegresarPorcentajeMujeresMouseExited(evt);
            }
        });
        jpRegresarPorcentajeMujeres.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresarPPR2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresarPPR2.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresarPPR2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresarPPR2.setText("Regresar");
        lblRegresarPPR2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresarPPR2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarPPR2MouseMoved(evt);
            }
        });
        lblRegresarPPR2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarPPR2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarPPR2MouseExited(evt);
            }
        });
        jpRegresarPorcentajeMujeres.add(lblRegresarPPR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpPorctjMuj.add(jpRegresarPorcentajeMujeres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        lblPaqEntreg2.setFont(new java.awt.Font("DialogInput", 3, 20)); // NOI18N
        lblPaqEntreg2.setForeground(new java.awt.Color(255, 255, 255));
        lblPaqEntreg2.setText("•Porcentaje de Mujeres:");
        jpPorctjMuj.add(lblPaqEntreg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        cantidad13.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad13.setForeground(new java.awt.Color(255, 255, 255));
        cantidad13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantidad13.setText("<html>Reporte porcentaje de Clientes mujeres</html>");
        jpPorctjMuj.add(cantidad13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 280, 70));

        getContentPane().add(jpPorctjMuj, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

        jpPorctjHom.setBackground(new java.awt.Color(109, 157, 255));
        jpPorctjHom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorctjHomMouseExited(evt);
            }
        });
        jpPorctjHom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpPorcentajeHombres.setBackground(new java.awt.Color(0, 80, 255));
        jpPorcentajeHombres.setForeground(new java.awt.Color(0, 80, 255));
        jpPorcentajeHombres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPorcentajeHombres.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPorcentajeHombresMouseMoved(evt);
            }
        });
        jpPorcentajeHombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorcentajeHombresMouseExited(evt);
            }
        });
        jpPorcentajeHombres.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReportePorcRecg1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReportePorcRecg1.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReportePorcRecg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReportePorcRecg1.setText("Crear Reporte");
        lblCrearReportePorcRecg1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReportePorcRecg1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecg1MouseMoved(evt);
            }
        });
        lblCrearReportePorcRecg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecg1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecg1MouseExited(evt);
            }
        });
        jpPorcentajeHombres.add(lblCrearReportePorcRecg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpPorctjHom.add(jpPorcentajeHombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, -1));

        lblPorctjHombres.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblPorctjHombres.setForeground(new java.awt.Color(255, 255, 255));
        lblPorctjHombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorctjHombres.setText("0");
        jpPorctjHom.add(lblPorctjHombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 100, -1));

        jpPorcentajeHombre.setBackground(new java.awt.Color(0, 80, 255));
        jpPorcentajeHombre.setForeground(new java.awt.Color(0, 80, 255));
        jpPorcentajeHombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPorcentajeHombre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPorcentajeHombreMouseMoved(evt);
            }
        });
        jpPorcentajeHombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorcentajeHombreMouseExited(evt);
            }
        });
        jpPorcentajeHombre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresarPPR1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresarPPR1.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresarPPR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresarPPR1.setText("Regresar");
        lblRegresarPPR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresarPPR1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarPPR1MouseMoved(evt);
            }
        });
        lblRegresarPPR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarPPR1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarPPR1MouseExited(evt);
            }
        });
        jpPorcentajeHombre.add(lblRegresarPPR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpPorctjHom.add(jpPorcentajeHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        lblPaqEntreg1.setFont(new java.awt.Font("DialogInput", 3, 20)); // NOI18N
        lblPaqEntreg1.setForeground(new java.awt.Color(255, 255, 255));
        lblPaqEntreg1.setText("•Porcentaje de Hombres:");
        jpPorctjHom.add(lblPaqEntreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        cantidad12.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad12.setForeground(new java.awt.Color(255, 255, 255));
        cantidad12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantidad12.setText("<html>Reporte porcentaje de Clientes hombres</html>");
        jpPorctjHom.add(cantidad12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 280, 70));

        getContentPane().add(jpPorctjHom, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

        jpDiaSemanaMayorRecog.setBackground(new java.awt.Color(109, 157, 255));
        jpDiaSemanaMayorRecog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpDiaMayorRecogida.setBackground(new java.awt.Color(0, 80, 255));
        jpDiaMayorRecogida.setForeground(new java.awt.Color(0, 80, 255));
        jpDiaMayorRecogida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpDiaMayorRecogida.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpDiaMayorRecogidaMouseMoved(evt);
            }
        });
        jpDiaMayorRecogida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpDiaMayorRecogidaMouseExited(evt);
            }
        });
        jpDiaMayorRecogida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReporteSem1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReporteSem1.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReporteSem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReporteSem1.setText("Crear Reporte");
        lblCrearReporteSem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReporteSem1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReporteSem1MouseMoved(evt);
            }
        });
        lblCrearReporteSem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReporteSem1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReporteSem1MouseExited(evt);
            }
        });
        jpDiaMayorRecogida.add(lblCrearReporteSem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpDiaSemanaMayorRecog.add(jpDiaMayorRecogida, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 190, -1));

        lblCantDiaSemanaMayorRec.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblCantDiaSemanaMayorRec.setForeground(new java.awt.Color(255, 255, 255));
        lblCantDiaSemanaMayorRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantDiaSemanaMayorRec.setText("0");
        jpDiaSemanaMayorRecog.add(lblCantDiaSemanaMayorRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 100, -1));

        jpAtrasDiaMayorRecogida.setBackground(new java.awt.Color(0, 80, 255));
        jpAtrasDiaMayorRecogida.setForeground(new java.awt.Color(0, 80, 255));
        jpAtrasDiaMayorRecogida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpAtrasDiaMayorRecogida.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpAtrasDiaMayorRecogidaMouseMoved(evt);
            }
        });
        jpAtrasDiaMayorRecogida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpAtrasDiaMayorRecogidaMouseExited(evt);
            }
        });
        jpAtrasDiaMayorRecogida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresarSemana1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresarSemana1.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresarSemana1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresarSemana1.setText("Regresar");
        lblRegresarSemana1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresarSemana1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarSemana1MouseMoved(evt);
            }
        });
        lblRegresarSemana1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarSemana1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarSemana1MouseExited(evt);
            }
        });
        jpAtrasDiaMayorRecogida.add(lblRegresarSemana1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpDiaSemanaMayorRecog.add(jpAtrasDiaMayorRecogida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        cantidad9.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        cantidad9.setForeground(new java.awt.Color(255, 255, 255));
        cantidad9.setText("cantidad");
        jpDiaSemanaMayorRecog.add(cantidad9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        lblSemana1.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblSemana1.setForeground(new java.awt.Color(255, 255, 255));
        lblSemana1.setText("dia:");
        jpDiaSemanaMayorRecog.add(lblSemana1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, 20));

        cantidad11.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad11.setForeground(new java.awt.Color(255, 255, 255));
        cantidad11.setText("Dia de Semana con mayor Recogida");
        jpDiaSemanaMayorRecog.add(cantidad11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lblMes4.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblMes4.setForeground(new java.awt.Color(255, 255, 255));
        lblMes4.setText("Mes:");
        jpDiaSemanaMayorRecog.add(lblMes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 50, 20));

        lblMes5.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblMes5.setForeground(new java.awt.Color(255, 255, 255));
        lblMes5.setText("Año:");
        jpDiaSemanaMayorRecog.add(lblMes5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, 20));

        jtdia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtdia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtdiaKeyTyped(evt);
            }
        });
        jpDiaSemanaMayorRecog.add(jtdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 40, -1));

        cbxMes_DiaSemanaMayorR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jpDiaSemanaMayorRecog.add(cbxMes_DiaSemanaMayorR, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 50, -1));

        cantidad14.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        cantidad14.setForeground(new java.awt.Color(255, 255, 255));
        cantidad14.setText("Dia:");
        jpDiaSemanaMayorRecog.add(cantidad14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        lblDiaSemanaMayorRec.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblDiaSemanaMayorRec.setForeground(new java.awt.Color(255, 255, 255));
        lblDiaSemanaMayorRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiaSemanaMayorRec.setText("0");
        jpDiaSemanaMayorRecog.add(lblDiaSemanaMayorRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 100, -1));

        tfYear_DiaSemanaMayorR1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfYear_DiaSemanaMayorR1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfYear_DiaSemanaMayorR1KeyTyped(evt);
            }
        });
        jpDiaSemanaMayorRecog.add(tfYear_DiaSemanaMayorR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 70, -1));

        getContentPane().add(jpDiaSemanaMayorRecog, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

        jpPorctjPaqRec.setBackground(new java.awt.Color(109, 157, 255));
        jpPorctjPaqRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPorctjPaqRecMouseExited(evt);
            }
        });
        jpPorctjPaqRec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCrearReportePorcRecg.setBackground(new java.awt.Color(0, 80, 255));
        jpCrearReportePorcRecg.setForeground(new java.awt.Color(0, 80, 255));
        jpCrearReportePorcRecg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCrearReportePorcRecg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCrearReportePorcRecgMouseMoved(evt);
            }
        });
        jpCrearReportePorcRecg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCrearReportePorcRecgMouseExited(evt);
            }
        });
        jpCrearReportePorcRecg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReportePorcRecg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReportePorcRecg.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReportePorcRecg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReportePorcRecg.setText("Crear Reporte");
        lblCrearReportePorcRecg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReportePorcRecg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecgMouseMoved(evt);
            }
        });
        lblCrearReportePorcRecg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecgMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReportePorcRecgMouseExited(evt);
            }
        });
        jpCrearReportePorcRecg.add(lblCrearReportePorcRecg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpPorctjPaqRec.add(jpCrearReportePorcRecg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, -1));

        lblPorctjEntreg.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblPorctjEntreg.setForeground(new java.awt.Color(255, 255, 255));
        lblPorctjEntreg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorctjEntreg.setText("0");
        jpPorctjPaqRec.add(lblPorctjEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 100, -1));

        jpRegresarPPR.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresarPPR.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresarPPR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresarPPR.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpRegresarPPRMouseMoved(evt);
            }
        });
        jpRegresarPPR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpRegresarPPRMouseExited(evt);
            }
        });
        jpRegresarPPR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresarPPR.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresarPPR.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresarPPR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresarPPR.setText("Regresar");
        lblRegresarPPR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresarPPR.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarPPRMouseMoved(evt);
            }
        });
        lblRegresarPPR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarPPRMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarPPRMouseExited(evt);
            }
        });
        jpRegresarPPR.add(lblRegresarPPR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpPorctjPaqRec.add(jpRegresarPPR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        lblPaqEntreg.setFont(new java.awt.Font("DialogInput", 3, 20)); // NOI18N
        lblPaqEntreg.setForeground(new java.awt.Color(255, 255, 255));
        lblPaqEntreg.setText("•Porcentaje de Paquetes Entregados:");
        jpPorctjPaqRec.add(lblPaqEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        cantidad10.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad10.setForeground(new java.awt.Color(255, 255, 255));
        cantidad10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantidad10.setText("<html>Reporte porcentaje de Paquetes recogidos</html>");
        jpPorctjPaqRec.add(cantidad10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 300, 70));

        lblPaqSinEntreg.setFont(new java.awt.Font("DialogInput", 3, 20)); // NOI18N
        lblPaqSinEntreg.setForeground(new java.awt.Color(255, 255, 255));
        lblPaqSinEntreg.setText("•Porcentaje de Paquetes aún sin Entregar:");
        jpPorctjPaqRec.add(lblPaqSinEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lblPorctjSinEntreg.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblPorctjSinEntreg.setForeground(new java.awt.Color(255, 255, 255));
        lblPorctjSinEntreg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorctjSinEntreg.setText("0");
        jpPorctjPaqRec.add(lblPorctjSinEntreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 100, -1));

        getContentPane().add(jpPorctjPaqRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

        jpCantMes.setBackground(new java.awt.Color(109, 157, 255));
        jpCantMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCrearReporteMes.setBackground(new java.awt.Color(0, 80, 255));
        jpCrearReporteMes.setForeground(new java.awt.Color(0, 80, 255));
        jpCrearReporteMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCrearReporteMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCrearReporteMesMouseMoved(evt);
            }
        });
        jpCrearReporteMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCrearReporteMesMouseExited(evt);
            }
        });
        jpCrearReporteMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReporteMes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReporteMes.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReporteMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReporteMes.setText("Crear Reporte");
        lblCrearReporteMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReporteMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReporteMesMouseMoved(evt);
            }
        });
        lblCrearReporteMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReporteMesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReporteMesMouseExited(evt);
            }
        });
        jpCrearReporteMes.add(lblCrearReporteMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpCantMes.add(jpCrearReporteMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 190, -1));

        lblReportePorMes.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblReportePorMes.setForeground(new java.awt.Color(255, 255, 255));
        lblReportePorMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportePorMes.setText("0");
        jpCantMes.add(lblReportePorMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 100, -1));

        jpRegresarMes.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresarMes.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresarMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresarMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpRegresarMesMouseMoved(evt);
            }
        });
        jpRegresarMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpRegresarMesMouseExited(evt);
            }
        });
        jpRegresarMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresarMes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresarMes.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresarMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresarMes.setText("Regresar");
        lblRegresarMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresarMes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarMesMouseMoved(evt);
            }
        });
        lblRegresarMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarMesMouseExited(evt);
            }
        });
        jpRegresarMes.add(lblRegresarMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpCantMes.add(jpRegresarMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        cantidad5.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        cantidad5.setForeground(new java.awt.Color(255, 255, 255));
        cantidad5.setText("Cantidad de Clientes:");
        jpCantMes.add(cantidad5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        cantidad8.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad8.setForeground(new java.awt.Color(255, 255, 255));
        cantidad8.setText("Reporte por Mes");
        jpCantMes.add(cantidad8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        lblMes2.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblMes2.setForeground(new java.awt.Color(255, 255, 255));
        lblMes2.setText("Mes:");
        jpCantMes.add(lblMes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 50, 20));

        lblMes3.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblMes3.setForeground(new java.awt.Color(255, 255, 255));
        lblMes3.setText("Año:");
        jpCantMes.add(lblMes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 20));

        tfYearReporteMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfYearReporteMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfYearReporteMesKeyTyped(evt);
            }
        });
        jpCantMes.add(tfYearReporteMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 70, -1));

        cbxReporteMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jpCantMes.add(cbxReporteMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 50, -1));

        getContentPane().add(jpCantMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

        jpCantSem.setBackground(new java.awt.Color(109, 157, 255));
        jpCantSem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCrearReporteSem.setBackground(new java.awt.Color(0, 80, 255));
        jpCrearReporteSem.setForeground(new java.awt.Color(0, 80, 255));
        jpCrearReporteSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCrearReporteSem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpCrearReporteSemMouseMoved(evt);
            }
        });
        jpCrearReporteSem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpCrearReporteSemMouseExited(evt);
            }
        });
        jpCrearReporteSem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReporteSem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReporteSem.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReporteSem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReporteSem.setText("Crear Reporte");
        lblCrearReporteSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReporteSem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReporteSemMouseMoved(evt);
            }
        });
        lblCrearReporteSem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReporteSemMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReporteSemMouseExited(evt);
            }
        });
        jpCrearReporteSem.add(lblCrearReporteSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpCantSem.add(jpCrearReporteSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 190, -1));

        lblCantidadSem.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblCantidadSem.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadSem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidadSem.setText("0");
        jpCantSem.add(lblCantidadSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 100, -1));

        jpRegresarSemana.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresarSemana.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresarSemana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresarSemana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpRegresarSemanaMouseMoved(evt);
            }
        });
        jpRegresarSemana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpRegresarSemanaMouseExited(evt);
            }
        });
        jpRegresarSemana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresarSemana.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresarSemana.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresarSemana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresarSemana.setText("Regresar");
        lblRegresarSemana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresarSemana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresarSemanaMouseMoved(evt);
            }
        });
        lblRegresarSemana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarSemanaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresarSemanaMouseExited(evt);
            }
        });
        jpRegresarSemana.add(lblRegresarSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpCantSem.add(jpRegresarSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        cantidad4.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        cantidad4.setForeground(new java.awt.Color(255, 255, 255));
        cantidad4.setText("Cantidad de Clientes:");
        jpCantSem.add(cantidad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        lblSemana.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblSemana.setForeground(new java.awt.Color(255, 255, 255));
        lblSemana.setText("Semana:");
        jpCantSem.add(lblSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 20));

        cantidad6.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad6.setForeground(new java.awt.Color(255, 255, 255));
        cantidad6.setText("Reporte por Semana");
        jpCantSem.add(cantidad6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        lblMes.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblMes.setForeground(new java.awt.Color(255, 255, 255));
        lblMes.setText("Mes:");
        jpCantSem.add(lblMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 50, 20));

        lblMes1.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        lblMes1.setForeground(new java.awt.Color(255, 255, 255));
        lblMes1.setText("Año:");
        jpCantSem.add(lblMes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, 20));

        tfYearSemana.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfYearSemana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfYearSemanaKeyTyped(evt);
            }
        });
        jpCantSem.add(tfYearSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 70, -1));

        cbxSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jpCantSem.add(cbxSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 50, -1));

        cbxMesSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jpCantSem.add(cbxMesSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 50, -1));

        getContentPane().add(jpCantSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

        jpCantDia.setBackground(new java.awt.Color(109, 157, 255));
        jpCantDia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCrearReporteDia.setBackground(new java.awt.Color(0, 80, 255));
        jpCrearReporteDia.setForeground(new java.awt.Color(0, 80, 255));
        jpCrearReporteDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCrearReporteDia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCrearReporteDia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCrearReporteDia.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearReporteDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/report.png"))); // NOI18N
        lblCrearReporteDia.setText("Crear Reporte");
        lblCrearReporteDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearReporteDia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCrearReporteDiaMouseMoved(evt);
            }
        });
        lblCrearReporteDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearReporteDiaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearReporteDiaMouseExited(evt);
            }
        });
        jpCrearReporteDia.add(lblCrearReporteDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        jpCantDia.add(jpCrearReporteDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 190, -1));

        lblCantidadDia.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        lblCantidadDia.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantidadDia.setText("0");
        jpCantDia.add(lblCantidadDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 100, -1));

        jpRegresar.setBackground(new java.awt.Color(0, 80, 255));
        jpRegresar.setForeground(new java.awt.Color(0, 80, 255));
        jpRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegresar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRegresar1.setForeground(new java.awt.Color(255, 255, 255));
        lblRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recogidapaquete/images/back.png"))); // NOI18N
        lblRegresar1.setText("Regresar");
        lblRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRegresar1MouseMoved(evt);
            }
        });
        lblRegresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresar1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegresar1MouseExited(evt);
            }
        });
        jpRegresar.add(lblRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jpCantDia.add(jpRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        cantidad.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        cantidad.setForeground(new java.awt.Color(255, 255, 255));
        cantidad.setText("Cantidad de Clientes:");
        jpCantDia.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        tfDia.setForeground(new java.awt.Color(0, 0, 0));
        tfDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpCantDia.add(tfDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 90, -1));

        cantidad3.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        cantidad3.setForeground(new java.awt.Color(255, 255, 255));
        cantidad3.setText("Dia:");
        jpCantDia.add(cantidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, 20));

        cantidad7.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        cantidad7.setForeground(new java.awt.Color(255, 255, 255));
        cantidad7.setText("Reporte por Dia");
        jpCantDia.add(cantidad7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        getContentPane().add(jpCantDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 540, 490));

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
    
    private void jpCantClienteDiaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCantClienteDiaMouseMoved
        jpCantClienteDia.setBackground(new Color(0,0,255));
        jpCantClienteDia.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpCantClienteDiaMouseMoved
    
    private void lblCantClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClientesMouseMoved
        jpCantClienteDia.setBackground(new Color(0,0,255));
        jpCantClienteDia.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCantClientesMouseMoved
    
    private void lblCantClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClientesMouseExited
        jpCantClienteDia.setBackground(new Color(0,80,255));
        jpCantClienteDia.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCantClientesMouseExited
    
    private void jpCantClienteDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCantClienteDiaMouseExited
        jpCantClienteDia.setBackground(new Color(0,80,255));
        jpCantClienteDia.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpCantClienteDiaMouseExited
    
    private void lblCantClienteSemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClienteSemMouseMoved
        jpCantClienteSem.setBackground(new Color(0,0,255));
        jpCantClienteSem.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCantClienteSemMouseMoved
    
    private void lblCantClienteSemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClienteSemMouseExited
        jpCantClienteSem.setBackground(new Color(0,80,255));
        jpCantClienteSem.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCantClienteSemMouseExited
    
    private void jpCantClienteSemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCantClienteSemMouseMoved
        jpCantClienteSem.setBackground(new Color(0,0,255));
        jpCantClienteSem.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpCantClienteSemMouseMoved
    
    private void jpCantClienteSemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCantClienteSemMouseExited
        jpCantClienteSem.setBackground(new Color(0,80,255));
        jpCantClienteSem.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpCantClienteSemMouseExited
    
    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        salir();
    }//GEN-LAST:event_lblCloseMouseClicked
    
    private void lblCantClienMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClienMesMouseMoved
        jpCantClienMes.setBackground(new Color(0,0,255));
        jpCantClienMes.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCantClienMesMouseMoved
    
    private void lblCantClienMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClienMesMouseExited
        jpCantClienMes.setBackground(new Color(0,80,255));
        jpCantClienMes.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCantClienMesMouseExited
    
    private void jpCantClienMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCantClienMesMouseMoved
        jpCantClienMes.setBackground(new Color(0,0,255));
        jpCantClienMes.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpCantClienMesMouseMoved
    
    private void jpCantClienMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCantClienMesMouseExited
        jpCantClienMes.setBackground(new Color(0,80,255));
        jpCantClienMes.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpCantClienMesMouseExited
    
    private void lblPorcentajeRecgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeRecgMouseMoved
        jpPorcentajeRecg.setBackground(new Color(0,0,255));
        jpPorcentajeRecg.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblPorcentajeRecgMouseMoved
    
    private void lblPorcentajeRecgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeRecgMouseExited
        jpPorcentajeRecg.setBackground(new Color(0,80,255));
        jpPorcentajeRecg.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblPorcentajeRecgMouseExited
    
    private void jpPorcentajeRecgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeRecgMouseMoved
        jpPorcentajeRecg.setBackground(new Color(0,0,255));
        jpPorcentajeRecg.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpPorcentajeRecgMouseMoved
    
    private void jpPorcentajeRecgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeRecgMouseExited
        jpPorcentajeRecg.setBackground(new Color(0,80,255));
        jpPorcentajeRecg.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorcentajeRecgMouseExited
    
    private void lblSemanaRecogidaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemanaRecogidaMouseMoved
        jpSemanaRecogida.setBackground(new Color(0,0,255));
        jpSemanaRecogida.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblSemanaRecogidaMouseMoved
    
    private void lblSemanaRecogidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemanaRecogidaMouseExited
        jpSemanaRecogida.setBackground(new Color(0,80,255));
        jpSemanaRecogida.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblSemanaRecogidaMouseExited
    
    private void jpSemanaRecogidaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSemanaRecogidaMouseMoved
        jpSemanaRecogida.setBackground(new Color(0,0,255));
        jpSemanaRecogida.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpSemanaRecogidaMouseMoved
    
    private void jpSemanaRecogidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSemanaRecogidaMouseExited
        jpSemanaRecogida.setBackground(new Color(0,80,255));
        jpSemanaRecogida.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpSemanaRecogidaMouseExited
    
    private void lblPorcentajeHMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeHMouseMoved
        jpPorcentajeH.setBackground(new Color(0,0,255));
        jpPorcentajeH.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblPorcentajeHMouseMoved
    
    private void lblPorcentajeHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeHMouseExited
        jpPorcentajeH.setBackground(new Color(0,80,255));
        jpPorcentajeH.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblPorcentajeHMouseExited
    
    private void jpPorcentajeHMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHMouseMoved
        jpPorcentajeH.setBackground(new Color(0,0,255));
        jpPorcentajeH.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpPorcentajeHMouseMoved
    
    private void jpPorcentajeHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHMouseExited
        jpPorcentajeH.setBackground(new Color(0,80,255));
        jpPorcentajeH.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorcentajeHMouseExited

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(ReporteRecogidasPaquetes.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblCantClienteSemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClienteSemMouseClicked
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(true);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
        jpPorctjMuj.setVisible(false);
    }//GEN-LAST:event_lblCantClienteSemMouseClicked
    
    private void lblCantClienMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClienMesMouseClicked
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(true);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
        jpPorctjMuj.setVisible(false);
    }//GEN-LAST:event_lblCantClienMesMouseClicked

    private void lblBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMove, y - yMove);
    }//GEN-LAST:event_lblBarraMouseDragged

    private void lblBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMousePressed
        xMove = evt.getX();
        yMove = evt.getY();
    }//GEN-LAST:event_lblBarraMousePressed

    private void lblPorcentajeMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeMMouseMoved
        jpPorcentajeM.setBackground(new Color(0,0,255));
        jpPorcentajeM.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblPorcentajeMMouseMoved

    private void lblPorcentajeMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeMMouseExited
        jpPorcentajeM.setBackground(new Color(0,80,255));
        jpPorcentajeM.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblPorcentajeMMouseExited

    private void jpPorcentajeMMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeMMouseMoved
        jpPorcentajeM.setBackground(new Color(0,0,255));
        jpPorcentajeM.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpPorcentajeMMouseMoved

    private void jpPorcentajeMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeMMouseExited
        jpPorcentajeM.setBackground(new Color(0,80,255));
        jpPorcentajeM.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorcentajeMMouseExited

    private void lblRegresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresar1MouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresar1MouseClicked

    private void lblCrearReporteDiaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteDiaMouseMoved
        jpCrearReporteDia.setBackground(new Color(0,0,255));
        jpCrearReporteDia.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReporteDiaMouseMoved

    private void lblCrearReporteDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteDiaMouseExited
        jpCrearReporteDia.setBackground(new Color(0,80,255));
        jpCrearReporteDia.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReporteDiaMouseExited

    private void lblRegresar1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresar1MouseMoved
        jpRegresar.setBackground(new Color(0,0,255));
        jpRegresar.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresar1MouseMoved

    private void lblRegresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresar1MouseExited
        jpRegresar.setBackground(new Color(0,80,255));
        jpRegresar.setForeground(new Color(0,80,255));    }//GEN-LAST:event_lblRegresar1MouseExited

    private void lblCrearReporteDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteDiaMouseClicked
        String dia = null;
        try {
            conexionMySQL.consultaPorDia(tfDia.getText());
            dia = String.valueOf(conexionMySQL.getCantClientesRecogidaDia());
            lblCantidadDia.setText(dia);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el proceso.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
        exportReporteDia("CantClientesRecogidoPaqueteDia", tfDia.getText(), lblCantidadDia.getText());
    }//GEN-LAST:event_lblCrearReporteDiaMouseClicked

    private void lblCantClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCantClientesMouseClicked
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(true);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
        jpPorctjMuj.setVisible(false);
    }//GEN-LAST:event_lblCantClientesMouseClicked

    private void lblCrearReporteSemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteSemMouseMoved
        jpCrearReporteSem.setBackground(new Color(0,0,255));
        jpCrearReporteSem.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReporteSemMouseMoved

    private void lblCrearReporteSemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteSemMouseClicked
        try {
            conexionMySQL.consultaPorSemana(cbxSemana.getSelectedItem().toString(), cbxMesSemana.getSelectedItem().toString(), tfYearSemana.getText());
            String dia = String.valueOf(conexionMySQL.getCantClientesRecogidaDia());
            lblCantidadSem.setText(dia);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        exportReporteSemana("CantClientesRecogidoPaqueteSemana", cbxSemana.getSelectedItem().toString(), lblCantidadSem.getText());
    }//GEN-LAST:event_lblCrearReporteSemMouseClicked
    
    private void lblCrearReporteSemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteSemMouseExited
        jpCrearReporteSem.setBackground(new Color(0,80,255));
        jpCrearReporteSem.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReporteSemMouseExited

    private void lblRegresarSemanaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarSemanaMouseMoved
        jpRegresarSemana.setBackground(new Color(0,0,255));
        jpRegresarSemana.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarSemanaMouseMoved

    private void lblRegresarSemanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarSemanaMouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresarSemanaMouseClicked

    private void lblRegresarSemanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarSemanaMouseExited
        jpRegresarSemana.setBackground(new Color(0,80,255));
        jpRegresarSemana.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarSemanaMouseExited

    private void tfYearSemanaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfYearSemanaKeyTyped
        validarNumerosEnCamposYear(evt, tfYearSemana);
    }//GEN-LAST:event_tfYearSemanaKeyTyped

    private void jpCrearReporteSemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCrearReporteSemMouseMoved
        jpCrearReporteSem.setBackground(new Color(0,0,255));
        jpCrearReporteSem.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpCrearReporteSemMouseMoved

    private void jpCrearReporteSemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCrearReporteSemMouseExited
        jpCrearReporteSem.setBackground(new Color(0,80,255));
        jpCrearReporteSem.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpCrearReporteSemMouseExited

    private void jpRegresarSemanaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarSemanaMouseMoved
        jpRegresarSemana.setBackground(new Color(0,0,255));
        jpRegresarSemana.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpRegresarSemanaMouseMoved

    private void jpRegresarSemanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarSemanaMouseExited
        jpRegresarSemana.setBackground(new Color(0,80,255));
        jpRegresarSemana.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpRegresarSemanaMouseExited

    private void lblCrearReporteMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteMesMouseMoved
        jpCrearReporteMes.setBackground(new Color(0,0,255));
        jpCrearReporteMes.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReporteMesMouseMoved
    
    private void lblCrearReporteMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteMesMouseClicked
        try {
            conexionMySQL.consultaPorMes(cbxReporteMes.getSelectedItem().toString(), tfYearReporteMes.getText());
            lblReportePorMes.setText(String.valueOf(conexionMySQL.getCantClientesRecogidaDia()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        exportReporteMes("CantClientesRecogidoPaqueteMes", cbxReporteMes.getSelectedItem().toString(), lblReportePorMes.getText());
    }//GEN-LAST:event_lblCrearReporteMesMouseClicked

    private void lblCrearReporteMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteMesMouseExited
        jpCrearReporteMes.setBackground(new Color(0,80,255));
        jpCrearReporteMes.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReporteMesMouseExited

    private void jpCrearReporteMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCrearReporteMesMouseMoved
        jpCrearReporteMes.setBackground(new Color(0,0,255));
        jpCrearReporteMes.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpCrearReporteMesMouseMoved

    private void jpCrearReporteMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCrearReporteMesMouseExited
        jpCrearReporteMes.setBackground(new Color(0,80,255));
        jpCrearReporteMes.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpCrearReporteMesMouseExited

    private void lblRegresarMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMesMouseMoved
        jpRegresarMes.setBackground(new Color(0,0,255));
        jpRegresarMes.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarMesMouseMoved

    private void lblRegresarMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMesMouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresarMesMouseClicked

    private void lblRegresarMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMesMouseExited
        jpRegresarMes.setBackground(new Color(0,80,255));
        jpRegresarMes.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarMesMouseExited

    private void jpRegresarMesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarMesMouseMoved
        jpRegresarMes.setBackground(new Color(0,0,255));
        jpRegresarMes.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpRegresarMesMouseMoved

    private void jpRegresarMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarMesMouseExited
        jpRegresarMes.setBackground(new Color(0,80,255));
        jpRegresarMes.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpRegresarMesMouseExited

    private void tfYearReporteMesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfYearReporteMesKeyTyped
        validarNumerosEnCamposYear(evt, tfYearReporteMes);
    }//GEN-LAST:event_tfYearReporteMesKeyTyped

    private void lblCrearReportePorcRecgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecgMouseMoved
        jpCrearReportePorcRecg.setBackground(new Color(0,0,255));
        jpCrearReportePorcRecg.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReportePorcRecgMouseMoved

    private void lblCrearReportePorcRecgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecgMouseClicked
        conexionMySQL.getPorcentajePaquetesRecogido();   
        lblPorctjEntreg.setText(String.valueOf(conexionMySQL.getPorcentajePaqRecogidos())+"%");
        lblPorctjSinEntreg.setText(String.valueOf(conexionMySQL.getPorcentajePaqNoRecogidos())+"%");
        exportReporPorcentajePaqEntregSinEntreg("PorcientoPaquetesRecogidoYsinRecogerse", lblPorctjEntreg.getText(), lblPorctjSinEntreg.getText());
    }//GEN-LAST:event_lblCrearReportePorcRecgMouseClicked

    private void lblCrearReportePorcRecgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecgMouseExited
        jpCrearReportePorcRecg.setBackground(new Color(0,80,255));
        jpCrearReportePorcRecg.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReportePorcRecgMouseExited

    private void jpCrearReportePorcRecgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCrearReportePorcRecgMouseMoved
        jpCrearReportePorcRecg.setBackground(new Color(0,0,255));
        jpCrearReportePorcRecg.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpCrearReportePorcRecgMouseMoved

    private void jpCrearReportePorcRecgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCrearReportePorcRecgMouseExited
        jpCrearReportePorcRecg.setBackground(new Color(0,80,255));
        jpCrearReportePorcRecg.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpCrearReportePorcRecgMouseExited

    private void lblRegresarPPRMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPRMouseMoved
        jpRegresarPPR.setBackground(new Color(0,0,255));
        jpRegresarPPR.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarPPRMouseMoved

    private void lblRegresarPPRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPRMouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresarPPRMouseClicked

    private void lblRegresarPPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPRMouseExited
        jpRegresarPPR.setBackground(new Color(0,80,255));
        jpRegresarPPR.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarPPRMouseExited

    private void jpRegresarPPRMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarPPRMouseMoved
        jpRegresarPPR.setBackground(new Color(0,0,255));
        jpRegresarPPR.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpRegresarPPRMouseMoved

    private void jpRegresarPPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarPPRMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jpRegresarPPRMouseExited

    private void jpPorctjPaqRecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorctjPaqRecMouseExited
        jpRegresarPPR.setBackground(new Color(0,80,255));
        jpRegresarPPR.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorctjPaqRecMouseExited

    private void lblPorcentajeRecgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeRecgMouseClicked
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(true);
        jpDiaSemanaMayorRecog.setVisible(false);
        jpPorctjMuj.setVisible(false);
    }//GEN-LAST:event_lblPorcentajeRecgMouseClicked

    private void lblCrearReporteSem1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteSem1MouseMoved
        jpDiaMayorRecogida.setBackground(new Color(0,0,255));
        jpDiaMayorRecogida.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReporteSem1MouseMoved

    private void lblCrearReporteSem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteSem1MouseClicked
        //aqui va el reporte por dia por semana
        conexionMySQL.setDiaSemanaMayor(jtdia.getText(), cbxMes_DiaSemanaMayorR.getSelectedItem().toString(),tfYear_DiaSemanaMayorR1.getText());
        lblDiaSemanaMayorRec.setText(conexionMySQL.getDiaSemanaMayorRecogida());
        lblCantDiaSemanaMayorRec.setText(conexionMySQL.getCantidadDiaSemanaMayor());
        exportDiaSemanaMayorRecogida("DiaSemanaMayorRecogida", lblDiaSemanaMayorRec.getText(), lblCantDiaSemanaMayorRec.getText());
    }//GEN-LAST:event_lblCrearReporteSem1MouseClicked

    private void lblCrearReporteSem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReporteSem1MouseExited
        jpDiaMayorRecogida.setBackground(new Color(0,80,255));
        jpDiaMayorRecogida.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReporteSem1MouseExited

    private void jpDiaMayorRecogidaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDiaMayorRecogidaMouseMoved
        jpDiaMayorRecogida.setBackground(new Color(0,0,255));
        jpDiaMayorRecogida.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpDiaMayorRecogidaMouseMoved

    private void jpDiaMayorRecogidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDiaMayorRecogidaMouseExited
        jpDiaMayorRecogida.setBackground(new Color(0,80,255));
        jpDiaMayorRecogida.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpDiaMayorRecogidaMouseExited

    private void lblRegresarSemana1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarSemana1MouseMoved
        jpAtrasDiaMayorRecogida.setBackground(new Color(0,0,255));
        jpAtrasDiaMayorRecogida.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarSemana1MouseMoved

    private void lblRegresarSemana1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarSemana1MouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresarSemana1MouseClicked

    private void lblRegresarSemana1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarSemana1MouseExited
        jpAtrasDiaMayorRecogida.setBackground(new Color(0,80,255));
        jpAtrasDiaMayorRecogida.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarSemana1MouseExited

    private void jpAtrasDiaMayorRecogidaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAtrasDiaMayorRecogidaMouseMoved
        jpAtrasDiaMayorRecogida.setBackground(new Color(0,0,255));
        jpAtrasDiaMayorRecogida.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpAtrasDiaMayorRecogidaMouseMoved

    private void jpAtrasDiaMayorRecogidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAtrasDiaMayorRecogidaMouseExited
        jpAtrasDiaMayorRecogida.setBackground(new Color(0,80,255));
        jpAtrasDiaMayorRecogida.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpAtrasDiaMayorRecogidaMouseExited

    private void jtdiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtdiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtdiaKeyTyped

    private void lblSemanaRecogidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemanaRecogidaMouseClicked
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(true);
        jpPorctjMuj.setVisible(false);
        JOptionPane.showMessageDialog(null, "Introducir una fecha limite, donde se empieza \ndesde el 1ero del mes seleccionado hasta \nel dia introducido.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_lblSemanaRecogidaMouseClicked

    private void lblCrearReportePorcRecg1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecg1MouseMoved
        jpPorcentajeHombres.setBackground(new Color(0,0,255));
        jpPorcentajeHombres.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReportePorcRecg1MouseMoved

    private void lblCrearReportePorcRecg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecg1MouseClicked
        try {
            conexionMySQL.getPorcentajeClienteMascFem();
            lblPorctjHombres.setText(String.valueOf(conexionMySQL.getPorcentajeHombres())+"%");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        exportPorcentajeMujeresHombres("PorcientoClientesHombres", lblPorctjHombres.getText());

    }//GEN-LAST:event_lblCrearReportePorcRecg1MouseClicked

    private void lblCrearReportePorcRecg1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecg1MouseExited
        jpPorcentajeHombres.setBackground(new Color(0,80,255));
        jpPorcentajeHombres.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReportePorcRecg1MouseExited

    private void jpPorcentajeHombresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHombresMouseMoved
        jpPorcentajeHombres.setBackground(new Color(0,0,255));
        jpPorcentajeHombres.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpPorcentajeHombresMouseMoved

    private void jpPorcentajeHombresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHombresMouseExited
        jpPorcentajeHombres.setBackground(new Color(0,80,255));
        jpPorcentajeHombres.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorcentajeHombresMouseExited

    private void lblRegresarPPR1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPR1MouseMoved
        jpPorcentajeHombre.setBackground(new Color(0,0,255));
        jpPorcentajeHombre.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarPPR1MouseMoved

    private void lblRegresarPPR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPR1MouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresarPPR1MouseClicked

    private void lblRegresarPPR1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPR1MouseExited
        jpPorcentajeHombre.setBackground(new Color(0,80,255));
        jpPorcentajeHombre.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarPPR1MouseExited

    private void jpPorcentajeHombreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHombreMouseMoved
        jpPorcentajeHombre.setBackground(new Color(0,0,255));
        jpPorcentajeHombre.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpPorcentajeHombreMouseMoved

    private void jpPorcentajeHombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHombreMouseExited
        jpPorcentajeHombre.setBackground(new Color(0,80,255));
        jpPorcentajeHombre.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorcentajeHombreMouseExited

    private void jpPorctjHomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorctjHomMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jpPorctjHomMouseExited

    private void lblPorcentajeMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeMMouseClicked
        jpPorctjMuj.setVisible(true);
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
    }//GEN-LAST:event_lblPorcentajeMMouseClicked

    private void lblCrearReportePorcRecg2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecg2MouseMoved
        jpPorcentajeMujeres.setBackground(new Color(0,0,255));
        jpPorcentajeMujeres.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblCrearReportePorcRecg2MouseMoved
    
    private void lblCrearReportePorcRecg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecg2MouseClicked
        try {
            conexionMySQL.getPorcentajeClienteMascFem();
            lblPorctjMujeres.setText(String.valueOf(conexionMySQL.getPorcentajeMujeres()+"%"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        exportPorcentajeMujeresHombres("PorcientoClientesMujeres", lblPorctjMujeres.getText());
    }//GEN-LAST:event_lblCrearReportePorcRecg2MouseClicked
    
    private void lblCrearReportePorcRecg2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearReportePorcRecg2MouseExited
        jpPorcentajeMujeres.setBackground(new Color(0,80,255));
        jpPorcentajeMujeres.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblCrearReportePorcRecg2MouseExited
    
    private void jpPorcentajeMujeresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeMujeresMouseMoved
        jpPorcentajeMujeres.setBackground(new Color(0,0,255));
        jpPorcentajeMujeres.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpPorcentajeMujeresMouseMoved
    
    private void jpPorcentajeMujeresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeMujeresMouseExited
        jpPorcentajeMujeres.setBackground(new Color(0,80,255));
        jpPorcentajeMujeres.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpPorcentajeMujeresMouseExited
    
    private void lblRegresarPPR2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPR2MouseMoved
        jpRegresarPorcentajeMujeres.setBackground(new Color(0,0,255));
        jpRegresarPorcentajeMujeres.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_lblRegresarPPR2MouseMoved
    
    private void lblRegresarPPR2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPR2MouseClicked
       this.setVisible(false);
       this.dispose();
       AdministradorGrafica administradorGrafica = new AdministradorGrafica();
       administradorGrafica.setVisible(true);
    }//GEN-LAST:event_lblRegresarPPR2MouseClicked
    
    private void lblRegresarPPR2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarPPR2MouseExited
        jpRegresarPorcentajeMujeres.setBackground(new Color(0,80,255));
        jpRegresarPorcentajeMujeres.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_lblRegresarPPR2MouseExited
    
    private void jpRegresarPorcentajeMujeresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarPorcentajeMujeresMouseMoved
        jpRegresarPorcentajeMujeres.setBackground(new Color(0,0,255));
        jpRegresarPorcentajeMujeres.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_jpRegresarPorcentajeMujeresMouseMoved
    
    private void jpRegresarPorcentajeMujeresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRegresarPorcentajeMujeresMouseExited
        jpRegresarPorcentajeMujeres.setBackground(new Color(0,80,255));
        jpRegresarPorcentajeMujeres.setForeground(new Color(0,80,255));
    }//GEN-LAST:event_jpRegresarPorcentajeMujeresMouseExited

    private void jpPorctjMujMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorctjMujMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jpPorctjMujMouseExited

    private void tfYear_DiaSemanaMayorR1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfYear_DiaSemanaMayorR1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfYear_DiaSemanaMayorR1KeyTyped
    
    private void lblPorcentajeHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPorcentajeHMouseClicked
        jpPorctjMuj.setVisible(false);
        jpPorctjHom.setVisible(true);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
    }//GEN-LAST:event_lblPorcentajeHMouseClicked
    
    private void jpPorcentajeMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeMMouseClicked
        jpPorctjMuj.setVisible(true);
        jpPorctjHom.setVisible(false);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
    }//GEN-LAST:event_jpPorcentajeMMouseClicked
    
    private void jpPorcentajeHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPorcentajeHMouseClicked
        jpPorctjMuj.setVisible(false);
        jpPorctjHom.setVisible(true);
        jpCantMes.setVisible(false);
        jpCantSem.setVisible(false);
        jpCantDia.setVisible(false);
        jpPorctjPaqRec.setVisible(false);
        jpDiaSemanaMayorRecog.setVisible(false);
    }//GEN-LAST:event_jpPorcentajeHMouseClicked
    
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
            java.util.logging.Logger.getLogger(ReporteRecogidasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteRecogidasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteRecogidasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteRecogidasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteRecogidasPaquetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel cantidad10;
    private javax.swing.JLabel cantidad11;
    private javax.swing.JLabel cantidad12;
    private javax.swing.JLabel cantidad13;
    private javax.swing.JLabel cantidad14;
    private javax.swing.JLabel cantidad3;
    private javax.swing.JLabel cantidad4;
    private javax.swing.JLabel cantidad5;
    private javax.swing.JLabel cantidad6;
    private javax.swing.JLabel cantidad7;
    private javax.swing.JLabel cantidad8;
    private javax.swing.JLabel cantidad9;
    private javax.swing.JComboBox<String> cbxMesSemana;
    private javax.swing.JComboBox<String> cbxMes_DiaSemanaMayorR;
    private javax.swing.JComboBox<String> cbxReporteMes;
    private javax.swing.JComboBox<String> cbxSemana;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpAtrasDiaMayorRecogida;
    private javax.swing.JPanel jpCantClienMes;
    private javax.swing.JPanel jpCantClienteDia;
    private javax.swing.JPanel jpCantClienteSem;
    private javax.swing.JPanel jpCantDia;
    private javax.swing.JPanel jpCantMes;
    private javax.swing.JPanel jpCantSem;
    private javax.swing.JPanel jpCrearReporteDia;
    private javax.swing.JPanel jpCrearReporteMes;
    private javax.swing.JPanel jpCrearReportePorcRecg;
    private javax.swing.JPanel jpCrearReporteSem;
    private javax.swing.JPanel jpDiaMayorRecogida;
    private javax.swing.JPanel jpDiaSemanaMayorRecog;
    private javax.swing.JPanel jpPorcentajeH;
    private javax.swing.JPanel jpPorcentajeHombre;
    private javax.swing.JPanel jpPorcentajeHombres;
    private javax.swing.JPanel jpPorcentajeM;
    private javax.swing.JPanel jpPorcentajeMujeres;
    private javax.swing.JPanel jpPorcentajeRecg;
    private javax.swing.JPanel jpPorctjHom;
    private javax.swing.JPanel jpPorctjMuj;
    private javax.swing.JPanel jpPorctjPaqRec;
    private javax.swing.JPanel jpRegresar;
    private javax.swing.JPanel jpRegresar2;
    private javax.swing.JPanel jpRegresar3;
    private javax.swing.JPanel jpRegresarMes;
    private javax.swing.JPanel jpRegresarPPR;
    private javax.swing.JPanel jpRegresarPorcentajeMujeres;
    private javax.swing.JPanel jpRegresarSemana;
    private javax.swing.JPanel jpSemanaRecogida;
    private javax.swing.JTextField jtdia;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblBarraTitulo;
    private javax.swing.JLabel lblBy;
    private javax.swing.JLabel lblCantClienMes;
    private javax.swing.JLabel lblCantClienteSem;
    private javax.swing.JLabel lblCantClientes;
    private javax.swing.JLabel lblCantDiaSemanaMayorRec;
    private javax.swing.JLabel lblCantidadDia;
    private javax.swing.JLabel lblCantidadSem;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblCrearReporteDia;
    private javax.swing.JLabel lblCrearReporteMes;
    private javax.swing.JLabel lblCrearReportePorcRecg;
    private javax.swing.JLabel lblCrearReportePorcRecg1;
    private javax.swing.JLabel lblCrearReportePorcRecg2;
    private javax.swing.JLabel lblCrearReporteSem;
    private javax.swing.JLabel lblCrearReporteSem1;
    private javax.swing.JLabel lblDiaSemanaMayorRec;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblLYC;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMes1;
    private javax.swing.JLabel lblMes2;
    private javax.swing.JLabel lblMes3;
    private javax.swing.JLabel lblMes4;
    private javax.swing.JLabel lblMes5;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblPaqEntreg;
    private javax.swing.JLabel lblPaqEntreg1;
    private javax.swing.JLabel lblPaqEntreg2;
    private javax.swing.JLabel lblPaqSinEntreg;
    private javax.swing.JLabel lblPaquete;
    private javax.swing.JLabel lblPorcentajeH;
    private javax.swing.JLabel lblPorcentajeM;
    private javax.swing.JLabel lblPorcentajeRecg;
    private javax.swing.JLabel lblPorctjEntreg;
    private javax.swing.JLabel lblPorctjHombres;
    private javax.swing.JLabel lblPorctjMujeres;
    private javax.swing.JLabel lblPorctjSinEntreg;
    private javax.swing.JLabel lblRegresar1;
    private javax.swing.JLabel lblRegresar2;
    private javax.swing.JLabel lblRegresar3;
    private javax.swing.JLabel lblRegresarMes;
    private javax.swing.JLabel lblRegresarPPR;
    private javax.swing.JLabel lblRegresarPPR1;
    private javax.swing.JLabel lblRegresarPPR2;
    private javax.swing.JLabel lblRegresarSemana;
    private javax.swing.JLabel lblRegresarSemana1;
    private javax.swing.JLabel lblRepaq2;
    private javax.swing.JLabel lblRepaqIcon;
    private javax.swing.JLabel lblReportePorMes;
    private javax.swing.JLabel lblSemana;
    private javax.swing.JLabel lblSemana1;
    private javax.swing.JLabel lblSemanaRecogida;
    private javax.swing.JTextField tfDia;
    private javax.swing.JTextField tfYearReporteMes;
    private javax.swing.JTextField tfYearSemana;
    private javax.swing.JTextField tfYear_DiaSemanaMayorR1;
    // End of variables declaration//GEN-END:variables
}
