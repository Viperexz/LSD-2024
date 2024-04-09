package plc_tu;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;

import sop_rmi.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClienteDeObjetos {

    private static GesUsuario objRemoto;

    public static void main(String[] args) {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la direcciOn ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el nUmero de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        objRemoto = (AdivinadorInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry,
                "GesUsuario");
        juegoCliente();

    }

    private static void menuSesion() {
        int opcion;
        String password;
        String user;
        int ID;
        Usuario_DTO usuario;

        System.out.println("=== Menu Sesion ===");
        System.out.println("1. Abrir Sesion");
        System.out.println("2. Salir");
        System.out.println("");

        while(true) {
            System.out.println("Digite una opcion:");
            opcion = UtilidadesConsola.leerEntero();

            switch(opcion) {
                case 1:
                    System.out.println("Ingrese las credenciales");
                    System.out.println("");
                    System.out.println("ID:");
                    ID = UtilidadesConsola.leerEntero();
                    System.out.println("User:");
                    user = UtilidadesConsola.leerCadena();
                    System.out.println("Password:");
                    password = UtilidadesConsola.leerCadena();
                    usuario.setId(ID);
                    usuario.setUsuario(user);
                    usuario.setClave(password);
                    if (objRemoto.abrirSesion(usuario)) {
                        menuOperador();
                    }
                    else {
                        menuUsuario();
                    }
                    break;
                    
                case 2:
                    System.out.println("Saliendo...");
                    System.exit(0); // Terminar el programa
                    break;
                default:
                    System.out.println("El número ingresado no está en las opciones");
                    break;
            }
        }
    }

    private static void menuOperador() {
        int opcion;

        System.out.println("=== Menu Operador ===");
        System.out.println("1. Registrar Dispositivo");
        System.out.println("2. Consultar Dispositivo");
        System.out.println("3. Salir");
        System.out.println("");
        while(true) {
            System.out.println("Digite una opcion:");
            opcion = UtilidadesConsola.leerEntero();

            switch(opcion) {
                case 1:
                    System.out.println("En construccion");
                    break;
                case 2:
                    System.out.println("En construccion");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    System.exit(0); // Terminar el programa
                    break;
                default:
                    System.out.println("El número ingresado no está en las opciones");
                    break;
            }
        }
    }

    private static void menuUsuario() {
        int opcion;

        System.out.println("=== Menu Usuario ===");
        System.out.println("1. Consultar Dispositivo");
        System.out.println("2. Salir");
        System.out.println("");
        
        while(true) {
            System.out.println("Digite una opcion:");
            opcion = UtilidadesConsola.leerEntero();

            switch(opcion) {
                case 1:
                    System.out.println("En construccion");
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    System.exit(0); // Terminar el programa
                    break;
                default:
                    System.out.println("El número ingresado no está en las opciones");
                    break;
            }
        }
    }

    public static void limpiar() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}
