package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineaDeCredito {
    private Date fechaVencimiento;
    private float monto;
    private int numeroSocio;
    private int tipoOperacionCredito;

    private final List<Operacion> listaOperaciones = new ArrayList<>();

    public LineaDeCredito() {

    }
    public LineaDeCredito(Date fechaV, float total, Socio socio, int tipoOperacion)
    {
        this.fechaVencimiento = fechaV;
        this.monto = total;
        this.numeroSocio = socio.getID();
        this.tipoOperacionCredito = tipoOperacion;
        socio.setLineaDeCredito(this);
    }

    public void riesgoVivo() {

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

    public float getMonto() {
        return monto;
    }
    public int getIdSocio() {return this.numeroSocio;}
    public Date getFechaVencimiento(){
        return this.fechaVencimiento;
    }
    public int getTipoOperacionCredito(){return this.tipoOperacionCredito;}
}

