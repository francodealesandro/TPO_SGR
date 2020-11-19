package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultaPorcentajeOperacion extends JDialog {
    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JTextField textField1;
    private JButton verificarButton;
    private JComboBox comboBox1;
    private JButton calcularPorcentajeComisionButton;
    private FrmConsultaPorcentajeOperacion self;


    public FrmConsultaPorcentajeOperacion(Window owner, String titulo) {
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

    private void asociarEventos() {
        calcularPorcentajeComisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}