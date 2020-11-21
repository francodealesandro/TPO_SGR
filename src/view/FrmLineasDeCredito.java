package view;

import controler.LineaDeCreditoController;
import controler.SociosController;
import model.EstadoSocio;
import model.Socio;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class FrmLineasDeCredito extends JDialog {
    private JPanel pnl;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JButton btnAsignarLineaDeCredito;
    private JPanel pnlMenu;
    private JList listSocios;
    private JPanel pnlPrincipal;
    private JPanel pnlInfo;

    private SociosController controllerS;
    private LineaDeCreditoController controllerLDC;


    private FrmLineasDeCredito self;

    private int selectedIndexSocio;
    private Socio selectedSocio;

    public FrmLineasDeCredito(Window owner, String titulo)
    {
        super(owner, titulo);
        controllerS = SociosController.getInstance();
        controllerLDC = LineaDeCreditoController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.listSocios.setModel(controllerS.getSociosParticipes());
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos()
    {
        listSocios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectedIndexSocio = listSocios.getSelectedIndex();
                selectedSocio = (Socio)listSocios.getSelectedValue();
            }
        });
    }
}
