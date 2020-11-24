package model;

import java.util.Date;

public class CambioEstado {
    private String estadoAnterior;
    private String estadoNuevo;
    private Date fechaDeCambio;

    public CambioEstado(String estadoAnterior, String estadoNuevo){
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.fechaDeCambio = new Date();
    }
}
