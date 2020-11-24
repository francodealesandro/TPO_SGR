package view;

import controler.SociosController;
import model.LineaDeCredito;
import model.Socio;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultaRiesgoVivoYTotalUtilizado extends JDialog {
    private JPanel pnlTitulo;
    private JButton verificarYObtenerLineaButton;
    private JPanel pnlPrincipal;
    private JComboBox comboSocios;
    private JLabel lblTotalUtilizado;
    private JLabel lblRiesgoVivo;

    private SociosController controllerS;


    private FrmConsultaRiesgoVivoYTotalUtilizado self;

    public FrmConsultaRiesgoVivoYTotalUtilizado(Window owner, String titulo) {
        super(owner, titulo);
        controllerS = SociosController.getInstance();
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        comboSocios.setModel(new DefaultComboBoxModel(controllerS.getSocios().stream().toArray()));
        this.asociarEventos();
        this.self = this;
    }
    private void asociarEventos () {
        verificarYObtenerLineaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio s = (Socio)comboSocios.getSelectedItem();
                LineaDeCredito linea = s.getLineaDeCredito();
                lblRiesgoVivo.setText(String.valueOf(linea.riesgoVivo()));
                lblTotalUtilizado.setText(String.valueOf(linea.calcularTotalUtilizado()));
            }
        });
    }

}