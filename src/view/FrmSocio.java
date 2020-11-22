package view;

import controler.SociosController;
import model.Socio;
import model.TipoEmpresa;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FrmSocio extends JDialog {
    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JTextField txtCuit;
    private JTextField txtRazonSocial;
    private JComboBox comboTipo;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtActPrincipal;
    private JButton guardarButton;
    private JRadioButton radioParticipe;
    private JRadioButton radioProtector;
    private JFormattedTextField txtFechaInicio;
    private SociosController controller;

    private FrmSocio self;
    private Socio socio;

    public Socio getSocio() {
        return socio;
    }

    public FrmSocio(Window owner, String titulo)
    {
        super(owner, titulo);
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
        DateFormatter displayFormatter = new DateFormatter(new SimpleDateFormat("dd-MM-yyyy"));
        DefaultFormatterFactory factory = new DefaultFormatterFactory(displayFormatter, displayFormatter, displayFormatter);
        this.txtFechaInicio.setFormatterFactory(factory);
        this.asociarEventos();

        this.self = this;
    }

    private void asociarEventos()
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    socio = new Socio(radioParticipe.isSelected(),
                            txtCuit.getText(),
                            txtRazonSocial.getText(),
                            new SimpleDateFormat("dd-MM-yyyy").parse(txtFechaInicio.getText()),
                            comboTipo.getSelectedItem().equals("Pequeño") ? TipoEmpresa.PEQUEÑA : comboTipo.getSelectedItem().equals("Mediana") ? TipoEmpresa.MEDIANA : TipoEmpresa.GRANDE,
                            txtActPrincipal.getText(),
                            txtDireccion.getText(),
                            Integer.parseInt(txtTelefono.getText()),
                            txtCorreo.getText());
                    dispose();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
    }
}
