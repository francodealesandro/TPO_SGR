package model;

import java.util.Date;

public class Cheque extends Operacion {
    private int numero;
    private Date fechaVencimiento;
    private String cuitFirmante;
    private String banco;

    public Cheque(int tipoOperacion, String estado, float monto, boolean certificadoEmitido, Date fecha, int numero,
                  Date fechaVencimiento, String cuitFirmante, String banco)
    {
        super(tipoOperacion,estado,monto,certificadoEmitido,fecha);

        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cuitFirmante = cuitFirmante;
        this.banco = banco;


    }

    @Override
    Date getFecha() {
        return fechaVencimiento;
    }

    public void calcularTasaDescuento() {

    }

    public boolean estaVencido() {
        return false;
    }

}
