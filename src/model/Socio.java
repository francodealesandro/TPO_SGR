package model;

import utils.Lista;

import java.util.Date;

public class Socio {
    private String cuit;
    private String razonSocial;
    private Date fechaInicioActividades;
    private TipoEmpresa tipoEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private int telefono;
    private String correo;
    private boolean esParticipe;
    private EstadoSocio estado = EstadoSocio.POSTULANTE_A_SOCIO;

    private LineaDeCredito lineaDeCredito;

    private Lista<Accionista> accionistas = new Lista<>();
    private Lista<Documentacion> documentaciones = new Lista<>();
    private Lista<Aporte> aportes = new Lista<>();

    public Socio(Boolean esParticipe,
                 String cuit,
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

    public void cambiarEstado(){

    }

    public void controlPostulantes(){

    }

    public void retirarAportes(){

    }

    public String getCuit() { return cuit; }

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

    public Lista<Accionista> getAccionistas() { return accionistas; }

    public void setAccionistas(Lista<Accionista> accionistas) {
        this.accionistas = accionistas;
    }

    public Lista<Documentacion> getDocumentaciones() {
        return documentaciones;
    }

    public void setDocumentaciones(Lista<Documentacion> documentaciones) {
        this.documentaciones = documentaciones;
    }

    public Lista<Aporte> getAportes() {
        return aportes;
    }

    public void setAportes(Lista<Aporte> aportes) {
        this.aportes = aportes;
    }

    public LineaDeCredito getLineaDeCredito() {
        return lineaDeCredito;
    }

    public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }

    @Override
    public String toString() {
        return this.getNombre() + (estado == EstadoSocio.POSTULANTE_A_SOCIO ? " (Postulante a socio)" : " (Socio pleno)");
    }

    public EstadoSocio getEstado() {
        return estado;
    }

    public void Aceptar() throws ExceptionDocumentacionNoAprobada {
        boolean documentacionesAprobadas = this.documentaciones.get().stream()
                .filter(x -> x.getEstado() != EstadoDocumentacion.RECHAZADO)
                .allMatch(x -> x.getEstado() == EstadoDocumentacion.CONTROLADO);
        if (documentacionesAprobadas)
            this.estado = EstadoSocio.SOCIO_PLENO;
        else
            throw new ExceptionDocumentacionNoAprobada(this.documentaciones.get().stream()
                    .filter(x -> x.getEstado() == EstadoDocumentacion.INGRESADO)
                    .map(x -> x.toString())
                    .reduce("", (x,y) -> x + y + "\n"));
    }
}
