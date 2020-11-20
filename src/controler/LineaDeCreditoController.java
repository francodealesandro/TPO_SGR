
package controler;

import model.LineaDeCredito;
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
                listaLineasDeCreditos.add(socio.getLineaDeCredito());
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

    public Lista<LineaDeCredito> getSocios() {
        return listaLineasDeCreditos;
    }

    public void addSocio(LineaDeCredito model) {
        listaLineasDeCreditos.add(model);
        try {
            sociosController.getSocios().save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}