package model;

import controler.CambioEstadoController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {
    private int idSocio;
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


    static int idBase = 0;

    public static void setIdBase(int idBase) {
        Socio.idBase = idBase;
    }

    private LineaDeCredito lineaDeCredito;

    private List<Accionista> accionistas = new ArrayList<>();
    private List<Documentacion> documentaciones = new ArrayList<>();
    private List<Aporte> aportes = new ArrayList<>();

    public Socio(Boolean esParticipe,
                 String cuit,
                 String razonSocial,
                 Date fechaInicioActividades,
                 TipoEmpresa tipoEmpresa,
                 String actividadPrincipal,
                 String direccion,
                 int telefono,
                 String correo) {
        this.idSocio = idBase;
        idBase ++;
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

    public void cambiarEstado(EstadoSocio estado){
        CambioEstadoController.getInstance().GuardarCambio(this.estado.toString(), estado.toString());
        this.estado = estado;
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

    public List<Accionista> getAccionistas() { return accionistas; }

    public void setAccionistas(List<Accionista> accionistas) {
        this.accionistas = accionistas;
    }

    public List<Documentacion> getDocumentaciones() {
        return documentaciones;
    }

    public void setDocumentaciones(List<Documentacion> documentaciones) {
        this.documentaciones = documentaciones;
    }

    public List<Aporte> getAportes() {
        return aportes;
    }

    public void setAportes(List<Aporte> aportes) {
        this.aportes = aportes;
    }

    public LineaDeCredito getLineaDeCredito() {
        return this.lineaDeCredito;
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
        boolean documentacionesAprobadas = this.documentaciones.stream()
                .filter(x -> x.getEstado() != EstadoDocumentacion.RECHAZADO)
                .allMatch(x -> x.getEstado() == EstadoDocumentacion.CONTROLADO);
        if (documentacionesAprobadas)
            cambiarEstado(EstadoSocio.SOCIO_PLENO);
        else
            throw new ExceptionDocumentacionNoAprobada(this.documentaciones.stream()
                    .filter(x -> x.getEstado() == EstadoDocumentacion.INGRESADO)
                    .map(x -> x.toString())
                    .reduce("", (x,y) -> x + y + "\n"));
    }

    public int getID() {
        return this.idSocio;
    }
}
