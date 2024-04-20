package grsaa;

import grsaa.sop_rmi.GestionPlcMmsIntImpl;
import plc_mms.dto.Usuario_DTO;
import plc_mms.sop_rmi.GestionPlcTuInt;
import plc_mms.sop_rmi.GestionUsuariosInt;
import plc_tu.menuOperador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class LoginOper extends JFrame {
    private JTextField txtUsuario;
    private JButton btnLogin;
    private JTextField txtClave;
    private JTextField txtID;
    private JPanel LoginPane;
    Usuario_DTO usuario = null;

    public LoginOper(GestionPlcMmsIntImpl objUsuario) {
        setContentPane(LoginPane);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = new Usuario_DTO(Integer.parseInt(txtID.getText()), "", txtUsuario.getText(), txtClave.getText());
            }
        });

    }



}
