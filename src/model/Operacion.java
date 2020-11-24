package model;

import java.util.Date;

public abstract class Operacion {
    private int numeroCertificadoGarantia;
    private int tipoOperacion;
    private String estado;
    private float monto;
    private boolean certificadoEmitido;
    protected Date fecha;
    private Comision comision = null;
    static int idBase = 0;

    public void calcularComiciones() {

    }

    public void cambiarEstado(String estado) {
        this.estado = estado;

    }

    public void factibilidad() {

    }

    public Operacion(LineaDeCredito linea, int tipoOperacion, float monto, Date fecha) {
        this.numeroCertificadoGarantia = idBase;
        idBase++;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.fecha = fecha;
        linea.addOperacion(this);
        if (linea.calcularRestante() >= monto) {
            this.estado = "Con certificado emitido";
            this.certificadoEmitido = true;
        } else {
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

    public abstract Date getFecha();

    public int getNumeroCertificadoGarantia() {
        return numeroCertificadoGarantia;
    }

    public float getMonto() {
        return monto;
    }

    public boolean getCertificadoEmitido() {
        return this.certificadoEmitido;
    }

    public String getTipoOperacionString() {
        String respuesta = "";
        switch (tipoOperacion) {
            case 1:
                respuesta = "Cheques";
                break;
            case 2:
                respuesta = "Cuentas corrientes/tarjetas de credito";
                break;
            case 3:
                respuesta = "Prestamos";
                break;
        }
        return respuesta;
    }

    abstract float getMontoComision();

    public void addComision(){

        Comision c = new Comision(
                this.getNumeroCertificadoGarantia(),
                this.getMonto() * getMontoComision()
        );
        this.comision = c;

    }

    public Comision getComision() {
        return comision;
    }

}