package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton sociosButton;
    private JButton LineayTipoButton;
    private JButton operacionesButton;
    private JButton consultasButton;
    private JPanel pnlTitulo;

    private FrmPrincipal self;

    public FrmPrincipal(String titulo) {
        super(titulo);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setContentPane(pnlPrincipal);
        this.setSize(400, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();

        this.self = this;

    }

    private void asociarEventos() {
        sociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmSocios frame = new FrmSocios(self, "Socios");
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        FrmPrincipal frame = new FrmPrincipal("Sistema SRG");
        frame.setVisible(true);
    }

}
