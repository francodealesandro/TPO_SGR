package view;

import controler.OperacionesController;
import controler.SociosController;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FrmOperacionesAvaladas extends JDialog {
    private JPanel pnlPrincipal;
    private JButton calcularButton;
    private JPanel pnlTitulo;
    private JComboBox cbDiaDesde;
    private JComboBox cbMesDesde;
    private JComboBox cbAnioDesde;
    private JComboBox cbDiaHasta;
    private JComboBox cbMesHasta;
    private JComboBox cbAnioHasta;
    private JTable tableResultados;
    private JPanel pnlResultados;
    private JComboBox cbNombreSocios;
    private FrmOperacionesAvaladas self;
    private SociosController controllerS;
    private OperacionesController controllerO;

    public FrmOperacionesAvaladas(Window owner, String titulo) {
        super(owner, titulo);
        controllerS = SociosController.getInstance();
        controllerO = OperacionesController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(464, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        cbNombreSocios.setModel(new DefaultComboBoxModel(controllerS.getSocios().stream().toArray()));
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos() {
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dDesde = Integer.parseInt(cbDiaDesde.getSelectedItem().toString());
                int mDesde = Integer.parseInt(cbMesDesde.getSelectedItem().toString());
                int aDesde = Integer.parseInt(cbAnioDesde.getSelectedItem().toString());
                int dHasta = Integer.parseInt(cbDiaHasta.getSelectedItem().toString());
                int mHasta = Integer.parseInt(cbMesHasta.getSelectedItem().toString());
                int aHasta = Integer.parseInt(cbAnioHasta.getSelectedItem().toString());
                tableResultados.setModel(controllerO.getOperaciones((Socio) cbNombreSocios.getSelectedItem(), getDate(aDesde, mDesde, dDesde), getDate(aHasta, mHasta, dHasta)));
                pnlResultados.setVisible(tableResultados.getRowCount() > 0);
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