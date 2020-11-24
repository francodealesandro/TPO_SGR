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

    public float getCantidad(){
        return this.cantidad;
    }

    public String getEstado(){ return this.estado;}

    public void setEstado(String s){
        this.estado = s;
    }

}
