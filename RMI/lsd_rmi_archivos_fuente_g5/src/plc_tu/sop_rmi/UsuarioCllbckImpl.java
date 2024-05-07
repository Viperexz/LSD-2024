package plc_tu.sop_rmi;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UsuarioCllbckImpl extends UnicastRemoteObject implements UsuarioCllbckInt
{

    public UsuarioCllbckImpl() throws RemoteException
    {
        super();
    }

    @Override
    public void notificar(String usuario, String id ,int modo) throws RemoteException {
        Thread thread = new Thread(() -> {

            if(modo == 1)
            {
                JOptionPane.showMessageDialog(
                        null,
                        "El usuario: " + usuario + " con id: " + id + " está realizando una consulta.",
                        "Notificación", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(
                        null,
                        "La factura del PLC:TU id plc_tu"+id+" esta lista y ya puede ser consultada",
                        "Notificación", JOptionPane.INFORMATION_MESSAGE);
            }


        });


        thread.start();
    }

}

