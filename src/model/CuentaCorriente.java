package model;

import javax.sound.sampled.Line;
import java.util.Date;

public class CuentaCorriente extends Operacion {
    private String empresa;
    private Date fechaVencimiento;

    public CuentaCorriente(LineaDeCredito linea,int tipoOperacion, float monto, Date fecha, String empresa,
                           Date fechaVencimiento)
    {
        super(linea, tipoOperacion,monto,fecha);
        this.empresa = empresa;
        this.fechaVencimiento = fechaVencimiento;


    }

    @Override
    Date getFecha() {
        return fechaVencimiento;
    }
}
