package view;

import controler.SociosController;
import model.Accionista;
import model.Socio;

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
    private Socio socio;
    private SociosController controller;

    private FrmAccionista self;

    public FrmAccionista(Window owner, String titulo, Socio socio)
    {
        super(owner, titulo);
        this.socio = socio;
        controller = SociosController.getInstance();

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
                    Accionista accionista = new Accionista(txtCuit.getText(),
                            txtRazonSocial.getText(),
                            Float.parseFloat(txtPorcentaje.getText()));
                    socio.getAccionistas().add(accionista);
                    controller.getSocios().save();
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
