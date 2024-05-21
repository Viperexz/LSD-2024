package plc_mms;

import grsaa.sop_corba.*;
import plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO;
import plc_tu.utilidades.UtilidadesRegistroS;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class GestionPlcTuImpl extends plc_mms.sop_corba.GestionPlcTuPOA {

    private final ArrayList<DatosPlcTu_DTO> listplcTu = new ArrayList<plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO>();
    private String plcTuId;
    @Override
    public boolean registrar_plctu (plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO dplctu){
        System.out.println("Registrando PLC_TU: " + dplctu.id_plctu);

        if (listplcTu.size() == 5) {
            System.out.println("Se alcanzó el número máximo de PLC TU");
           // objRemoto.notificacionmms(Integer.parseInt(plcTuId));
            return false;
        }

        for (plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO plcTu : listplcTu) {
            if (plcTu.id_plctu.equals(dplctu.id_plctu)) {
                System.out.println("Error al registrar: ID Repetido");
                return false;
            }
        }

        listplcTu.add(dplctu);
        System.out.println("Plc Tu registrado, ID( " + dplctu.id_plctu + " )");
        System.out.println("PLC TU Totales: " + listplcTu.size());
        return true;
    }
    @Override
    public boolean consultarplctu (int plctuid, plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHolder objTU){
        String varId = String.valueOf(plctuid);
        System.out.println("Consultando ID: " + varId);

        for (plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO plcTu : listplcTu) {
            if (plcTu.id_plctu.equals(varId)) {
                System.out.println("Plc Tu encontrado.");
                objTU.value =plcTu;
                return true;
            }
        }
        System.out.println("Plc Tu no encontrado.");
        return false;
    }



    private String generarNumeroAleatorio() {
        // Crear un objeto Random
        Random rand = new Random();

        // Generar un número aleatorio entre 0 y 99
        int numero = rand.nextInt(100);

        // Formatear el número como una cadena de dos dígitos
        String numeroFormateado = String.format("%02d", numero);

        return numeroFormateado;
    }

}

