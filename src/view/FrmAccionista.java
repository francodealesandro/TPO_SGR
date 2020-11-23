package view;

import model.Accionista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAccionista extends JDialog {
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JPanel pnlPrincipal;
    private JTextField txtCuit;
    private JTextField txtRazonSocial;
    private JButton guardarButton;
    private JTextField txtPorcentaje;

    private FrmAccionista self;
    private Accionista accionista;

    public Accionista getAccionista() {
        return accionista;
    }

    public void setAccionista(Accionista accionista) {
        this.accionista = accionista;
    }

    public FrmAccionista(Window owner, String titulo)
    {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(400, 400);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //Formateo Date
        this.asociarEventos();

        this.self = this;
    }

    private void asociarEventos()
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    accionista = new Accionista(txtCuit.getText(),
                            txtRazonSocial.getText(),
                            Float.parseFloat(txtPorcentaje.getText()));
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
