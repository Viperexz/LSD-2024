package plc_mms.sop_rmi;

import plc_mms.dto.DatosPlcTu_DTO;
import plc_tu.sop_rmi.UsuarioCllbckInt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestionPlcTuInt extends Remote {
    public boolean registrar_plctu(DatosPlcTu_DTO dplctu) throws RemoteException;

    public DatosPlcTu_DTO consultarplctu(int plctuid) throws RemoteException;

    public boolean registrarOperador(UsuarioCllbckInt usuario) throws RemoteException;
}

