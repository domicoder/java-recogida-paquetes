
package com.recogidapaquete.base;

public class Receptor extends TipoUsuario {

    private String usuario;
    private String contrasena;
    
    public Receptor(Mediador mediador) {
        super(mediador);
    }
    
    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    @Override
    public void sendTipo(String usuario, String password) {
       
       mediador.tipo(usuario, password, this);
       this.usuario = usuario;
       this.contrasena = password;
       
    }
    
}
