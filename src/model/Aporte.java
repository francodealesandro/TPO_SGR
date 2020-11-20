package model;

import java.util.Date;

public class Aporte {
    private float monto;
    private Date fecha;

    @Override
    public String toString() {
        return String.valueOf(monto);
    }

    public Aporte(float monto) {
        this.monto = monto;
        this.fecha = new Date();
    }
}
