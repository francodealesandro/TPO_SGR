package view;

import controler.OperacionesController;
import controler.SociosController;
import model.Cheque;
import model.CuentaCorriente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FrmOperacionesTipo2 extends JDialog{
    private JTextField txtEmpresa;
    private JTextField txtImporte;
    private JComboBox fechaVencimientoD;
    private JComboBox fechaVencimientoM;
    private JComboBox fechaVencimientoA;
    private JButton aceptarButton;
    private JPanel pnlPrincipal;
    private JPanel panel;
    private JComboBox comboSocios;

    private OperacionesController controller;
    private SociosController controllerS;


    private FrmOperacionesTipo2 self;

    public FrmOperacionesTipo2(Window owner, String titulo)
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
                int a = Integer.parseInt(fechaVencimientoA.getSelectedItem().toString());
                int m = Integer.parseInt(fechaVencimientoM.getSelectedItem().toString());
                int d = Integer.parseInt(fechaVencimientoD.getSelectedItem().toString());
                Date fechaActual = new Date();


                CuentaCorriente cc = new CuentaCorriente(
                        2,
                        "Ingresado",
                        Float.parseFloat(txtImporte.getText()),
                        false,
                        fechaActual,
                        txtEmpresa.getText(),
                        getDate(a,m,d));
                controller.addCuentaCorriente(cc);
                dispose();
            }
        });
    }

}
