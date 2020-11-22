package controler;

import model.Socio;
import utils.Lista;
import utils.ListaDAO;
import utils.Tabla;

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

    public Lista<Socio> getSociosListaModel() {
        return new Lista(listaSocios);
    }

    public Tabla<Socio> getSociosTableModel() {
        return new Tabla(listaSocios, new String[]{"Nombre", "Estado"});
    }

    public void saveSocios() {
        try {
            listaSocios.save();
        } catch (Exception e) {
        }
    }

    public void getTotalDeComisiones(int socioID){

    }

    public void operacionesByRango(Date desde, Date hasta, String razonSocial) {

    }
}
