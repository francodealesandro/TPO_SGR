package model;

import java.util.Date;

public class Prestamo extends Operacion {
    private String banco;
    private float tasa;
    private Date fechaAcreditacion;
    private int cantidadCuotas;
    private String sistema;

    public Prestamo(int numeroCertificadoGarantia, int tipoOperacion, String estado, float monto, boolean certificadoEmitido, Date fecha,String banco,
            float tasa, Date fechaAcreditacion, int cantidadCuotas, String sistema)
    {
        super(numeroCertificadoGarantia,tipoOperacion,estado,monto,certificadoEmitido,fecha);
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
