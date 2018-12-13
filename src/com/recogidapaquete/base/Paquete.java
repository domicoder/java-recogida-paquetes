
package com.recogidapaquete.base;

public class Paquete {
    private String id_paquete;
    private String id_cliente;
    private String tipoPaquete;
    private String descripcion;
    private Estados estado;
    private static String estadoValido;
    private String ubicacion;
    private String fecha;
    
    public Paquete(){
    }
    
    public Paquete(String estado) {
        this.estadoValido = estado;
    }
    
    //Getters
    public String getTipoPaquete() {
        return tipoPaquete;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getEstadoValido() {
        return estadoValido;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getId_paquete() {
        return id_paquete;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    //Setters

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public void ejecutarAccion(){
        estado.ejecutarAccion();
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setId_paquete(String id_paquete) {
        this.id_paquete = id_paquete;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    
}
