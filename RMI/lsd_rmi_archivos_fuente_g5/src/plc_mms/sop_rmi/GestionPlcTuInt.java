package plc_mms.sop_rmi;

import plc_mms.dto.DatosPlcTu_DTO;
import plc_tu.sop_rmi.UsuarioCllbckInt;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestionPlcTuInt extends Remote {
    public boolean registrar_plctu(DatosPlcTu_DTO dplctu) throws RemoteException;

    public DatosPlcTu_DTO consultarplctu(int plctuid) throws RemoteException;

    public boolean registrarOperador(UsuarioCllbckInt usuario) throws RemoteException;

    public ArrayList<DatosPlcTu_DTO> recuperarLista() throws RemoteException;

    public void actualizarLista(ArrayList<DatosPlcTu_DTO> prmListaTU) throws RemoteException;

}

