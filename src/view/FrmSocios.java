package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSocios extends JDialog {

    private JPanel pnlPrincipal;
    private JPanel pnlTitulo;
    private JPanel pnlMenu;
    private JLabel lblTitulo;
    private JButton crearSocioButton;
    private JButton crearSocioPostulanteAButton;
    private JButton presentarDocumentacionObligatoriaButton;
    private JButton presentarDocumentacionOpcionalButton;
    private JButton hacerAporteButton;
    private JButton subirAccionesParticipeButton;
    private JButton subirAccionesProtectoresButton;

    private FrmSocios self;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();

        this.self = this;
    }

    private void asociarEventos()
    {
        crearSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSocios frame = new FrmSocios(self, "Demo con TABS");
                frame.setVisible(true);
            }
        });
    }

}
