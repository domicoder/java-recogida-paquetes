
package com.recogidapaquete.base;

public class Disponible implements Estados {
    //Using Status Pattern para avisar si el paquete esta disponible
    @Override
    public void ejecutarAccion() {
        String disponible = "Disponible";
        Paquete paquete = new Paquete(disponible);
    }

}
