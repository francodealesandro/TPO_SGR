package view;

import controler.LineaDeCreditoController;
import controler.OperacionesController;
import controler.SociosController;
import model.LineaDeCredito;
import model.Operacion;
import model.Socio;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPasarOperacionesAMonetizado extends JDialog {
    private JPanel pnlPrincipal;
    private JButton btnMonetizar;
    private JTable tableOperaciones;

    private OperacionesController controller;

    private int numeroCertificadoSelected;


    private FrmPasarOperacionesAMonetizado self;

    public FrmPasarOperacionesAMonetizado(Window owner, String titulo)
    {
        super(owner, titulo);
        controller = OperacionesController.getInstance();

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
        btnMonetizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setOperacionAMonetizado(numeroCertificadoSelected);

            }
        });
        tableOperaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                numeroCertificadoSelected = Integer.parseInt(tableOperaciones.getValueAt(tableOperaciones.getSelectedRow(), 0).toString());
            }
        });
    }
}
