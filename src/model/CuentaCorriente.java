package model;

import java.util.Date;

public class CuentaCorriente extends Operacion {
    private String empresa;
    private int importeTotal;
    private Date fechaVencimiento;

    @Override
    Date getFecha() {
        return fechaVencimiento;
    }
}
