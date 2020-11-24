package view;

import controler.SociosController;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FrmConsultaPorcentajeOperacion extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cbTipoOperacion;
    private JButton calcularPorcentajeComisionButton;
    private JPanel pnlTitulo;
    private JTextField txtComision;
    private JComboBox cbSocios;
    private FrmConsultaPorcentajeOperacion self;
    private SociosController controllerS;

    public FrmConsultaPorcentajeOperacion(Window owner, String titulo) {
        super(owner, titulo);
        controllerS = SociosController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(460, 200);
        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cbSocios.setModel(new DefaultComboBoxModel(controllerS.getSocios().stream().toArray()));
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos() {
        calcularPorcentajeComisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtComision.setText(String.valueOf(
                        controllerS.getComisiones((Socio) cbSocios.getSelectedItem(),
                                Integer.parseInt(cbTipoOperacion.getSelectedItem().toString()))));
            }
        });

    }
}