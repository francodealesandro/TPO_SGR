package view;

import controler.SociosController;

import javax.swing.*;
import java.awt.*;

public class FrmLineaCredito extends JDialog {

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JPanel pnlMenu;
    private JList listSocios;
    private JPanel menu;
    private JTextField textField1;
    private JButton asignarLineaDeCreditoButton;
    private JButton consultarLineaDeCreditoButton;

    private FrmLineaCredito self;
    private SociosController controller;

    public FrmLineaCredito(Window owner, String titulo){

        super(owner, titulo);
        controller = SociosController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.listSocios.setModel(controller.getSociosListaModel());
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos(){


    }
}
