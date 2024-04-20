package grsaa;

import grsaa.sop_rmi.GestionPlcMmsIntImpl;
import grsaa.utilidades.UtilidadesRegistroS;
import plc_mms.sop_rmi.GestionPlcTuInt;
import plc_mms.sop_rmi.GestionUsuariosInt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class DatosConexion extends JFrame {
    private JPanel ConexionPane;
    private JTextField txtDireccion;
    private JButton btnConexion;
    private JTextField txtPuerto;
    GestionPlcMmsIntImpl objRemoto ;

    public DatosConexion() {
        setContentPane(ConexionPane);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        btnConexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    objRemoto =  new GestionPlcMmsIntImpl();// se leasigna el puerto de escucha del objeto remoto
                    grsaa.utilidades.UtilidadesRegistroS.arrancarNS(Integer.parseInt(txtPuerto.getText()));
                    UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, txtDireccion.getText(), Integer.parseInt(txtPuerto.getText()),"GesPlcMms");
                    if (objRemoto != null) {
                        new LoginOper(objRemoto);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error remoto", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (RemoteException rex) {
                    JOptionPane.showMessageDialog(
                            null, rex, "Error remoto", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null, ex, "Error desconocido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) throws RemoteException {
        new DatosConexion();
    }

}
