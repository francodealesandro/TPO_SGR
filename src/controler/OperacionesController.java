package controler;

import model.Operacion;
import utils.ListaDAO;

import java.util.Date;

public class OperacionesController {
    private ListaDAO<Operacion> listaOperaciones;

    public OperacionesController() throws Exception {
        listaOperaciones = new ListaDAO(Operacion.class);
    }

    public void calcularPromedioDescuentos(int total, int iteraciones) {

    }

    public void getOperacionesEnChequesYPromedios(int cuit, Date desde, Date hasta) {

    }
}
