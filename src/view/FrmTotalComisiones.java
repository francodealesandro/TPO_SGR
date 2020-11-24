package view;

import controler.OperacionesController;
import controler.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

public class FrmTotalComisiones extends JDialog{
    private JPanel pnlPrincipal;
    private JButton calcularButton;
    private JPanel pnlTitulo;
    private JComboBox cbDia;
    private JComboBox cbMes;
    private JComboBox cbAnio;
    private JTextField txtResultado;
    private JTable tableResultados;
    private FrmTotalComisiones self;
    private OperacionesController controller;

    public FrmTotalComisiones(Window owner, String titulo) {
        super(owner, titulo);
        controller = OperacionesController.getInstance();

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
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(cbDia.getSelectedItem().toString());
                int m = Integer.parseInt(cbMes.getSelectedItem().toString());
                int d = Integer.parseInt(cbAnio.getSelectedItem().toString());
                txtResultado.setText(String.valueOf(controller.getComisionesCalculadas(getDate(a, m, d))));
            }
        });

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

}
