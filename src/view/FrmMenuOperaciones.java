package view;

import controler.LineaDeCreditoController;
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
    private JButton btnPasarOperacionesAMonetizado;
    private JButton facturarOperacionesDeChequesButton;
    private JButton volverAtrasButton;
    private JPanel pnlPrincipal;
    private JList operacionesList;
    private OperacionesController controller;
    private LineaDeCreditoController controllerLDC;


    private FrmMenuOperaciones self;


    public FrmMenuOperaciones(Window owner, String titulo)
    {
        super(owner, titulo);


        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);
        controller = OperacionesController.getInstance();
        controllerLDC = LineaDeCreditoController.getInstance();


        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.self = this;
        this.operacionesList.setModel(controller.getListaOperacionesModel());
        this.asociarEventos();


    }
    private void asociarEventos()
    {
        hacerOperacionTipo1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controllerLDC.getSociosPorLineasPorOperacion(1).stream().count() < 1){
                    JOptionPane.showMessageDialog(null, "La operacion no puede ser creada porque no hay socios con lineas de credito asignadas para este tipo de operaciones");
                }
                else {
                    FrmOperacionesTipo1 frame = new FrmOperacionesTipo1(self, "Nueva operacion tipo 1");
                    frame.setVisible(true);
                }
            }
        });
        hacerOperacionTipo2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controllerLDC.getSociosPorLineasPorOperacion(2).stream().count() < 1){
                    JOptionPane.showMessageDialog(null, "La operacion no puede ser creada porque no hay socios con lineas de credito asignadas para este tipo de operaciones");
                }
                else {
                    FrmOperacionesTipo2 frame = new FrmOperacionesTipo2(self, "Nueva operacion tipo 2");
                    frame.setVisible(true);
                }
            }
        });

        hacerOperacionTipo3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (controllerLDC.getSociosPorLineasPorOperacion(3).stream().count() < 1) {
                    JOptionPane.showMessageDialog(null, "La operacion no puede ser creada porque no hay socios con lineas de credito asignadas para este tipo de operaciones");
                } else {

                    FrmOperacionesTipo3 frame = new FrmOperacionesTipo3(self, "Nueva operacion tipo 3");
                    frame.setVisible(true);
                }
            }
        });
        btnPasarOperacionesAMonetizado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                FrmPasarOperacionesAMonetizado frame = new FrmPasarOperacionesAMonetizado(self, "Pasar operaciones a monetizado");
                frame.setVisible(true);

            }
        });
        };

    }

