package controler;

import model.Operacion;
import utils.ListDAO;

import java.util.Date;

public class OperacionesController {
    private ListDAO<Operacion> listaOperaciones;

    public OperacionesController() throws Exception {
        listaOperaciones = new ListDAO(Operacion.class);
    }

    public void calcularPromedioDescuentos(int total, int iteraciones) {

    }

    public void getOperacionesEnChequesYPromedios(int cuit, Date desde, Date hasta) {

    }
}
