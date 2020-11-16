package controler;

import model.Socio;
import utils.ListDAO;

import java.util.Date;

public class SociosController {
    static SociosController instance = null;
    private ListDAO<Socio> listaSocios;

    private SociosController() {
        try {
            listaSocios = new ListDAO(Socio.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SociosController getInstance() {
        if (instance == null)
            instance = new SociosController();
        return instance;
    }

    public ListDAO<Socio> getSocios() {
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
