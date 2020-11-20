package view;

import controler.SociosController;
import model.Aporte;
import model.Documentacion;
import model.Socio;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class FrmAporte extends JDialog {
    private SociosController controller;
    private Socio socio;

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JPanel pnlMenu;
    private JTextField txtMonto;
    private JButton guardarButton;

    private FrmAporte self;

    public FrmAporte(Window owner, String titulo, Socio socio) {
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
        this.asociarEventos();

        this.self = this;

    }

    private void asociarEventos()
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aporte aporte = new Aporte(Float.parseFloat(txtMonto.getText()));
                    socio.getAportes().add(aporte);
                    controller.getSocios().save();
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
