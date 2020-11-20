package view;

import controler.OperacionesController;
import model.Socio;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuOperaciones extends JDialog{
    private JButton hacerOperacionTipo1Button;
    private JButton hacerOperacionTipo2Button;
    private JButton hacerOperacionTipo3Button;
    private JButton emitirCertificadoDeGarantiaButton;
    private JButton pasarOperacionAMonetizadoButton;
    private JButton volverAtrasButton;
    private JPanel pnlPrincipal;
    private JList operacionesList;
    private OperacionesController controller;


    private FrmMenuOperaciones self;


    public FrmMenuOperaciones(Window owner, String titulo)
    {
        super(owner, titulo);


        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);
        controller = OperacionesController.getInstance();


        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.self = this;
        this.operacionesList.setModel(controller.getListaOperaciones());
        this.asociarEventos();


    }
    private void asociarEventos()
    {
        hacerOperacionTipo1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperacionesTipo1 frame = new FrmOperacionesTipo1(self, "Nueva operacion tipo 1");
                frame.setVisible(true);
            }
        });
        hacerOperacionTipo2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperacionesTipo2 frame = new FrmOperacionesTipo2(self, "Nueva operacion tipo 2");
                frame.setVisible(true);
            }
        });

        hacerOperacionTipo3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperacionesTipo3 frame = new FrmOperacionesTipo3(self, "Nueva operacion tipo 3");
                frame.setVisible(true);
            }
        });
        volverAtrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });

    }
}
