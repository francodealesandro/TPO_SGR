
package controler;

import model.LineaDeCredito;
import model.Operacion;
import model.Socio;
import utils.Lista;

import java.util.List;
import java.util.stream.Collectors;

public class LineaDeCreditoController {
    static LineaDeCreditoController instance = null;
    private Lista<LineaDeCredito> listaLineasDeCreditos = new Lista<>();
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

    public Lista<LineaDeCredito> getListaLineasDeClisreditos() {
        return listaLineasDeCreditos;
    }

    public void addLineaDeCredito(LineaDeCredito model) {
        Socio socioActual = sociosController.getsocioById(model.getIdSocio());
        try {
            sociosController.getSocios().save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Socio> getSociosPorLineasPorOperacion(int tipo){
        List<Socio> listaReturn = null;
        List<LineaDeCredito> lista = listaLineasDeCreditos.get().stream().filter(x -> x.getTipoOperacionCredito() == tipo).collect(Collectors.toList());
        for(LineaDeCredito linea: lista){
            listaReturn.add(sociosController.getsocioById(linea.getIdSocio()));
        }
        int h = 1;
        return listaReturn;
    }

}