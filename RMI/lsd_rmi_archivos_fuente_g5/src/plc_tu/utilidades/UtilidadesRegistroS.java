
package plc_tu.utilidades;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UtilidadesRegistroS {
    public static void arrancarNS(int numPuertoNS) throws RemoteException {
        try {

            Registry registro = LocateRegistry.getRegistry(numPuertoNS);
            String[] vector = registro.list();
            System.out.println("nombres de objetos remotos registrados ");
            for (String IDObjetoRemoto : vector) {
                System.out.println("nombre : " + IDObjetoRemoto);
            }
            System.out.println("El rmiRegistry se ha obtenido y se encuentra escuchando en el puerto: " + numPuertoNS);

        } catch (RemoteException e) {
            System.out.println("El rmiRegistry no se localizó en el puerto: " + numPuertoNS);

            Registry registro = LocateRegistry.createRegistry(numPuertoNS);
            System.out.println("El registro se ha creado en el puerto: " + numPuertoNS);
        }

    }

    public static Remote obtenerObjRemoto(String dirIPNS, int puertoNS, String identificadorObjetoRemoto) throws RemoteException {
        Remote objetoObtenido = null;
        String URLRegistro = "rmi://" + dirIPNS + ":" + puertoNS + "/" + identificadorObjetoRemoto;
        try {
            objetoObtenido = Naming.lookup(URLRegistro);
        } catch (NotBoundException e) {
            System.out.println("Error, objeto remoto no localizado");
            return objetoObtenido;
        } catch (MalformedURLException e) {
            System.out.println("Error, url inválida");
            return objetoObtenido;
        } catch (RemoteException e) {
            System.out.println("Excepcion en obtencion del objeto remoto" + e);
            return objetoObtenido;
        }
        return objetoObtenido;
    }

}
