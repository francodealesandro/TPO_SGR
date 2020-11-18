package model;

import java.util.Date;

public class Aporte {
    private float monto;
    private Date fecha;

    public Aporte(float monto) {
        this.monto = monto;
        this.fecha = new Date();
    }
}
