package view;

import controler.SociosController;
import model.*;
import utils.Lista;
import utils.Tabla;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSocios extends JDialog {

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JPanel pnlMenu;
    private JLabel lblTitulo;
    private JButton crearSocioButton;
    private JButton documentacionButton;
    private JButton aportesButton;
    private JButton accionistasButton;
    private SociosController controller;
    private JTabbedPane tabbedSocio;
    private JPanel accionistasTab;
    private JPanel documentacionTab;
    private JPanel aportesTab;
    private JList listAccionistas;
    private JList listDocumentacion;
    private JList listAportes;
    private JButton btnAceptar;
    private JButton btnAceptarDoc;
    private JButton btnRechazarDoc;
    private JTable tableSocios;

    private FrmSocios self;

    private Tabla<Socio> socios;
    private Socio selectedSocio;
    private Lista<Documentacion> documentos;
    private Lista<Accionista> accionistas;
    private Lista<Aporte> aportes;

    private Documentacion selectedDocumentacion;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);
        controller = SociosController.getInstance();
        socios = controller.getSociosTableModel();

        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.tableSocios.setModel(socios);
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos()
    {
        listDocumentacion.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedDocumentacion = (Documentacion)listDocumentacion.getSelectedValue();
                setActionsDocumentos(selectedDocumentacion != null && selectedDocumentacion.getEstado() == EstadoDocumentacion.INGRESADO);
            }
        });
        btnAceptarDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDocumentacion.cambiarEstado(EstadoDocumentacion.CONTROLADO);
                setActionsDocumentos(false);
            }
        });
        btnRechazarDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDocumentacion.cambiarEstado(EstadoDocumentacion.RECHAZADO);
                setActionsDocumentos(false);
            }
        });
        tableSocios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectedSocio = controller.getSocios().get(tableSocios.getSelectedRow());
                accionistas = new Lista(selectedSocio.getAccionistas());
                documentos = new Lista(selectedSocio.getDocumentaciones());
                aportes = new Lista(selectedSocio.getAportes());
                listAccionistas.setModel(accionistas);
                listDocumentacion.setModel(documentos);
                listAportes.setModel(aportes);
                tabbedSocio.setEnabledAt(2, selectedSocio.esProtector());
                btnAceptar.setEnabled(selectedSocio.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO);
                setSocioActions(true);
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectedSocio.Aceptar();
                    controller.saveSocios();
                    btnAceptar.setEnabled(false);
                } catch (ExceptionDocumentacionNoAprobada exceptionDocumentacionNoAprobada) {
                    JOptionPane.showMessageDialog(null, "Debe aprobar la documentacion:\n" + exceptionDocumentacionNoAprobada.getMessage());
                } catch (Exception ex) {
                }
            }
        });
        crearSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSocio frame = new FrmSocio(self, "Nuevo Socio");
                frame.setVisible(true);
                if (frame.getSocio() != null) {
                    socios.add(frame.getSocio());
                    controller.saveSocios();
                }
            }
        });
        documentacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDocumentacion frame = new FrmDocumentacion(self, "Nueva Documentacion");
                frame.setVisible(true);
                if (frame.getDocumentacion() != null) {
                    documentos.add(frame.getDocumentacion());
                    controller.saveSocios();
                }
            }
        });
        aportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAporte frame = new FrmAporte(self, "Nuevo Aporte");
                frame.setVisible(true);
                if (frame.getAporte() != null) {
                    aportes.add(frame.getAporte());
                    controller.saveSocios();
                }
            }
        });
        accionistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAccionista frame = new FrmAccionista(self, "Nuevo Accionista");
                frame.setVisible(true);
                if (frame.getAccionista() != null) {
                    accionistas.add(frame.getAccionista());
                    controller.saveSocios();
                }
            }
        });
    }

    private void setSocioActions(boolean enabled) {
        this.documentacionButton.setEnabled(enabled);
        this.aportesButton.setEnabled(enabled);
        this.accionistasButton.setEnabled(enabled);
    }

    private void setActionsDocumentos(boolean enabled) {
        btnAceptarDoc.setEnabled(enabled);
        btnRechazarDoc.setEnabled(enabled);
    }
}
