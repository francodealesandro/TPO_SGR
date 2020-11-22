package controler;

import model.EstadoSocio;
import model.LineaDeCredito;
import model.Socio;
import utils.Lista;
import utils.ListaDAO;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.util.Collection;
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

    public ListModel getSociosParticipes() {
        Lista<Socio> listaReturnSocio = new Lista<>();


        try {
            for (Socio socio: this.getSocios().get()) {
                if (socio.esParticipe() && socio.getEstado() != EstadoSocio.POSTULANTE_A_SOCIO)
                    listaReturnSocio.add(socio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaReturnSocio;
    }

    public Socio getsocioById(int selectedIndexSocio) {

        return listaSocios.get().stream().filter(x -> x.getID() == selectedIndexSocio).collect(Collectors.toList()).get(0);
    }

    public void addLineaDeCreditoASocio(LineaDeCredito linea){

    }
}
