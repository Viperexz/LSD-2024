package grsaa.sop_rmi;

import grsaa.dto.ListTu_DTO;
import grsaa.dto.Usuario_DTO;
import plc_mms.dto.DatosPlcTu_DTO;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GestionPlcMmsIntImpl extends UnicastRemoteObject implements GestionPlcMmsInt {
    private Usuario_DTO usuario = new Usuario_DTO(1,"Juanito Perez","admin","admin");
    private int sesionOPER;
    private ListTu_DTO GestionTU;


    public GestionPlcMmsIntImpl() throws RemoteException
    {
        System.out.println("En GestionUsuariosImpl()");
    }

    @Override
    public void notificacionmms(int mmsid,ArrayList<DatosPlcTu_DTO> listTU)throws RemoteException {
        GestionTU = new ListTu_DTO(mmsid, listTU);
        System.out.println("El dispositivo PLC_MMS con Id:"+ mmsid +" Fue registrado y sus PLC_TU Cargados.");
    }


    public int lectura(ArrayList<DatosPlcTu_DTO> listTU)
    {
        int varContador = 0;
        System.out.println("Se esta iniciando la lectura.");
        GestionTU.setListTU(listTU);
        if(varContador == GestionTU.getListTU().size()) return 1;
        for (DatosPlcTu_DTO plcTu : GestionTU.getListTU()) {
            if(contarLineas(GestionTU.getMmsId()+"_"+plcTu.getId_plctu()+".txt")<=4) {
                escribirArchivo(GestionTU.getMmsId(), plcTu.getId_plctu(), plcTu.getLectura());
            }
            else
            {
                varContador++;
                System.out.println("Se termino la lectura para este dispositivo: ");
            }
        }
        return 0;
    }



    public void escribirArchivo(int mmsid, String plc,int lectura) {


        String fileName =mmsid+"_"+plc+".txt";
        System.out.println("Se esta escribiendo en el archivo: " + fileName + " Lectura: " + lectura);
        String encoding = "UTF-8";
        if(contarLineas(fileName)<=4)
        {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(fileName, true)); // true para agregar al final del archivo
                writer.println(lectura);
                writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("La factura esta disponible");
        }

    }

    public int contarLineas(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return count;
    }







}
