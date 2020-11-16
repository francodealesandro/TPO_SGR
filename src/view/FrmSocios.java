package view;

import controler.SociosController;
import model.Socio;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSocios extends JDialog {

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JPanel pnlMenu;
    private JLabel lblTitulo;
    private JButton crearSocioButton;
    private JButton documentacionButton;
    private JButton aportesButton;
    private JButton accionesButton;
    private SociosController controller;
    private JList listSocios;

    private FrmSocios self;

    private int selectedIndexSocio;
    private Socio selectedSocio;

    public FrmSocios(Window owner, String titulo)
    {
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
        this.listSocios.setModel(controller.getSocios());
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
        crearSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSocio frame = new FrmSocio(self, "Crear Socio");
                frame.setVisible(true);
            }
        });
        documentacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        accionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
