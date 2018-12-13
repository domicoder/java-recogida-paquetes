
package com.recogidapaquete.base;

import com.recogidapaquete.BD.ConexionMySQL;
import com.recogidapaquete.interfaces.*;
import javax.swing.JOptionPane;

public class MediadorConcreto implements Mediador{
    
    private Cliente cliente;
    private Receptor receptor;
    private Administrador administrador;
    public static int ocultar;
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }
    
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    @Override
    public void tipo(String usuario, String contrasena, TipoUsuario tipousuario) {
        ConexionMySQL conexionMySQL = ConexionMySQL.getInstance();
        AdministradorGrafica administradorGrafica =  new AdministradorGrafica();
        ReceptorGrafica receptorGrafica = new ReceptorGrafica();
        ClienteGrafica clienteGrafica = new ClienteGrafica();
        
        if (tipousuario == cliente) {
            if (conexionMySQL.confirmacionLogin("cliente", usuario, contrasena) == 1) {
                ocultar += 1;
                clienteGrafica.setVisible(true);
                clienteGrafica.lblVerPerfilRgresarAdmin.setVisible(false);
                clienteGrafica.jpVerPerfilRgresarAdmin.setVisible(false);
                cliente.setUsuario(usuario);
                clienteGrafica.setMediadorConcretoConUsuario(cliente);
            } else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tipousuario == receptor) {
            if (conexionMySQL.confirmacionLogin("receptor", usuario, contrasena) == 1) {
                ocultar += 1;
                receptorGrafica.mostrarDatos();
                receptorGrafica.setVisible(true);
                receptorGrafica.lblRegresarAdministrador.setVisible(false);
                receptorGrafica.jpRegresarAdministrador.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (tipousuario == administrador) {
            if (conexionMySQL.confirmacionLogin("administrador", usuario, contrasena) == 1) {
                ocultar += 1;
                administradorGrafica.setVisible(true);
                receptorGrafica.lblRegresarAdministrador.setVisible(true);
                receptorGrafica.jpRegresarAdministrador.setVisible(true);
                clienteGrafica.lblVerPerfilRgresarAdmin.setVisible(true);
                clienteGrafica.jpVerPerfilRgresarAdmin.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }        
        }
    
    }
    
}
