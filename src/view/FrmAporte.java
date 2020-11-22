package view;

import model.Aporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAporte extends JDialog {

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JPanel pnlMenu;
    private JTextField txtMonto;
    private JButton guardarButton;

    private FrmAporte self;
    private Aporte aporte;

    public Aporte getAporte() {
        return aporte;
    }

    public FrmAporte(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(400, 200);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();

        this.self = this;

    }

    private void asociarEventos()
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aporte = new Aporte(Float.parseFloat(txtMonto.getText()));
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
