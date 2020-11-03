package model;

import java.util.Date;
import java.util.List;

public class Socio {
    private int socioID;
    private int cuit;
    private String razonSocial;
    private Date fechaInicioActividades;
    private String tipo;
    private String actividadPrincipal;
    private String direccion;
    private int telefono;
    private String correo;
    private boolean esProtector;
    private boolean esParticipe;

    private LineaDeCredito lineaDeCredito;

    public Socio() {

    }

    public void subcribirAccionesSGR(List<Acciones> acciones){

    }

    public void cambiarEstado(){

    }

    public void controlPostulantes(){

    }

    public void retirarAportes(){

    }

    public int getSocioID(){
        return socioID;
    }

    public LineaDeCredito getLineaDeCredito() {
        return lineaDeCredito;
    }

    public String getNombre(){
        return razonSocial;
    }
}
