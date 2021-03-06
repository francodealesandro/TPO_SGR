package view;

import model.Documentacion;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class FrmDocumentacion extends JDialog {
    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JTextField txtTipoDoc;
    private JTextField txtRazonSocial;
    private JButton guardarButton;
    private JPanel pnlMenu;
    private JCheckBox esObligatoriaCheckBox;
    private JCheckBox esDeseableCheckBox;
    private JFormattedTextField txtFechaRecepcion;

    private FrmDocumentacion self;
    private Documentacion documentacion;

    public Documentacion getDocumentacion() {
        return documentacion;
    }

    public FrmDocumentacion(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(400, 200);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //Formateo Date
        DateFormatter displayFormatter = new DateFormatter(new SimpleDateFormat("dd-MM-yyyy"));
        DefaultFormatterFactory factory = new DefaultFormatterFactory(displayFormatter, displayFormatter, displayFormatter);
        this.txtFechaRecepcion.setFormatterFactory(factory);
        this.asociarEventos();

        this.self = this;

    }

    private void asociarEventos()
    {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    documentacion = new Documentacion(txtTipoDoc.getText(),
                            new SimpleDateFormat("dd-MM-yyyy").parse(txtFechaRecepcion.getText()),
                            esObligatoriaCheckBox.isSelected(),
                            esDeseableCheckBox.isSelected());
                    dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
