package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineaDeCredito {
    private Date fechaVigencia;
    private float monto;
    private int numeroSocio;
    private String tipoOperacionCredito;

    private final List<Operacion> listaOperaciones = new ArrayList<>();

    public LineaDeCredito() {

    }

    public void riegoVivo() {

    }

    public float calcularRestante() {
        float respuesta = listaOperaciones.stream().map(x -> x.getMonto()).reduce(monto,(x,y) -> x - y );
        return respuesta;
    }

    public float calcularUtilizado() {
        return monto - this.calcularRestante();
    }

    public List<Operacion> getOperaciones(){
        return listaOperaciones;
    }

    public void addOperacion(Operacion o){
        this.listaOperaciones.add(o);
    }
}

