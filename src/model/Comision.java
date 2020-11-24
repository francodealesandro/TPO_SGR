package model;

import controler.CambioEstadoController;

public class Comision {

    private String estado;

    private float cantidad;
    private int idOperacion;


    public Comision(int idOp, float monto){
        this.idOperacion = idOp;
        this.cantidad = monto;
        this.estado = "Calculada";
    }

    public float getCantidad(){
        return this.cantidad;
    }

    public String getEstado(){ return this.estado;}

    public void cambiarEstado(String s){
        CambioEstadoController.getInstance().GuardarCambio(this.estado, s);
        this.estado = s;
    }

}
