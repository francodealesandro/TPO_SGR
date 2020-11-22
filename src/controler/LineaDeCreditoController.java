
package controler;

import model.LineaDeCredito;
import model.Operacion;
import model.Socio;
import utils.Lista;

public class LineaDeCreditoController {
    static LineaDeCreditoController instance = null;
    private Lista<LineaDeCredito> listaLineasDeCreditos = new Lista<>();
    private SociosController sociosController;

    private LineaDeCreditoController() {
        this.sociosController = SociosController.getInstance();
        try {
            for (Socio socio: sociosController.getSocios().get()) {
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

    public Lista<LineaDeCredito> getListaLineasDeCreditos() {
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



}