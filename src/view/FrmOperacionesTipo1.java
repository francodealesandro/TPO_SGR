package view;

import controler.LineaDeCreditoController;
import controler.OperacionesController;
import controler.SociosController;
import model.*;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FrmOperacionesTipo1 extends JDialog {
    private JTextField txtBanco;
    private JTextField txtNroCheque;
    private JComboBox fechaVencimientoD;
    private JComboBox fechaVencimientoM;
    private JComboBox fechaVencimientoA;
    private JTextField txtCuit;
    private JButton aceptarButton;
    private JPanel pnlPrincipal;
    private JTextField txtMonto;
    private JComboBox comboSocios;
    private OperacionesController controller;
    private SociosController controllerS;
    private LineaDeCreditoController controllerLDC;

    private FrmOperacionesTipo1 self;

    public FrmOperacionesTipo1(Window owner, String titulo)
    {
        super(owner, titulo);
        controller = OperacionesController.getInstance();
        controllerS = SociosController.getInstance();
        controllerLDC = LineaDeCreditoController.getInstance();

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
        model.addAll(controllerLDC.getSociosPorLineasPorOperacion(1));
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
                    int a = Integer.parseInt(fechaVencimientoA.getSelectedItem().toString());
                    int m = Integer.parseInt(fechaVencimientoM.getSelectedItem().toString());
                    int d = Integer.parseInt(fechaVencimientoD.getSelectedItem().toString());
                    Date fechaActual = new Date();
                    Socio s = (Socio)comboSocios.getSelectedItem();
                    LineaDeCredito linea = s.getLineaDeCredito();
                    float resto = linea.calcularRestante();


                        Cheque op = new Cheque(
                            //TODO el numero de certificado de garantia se crea sin repetir
                                linea,
                            1,
                            Float.parseFloat(txtMonto.getText()),
                            fechaActual,
                            Integer.parseInt(txtNroCheque.getText()),
                            getDate(a,m,d),
                            txtCuit.getText(),
                            txtBanco.getText())
                            ;
                    controller.addCheque(op);
                    if(!op.getCertificadoEmitido()){
                        JOptionPane.showMessageDialog(null, "La operacion no puede ser cursada por la linea de credito del socio seleccionado");
                    }
                    dispose();
            }
        });
    }
}
