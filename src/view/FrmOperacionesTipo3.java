package view;

import controler.OperacionesController;
import controler.SociosController;
import model.CuentaCorriente;
import model.LineaDeCredito;
import model.Prestamo;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FrmOperacionesTipo3 extends JDialog{
    private JTextField txtBanco;
    private JTextField txtImporte;
    private JTextField txtTasa;
    private JComboBox FechaAcreditacionD;
    private JComboBox FechaAcreditacionM;
    private JComboBox FechaAcreditacionA;
    private JTextField txtCuotas;
    private JComboBox comboSistema;
    private JButton aceptarButton;
    private JPanel pnlPrincipal;
    private JComboBox comboSocios;

    private OperacionesController controller;
    private SociosController controllerS;

    private FrmOperacionesTipo3 self;

    public FrmOperacionesTipo3(Window owner, String titulo)
    {
        super(owner, titulo);
        controller = OperacionesController.getInstance();
        controllerS = SociosController.getInstance();



        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.self = this;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(controllerS.getSocios().get());
        comboSocios.setModel(model);

        this.asociarEventos();



    }

    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    private void asociarEventos()
    {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(FechaAcreditacionA.getSelectedItem().toString());
                int m = Integer.parseInt(FechaAcreditacionM.getSelectedItem().toString());
                int d = Integer.parseInt(FechaAcreditacionD.getSelectedItem().toString());
                Date fechaActual = new Date();
                Socio s = (Socio)comboSocios.getSelectedItem();
                LineaDeCredito linea = s.getLineaDeCredito();


                Prestamo p = new Prestamo(
                        linea,
                        3,
                        Float.parseFloat(txtImporte.getText()),
                        fechaActual,
                        txtBanco.getText(),
                        Float.parseFloat(txtTasa.getText()),
                        getDate(a,m,d),
                        Integer.parseInt(txtCuotas.getText()),
                        comboSistema.getSelectedItem().toString());

                controller.addPrestamo(p);
                dispose();
            }
        });
    }
}

