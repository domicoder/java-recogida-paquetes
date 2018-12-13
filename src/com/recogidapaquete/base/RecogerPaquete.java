
package com.recogidapaquete.base;

import java.util.ArrayList;

public class RecogerPaquete implements Subject{
    
    private String fechaEspecifica = "";
    private ArrayList<Observer> listaObserver;

    public RecogerPaquete(){
        listaObserver = new ArrayList<Observer>();
    }
    
    //Getters
    public String getFechaEspecifica() {
        return fechaEspecifica;
    }
    
    //Setters
    public void setFechaEspecifica(String fechaEspecifica) {
        this.fechaEspecifica = fechaEspecifica;
        notificar();
    }
    
    //Enlazar objetos observadores
    public void enlazarObserver(Observer observer){
        listaObserver.add(observer);
    }
    
    //Metodo que ejecuta el sujeto RecogerPaquete y le informa a su observador
    @Override
    public void notificar() {
        for (Observer  observer: listaObserver) {
            observer.update();
        }
    }
    
}
