package controler;

import model.*;
import utils.Lista;
import utils.Tabla;

import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OperacionesController {
    static OperacionesController instance = null;
    private LineaDeCreditoController controllerLDC = null;
    private List<Operacion> listaOperaciones = new ArrayList<Operacion>();

    public OperacionesController(){
        this.controllerLDC = LineaDeCreditoController.getInstance();
        try {
            for (LineaDeCredito ldc: controllerLDC.getListaLineasDeCreditos()) {
                for (Operacion op : ldc.getOperaciones()) {

                    listaOperaciones.add(op);
                }
            }
            Operacion.setIdBase(listaOperaciones.stream().map(s -> s.getNumeroCertificadoGarantia()).max(Integer::compareTo).orElse(-1)+1);            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Operacion> getListaOperaciones() {
        return listaOperaciones;
    }

    public Lista<Operacion> getListaOperacionesModel() {
        return new Lista(listaOperaciones);
    }

    public static OperacionesController getInstance() {
        if (instance == null)
            instance = new OperacionesController();
        return instance;
    }

    public void addCheque(Cheque c)
    {
        listaOperaciones.add(c);

        try {
            controllerLDC.guardarDatos();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addCuentaCorriente(CuentaCorriente cuenta)
    {
        listaOperaciones.add(cuenta);

        try {
            controllerLDC.guardarDatos();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addPrestamo(Prestamo p)
    {
        listaOperaciones.add(p);

        try {
            controllerLDC.guardarDatos();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public Tabla<Operacion> getOperacionesTableModel() {
        return new Tabla(listaOperaciones.stream().filter(x -> x.getEstado().equals("Con certificado emitido")).collect(Collectors.toList()), new String[]{"NumeroCertificadoGarantia", "TipoOperacionString"});
    }

    public float getComisionesCalculadas(Date date) {
        return this.listaOperaciones.stream()
                .filter(op -> op.getTipoOperacion() == 1 &&
                    op.getFecha().equals(date) &&
                    op.getComision() != null &&
                    ((Cheque)op).getBanco().trim().equals("Mercado Argentino de Valores"))
                .map(op -> op.getComision().getCantidad())
                .reduce(0f, (acum, comision) -> acum + comision);
    }

    public void setOperacionAMonetizado(int numeroCertificadoGarantia) {
        listaOperaciones.stream().filter(x -> x.getNumeroCertificadoGarantia() == numeroCertificadoGarantia)
                .forEach(x ->{
                            x.cambiarEstado("Monetizado");
                            x.addComision();
                });



        controllerLDC.guardarDatos();
    }

    public TableModel getOperaciones(Socio socio, Date desde, Date hasta) {
        return new Tabla<>(socio.getLineaDeCredito().getOperaciones().stream()
                .filter(op -> op.getFecha().after(desde) && op.getFecha().before(hasta)).collect(Collectors.toList()),
                new String[]{"NumeroCertificadoGarantia", "TipoOperacionString", "Estado", "Monto"});
    }

    public Tabla<Operacion> getComisionesTableModel() {
        return new Tabla(listaOperaciones.stream().filter(x -> x.getComision() != null && x.getEstadoComision() == "Calculada").collect(Collectors.toList()), new String[]{"NumeroCertificadoGarantia", "CantidadComision"});
    }

    public void facturarComisiones() {
        listaOperaciones.stream().filter(x -> x.getEstadoComision() == "Calculada").forEach(x -> x.cambiarEstadoComision("Facturada"));
        controllerLDC.guardarDatos();
    }

    public float getMontosCheques(String cuitFirmante) {
        return this.listaOperaciones.stream().filter(op -> op.getTipoOperacion() == 1 &&
                ((Cheque)op).getCuitFirmante().toLowerCase().trim().equals(cuitFirmante.toLowerCase().trim()))
                .map(Operacion::getMonto)
                .reduce(0f, (acum, monto) -> acum + monto);
    }
}
