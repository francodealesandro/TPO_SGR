package model;

import java.util.Date;

public class Prestamo extends Operacion {
    private String banco;
    private float tasa;
    private Date fechaAcreditacion;
    private int cantidadCuotas;
    private String sistema;

    public Prestamo(LineaDeCredito linea,  int tipoOperacion, float monto,Date fecha,String banco,
            float tasa, Date fechaAcreditacion, int cantidadCuotas, String sistema)
    {
        super(linea, tipoOperacion,monto,fecha);
        this.banco = banco;
        this.tasa = tasa;
        this.fechaAcreditacion = fechaAcreditacion;
        this.cantidadCuotas = cantidadCuotas;
        this.sistema = sistema;


    }
    @Override
    public Date getFecha() {
        return fechaAcreditacion;
    }
}
