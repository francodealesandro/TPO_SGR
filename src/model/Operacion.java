package model;

import java.util.Date;

public abstract class Operacion {
    private int numeroCertificadoGarantia;
    private int tipoOperacion;
    private String estado;
    private float monto;
    private boolean certificadoEmitido;
    protected Date fecha;

    static int idBase = 0;

    public void calcularComiciones(){

    }

    public void cambiarEstado() {

    }

    public void factibilidad(){

    }

    public Operacion(int tipoOperacion, String estado, float monto, boolean certificadoEmitido, Date fecha)
    {
        this.numeroCertificadoGarantia = idBase;
        idBase ++;
        this.tipoOperacion = tipoOperacion;
        this.estado = estado;
        this.monto = monto;
        this.certificadoEmitido = certificadoEmitido;
        this.fecha = fecha;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public String getEstado() {
        return estado;
    }

    abstract Date getFecha();

    public int getNumeroCertificadoGarantia(){ return numeroCertificadoGarantia;}


}
