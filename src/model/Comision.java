package model;

public class Comision {

    private String estado;
    private float cantidad;
    private int idOperacion;

    public Comision(int idOp, float monto){
        this.idOperacion = idOp;
        this.cantidad = monto;
        this.estado = "Calculada";
    }

}
