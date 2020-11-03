package model;

import java.util.Date;

public class Documentacion {
    private String tipoDoc;
    private Date fechaRecepcion;
    private String estado;
    private boolean esObligatoria;
    private boolean esDeseable;

    public void cambiarEstado(String estado)
    {
        this.estado = estado;
    }
}
