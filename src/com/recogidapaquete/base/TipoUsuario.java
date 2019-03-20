
package com.recogidapaquete.base;

/**
 *
 * @author El cibernetico
 */

public abstract class TipoUsuario {
    //Creanto variable de tipo Mediador
    protected Mediador mediador;
    
    public TipoUsuario(Mediador mediador){
        this.mediador = mediador;
    }
    
    public abstract void sendTipo(String usuario, String password);
    
}
