package model;

import javax.sound.sampled.Line;
import java.util.Date;

public class Cheque extends Operacion {
    private int numero;
    private Date fechaVencimiento;
    private String cuitFirmante;
    private int tasaDeDescuento;

    private String banco;

    public Cheque(LineaDeCredito linea,int tipoOperacion, float monto, Date fecha, int numero,
                  Date fechaVencimiento, String cuitFirmante, String banco, int tasa)
    {
        super(linea, tipoOperacion,monto,fecha);

        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cuitFirmante = cuitFirmante;
        this.banco = banco;
        this.tasaDeDescuento = tasa;


    }

    @Override
    public Date getFecha() {
        return fechaVencimiento;
    }

    @Override
    public float getMontoComision() {
        return 3;
    }

    public void calcularTasaDescuento() {

    }

    public boolean estaVencido() {
        return false;
    }

    public String getBanco() {
        return banco;
    }

}
