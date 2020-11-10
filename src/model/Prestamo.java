package model;

import java.util.Date;

public class Prestamo extends Operacion {
    private String banco;
    private int importeTotal;
    private int tasa;
    private Date fechaAcreditacion;
    private int cantidadCuotas;
    private String sistema;

    public Prestamo(){

    }

    @Override
    public Date getFecha() {
        return fechaAcreditacion;
    }
}
