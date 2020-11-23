
package controler;

import model.LineaDeCredito;
import model.Operacion;
import model.Socio;
import utils.Lista;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LineaDeCreditoController {
    static LineaDeCreditoController instance = null;
    private List<LineaDeCredito> listaLineasDeCreditos = new ArrayList<LineaDeCredito>();
    private SociosController sociosController;

    private LineaDeCreditoController() {
        this.sociosController = SociosController.getInstance();
        try {
            for (Socio socio: sociosController.getSocios()) {
                LineaDeCredito linea = socio.getLineaDeCredito();
                if (linea !=  null)
                    listaLineasDeCreditos.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LineaDeCreditoController getInstance() {
        if (instance == null)
            instance = new LineaDeCreditoController();
        return instance;
    }

    public List<LineaDeCredito> getListaLineasDeCreditos() {
        return listaLineasDeCreditos;
    }

    public void addLineaDeCredito(LineaDeCredito model) {
        Socio socioActual = sociosController.getsocioById(model.getIdSocio());
        try {
            this.guardarDatos();
            listaLineasDeCreditos.add(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarDatos(){
        try {
            sociosController.getSocios().save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Socio> getSociosPorLineasPorOperacion(int tipo){
        ArrayList<Socio> listaReturn = new ArrayList<Socio>();
        List<LineaDeCredito> lista = listaLineasDeCreditos.stream().filter(x -> x.getTipoOperacionCredito() == tipo).collect(Collectors.toList());
        for(LineaDeCredito linea: lista){
            listaReturn.add(sociosController.getsocioById(linea.getIdSocio()));
        }
        int h = 1;
        return listaReturn;
    }

}