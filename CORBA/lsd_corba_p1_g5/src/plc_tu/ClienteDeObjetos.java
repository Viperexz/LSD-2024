package plc_tu;

import plc_tu.utilidades.UtilidadesRegistroS;
import plc_tu.utilidades.UtilidadesConsola;

import plc_mms.sop_rmi.*;
import plc_mms.dto.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

public class ClienteDeObjetos {





package cliente;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import sop_corba.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

    public class ClienteDeObjetos
    {

        public static void main(String args[])
        {
            try
            {
                System.out.println("1. Crea e inicia el ORB");
                ORB orb = ORB.init(args, null);

                System.out.println("2. Obtiene una referencia al servicio de nombrado por medio del orb");
                org.omg.CORBA.Object objRefNameService = orb.resolve_initial_references("NameService");

                System.out.println("3. Convierte la ref genErica a ref de NamingContextExt");
                NamingContextExt refContextoNombrado = NamingContextExtHelper.narrow(objRefNameService);

                System.out.println("4. Resuelve la referencia del objeto en el N_S.");

                String identificadorServant = "identificadorServant";

                NameComponent [] path = new NameComponent[1];
                path[0] = new NameComponent();
                path[0].id = identificadorServant;
                path[0].kind = "tipoServicio";

                org.omg.CORBA.Object objRef= refContextoNombrado.resolve(path);

                System.out.println("5. Convierte la referencia de un objeto genErico a una referencia al servant ");

                Registro objSolucion = RegistroHelper.narrow(objRef);

                System.out.println("InvocaciOn de los mEtodos como si fueran locales");

                objSolucion.cantidadMaximaDepositos(3);
                objSolucion.registrarDeposito("1", 250000);
                objSolucion.registrarDeposito("1", 500000);
                objSolucion.registrarDeposito("2", 1500000);
                float saldoCuenta=objSolucion.cantidadCuenta("1");
                System.out.println("El saldo de la cuenta para la identificacion 1 es: " + saldoCuenta );
                int cantidadDepositos= objSolucion.cantidadDepositosRegistrados();
                System.out.println("La cantidad de depOsitos registrados es: " + cantidadDepositos);


            } catch (InvalidName | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | NotFound e)
            {
                System.out.println("ERROR : " + e.getMessage()) ;
                e.printStackTrace(System.out);
            }
        }

    }


    private static GestionUsuariosInt objRemoto;

    public static void main(String[] args) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la direcciOn ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena("Ingrese la IP (localhost o otra): ");
        System.out.println("Cual es el nUmero de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();

        objRemoto = (GestionUsuariosInt) UtilidadesRegistroS.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry,
                "GesUsuario");
        menuSesion();

    }

    private static void menuSesion() throws RemoteException {
        int opcion = 0;
        String password;
        String user;
        int ID;
        Usuario_DTO usuario = null;
        do{
        System.out.println("=== Menu Sesion ===");
        System.out.println("1. Abrir Sesion");
        System.out.println("2. Salir");

            System.out.println("Digite una opcion:");
            opcion = UtilidadesConsola.leerEntero();

            switch(opcion) {
                case 1:
                    System.out.println("Ingrese las credenciales");
                    System.out.println("");
                    System.out.println("ID:");
                    ID = UtilidadesConsola.leerEntero();
                    user = UtilidadesConsola.leerCadena("Ingresar Usuario:");
                    password = UtilidadesConsola.leerCadena("Ingresar Password");
                    usuario = new Usuario_DTO(ID,"",user,password);
                    if (objRemoto.abrirSesion(usuario)==1) {
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
        }while(opcion != 2);
    }

    private static void menuOperador() {
        int opcion = 0;
        do{
            System.out.println("=== Menu Operador ===");
            System.out.println("1. Registrar Dispositivo");
            System.out.println("2. Consultar Dispositivo");
            System.out.println("3. Salir");
            System.out.println("");
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
        }while(opcion != 3);
    }

    private static void menuUsuario() {
        int opcion = 0;
        do{
        System.out.println("=== Menu Usuario ===");
        System.out.println("1. Consultar Dispositivo");
        System.out.println("2. Salir");
        System.out.println("");
        

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
        }while(opcion != 2);
    }

    public static void limpiar() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}
