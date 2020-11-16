package model;

import java.util.Date;
import java.util.List;

public class Socio {
    private int socioID;
    private int cuit;

    private String razonSocial;
    private Date fechaInicioActividades;
    private TipoEmpresa tipoEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private int telefono;
    private String correo;
    private boolean esParticipe;

    private LineaDeCredito lineaDeCredito;

    public Socio(Boolean esParticipe,
                 int cuit,
                 String razonSocial,
                 Date fechaInicioActividades,
                 TipoEmpresa tipoEmpresa,
                 String actividadPrincipal,
                 String direccion,
                 int telefono,
                 String correo) {
        this.esParticipe = esParticipe;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaInicioActividades = fechaInicioActividades;
        this.tipoEmpresa = tipoEmpresa;
        this.actividadPrincipal = actividadPrincipal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;

    }
    public void subcribirAccionesSGR(List<Acciones> acciones){

    }

    public void cambiarEstado(){

    }

    public void controlPostulantes(){

    }

    public void retirarAportes(){

    }

    public int getCuit() {
        return cuit;
    }

    public Date getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean esParticipe() {
        return esParticipe;
    }

    public boolean esProtector() {
        return !esParticipe;
    }

    public String getNombre(){
        return razonSocial;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
