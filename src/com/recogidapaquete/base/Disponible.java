
package com.recogidapaquete.base;

public class Disponible implements Estados {
    
    @Override
    public void ejecutarAccion() {
        String disponible = "Disponible";
        Paquete paquete = new Paquete(disponible);
    }

}
