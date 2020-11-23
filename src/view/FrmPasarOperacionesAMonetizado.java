package view;

import controler.LineaDeCreditoController;
import controler.OperacionesController;
import controler.SociosController;

import javax.swing.*;
import java.awt.*;

public class FrmPasarOperacionesAMonetizado extends JDialog {
    private JPanel pnlPrincipal;
    private JButton btnMonetizar;
    private JTable tableOperaciones;

    private OperacionesController controller;


    private FrmPasarOperacionesAMonetizado self;

    public FrmPasarOperacionesAMonetizado(Window owner, String titulo)
    {
        super(owner, titulo);
        controller = OperacionesController.getInstance();
        /*controllerS = SociosController.getInstance();
        controllerLDC = LineaDeCreditoController.getInstance();
*/
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.tableOperaciones.setModel(controller.getOperacionesTableModel());
        this.self = this;

        this.asociarEventos();

    }
    private void asociarEventos()
    {


    }
}
