
package com.recogidapaquete.base;

public class Cliente extends TipoUsuario {
    
    private String nombre;
    private String apellido;
    private String direccion;
    private String sexo;
    private String usuario;
    private String contrasena;
    private String correo;
    private String idCliente;
    
    public Cliente(Mediador mediador){
        super(mediador);
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public String getCorreo() {
        return correo;
    }

    public String getIdCliente() {
        return idCliente;
    }
    
    @Override
    public void sendTipo(String usuario, String password) {
        
       mediador.tipo(usuario, password, this);
       this.usuario = usuario;
       this.contrasena = password;
       
    }
    
}
