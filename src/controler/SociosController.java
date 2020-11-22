package controler;

import model.EstadoSocio;
import model.LineaDeCredito;
import model.Socio;
import utils.Lista;
import utils.ListaDAO;
import utils.Tabla;

import java.util.Date;
import java.util.stream.Collectors;

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

    public Lista<Socio> getSociosParticipes() {
        return new Lista(this.getSocios().stream()
                .filter(socio -> socio.esParticipe() && socio.getEstado() != EstadoSocio.POSTULANTE_A_SOCIO)
                .collect(Collectors.toList()));
    }

    public Socio getsocioById(int selectedIndexSocio) {
        return listaSocios.stream().filter(x -> x.getID() == selectedIndexSocio).findFirst().orElseGet(null);
    }

    public void addLineaDeCreditoASocio(LineaDeCredito linea){

    }
}
