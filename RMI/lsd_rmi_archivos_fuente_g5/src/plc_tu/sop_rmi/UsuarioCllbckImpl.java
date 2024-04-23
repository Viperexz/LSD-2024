package plc_tu.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UsuarioCllbckImpl extends UnicastRemoteObject implements UsuarioCllbckInt
{

    public UsuarioCllbckImpl() throws RemoteException
    {
        super();
    }

    @Override
    public void notificar(String usuario, int id) throws RemoteException {
        System.out.println("El usuario "+usuario+ "con id "+id+"esta realizando una consulta.");
    }

}