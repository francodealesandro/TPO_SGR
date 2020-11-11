package controler;

import model.Socio;
import utils.ListDAO;

import java.util.Date;

public class SociosController {
    private ListDAO<Socio> listaSocios;

    public SociosController() throws Exception {
        listaSocios = new ListDAO(Socio.class);
    }

    public void getTotalDeComisiones(int socioID){

    }

    public void operacionesByRango(Date desde, Date hasta, String razonSocial) {

    }
}
