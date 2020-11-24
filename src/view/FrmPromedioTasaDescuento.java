package view;

import controler.SociosController;
import model.TipoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FrmPromedioTasaDescuento extends JDialog{
    private JPanel pnlPrincipal;
    private JComboBox cbTipoEmpresa;
    private JComboBox cbAnioDesde;
    private JComboBox cbMesDesde;
    private JComboBox cbDiaDesde;
    private JComboBox cbDiaHasta;
    private JComboBox cbMesHasta;
    private JComboBox cbAnioHasta;
    private JButton calcularPromedioButton;
    private JPanel pnlTitulo;
    private JTextField txtTotal;
    private JTextField txtPromedio;
    private FrmPromedioTasaDescuento self;
    private SociosController controller;


    public FrmPromedioTasaDescuento(Window owner, String titulo) {
        super(owner, titulo);
        controller = SociosController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(654, 200);

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
        calcularPromedioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dDesde = Integer.parseInt(cbDiaDesde.getSelectedItem().toString());
                int mDesde = Integer.parseInt(cbMesDesde.getSelectedItem().toString());
                int aDesde = Integer.parseInt(cbAnioDesde.getSelectedItem().toString());
                int dHasta = Integer.parseInt(cbDiaHasta.getSelectedItem().toString());
                int mHasta = Integer.parseInt(cbMesHasta.getSelectedItem().toString());
                int aHasta = Integer.parseInt(cbAnioHasta.getSelectedItem().toString());
                TipoEmpresa tipoEmpresa = null;
                switch (cbTipoEmpresa.getSelectedItem().toString()){
                    case "Pequeña":
                        tipoEmpresa = TipoEmpresa.PEQUEÑA;
                        break;
                    case "Mediana":
                        tipoEmpresa = TipoEmpresa.MEDIANA;
                        break;
                    case "Grande":
                        tipoEmpresa = TipoEmpresa.GRANDE;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Debe eligir una tipo de empresa");
                }
                float[] promedioTotal = new float[]{0f, 0f};
                if (tipoEmpresa != null)
                    promedioTotal = controller.PromedioTasaDescuento(getDate(aDesde, mDesde, dDesde), getDate(aHasta, mHasta, dHasta), tipoEmpresa);
                txtTotal.setText(String.valueOf(promedioTotal[0]));
                txtPromedio.setText(String.valueOf(promedioTotal[1]));
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
