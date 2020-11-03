package model;

import java.util.Date;

public abstract class Operacion {
    private int numeroCertificadoGarantia;
    private String tipoOperacion;
    private String estado;
    private int monto;
    private boolean certificadoEmitido;
    protected Date fecha;

    public void calcularComiciones(){

    }

    public void cambiarEstado() {

    }

    public void factibilidad(){

    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public String getEstado() {
        return estado;
    }

    abstract void getFecha();
}
