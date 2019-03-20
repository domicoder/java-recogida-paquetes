
package com.recogidapaquete.base;

public class Receptor extends TipoUsuario {

    private String usuario;
    private String contrasena;
    //Recibe un tipo de dato mediador para verificar que tipo de usuario es y sus datos, en este caso -receptor-
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
    //Envia el tipo de usuario que es y sus datos, en este caso -receptor-
    @Override
    public void sendTipo(String usuario, String password) {
       
       mediador.tipo(usuario, password, this);
       this.usuario = usuario;
       this.contrasena = password;
       
    }
    
}
