package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineaDeCredito {
    private Date fechaVigencia;
    private int monto;
    private int numeroSocio;
    private String tipoOperacionCredito;

    private final List<Operacion> listaOperaciones = new ArrayList<>();

    public LineaDeCredito() {

    }

    public void riegoVivo() {

    }

    public int calcularRestante() {
        return 0;
    }

    public int calcularUtilizado() {
        return monto - this.calcularRestante();
    }

    public List<Operacion> getOperaciones(){
        return listaOperaciones;
    }
}

