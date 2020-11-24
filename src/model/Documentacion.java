package model;

import controler.CambioEstadoController;

import java.util.Date;

public class Documentacion {
    private String tipoDoc;
    private Date fechaRecepcion;
    private EstadoDocumentacion estado;
    private boolean esObligatoria;
    private boolean esDeseable;

    @Override
    public String toString() {
        return tipoDoc;
    }

    public Documentacion(String tipoDoc, Date fechaRecepcion, boolean esObligatoria, boolean esDeseable) {
        this.tipoDoc = tipoDoc;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = EstadoDocumentacion.INGRESADO;
        this.esObligatoria = esObligatoria;
        this.esDeseable = esDeseable;
    }

    public void cambiarEstado(EstadoDocumentacion estado){
        CambioEstadoController.getInstance().GuardarCambio(this.estado.toString(), estado.toString());
        this.estado = estado;
    }

    public EstadoDocumentacion getEstado() {
        return estado;
    }

}
