package model;

public class Accionista {
    private String cuit;
    private String razonSocial;
    private float porcentajeParticipacion;

    public Accionista() {
    }

    public Accionista(String cuit, String razonSocial, float porcentajeParticipacion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public float getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    @Override
    public String toString() {
        return razonSocial;
    }
}
