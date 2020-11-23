package controler;

import model.*;
import utils.Lista;
import utils.ListaDAO;
import utils.Tabla;

import javax.sound.sampled.Line;
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
                ;
            }
        } catch (Exception e) {
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

    public void calcularPromedioDescuentos(int total, int iteraciones) {

    }

    public void getOperacionesEnChequesYPromedios(int cuit, Date desde, Date hasta) {

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
        return new Tabla(listaOperaciones.stream().filter(x -> x.getEstado() == "Con certificado emitido").collect(Collectors.toList()), new String[]{"Numero de certidicado de garantia", "Tipo de operacion"});
    }



}
