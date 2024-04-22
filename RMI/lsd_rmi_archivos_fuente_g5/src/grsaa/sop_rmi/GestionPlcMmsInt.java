package grsaa.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import plc_mms.dto.DatosPlcTu_DTO;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionPlcMmsInt extends Remote {
    // Definicion del primer método remoto
    public void notificacionmms(int mmsid, ArrayList<DatosPlcTu_DTO> listTU)throws RemoteException;
    // Definicion del segundo método remoto
    public int lectura(ArrayList<DatosPlcTu_DTO> listTU)throws RemoteException;

}
