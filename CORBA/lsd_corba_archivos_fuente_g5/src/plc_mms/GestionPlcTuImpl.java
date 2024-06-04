package plc_mms;

import grsaa.sop_corba.*;
import grsaa.sop_corba.GestionDispositivosPackage.Lectura_DTO;
import grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import plc_mms.sop_corba.GestionPlcTuPackage.*;
import plc_tu.sop_corba.GestionAlertasPackage.alertaDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GestionPlcTuImpl extends plc_mms.sop_corba.GestionPlcTuPOA {
    private GestionDispositivos refServant2;
    private final ArrayList<DatosPlcTu_DTO> listplcTu = new ArrayList<DatosPlcTu_DTO>();
    private String plcTuId;
    private  notificacionDTO notificacion;
    private boolean running;
    private  ArrayList<plc_tu.sop_corba.GestionAlertas> TuOperConectados =  new ArrayList<plc_tu.sop_corba.GestionAlertas>() ;
    private  ArrayList<plc_tu.sop_corba.GestionAlertas> UsuarioCOnectado =  new ArrayList<plc_tu.sop_corba.GestionAlertas>() ;
    @Override
    public boolean registrar_plctu (DatosPlcTu_DTO dplctu){
        System.out.println("Registrando PLC_TU: " + dplctu.id_plctu);

        if (listplcTu.size() == 1) {
            System.out.println("Se alcanzó el número máximo de PLC TU");

            notificacion = new notificacionDTO();
            notificacion.idPlcmms = generarNumeroAleatorio();
            notificacion.listTU = conversoDTO(listplcTu).toArray(new grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO[0]);
            refServant2.notificacionmms(notificacion);
            return false;
        }

        for (DatosPlcTu_DTO plcTu : listplcTu) {
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
    public boolean consultarplctu (int plctuid, DatosPlcTu_DTOHolder objTU){
        String varId = String.valueOf(plctuid);
        System.out.println("Consultando ID: " + varId);

        for (DatosPlcTu_DTO plcTu : listplcTu) {
            if (plcTu.id_plctu.equals(varId)) {
                System.out.println("Plc Tu encontrado.");
                objTU.value =plcTu;
                System.out.println("Se notifico al operador");
                alertaDto objAlerta = new alertaDto(plcTu.propietario,Integer.parseInt(plcTu.id_plctu),1);
                System.out.println("Se crea la Alerta DTO");
                for(plc_tu.sop_corba.GestionAlertas TuOperConectado : TuOperConectados)
                {
                    TuOperConectado.notificar(objAlerta);
                }

                return true;
            }
        }
        System.out.println("Plc Tu no encontrado.");
        return false;
    }
    @Override
    public void registrarCallback(plc_tu.sop_corba.GestionAlertas objAlertas) {
        TuOperConectados.add(objAlertas);
        System.out.println("Se registro un operador.");
    }

    @Override
    public void usuariosConectados(plc_tu.sop_corba.GestionAlertas objUsuario) {
        UsuarioCOnectado.add(objUsuario);
        System.out.println("Se registro un operador.");
    }

    @Override
    public Factura_DTO recuperarFactura(String IdTu) {
        return null;
    }

    @Override
    public void notificarFacturas(String IdTu) {

    }
    @Override
    public boolean recuperarLista(ListaDtoHolder objLista) {
        if(!listplcTu.isEmpty())
        {
            System.out.println("Se envio la lista.");
            objLista.value.listTU = listplcTu.toArray(new DatosPlcTu_DTO[0]);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public synchronized void actualizarLista(ListaDto objLista) {
        if (objLista.listTU.length == 0) {
            System.out.println("Se actualizó la lista");
            listplcTu.clear();
            listplcTu.addAll(Arrays.asList(objLista.listTU));
        }
    }
    @Override
    public boolean eliminarTU(String idTu) {
        return false;
    }




    public void consultarReferenciaRemota(NamingContextExt nce, String servicio)
    {
        try {
            this.refServant2 = GestionDispositivosHelper.narrow(nce.resolve_str(servicio));
            System.out.println("Obtenido el servidor 2" + refServant2 );
        } catch (InvalidName e) {
            throw new RuntimeException(e);
        } catch (CannotProceed e) {
            throw new RuntimeException(e);
        } catch (NotFound e) {
            throw new RuntimeException(e);
        }
    }





    private int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(100);
    }



    private synchronized void iniciarLecturaPeriodica() {
        Lectura_DTO lecturaDto = new Lectura_DTO();
        lecturaDto.listTU = conversoDTO(listplcTu).toArray(new grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO[0]);
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    if (refServant2.lectura(lecturaDto) == 1) break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        thread.start();
    }

    public synchronized void startConsumoAleatorio() {
        Thread thread = new Thread(() -> {
            while (running) {
                consumoAleatorio();
            }
        });
        thread.start();
    }

    public synchronized void stopConsumoAleatorio() {
        running = false;
    }

    private synchronized void consumoAleatorio() {
        Random rand = new Random();
        int maxNumero = 10;
        while (running) {
            if (!listplcTu.isEmpty()) {
                try {
                    int indiceAleatorio = rand.nextInt(listplcTu.size());
                    DatosPlcTu_DTO plcTuAleatorio = listplcTu.get(indiceAleatorio);
                    int numero = rand.nextInt(maxNumero);
                    plcTuAleatorio.lectura = (plcTuAleatorio.lectura + numero);
                    System.out.println("El ID:" + plcTuAleatorio.id_plctu + " registra una lectura de: " + plcTuAleatorio.lectura);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public notificacionDTO getGestionTU() {
        return notificacion;
    }

    public static ArrayList<grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO> conversoDTO(
            ArrayList<DatosPlcTu_DTO> listMMS) {

        ArrayList<grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO> listGRSAA = new ArrayList<>();

        for (DatosPlcTu_DTO objMMS : listMMS) {
            grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO objGestion =
                    new grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO();

            objGestion.id_plctu = objMMS.id_plctu;
            objGestion.lectura = objMMS.lectura;
            objGestion.propietario = objMMS.propietario;
            objGestion.estrato = objMMS.estrato;

            listGRSAA.add(objGestion);
        }

        return listGRSAA;
    }
}


