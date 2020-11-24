package controler;

import model.CambioEstado;
import utils.ListaDAO;

public class CambioEstadoController {
    static CambioEstadoController instance = null;
    private ListaDAO<CambioEstado> listaCambios;

    private CambioEstadoController() {
        try {
            listaCambios = new ListaDAO(CambioEstado.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CambioEstadoController getInstance() {
        if (instance == null)
            instance = new CambioEstadoController();
        return instance;
    }

    public void GuardarCambio(String estadoAnterior, String estadoNuevo){
        listaCambios.add(new CambioEstado(estadoAnterior, estadoNuevo));
        try {
            listaCambios.save();
        } catch (Exception e) {

        }
    }

}
