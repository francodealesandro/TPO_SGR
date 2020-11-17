package controler;

import model.Socio;
import utils.ListaDAO;

import java.util.Date;

public class SociosController {
    static SociosController instance = null;
    private ListaDAO<Socio> listaSocios;

    private SociosController() {
        try {
            listaSocios = new ListaDAO(Socio.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SociosController getInstance() {
        if (instance == null)
            instance = new SociosController();
        return instance;
    }

    public ListaDAO<Socio> getSocios() {
        return listaSocios;
    }

    public void addSocio(Socio model) {
        listaSocios.add(model);
        try {
            listaSocios.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTotalDeComisiones(int socioID){

    }

    public void operacionesByRango(Date desde, Date hasta, String razonSocial) {

    }
}
