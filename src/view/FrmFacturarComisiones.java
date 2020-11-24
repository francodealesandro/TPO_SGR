package view;

import controler.OperacionesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmFacturarComisiones extends JDialog {
    private JPanel pnlPrincipal;
    private JTable tableComisiones;
    private JButton btnFacturarTodasLasComisiones;

    private OperacionesController controller;

    private FrmFacturarComisiones self;

    public FrmFacturarComisiones(Window owner, String titulo) {
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
        this.tableComisiones.setModel(controller.getComisionesTableModel());
        this.self = this;

        this.asociarEventos();
    }

    private void asociarEventos(){

        btnFacturarTodasLasComisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.facturarComisiones();

            }
        });

    }


}
