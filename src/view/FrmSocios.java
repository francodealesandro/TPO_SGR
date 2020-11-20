package view;

import controler.SociosController;
import model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

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
    private JList listSocios;
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

    private FrmSocios self;

    private int selectedIndexSocio;
    private Socio selectedSocio;

    private int selectedIndexDocumentacion;
    private Documentacion selectedDocumentacion;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);
        controller = SociosController.getInstance();

        this.setContentPane(pnlPrincipal);
        this.setSize(600, 600);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.listSocios.setModel(controller.getSocios());
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos()
    {
        listDocumentacion.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedIndexDocumentacion = listDocumentacion.getSelectedIndex();
                selectedDocumentacion = (Documentacion)listDocumentacion.getSelectedValue();
                if (selectedDocumentacion != null) {
                    btnAceptarDoc.setEnabled(selectedDocumentacion.getEstado() == EstadoDocumentacion.INGRESADO);
                    btnRechazarDoc.setEnabled(selectedDocumentacion.getEstado() == EstadoDocumentacion.INGRESADO);
                }
            }
        });
        btnAceptarDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDocumentacion.cambiarEstado(EstadoDocumentacion.CONTROLADO);
                btnAceptarDoc.setEnabled(false);
                btnRechazarDoc.setEnabled(false);
            }
        });
        btnRechazarDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDocumentacion.cambiarEstado(EstadoDocumentacion.RECHAZADO);
                btnAceptarDoc.setEnabled(false);
                btnRechazarDoc.setEnabled(false);
            }
        });
        listSocios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectedIndexSocio = listSocios.getSelectedIndex();
                selectedSocio = (Socio)listSocios.getSelectedValue();
                listAccionistas.setModel(selectedSocio.getAccionistas());
                listDocumentacion.setModel(selectedSocio.getDocumentaciones());
                tabbedSocio.setEnabledAt(2, selectedSocio.esProtector());
                btnAceptar.setEnabled(selectedSocio.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO);
                listAportes.setModel(selectedSocio.getAportes());
                setSocioActions(true);
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectedSocio.Aceptar();
                    controller.getSocios().save();
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
            }
        });
        documentacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDocumentacion frame = new FrmDocumentacion(self, "Nueva Documentacion", selectedSocio);
                frame.setVisible(true);
            }
        });
        aportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAporte frame = new FrmAporte(self, "Nuevo Aporte", selectedSocio);
                frame.setVisible(true);
            }
        });
        accionistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAccionista frame = new FrmAccionista(self, "Nuevo Accionista", selectedSocio);
                frame.setVisible(true);
            }
        });

    }

    private void setSocioActions(boolean enabled) {
        this.documentacionButton.setEnabled(enabled);
        this.aportesButton.setEnabled(enabled);
        this.accionistasButton.setEnabled(enabled);
    }

}
