package controler;

import model.*;
import utils.ListaDAO;

import java.util.Date;

public class OperacionesController {
    static OperacionesController instance = null;
    private ListaDAO<Operacion> listaOperaciones;

    public OperacionesController(){
        try {
            listaOperaciones = new ListaDAO(Operacion.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListaDAO<Operacion> getListaOperaciones() {
        return listaOperaciones;
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
            listaOperaciones.save();
        }
        catch (Exception e){
            e.printStackTrace();

        }


    }

    public void addCuentaCorriente(CuentaCorriente cuenta)
    {
        listaOperaciones.add(cuenta);

        try {
            listaOperaciones.save();
            }
        catch (Exception e){
            e.printStackTrace();

        }

    }

    public void addPrestamo(Prestamo p)
    {
        listaOperaciones.add(p);

        try {
            listaOperaciones.save();
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }




}
