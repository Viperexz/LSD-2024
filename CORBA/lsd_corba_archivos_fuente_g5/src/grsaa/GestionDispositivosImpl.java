package grsaa;

import grsaa.sop_corba.GestionDispositivosPackage.Factura_DTO;
import grsaa.sop_corba.GestionDispositivosPackage.Factura_DTOHolder;
import grsaa.sop_corba.GestionDispositivosPackage.Lectura_DTO;
import grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO;
import plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO;
import plc_mms.sop_corba.GestionUsuariosPackage.usuarioDTO;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class GestionDispositivosImpl extends grsaa.sop_corba.GestionDispositivosPOA{
    private usuarioDTO usuario = new usuarioDTO(1,"Juanito Perez","admin","admin");
    private int sesionOPER;
    private notificacionDTO GestionTU;
    private ArrayList<Factura_DTO> listFacturas;



    @Override
    public void notificacionmms(notificacionDTO objNotificacion) {
        System.out.println("El dispositivo PLC_MMS con Id:"+ objNotificacion.idPlcmms +" completo sus registros y esta activo en el sistema");
    }

    @Override
    public int lectura(Lectura_DTO objLectura) {
        int varContador = 0;
        System.out.println("Se esta iniciando la lectura.");
        GestionTU.listTU =  objLectura.listTU;
        if(varContador == GestionTU.listTU.length) return 1;

        for (grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO plcTu : GestionTU.listTU) {
            if(contarLineas(GestionTU.idPlcmms+"_"+plcTu.id_plctu+".txt")<4) {
                escribirArchivo(GestionTU.idPlcmms, plcTu.id_plctu, plcTu.lectura);
            }
            else
            {
                varContador++;
                System.out.println("Se termino la lectura para este dispositivo: ");

                crearFactura(plcTu,GestionTU.idPlcmms+"_"+plcTu.id_plctu+".txt");




            }
        }
        return 0;
    }

    @Override
    public double recuperarFactura(String IdTu, Factura_DTOHolder objFactura) {
        System.out.println("Se esta consultando la factura.");
        for (Factura_DTO facturaElem : listFacturas)
        {
            if(facturaElem.id_plctu.equals(IdTu))
            {
                objFactura.value = facturaElem;
                return facturaElem.consumo;
            }
        }
        return 0;
    }
    public void crearFactura(grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO prmTU , String fileName){

        int estrato = Integer.parseInt(prmTU.estrato);
        switch (estrato)
        {
            case 1: prmTU.consumo = calcularConsumo(fileName,0) * 420;
                break;
            case 2: prmTU.consumo = (calcularConsumo(fileName,0) * 525);
                break;
            case 3: prmTU.consumo = (calcularConsumo(fileName,0) * 852);
                break;
            case 4: prmTU.consumo = (calcularConsumo(fileName,0) * 1002);
                break;
            case 5: prmTU.consumo = (calcularConsumo( fileName,0)* 1002);
                break;
            case 6: prmTU.consumo = (calcularConsumo(fileName,0) * 1002);
                break;
        }
        Factura_DTO factura = new Factura_DTO(String.valueOf(calcularConsumo(fileName,1)),prmTU.id_plctu,String.valueOf(calcularConsumo(fileName,2)),prmTU.consumo);
        System.out.println("Se calculo el consumo del TU: " + prmTU.id_plctu +" En un total de: " + prmTU.consumo);
        //objRemoto2.notificarFacturas(String.valueOf(prmTU.getId_plctu()));
        listFacturas.add(factura);
    }


    public Factura_DTO recuperarFactura(String plcID)
    {
        System.out.println("Se esta consultando la factura.");
        for (Factura_DTO facturaElem : listFacturas)
        {
            if(facturaElem.id_plctu.equals(plcID))
            {
                return facturaElem;
            }
        }
        return null;
    }




    public void escribirArchivo(int mmsid, String plc,int lectura) {


        String fileName =mmsid+"_"+plc+".txt";
        System.out.println("Se esta escribiendo en el archivo: " + fileName + " Lectura: " + lectura);
        String encoding = "UTF-8";
        if(contarLineas(fileName)<4)
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



    //Se fijan 3 modos:
    //Modo 1: Retorna solo la lectura 1:
    //Modo 2: Retorno Solo lectura 2;
    //Modo 0 u otro: retorna el calculo de consumo
    public int calcularConsumo(String fileName , int modo) {
        int varLectura1 = 0, varLectura2 = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    varLectura1 = Integer.parseInt(line);
                } else if (count == 3) {
                    varLectura2 = Integer.parseInt(line);
                    break; // Se detiene el bucle después de leer la segunda línea necesaria.
                }
                count++;
            }
            System.out.println("El archivo "+ fileName + " tiene las siguientes siguientes lecturas 1: " + varLectura1 + " 2: " + varLectura2);
            if(modo==1)
            {
                return varLectura1;
            }
            else if (modo ==2)
            {
                return varLectura2;
            }
            else {
                return varLectura2 - varLectura1;
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
            return 0;
        } catch (NumberFormatException e) {
            System.out.println("El archivo contiene datos no válidos para la lectura.");
            e.printStackTrace();
            return 0;
        }
    }


    public notificacionDTO getGestionTU() {
        return GestionTU;
    }

    public void setGestionTU(notificacionDTO gestionTU) {
        GestionTU = gestionTU;
    }

    grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO conversoDTO(DatosPlcTu_DTO objMMS , grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO objGestion)
    {
        objGestion.id_plctu = objMMS.id_plctu;
        objGestion.lectura = objMMS.lectura;
        objGestion.propietario = objMMS.propietario;
        objGestion.estrato = objMMS.estrato;
        return objGestion;
    };


}
