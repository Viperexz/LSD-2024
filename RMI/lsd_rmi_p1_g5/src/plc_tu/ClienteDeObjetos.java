package plc_tu;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;

import sop_rmi.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClienteDeObjetos {

    private static AdivinadorInt objRemoto;

    public static void main(String[] args) {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la direcciOn ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el nUmero de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        objRemoto = (AdivinadorInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry,
                "adivinador");
        juegoCliente();

    }

    private static void juegoCliente() {
        int cont_i = 0;
        int bandera = 1;
        int nivel = 1;
        int numero = 0;
        int res = 0;
        int[] intentos;
        String linea = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            while (cont_i != 3 && nivel != 4) {
                limpiar();
                if (bandera == 1) {
                    objRemoto.generarAleatorio(nivel);
                    objRemoto.resetAdivinador();
                    bandera = 0;
                }
                System.out.println("===== Nivel: " + nivel + " =====\n");
                String rango = "";
                if (nivel == 1)
                    rango = "(0-5)";
                if (nivel == 2)
                    rango = "(0-15)";
                if (nivel == 3)
                    rango = "(0-25)";
                System.out.print("Digite un numero(" + rango + ": ");
                numero = UtilidadesConsola.leerEntero();
                res = objRemoto.evaluarNumero(numero);
                if (res == 0) {
                    System.out.println("\nAdivinaste!!");
                    nivel++;
                    if (nivel == 4)
                        System.out.println("Ganaste!!");
                    else
                        System.out.println("\nAvanza al nivel " + nivel + "!!");
                    bandera = 1;
                    cont_i = 0;
                } else {
                    cont_i++;
                    System.out.println("\nFallaste!! ");
                    if (res == 1) {
                        System.out.println("\nEl numero es menor!!");
                    } else {
                        System.out.println("\nEl numero es mayor!!");
                    }
                    int i = 3 - cont_i;
                    if (i != 0)
                        System.out.println("Tienes " + i + " oportunidades más");
                }
                System.out.println("Oprima una tecla para continuar");
                linea = UtilidadesConsola.leerCadena();
                // limpiar();
            }
            if (cont_i == 3) {
                System.out.println("======== Perdiste!! ========");
                System.out.print("Intentos realizados: ");
                intentos = objRemoto.getIntentos();
                for (int i = 0; i < 3; i++) {
                    System.out.print(intentos[i] + ",");
                }
                System.out.println("\n===========================");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error2:");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Client exception:" + e);
        }
    }

    public static void limpiar() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}
