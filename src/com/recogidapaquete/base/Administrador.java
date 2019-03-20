
package com.recogidapaquete.base;

public class Administrador extends TipoUsuario {
    
    private String usuario;
    private String contrasena;
    //Constructor recibe mediator (Design Pattern) y se iguala a la clase Padre desde donde extiende TipoUsuario
    public Administrador(Mediador mediador) {
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
    //Using Observer Mediator para indicar que tipo de usuario es el que inicia sesion
    @Override
    public void sendTipo(String usuario, String password) {
       
       mediador.tipo(usuario, password, this);
       this.usuario = usuario;
       this.contrasena = password;
       
    }
    
}
