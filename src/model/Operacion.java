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

    public Operacion(LineaDeCredito linea, int tipoOperacion, float monto, Date fecha)
    {
        this.numeroCertificadoGarantia = idBase;
        idBase ++;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.fecha = fecha;
        linea.addOperacion(this);
        if(linea.calcularRestante() >= monto){
            this.estado = "Con certificado emitido";
            this.certificadoEmitido = true;
        }else {
            this.estado = "Ingresado";
            this.certificadoEmitido = false;
        }




    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public String getEstado() {
        return estado;
    }

    abstract Date getFecha();

    public int getNumeroCertificadoGarantia(){ return numeroCertificadoGarantia;}

    public float getMonto(){
        return monto;
    }

    public boolean getCertificadoEmitido(){
        return this.certificadoEmitido;
    }

}
