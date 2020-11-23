package view;

import controler.LineaDeCreditoController;
import controler.SociosController;
import model.EstadoSocio;
import model.ExceptionDocumentacionNoAprobada;
import model.LineaDeCredito;
import model.Socio;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLineasDeCredito extends JDialog {
    private JPanel pnl;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JButton btnAsignarLineaDeCredito;
    private JPanel pnlMenu;
    private JList listSocios;
    private JPanel pnlPrincipal;
    private JPanel pnlInfo;
    private JLabel lblInfo;
    private JLabel lblFecha;
    private JLabel lblTipoOperaciones;

    private SociosController controllerS;
    private LineaDeCreditoController controllerLDC;

    private FrmLineasDeCredito self;

    private int selectedIndexSocio;
    private Socio selectedSocio;

    public FrmLineasDeCredito(Window owner, String titulo)
    {
        super(owner, titulo);
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
        this.listSocios.setModel(controllerS.getSociosParticipes());
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos()
    {
        listSocios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectedIndexSocio = listSocios.getSelectedIndex();
                selectedSocio = (Socio)listSocios.getSelectedValue();
                btnAsignarLineaDeCredito.setEnabled(selectedSocio.getLineaDeCredito() == null);

                if(selectedSocio.getLineaDeCredito() == null){
                    lblInfo.setText("Debe asignarle un valor a la linea de credito.");
                    lblFecha.setText("");
                    lblTipoOperaciones.setText("");
                }
                else{
                    LineaDeCredito linea = selectedSocio.getLineaDeCredito();
                    lblInfo.setText("El monto de la linea de credito es de " + linea.getMonto());
                    lblFecha.setText("La fecha de vencimiento de la misma es " + linea.getFechaVencimiento());
                    lblTipoOperaciones.setText("La linea sirve para operaciones de tipo " + linea.getTipoOperacionCredito());
                }
            }
        });
        btnAsignarLineaDeCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAsignarLineaDeCredito frame = new FrmAsignarLineaDeCredito(self, "Nueva Documentacion", selectedSocio);
                frame.setVisible(true);
            }
        });

    }
}
