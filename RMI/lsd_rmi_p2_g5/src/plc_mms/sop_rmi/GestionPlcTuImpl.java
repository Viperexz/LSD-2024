package plc_mms.sop_rmi;

import grsaa.sop_rmi.GestionPlcMmsInt;
import plc_mms.dto.DatosPlcTu_DTO;
import plc_tu.utilidades.UtilidadesRegistroS;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class GestionPlcTuImpl extends UnicastRemoteObject implements GestionPlcTuInt{

    private ArrayList<DatosPlcTu_DTO> listplcTu = new ArrayList<>();
    private static GestionPlcMmsInt objRemoto;
    private String plcTuId;

    public GestionPlcTuImpl(String ip,int puerto) throws RemoteException {

        System.out.println("En GestionPlcTuImpl()");
        plcTuId = generarNumeroAleatorio();
        System.out.println("El PLC Tu ID: " + plcTuId);

        objRemoto = (GestionPlcMmsInt) UtilidadesRegistroS.obtenerObjRemoto(ip, puerto, "GesPlcMms");

    }

    @Override
    public boolean registrar_plctu(DatosPlcTu_DTO dplctu) throws RemoteException {
        System.out.println("Registrando PLC_TU");

        if(!listplcTu.isEmpty())
        {
            if(listplcTu.size() == 5)
            {
                System.out.println("Se alcanzo el numero maximo de PLC TU");
                objRemoto.notificacionmms(Integer.parseInt(plcTuId));
                return false;
            }
            else {
                for (int varContador = 0; true; varContador++) {
                    if (listplcTu.get(varContador).getId_plctu().equals(dplctu.getId_plctu())) {
                        System.out.println("Error al registrar: Id Repetido");
                        return false;
                    } else {
                        System.out.println("Plc Tu registrado, ID( " + dplctu.getId_plctu() + " )");
                        listplcTu.add(dplctu);
                        return true;
                    }
                }
            }
        }
        else
        {
            listplcTu.add(dplctu);
        }

        return false;
    }

    @Override
    public DatosPlcTu_DTO consultarplctu(int plctuid) throws RemoteException {
        String varId = String.valueOf(plctuid);
        System.out.println("Consultado ID: " + varId);
        if(!listplcTu.isEmpty())
        {
            for (int varContador = 0; true; varContador++) {
                if (listplcTu.get(varContador).getId_plctu().equals(varId)) {
                    System.out.println("Plc Tu encontrado.");
                    return listplcTu.get(varContador);
                } else {
                    System.out.println("Plc Tu No encontrado.");
                    return null;
                }
            }
        }
        else
        {
            System.out.println("No existen plc registrados");
            return null;
        }
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
