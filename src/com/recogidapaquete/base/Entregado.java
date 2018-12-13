
package com.recogidapaquete.base;

public class Entregado implements Estados{

    @Override
    public void ejecutarAccion() {
        String entregado = "Entregado";
        Paquete paquete = new Paquete(entregado);
    }

}
