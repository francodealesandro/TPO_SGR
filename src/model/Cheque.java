package model;

import javax.sound.sampled.Line;
import java.util.Date;

public class Cheque extends Operacion {
    private int numero;
    private Date fechaVencimiento;
    private String cuitFirmante;
    private String banco;

    public Cheque(LineaDeCredito linea,int tipoOperacion, float monto, Date fecha, int numero,
                  Date fechaVencimiento, String cuitFirmante, String banco)
    {
        super(linea, tipoOperacion,monto,fecha);

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
