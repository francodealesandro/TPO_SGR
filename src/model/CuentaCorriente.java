package model;

import java.util.Date;

public class CuentaCorriente extends Operacion {
    private String empresa;
    private Date fechaVencimiento;

    public CuentaCorriente(int tipoOperacion, String estado, float monto, boolean certificadoEmitido, Date fecha, String empresa,
                           Date fechaVencimiento)
    {
        super(tipoOperacion,estado,monto,certificadoEmitido,fecha);
        this.empresa = empresa;
        this.fechaVencimiento = fechaVencimiento;


    }

    @Override
    Date getFecha() {
        return fechaVencimiento;
    }
}
