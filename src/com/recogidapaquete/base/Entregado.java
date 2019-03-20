
package com.recogidapaquete.base;

public class Entregado implements Estados{
    //Using Status Pattern para avisar si el paquete fue entregado
    @Override
    public void ejecutarAccion() {
        String entregado = "Entregado";
        Paquete paquete = new Paquete(entregado);
    }

}
