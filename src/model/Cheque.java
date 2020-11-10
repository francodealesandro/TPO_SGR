package model;

import java.util.Date;

public class Cheque extends Operacion {
    private int numero;
    private Date fechaVencimiento;
    private int cuitFirmante;
    private String banco;
    private float valor;

    @Override
    Date getFecha() {
        return fechaVencimiento;
    }

    public void calcularTasaDescuento() {

    }

    public boolean estaVencido() {
        return false;
    }

    public float getValor() {
        return valor;
    }
}
