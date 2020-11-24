package model;

import java.util.Calendar;
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

    @Override
    float getMontoComision() {
        return 4;
    }

    public int getCantidadCuotas(){
        return this.cantidadCuotas;
    }

    public int getCantidadCuotasImpagas(){
        Date actual = new Date();

        Calendar fechaAcredita = Calendar.getInstance();
        Calendar fechaFinalPagos = Calendar.getInstance();
        fechaAcredita.setTime(this.fechaAcreditacion);
        fechaFinalPagos.setTime(this.fechaAcreditacion);
        fechaFinalPagos.add(Calendar.MONTH,this.cantidadCuotas);

        if(fechaFinalPagos.getTime().before(actual)){
            return 0;
        }else{
            int coutasImpagas = 0;
            while(fechaAcredita.before(actual)){
                coutasImpagas += 1;
                fechaAcredita.add(Calendar.MONTH, 1);
            }
            return coutasImpagas;
        }
    }
}
