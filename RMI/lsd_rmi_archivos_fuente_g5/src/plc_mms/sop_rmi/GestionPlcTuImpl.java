package plc_mms.sop_rmi;

import grsaa.sop_rmi.GestionPlcMmsInt;
import plc_mms.dto.DatosPlcTu_DTO;
import plc_tu.utilidades.UtilidadesRegistroS;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class GestionPlcTuImpl extends UnicastRemoteObject implements GestionPlcTuInt {

    private final ArrayList<DatosPlcTu_DTO> listplcTu = new ArrayList<>();
    
    private static GestionPlcMmsInt objRemoto;
    private final int plcTuId;
    private boolean running = true;
    private int numEnvioConsumos = 0;

    public GestionPlcTuImpl(String ip, int puerto) throws RemoteException {

        System.out.println("En GestionPlcTuImpl()");
        plcTuId = generarNumeroAleatorio();
        System.out.println("El PLC Tu ID: " + plcTuId);
        objRemoto = (GestionPlcMmsInt) UtilidadesRegistroS.obtenerObjRemoto(ip, puerto, "GesPlcMms");
    }

    @Override
    public boolean registrar_plctu(DatosPlcTu_DTO dplctu) throws RemoteException {
        dplctu.setId_plctu(String.format("%d",generarNumeroAleatorio()));
        System.out.println("Registrando PLC_TU: " + dplctu.getId_plctu());

        if (listplcTu.size() >= 1) {
            System.out.println("Se alcanzó el número máximo de PLC TU");
            objRemoto.notificacionmms(plcTuId,listplcTu);
            startConsumoAleatorio();
            iniciarLecturaPeriodica();
            return false;
        }

        for (DatosPlcTu_DTO plcTu : listplcTu) {
            if (plcTu.getId_plctu().equals(dplctu.getId_plctu())) {
                System.out.println("Error al registrar: ID Repetido");
                startConsumoAleatorio();
                return false;
            }
        }

        listplcTu.add(dplctu);
        System.out.println("Plc Tu registrado, ID( " + dplctu.getId_plctu() + " )");
        System.out.println("PLC TU Totales: " + listplcTu.size());
        return true;
    }
    @Override
    public DatosPlcTu_DTO consultarplctu(int plctuid) throws RemoteException {
        String varId = String.valueOf(plctuid);
        System.out.println("Consultando ID: " + varId);

        for (DatosPlcTu_DTO plcTu : listplcTu) {
            if (plcTu.getId_plctu().equals(varId)) {
                System.out.println("Plc Tu encontrado.");
                return plcTu;
            }
        }

        System.out.println("Plc Tu no encontrado.");
        return null;
    }


    private int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(100);
    }






// Hilo dedicado a la SIMULACION de consumo y el envio de informacion.


    private void iniciarLecturaPeriodica() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(60000); // Esperar 400 milisegundos
                    if(objRemoto.lectura(listplcTu)==1) break;
                } catch (InterruptedException | RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }





    public void startConsumoAleatorio() {
        Thread thread = new Thread(() -> {
            while (running) {
                consumoAleatorio();
            }
        });
        thread.start();
    }

    public void stopConsumoAleatorio() {
        running = false;
    }

    private void consumoAleatorio() {
        Random rand = new Random();
        int maxNumero = 10; // Define el rango máximo de los números aleatorios
        while (running) {
            synchronized (listplcTu) { // Sincronizar el acceso a la lista
                if (!listplcTu.isEmpty()) {
                    try {

                        int indiceAleatorio = rand.nextInt(listplcTu.size()); // Selecciona un índice aleatorio
                        DatosPlcTu_DTO plcTuAleatorio = listplcTu.get(indiceAleatorio); // Obtiene el objeto en el índice aleatorio
                        int numero = rand.nextInt(maxNumero); // Genera un número aleatorio entre 0 y maxNumero - 1
                        plcTuAleatorio.setLectura(plcTuAleatorio.getLectura()+numero);
                        System.out.println("El ID:"+plcTuAleatorio.getId_plctu()+" registra una lectura de: "+plcTuAleatorio.getLectura());
                        Thread.sleep(15000); // Espera 300 milisegundos
                    } catch (InterruptedException e) {
                        // Manejo de excepción si se interrumpe el hilo mientras está dormido
                        e.printStackTrace();
                    }
                }
            }
        }
    }





}

