package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultaRiesgoVivoYTotalUtilizado extends JDialog {
    private JPanel pnlTitulo;
    private JButton verificarYObtenerLineaButton;
    private JTextField textField1;
    private JPanel pnlPrincipal;
    private FrmConsultaRiesgoVivoYTotalUtilizado self;

    public FrmConsultaRiesgoVivoYTotalUtilizado(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();
        this.self = this;
    }
    private void asociarEventos () {
        verificarYObtenerLineaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}