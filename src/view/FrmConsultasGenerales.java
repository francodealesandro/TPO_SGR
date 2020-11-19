package view;

import controler.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmConsultasGenerales extends JDialog{
    private JPanel pnlTitulo;
    private JPanel pnlPrincipal;
    private JButton totalDeComisionesCalculadasButton;
    private JButton operacionesAvaladasANombreButton;
    private JButton valorPromedioDeLaButton;
    private JButton porcentajeDeComisionPorButton;
    private JButton consultaRiesgoVivoYButton;
    private FrmConsultasGenerales self;

    public FrmConsultasGenerales(Window owner, String titulo)
    {
        super(owner, titulo);

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void asociarEventos(){
        totalDeComisionesCalculadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmConsultaPorcentajeOperacion frame = new FrmConsultaPorcentajeOperacion(self, "Consulta porcentaje por operacion");
                frame.setVisible(true);

            }
        });
        operacionesAvaladasANombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperacionesAvaladas frame = new FrmOperacionesAvaladas(self, "Operaciones Avaladas");
                frame.setVisible(true);

            }
        });
        valorPromedioDeLaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  FrmPromedioTasaDescuento frame = new FrmPromedioTasaDescuento(self, "Promedio tasa de descuento");
             //   frame.setVisible(true);

            }
        });
        porcentajeDeComisionPorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  FrmTotalComisiones frame = new FrmTotalComisiones(self, "Total de comisiones calculadas en un dia");
              //  frame.setVisible(true);

            }
        });
        consultaRiesgoVivoYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // FrmConsultaRiesgoVivoYTotalUtilizado frame = new FrmConsultaRiesgoVivoYTotalUtilizado(self, "Consulta riesgo vivo y total utilizado");
             //   frame.setVisible(true);

            }
        });

    }
}
