package view;

import controler.LineaDeCreditoController;
import controler.SociosController;
import model.LineaDeCredito;
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
import java.util.Calendar;
import java.util.Date;

public class FrmAsignarLineaDeCredito extends JDialog{
    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JPanel pnlInfo;
    private JTextField txtMonto;
    private JButton btnAceptar;
    private JComboBox comboOperacion;
    private LineaDeCreditoController controller;

    private FrmAsignarLineaDeCredito self;

    public FrmAsignarLineaDeCredito(Window owner, String titulo, Socio socio) {
        super(owner, titulo);
        controller = LineaDeCreditoController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(400, 400);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //Formateo Date
        this.asociarEventos(socio);

        this.self = this;
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

    private void asociarEventos(Socio socio){
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Calendar date = Calendar.getInstance();
                    date.add(Calendar.YEAR, 2);


                    LineaDeCredito ldc = new LineaDeCredito(
                            date.getTime(),
                            Float.parseFloat(txtMonto.getText()),
                            socio,
                            Integer.parseInt(comboOperacion.getSelectedItem().toString()));

                    controller.addLineaDeCredito(ldc);
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
