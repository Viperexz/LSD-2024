package plc_mms.sop_rmi;

import plc_mms.dto.Usuario_DTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GestionUsuariosImpl extends UnicastRemoteObject implements GestionUsuariosInt {
    private Usuario_DTO usuario;
    private int sesionOPER;

    public GestionUsuariosImpl() throws RemoteException
    {

    }

    @Override
    public int abrirSesion(Usuario_DTO objUsuario) throws RemoteException {
        return 0;
    }

    @Override
    public Usuario_DTO consultarUsuario(int identificacion) throws RemoteException {
        return null;
    }

    int buscarAdmin(Usuario_DTO obj)
    {
        return 0;
    }
}
